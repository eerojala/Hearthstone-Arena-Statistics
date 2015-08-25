
package Xml;

import org.jdom.Document;

public abstract class StatisticsWriter extends XmlWriter{

    public StatisticsWriter(String filepath, String rootName, String childName) {
        super(filepath, rootName, childName);
    }
    
    public abstract void updateSpecific(Document doc, Object key, Object keeper);
}
