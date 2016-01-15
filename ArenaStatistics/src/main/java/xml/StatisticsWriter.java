
package xml;

/**
 * Abstract class meant for writing statistics to a Xml file.
 */
public abstract class StatisticsWriter extends XmlWriter{

    /**
     * Creates a new StatisticsWriter Object.
     * 
     * @param filepath File path to the Xml document.
     * @param rootName Name of the Xml document's root element.
     * @param childName Name of the Xml document's child elements.
     */
    public StatisticsWriter(String filepath, String rootName, String childName) {
        super(filepath, rootName, childName);
    }
    
    /**
     * Updates a specific child element on the Xml file.
     * 
     * @param element Child element which is updated.
     * @param keeper Statistics keeper which data is updated to the child element.
     */
    public abstract void updateSpecific(Object element, Object keeper);
}
