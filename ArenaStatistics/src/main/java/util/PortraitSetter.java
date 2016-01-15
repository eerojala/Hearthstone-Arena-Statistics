package util;

import domain.DeckClass;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 * Class which handles showing the class portrait in the GUI.
 */
public class PortraitSetter {

    /**
     * The default file path to the folder which stores the class portrait
     * images.
     */
    public static String filePath = "src/main/resources/portraits/";

    /**
     * Sets the portrait of the chosen class to a JLabel and updates the
     * JRadioButtons which allow the user to pick between the main and alternate
     * portrait.
     *
     * @param mainPortraitChooser JRadioButton for choosing the main portrait.
     * @param altPortraitChooser JRadioButton for choosing the alternate
     * portrait.
     * @param portrait JLabel which shows the portrait.
     * @param dc Selected DeckClass.
     */
    public static void setPortrait(JRadioButton mainPortraitChooser, JRadioButton altPortraitChooser,
            JLabel portrait, DeckClass dc) {
        if (mainPortraitChooser.isSelected()) {
            setMainPortrait(portrait, dc);
        } else {
            setAltPortrait(portrait, dc);
        }
    }

    /**
     * Sets the main portrait of the selected class to the JLabel.
     *
     * @param portrait JLabel which shows the portrait.
     * @param dc Selected DeckClass.
     */
    public static void setMainPortrait(JLabel portrait, DeckClass dc) {
        setPortrait(portrait, dc.getPortraitFilename());
    }

    /**
     * Sets the alternate portrait of the selected class to the JLabel.
     *
     * @param portrait JLabel which shows the portrait.
     * @param dc Selected DeckClass.
     */
    public static void setAltPortrait(JLabel portrait, DeckClass dc) {
        setPortrait(portrait, dc.getAltPortraitFilename());
    }

    private static void setPortrait(JLabel portrait, String fileName) {
        portrait.setIcon(new ImageIcon(filePath + fileName));
    }

    /**
     * Enables the JRadioButton used for selecting the alternate portrait if the
     * selected class has an alternate portrait. If the selected match does not
     * have an alternate portrait, the method disables the JRadioButton used for
     * choosing the alternate portrait and marks the JRadioButton which is used
     * for choosing the main portrait as selected.
     *
     * @param mainPortraitChooser JRadioButton used for choosing the main portrait.
     * @param altPortraitChooser JRadioButton used for choosing the alternate portrait.
     * @param dc Selected DeckClass.
     */
    public static void updatePortraitChoosers(JRadioButton mainPortraitChooser,
            JRadioButton altPortraitChooser, DeckClass dc) {
        if (dc.getAltPortraitFilename().isEmpty()) {
            altPortraitChooser.setEnabled(false);
            mainPortraitChooser.setSelected(true);
        } else {
            altPortraitChooser.setEnabled(true);
        }
    }
}
