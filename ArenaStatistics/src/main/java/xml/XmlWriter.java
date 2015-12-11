package xml;

import java.io.FileWriter;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import util.DocumentBuilder;

public abstract class XmlWriter {

    protected Document doc;
    protected String filepath;
    protected final String rootName;
    protected final String childName;

    public XmlWriter(String filepath, String rootName, String childName) {
        this.filepath = filepath;
        this.rootName = rootName;
        this.childName = childName;
        doc = DocumentBuilder.buildDocument(filepath);
    }

    public abstract void writeContent(Object obj);

    public void removeLatest() {
        List children = doc.getRootElement().getChildren(childName);
        children.remove(children.size() - 1);
        addToFile();
    }

    public void removeAll() {
        doc.getRootElement().removeContent();
        addToFile();
    }

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

    protected void addToFile() {
        XMLOutputter output = new XMLOutputter();
        output.setFormat(Format.getPrettyFormat());
        try {
            output.output(doc, new FileWriter(filepath));
        } catch (Exception e) {
            System.out.println("Writing to file failed");
        }
    }

    public String getRootName() {
        return rootName;
    }

    public Document getDoc() {
        return doc;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
        doc = DocumentBuilder.buildDocument(filepath);
    }
}
