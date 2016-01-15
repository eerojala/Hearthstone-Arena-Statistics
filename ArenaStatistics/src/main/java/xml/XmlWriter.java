package xml;

import java.io.FileWriter;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import util.DocumentBuilder;

/**
 * Abstract class for writing date from the program into Xml files.
 */
public abstract class XmlWriter {

    /**
     * Document representation of the Xml document.
     */
    protected Document doc;

    /**
     * File path to the Xml file.
     */
    protected String filePath;

    /**
     * Name of the Xml document's root element.
     */
    protected final String rootName;

    /**
     * Name of the Xml document's child elements.
     */
    protected final String childName;

    /**
     * Creates a new XmlWriter Object.
     * 
     * @param filepath File path to the Xml document.
     * @param rootName Name of the Xml document's root element.
     * @param childName Name of the Xml document's child elements.
     */
    public XmlWriter(String filepath, String rootName, String childName) {
        this.filePath = filepath;
        this.rootName = rootName;
        this.childName = childName;
        doc = DocumentBuilder.buildDocument(filepath);
    }

    /**
     * Writes data to the Xml file.
     * 
     * @param obj Object which is written to the file.
     */
    public abstract void writeContent(Object obj);

    /**
     * Removes the latest/last child element of the Xml document.
     */
    public void removeLatest() {
        List children = doc.getRootElement().getChildren(childName);
        children.remove(children.size() - 1);
        addToFile();
    }

    /**
     * Removes all of the child elements of the Xml document.
     */ 
    public void removeAll() {
        doc.getRootElement().removeContent();
        addToFile();
    }

    /**
     * Removes a specific child element from the Xml document.
     * 
     * @param id Id of the child element.
     */
    public void remove(String id) {
        List<Element> children = doc.getRootElement().getChildren();
        Element removeThis = null;
        for (Element child : children) {
            if (child.getAttributeValue("id").equals(id)) {
                removeThis = child;
                break;
            }
        }
        doc.getRootElement().removeContent(removeThis);
        addToFile();
    }

    /**
     * Writes the contents of the Document to the Xml file.
     */
    protected void addToFile() {
        XMLOutputter output = new XMLOutputter();
        output.setFormat(Format.getPrettyFormat());
        try {
            output.output(doc, new FileWriter(filePath));
        } catch (Exception e) {
            System.out.println("Writing to file failed");
        }
    }

    /**
     * Returns the name of the Xml document's root element.
     * 
     * @return Name of the Xml document's root element.
     */
    public String getRootName() {
        return rootName;
    }

    /**
     * Returns the Document representation of the Xml document.
     * 
     * @return Document.
     */
    public Document getDoc() {
        return doc;
    }

    /**
     * Returns the String representation of the Xml file's file path.
     * 
     * @return String representation of the Xml file's file path.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path to the Xml file.
     * 
     * @param filePath File path to the Xml file.
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        doc = DocumentBuilder.buildDocument(filePath);
    }
}
