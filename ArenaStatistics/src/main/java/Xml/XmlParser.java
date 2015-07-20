package Xml;

import domain.*;
import java.io.File;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public abstract class XmlParser {

    protected List childList;
    protected Document document;

    public XmlParser(String filePath, String tagName) {
        document = DocumentBuilder.buildDocument(filePath);
        if (document == null) {
            String rootName = "";
            if (tagName.equals("Match")) {
                rootName = "Matches";
            } else if (tagName.equals("Deck")) {
                rootName = "Decks";
            }
            document = DocumentBuilder.createNewDocument(rootName);
        }
        initChildList(tagName);
    }
    
    public XmlParser(Document doc, String tagName) {
        document = doc;
        initChildList(tagName);
    }

    private void initChildList(String tagName) {     
        try {
            Element rootNode = document.getRootElement();
            childList = rootNode.getChildren(tagName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void addValuesToList();

    protected String getStringValue(Element node, String tagName) {
        return node.getChildText(tagName);
    }

    protected int getIntegerValue(Element node, String tagName) {
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
    
    protected String getId(Element node) {
        return node.getAttributeValue("id");
    }

    public Document getDocument() {
        return document;
    }

}
