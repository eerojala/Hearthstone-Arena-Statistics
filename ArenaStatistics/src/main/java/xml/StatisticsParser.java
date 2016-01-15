package xml;

import org.jdom.Document;
import org.jdom.Element;

/**
 * Abstract class meant for parsing statistics from a Xml file.
 */
public abstract class StatisticsParser extends XmlParser {

    /**
     * Creates a new StatisticsParser object.
     *
     * @param filepath File path to the Xml document.
     * @param childname Name of the Xml document's child elements.
     * @param rootname Name of the Xml document's root element.
     */
    public StatisticsParser(String filepath, String childname, String rootname) {
        super(filepath, childname, rootname);
    }

    /**
     * Creates a new StatisticsParser object.
     *
     * @param doc Document representation of the Xml document.
     * @param childname Name of the Xml document's child elements.
     */
    public StatisticsParser(Document doc, String childname) {
        super(doc, childname);
    }

    /**
     * Parses values from the Xml file to the statistics keeper.
     */
    @Override
    public void addValues() {
        for (Element element : childlist) {
            setStatistics(element);
        }
    }

    /**
     * Sets the statistics parsed from the Xml file into a statistics keeper
     * class.
     *
     * @param element Child element from the Xml file.
     */
    protected abstract void setStatistics(Element element);
}
