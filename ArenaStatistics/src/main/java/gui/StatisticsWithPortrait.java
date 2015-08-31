
package gui;

public abstract class StatisticsWithPortrait implements StatisticsGUI{
    protected final MainGUI gui;

    public StatisticsWithPortrait(MainGUI gui) {
        this.gui = gui;
    }
    
    public void updateVisuals() {
        updatePortraitChoosers();
        updatePortrait();
        updateStats();
    }
    
    protected abstract void updatePortraitChoosers();
    public abstract void updatePortrait();
    @Override
    public abstract void updateStats();
}
