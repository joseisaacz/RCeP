
package Datos;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadAndWrite {
   private File file=null;
   private DocumentBuilderFactory doc=null;
   private DocumentBuilder docu=null;
   private Document document=null;
   public ReadAndWrite(String path) throws Exception{
       doc=DocumentBuilderFactory.newInstance();
       docu = doc.newDocumentBuilder();
       file= new File(path);
       document= (Document) docu.parse(file);
        document.getDocumentElement().normalize(); 
   }
   public String read(String idn, String idn2, int i){
    NodeList as=document.getElementsByTagName(idn);
    Node n=as.item(i);
    if(n.getNodeType()==Node.ELEMENT_NODE){
        Element a=(Element)n;
        return(a.getAttribute(idn2));
    }
       return null;
}
   public int length(String idn){
   NodeList as=document.getElementsByTagName(idn);
    return as.getLength();
}

}