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
import xml.DataWriter;
import xml.StatisticsWriter;

public class Main {

    public static void main(String[] args) {
        StartUpGUI gui = new StartUpGUI();
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
    }
}
