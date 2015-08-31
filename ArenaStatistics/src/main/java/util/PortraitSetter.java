package util;

import domain.DeckClass;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PortraitSetter {

    public static void setPortrait(JRadioButton mainPortraitChooser, JRadioButton altPortraitChooser,
            JLabel classPortrait, DeckClass dc) {
        ImageIcon icon;
        String filename;
        if (mainPortraitChooser.isSelected()) {
            filename = dc.getPortraitFilename();
        } else {
            filename = dc.getAlPortraitFilename();
        }
        icon = new ImageIcon("src/main/resources/portraits/" + filename);
        classPortrait.setIcon(icon);
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
