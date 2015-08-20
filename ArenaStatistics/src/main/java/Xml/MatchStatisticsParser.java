
package Xml;

import logic.MatchStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public abstract class MatchStatisticsParser extends XmlParser{

    public MatchStatisticsParser(String filepath, String childname, String rootname) {
        super(filepath, childname, rootname);
    }

    public MatchStatisticsParser(Document doc, String childname) {
        super(doc, childname);
    }

    @Override
    public void addValues() {
        for (Element element : childlist) {
            setStatistics(element);
        }
    }
    
    protected abstract void setStatistics(Element element);
}

