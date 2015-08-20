package Xml;

import java.io.FileWriter;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public abstract class XmlWriter {

    protected final String filepath;
    protected final String rootName;
    protected final String childName;

    public XmlWriter(String filepath, String rootName, String childName) {
        this.filepath = filepath;
        this.rootName = rootName;
        this.childName = childName;
    }

    public abstract void addContent(Document doc, Object obj);

    public void removeLatest(Document doc) {
        List children = doc.getRootElement().getChildren(childName);
        children.remove(children.size() - 1);
        addToFile(doc);
    }
    
    public void removeAll(Document doc) {
        doc.getRootElement().removeChildren(childName);
        addToFile(doc);
    }
    
    public void remove(Document doc, String id) {
        List<Element> children = doc.getRootElement().getChildren();
        Element removeThis = null;       
        for (Element child : children) {
            if (child.getAttributeValue("id").equals(id)) {
                removeThis = child;
                break;
            }
        }
        doc.getRootElement().removeContent(removeThis);
        addToFile(doc);
    } 

    protected void addToFile(Document doc) {
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
    
}
