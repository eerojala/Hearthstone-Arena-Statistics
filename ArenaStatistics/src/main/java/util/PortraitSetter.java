package util;

import domain.DeckClass;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PortraitSetter {

    public static String filePath = "src/main/resources/portraits/";

    public static void setPortrait(JRadioButton mainPortraitChooser, JRadioButton altPortraitChooser,
            JLabel portrait, DeckClass dc) {
        if (mainPortraitChooser.isSelected()) {
            setMainPortrait(portrait, dc);
        } else {
            setAltPortrait(portrait, dc);
        }
    }

    public static void setMainPortrait(JLabel portrait, DeckClass dc) {
        setPortrait(portrait, dc.getPortraitFilename());
    }
    
    public static void setAltPortrait(JLabel portrait, DeckClass dc) {
        setPortrait(portrait, dc.getAlPortraitFilename());
    }

    private static void setPortrait(JLabel portrait, String fileName) {
        portrait.setIcon(new ImageIcon(filePath + fileName));
    }

    public static void updatePortraitChoosers(JRadioButton mainPortraitChooser,
            JRadioButton altPortraitChooser, DeckClass dc) {
        if (dc.getAlPortraitFilename().isEmpty()) {
            altPortraitChooser.setEnabled(false);
            mainPortraitChooser.setSelected(true);
        } else {
            altPortraitChooser.setEnabled(true);
        }
    }
}
