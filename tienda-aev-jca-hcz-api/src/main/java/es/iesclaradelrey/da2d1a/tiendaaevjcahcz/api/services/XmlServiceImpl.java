package es.iesclaradelrey.da2d1a.tiendaaevjcahcz.api.services;

import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.ICategoriaRepository;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IMarcaRepository;
import es.iesclaradelrey.da2d1a.tiendaaevjcahcz.common.repositories.IProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.ErrorResponseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlServiceImpl implements IXmlService {
    private final IProductoRepository productos;
    private final IMarcaRepository marcas;
    private final ICategoriaRepository categorias;

    public XmlServiceImpl(IProductoRepository productos, IMarcaRepository marcas, ICategoriaRepository categorias) {
        this.productos = productos;
        this.marcas = marcas;
        this.categorias = categorias;
    }

    @Override
    public void exportarProductos(OutputStream out) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = doc.createElement("productos");
        doc.appendChild(root);

        for (Producto p : productos.findAll()) {
            Element pe = doc.createElement("producto");
            pe.setAttribute("id", String.valueOf(p.getId()));
            pe.setAttribute("codigoProducto", p.getCodigoProducto());
            pe.appendChild(elem(doc, "nombre", p.getNombre()));
            pe.appendChild(elem(doc, "descripcion", p.getDescripcion()));
            pe.appendChild(elem(doc, "precio", String.valueOf(p.getPrecio())));
            pe.appendChild(elem(doc, "descuento", String.valueOf(p.getDescuento())));

            Element m = doc.createElement("marca");
            m.setAttribute("id", String.valueOf(p.getMarca().getId()));
            m.setAttribute("nombre", p.getMarca().getNombre());
            pe.appendChild(m);

            Element cats = doc.createElement("categorias");
            for (Categoria c : p.getCategorias()) {
                Element ce = doc.createElement("categoria");
                ce.setAttribute("id", String.valueOf(c.getId()));
                ce.setAttribute("nombre", c.getNombre());
                cats.appendChild(ce);
            }
            pe.appendChild(cats);
            root.appendChild(pe);
        }

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(out));
    }

    @Override
    @Transactional
    public void importarProductos(InputStream in) throws Exception {
        Handler handler = new Handler();
        SAXParserFactory.newInstance().newSAXParser().parse(in, handler);

        for (var d : handler.lista) {
            Marca marca = marcas.findById(d.marcaId).orElseThrow(() ->
                    error404("Marca no encontrada con id: " + d.marcaId));

            List<Categoria> cats = new ArrayList<>();
            for (Long cid : d.catIds)
                cats.add(categorias.findById(cid).orElseThrow(() ->
                        error404("Categoría no encontrada con id: " + cid)));

            Producto p = new Producto();
            p.setCodigoProducto(d.codigo);
            p.setNombre(d.nombre);
            p.setDescripcion(d.descripcion);
            p.setPrecio(d.precio);
            p.setDescuento(d.descuento);
            p.setMarca(marca);
            p.setCategorias(cats);
            productos.save(p);
        }
    }

    private Element elem(Document doc, String tag, String valor) {
        Element e = doc.createElement(tag);
        e.setTextContent(valor);
        return e;
    }

    private ErrorResponseException error404(String msg) {
        return new ErrorResponseException(HttpStatus.NOT_FOUND,
                ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, msg), null);
    }

    static class Handler extends DefaultHandler {
        List<Data> lista = new ArrayList<>();
        Data actual;
        StringBuilder sb = new StringBuilder();

        @Override
        public void startElement(String u, String l, String q, Attributes a) {
            sb.setLength(0);
            if (q.equals("producto")) {
                actual = new Data();
                actual.codigo = a.getValue("codigoProducto");
            } else if (q.equals("marca") && actual != null) actual.marcaId = Long.parseLong(a.getValue("id"));
            else if (q.equals("categoria") && actual != null) actual.catIds.add(Long.parseLong(a.getValue("id")));
        }

        @Override
        public void endElement(String u, String l, String q) {
            if (actual == null) return;
            switch (q) {
                case "nombre" -> actual.nombre = sb.toString().trim();
                case "descripcion" -> actual.descripcion = sb.toString().trim();
                case "precio" -> actual.precio = Double.parseDouble(sb.toString().trim());
                case "descuento" -> actual.descuento = Integer.parseInt(sb.toString().trim());
                case "producto" -> lista.add(actual);
            }
        }

        @Override
        public void characters(char[] ch, int s, int l) {
            sb.append(ch, s, l);
        }
    }

    static class Data {
        String codigo, nombre, descripcion;
        Double precio;
        int descuento;
        Long marcaId;
        List<Long> catIds = new ArrayList<>();
    }
}
