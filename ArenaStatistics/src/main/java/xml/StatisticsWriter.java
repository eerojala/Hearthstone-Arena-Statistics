
package xml;


public abstract class StatisticsWriter extends XmlWriter{

    public StatisticsWriter(String filepath, String rootName, String childName) {
        super(filepath, rootName, childName);
    }
    
    public abstract void updateSpecific(Object key, Object keeper);
}
