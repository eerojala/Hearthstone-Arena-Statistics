package arenastatistics.arenastatistics;

import domain.*;
import gui.MainGUI;
import gui.StartUpGUI;
import java.util.*;
import javax.swing.SwingUtilities;
import logic.*;
import org.jdom.*;
import util.DocumentBuilder;
import util.Mapper;
import util.StatisticsHelper;
import util.TestForLoop;
import xml.ClassVSClassStatisticsParser;
import xml.ClassVSClassStatisticsWriter;
import xml.StatisticsWriter;

public class Main {

    public static void main(String[] args) {
//        StartUpGUI gui = new StartUpGUI();
//        SwingUtilities.invokeLater(gui);
//        gui.setVisible(true);
        StatisticsWriter writer;
        ClassVSClassStatisticsKeeper keeper1;
        ClassVSClassStatisticsKeeper keeper2;
        ClassVSClassStatisticsParser parser;
        String filepath;
        Document doc;
        DeckClassPair mVSr;
        DeckClassPair sVSh;
        
        mVSr = new DeckClassPair(DeckClass.MAGE, DeckClass.ROGUE);
        sVSh = new DeckClassPair(DeckClass.SHAMAN, DeckClass.HUNTER);
        filepath = "src/main/resources/ClassVSClassStatisticsWriteTest.xml";
        writer = new ClassVSClassStatisticsWriter(filepath);
        keeper1 = new ClassVSClassStatisticsKeeper();
        setDcp1(mVSr, keeper1);
        setDcp2(sVSh, keeper1);
        writer.writeContent(keeper1);
             
        parser = new ClassVSClassStatisticsParser(writer.getDoc());
        parser.addValues();
        keeper1 = parser.getKeeper();
        
        keeper1.setMatchesInClassVSClass1st(mVSr, 100);
        writer.updateSpecific(mVSr, keeper1);

        parser = new ClassVSClassStatisticsParser(writer.getDoc());
        parser.addValues();
        keeper2 = parser.getKeeper();
        System.out.println(keeper2.getMatchesInClassVSClass1st(mVSr));
    }
    
    private static void setDcp1(DeckClassPair dcp, ClassVSClassStatisticsKeeper keeper1) {
        keeper1.setMatchesInClassVSClass1st(dcp, 34);
        keeper1.setMatchesInClassVSClass2nd(dcp, 156);
        keeper1.setWinsInClassVSClass1st(dcp, 21);
        keeper1.setWinsInClassVSClass2nd(dcp, 108);
        keeper1.setLossesInClassVSClass1st(dcp, 13);
        keeper1.setLossesInClassVSClass2nd(dcp, 25);
    }
    
    private static void setDcp2(DeckClassPair dcp, ClassVSClassStatisticsKeeper keeper1) {
        keeper1.setMatchesInClassVSClass1st(dcp, 66);
        keeper1.setMatchesInClassVSClass2nd(dcp, 179);
        keeper1.setWinsInClassVSClass1st(dcp, 34);
        keeper1.setWinsInClassVSClass2nd(dcp, 146);
        keeper1.setLossesInClassVSClass1st(dcp, 20);
        keeper1.setLossesInClassVSClass2nd(dcp, 33);
    }
}
