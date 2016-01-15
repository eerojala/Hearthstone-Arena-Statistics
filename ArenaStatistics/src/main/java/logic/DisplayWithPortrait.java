package logic;

/**
 * Interface intended for logic classes which utilize MainGUI's tabs which have class portraits.
 */
public interface DisplayWithPortrait {

    /**
     * Enables/disables JRadioButtons which allow the user to pick between the main or alternate portrait
     */
    public void updatePortraitChoosers();

    /**
     * Updates the class portrait.
     */
    public void updatePortrait();
    
    /**
     * Updates the visuals of the GUI: statistics and the class portrait.
     */
    public void updateVisuals();
}
