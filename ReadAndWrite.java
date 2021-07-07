package proyecto;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author admin
 */
public class ReadWrite {

    /**
     * @param path
     * @return
     * @throws java.lang.Exception
     */
    private DocumentBuilderFactory docbuilderfactory;
    private DocumentBuilder docBuilder;
    private Document doc;
    private HashMap<String, Actividad> map;

    public ReadWrite(String path) throws Exception {

        docbuilderfactory = DocumentBuilderFactory.newInstance();
        docBuilder = docbuilderfactory.newDocumentBuilder();
        doc = docBuilder.parse(new File(path));
        doc.getDocumentElement().normalize();
        map= new HashMap();

    }

    public HashMap<String, Actividad> Read_All() throws Exception {
        //map.put("Start",new Actividad("Start",0));
        this.Read_Actividad();
        this.Read_Relacion();
        return map;
    }

    private void Read_Actividad() {
        
        NodeList as = doc.getElementsByTagName("Actividad");
        for (int i = 0; i < as.getLength(); i++) {

            Node n = as.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element a = (Element) n;
                String id = a.getAttribute("id");
                Actividad act = new Actividad(id, Integer.parseInt(a.getAttribute("duracion")));

                map.put(id, act);
            }

        }

    }

    private void Read_Relacion() {

        NodeList as = doc.getElementsByTagName("Relacion");
        for (int j = 0; j < as.getLength(); j++) {

            Node n = as.item(j);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element a = (Element) n;
                String id = a.getAttribute("actividad");
                String sucesor = a.getAttribute("sucesor");
                map.get(id).agregarS(map.get(sucesor));
                map.get(sucesor).agregarA(map.get(id));

            }
        }

    }

}
