package Xml;

import java.io.FileWriter;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public abstract class XmlWriter {

    protected String filePath;
    protected String rootName;
    protected String childName;

    public XmlWriter(String filePath, String rootName, String childName) {
        this.filePath = filePath;
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
            output.output(doc, new FileWriter(filePath));
        } catch (Exception e) {
            System.out.println("Writing to file failed");
        }
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

  
}
