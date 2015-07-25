package Xml;

import java.io.File;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class DocumentBuilder {

    public static Document buildDocument(String fileName) {
        try {
            SAXBuilder builder = new SAXBuilder();
            return (Document) builder.build(new File(fileName));
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Document createDocument(String rootName) {
        Element root = new Element(rootName);
        Document doc = new Document(root);
        doc.setRootElement(root);
        return doc;
    }
    
}
