package Datos;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadAndWrite {

    private File file = null;
    private DocumentBuilderFactory doc = null;
    private DocumentBuilder docu = null;
    private Document document = null;
    private NodeList as = null;

    public ReadAndWrite(String path) throws Exception {
        doc = DocumentBuilderFactory.newInstance();
        docu = doc.newDocumentBuilder();
        file = new File(path);
        document = (Document) docu.parse(file);
        document.getDocumentElement().normalize();
        as=null;
    }

    public Actividad read(String idn1, String idn2, int i) {
        Node n = as.item(i);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element a = (Element) n;
            int duracion=Integer.parseInt(a.getAttribute(idn2));
            Actividad act=new Actividad(a.getAttribute(idn1),duracion);
            return act;
        }
        return null;
    }

//    public int length(String idn) {
//        return getas(idn).getLength();
//    }

    public NodeList getas(String idn) {
        as=document.getElementsByTagName(idn);
        return as;
    }
    
//    public void setas(String idn){
//        as=document.getElementsByTagName(idn);
//    }
    
    public String readRelacion(int i,String idn){
        Node n=as.item(i);
        if (n.getNodeType() == Node.ELEMENT_NODE){
        Element a=(Element)n;
        return(a.getAttribute(idn));
    }
       return null;
}
       
}
