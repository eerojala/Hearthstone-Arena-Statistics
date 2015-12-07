package xml;

import util.DocumentBuilder;
import domain.*;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

public abstract class XmlParser {

    public List<Element> childlist;
    protected Document document;

    public XmlParser(String filepath, String tagName, String rootName) {
        document = DocumentBuilder.buildDocument(filepath);
        if (document == null) {
            document = DocumentBuilder.createDocument(rootName);
        }
        initChildList(tagName);
    }
    
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

    protected String getStringValue(Element node, String tagName) {
        return node.getChildText(tagName);
    }

    protected int getIntValue(Element node, String tagName) {
        return Integer.parseInt(getStringValue(node, tagName));
    }

    protected boolean getBooleanValue(Element node, String tagName) {
        return Boolean.parseBoolean(getStringValue(node, tagName));
    }

    protected Outcome getOutcomeValue(Element node, String tagName) {
        return Outcome.parseOutcome(getStringValue(node, tagName));
    }

    protected DeckClass getDeckClassValue(Element node, String tagName) {
        return DeckClass.parseDeckClass(getStringValue(node, tagName));
    }
    
    protected DeckClassPair getDeckClassPairValue(Element node, String tagName) {
        return DeckClassPair.parseDeckClassPair(getStringValue(node, tagName));
    }
    
    protected String getID(Element node) {
        return node.getAttributeValue("id");
    }

    public Document getDocument() {
        return document;
    }

    public List<Element> getChildlist() {
        return childlist;
    }
}
