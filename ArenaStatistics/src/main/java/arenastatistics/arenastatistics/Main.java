package arenastatistics.arenastatistics;

import domain.*;
import java.util.HashMap;
import logic.XmlParser;

public class Main {

    public static void main(String[] args) {
        XmlParser parser = new XmlParser("src/main/resources/ParseTest.xml");
        HashMap<Integer, ArenaDeck> map = parser.getDecks();
        System.out.println("");     
    }

}
