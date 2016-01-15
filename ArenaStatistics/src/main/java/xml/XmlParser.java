package xml;

import util.DocumentBuilder;
import domain.*;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Abstract class for parsing data for the program from Xml files.
 */
public abstract class XmlParser {

    /**
     * List of child elements from the Xml document.
     */
    protected List<Element> childlist;

    /**
     * Document class representation of the Xml document.
     */
    protected Document document;

    /**
     * Creates a new XmlParser Object.
     *
     * @param filepath Filepath of the Xml file.
     * @param childName Name of the child elements.
     * @param rootName Name of the root element.
     */
    public XmlParser(String filepath, String childName, String rootName) {
        document = DocumentBuilder.buildDocument(filepath);
        if (document == null) {
            document = DocumentBuilder.createDocument(rootName);
        }
        initChildList(childName);
    }

    /**
     * Creates a new XmlParser Object.
     *
     * @param doc Document representation of the Xml file.
     * @param childname Name of the child elements.
     */
    public XmlParser(Document doc, String childname) {
        document = doc;
        initChildList(childname);
    }

    private void initChildList(String tagName) {
        try {
            Element rootNode = document.getRootElement();
            childlist = rootNode.getChildren(tagName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void addValues();

    /**
     * Returns the Object parsed from the Xml file.
     *
     * @return Object if the Xml file has been parsed, null if the Xml file has
     * not yet been parsed or ir the parsing was unsuccesful.
     */
    public abstract Object getParsedObject();

    /**
     * Parses a String value from the node.
     *
     * @param node Node
     * @param nodeName Name of the node.
     * @return String value from the node.
     */
    protected static String getStringValue(Element node, String nodeName) {
        return node.getChildText(nodeName);
    }

    /**
     * Parses an integer value from the node.
     *
     * @param node Node
     * @param nodeName Name of the node.
     * @return int value from the node.
     */
    protected static int getIntValue(Element node, String nodeName) {
        return Integer.parseInt(getStringValue(node, nodeName));
    }

    /**
     * Parses a boolean value from the node.
     *
     * @param node Node
     * @param nodeName Name of the node.
     * @return boolean value from the node.
     */
    protected static boolean getBooleanValue(Element node, String nodeName) {
        return Boolean.parseBoolean(getStringValue(node, nodeName));
    }

    /**
     * Parses an Outcome value from the node.
     *
     * @param node Node
     * @param nodeName Name of the node.
     * @return Outcome value from the node.
     */
    protected static Outcome getOutcomeValue(Element node, String nodeName) {
        return Outcome.parseOutcome(getStringValue(node, nodeName));
    }

    /**
     * Parses a DeckClass value from the node.
     *
     * @param node Node
     * @param nodeName Name of the node.
     * @return DeckClass value from the node.
     */
    protected static DeckClass getDeckClassValue(Element node, String nodeName) {
        return DeckClass.parseDeckClass(getStringValue(node, nodeName));
    }

    /**
     * Parses a Matchup value from the node.
     *
     * @param node Node
     * @param nodeName Name of the node.
     * @return Matchup value from the node.
     */
    protected static Matchup getMatchupValue(Element node, String nodeName) {
        return Matchup.parseMatchup(getStringValue(node, nodeName));
    }

    /**
     * Parses an id String from the node.
     *
     * @param node Node
     * @return id String from the node.
     */
    protected static String getID(Element node) {
        return node.getAttributeValue("id");
    }

    /**
     * Returns the Document representation of the Xml document.
     *
     * @return Document
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Returns the list of child elements from the Xml document.
     *
     * @return List of child elements from the Xml document.
     */
    public List<Element> getChildlist() {
        return childlist;
    }
}
