
package xml;

import logic.MatchRelatedStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public abstract class StatisticsParser extends XmlParser{

    public StatisticsParser(String filepath, String childname, String rootname) {
        super(filepath, childname, rootname);
    }

    public StatisticsParser(Document doc, String childname) {
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

