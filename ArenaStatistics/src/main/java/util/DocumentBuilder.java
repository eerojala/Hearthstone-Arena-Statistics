package util;

import java.io.File;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Class which creates Document Objects.
 */
public class DocumentBuilder {

    /**
     * Creates a new Document Object from a Xml file.
     * 
     * @param filepath Filepath to the Xml file.
     * @return Document of the Xml file if successful, null otherwise.
     */
    public static Document buildDocument(String filepath) {
        try {
            SAXBuilder builder = new SAXBuilder();
            return (Document) builder.build(new File(filepath));
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Creates a new Document Object with a specified name for the root element.
     * 
     * @param rootName Name of the root element.
     * @return Created Document.
     */
    public static Document createDocument(String rootName) {
        Element root = new Element(rootName);
        Document doc = new Document(root);
        doc.setRootElement(root);
        return doc;
    }
    
}
