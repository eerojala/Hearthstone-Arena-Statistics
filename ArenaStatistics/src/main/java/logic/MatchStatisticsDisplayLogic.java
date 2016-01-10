package logic;

import domain.DeckClass;
import domain.Matchup;
import gui.MainGUI;
import util.PortraitSetter;
import util.StatisticsHelper;

public class MatchStatisticsDisplayLogic implements StatisticsGUI, GUIWithPortrait{

    private final MainGUI gui;
    private final MatchStatisticsKeeper csk;
    private final MatchupStatisticsKeeper cvcsk;

    public MatchStatisticsDisplayLogic(MainGUI gui) {
        this.gui = gui;
        csk = gui.getClassStatisticsKeeper();
        cvcsk = gui.getClassVSClassStatisticsKeeper();
    }

    @Override
    public void updatePortrait() {
        PortraitSetter.setPortrait(gui.getMatchStatisticsMainPortraitChooser(), 
                gui.getMatchStatisticsAltPortraitChooser(), gui.getMatchStatisticsPortrait(), 
                (DeckClass) gui.getMatchStatisticsClass1Chooser().getSelectedItem());
    }
    
    public void updatePortrait(DeckClass dc) {
        PortraitSetter.setPortrait(gui.getMatchStatisticsMainPortraitChooser(), 
                gui.getMatchStatisticsAltPortraitChooser(), gui.getMatchStatisticsPortrait(), dc);
    }

    @Override
    public void updatePortraitChoosers() {
        PortraitSetter.updatePortraitChoosers(gui.getMatchStatisticsMainPortraitChooser(), 
                gui.getMatchStatisticsAltPortraitChooser(), 
                (DeckClass) gui.getMatchStatisticsClass1Chooser().getSelectedItem());
    }

    @Override
    public void updateStats() {
        DeckClass dc1 = (DeckClass) gui.getMatchStatisticsClass1Chooser().getSelectedItem();
        DeckClass dc2 = (DeckClass) gui.getMatchStatisticsClass2Chooser().getSelectedItem();
        Matchup dcp = new Matchup(dc1, dc2);
        updateLabels(dc1, dc2);
        updateValues(dc1, dcp);
    }

    private void updateLabels(DeckClass dc1, DeckClass dc2) {
        String dc1VSdc2 = dc1 + " vs " + dc2;
        gui.getMatchStatisticsMatchesAsClassLabel().setText("Matches as " + dc1);
        gui.getMatchStatisticsMatchesVSClassLabel().setText("Matches vs " + dc1);
        gui.getMatchStatisticsWinsAsClassLabel().setText("Wins as " + dc1);
        gui.getMatchStatisticsMatchesVSClassLabel().setText("Wins vs " + dc1);
        gui.getMatchStatisticsWinPerAsClassLabel().setText("Win% as " + dc1);
        gui.getMatchStatisticsWinPerVSClassLabel().setText("Win% vs " + dc1);
        gui.getMatchStatisticsMatchesVSClass2Label().setText(dc1VSdc2 + " matches");
        gui.getMatchStatisticsWinsVSClass2Label().setText(dc1VSdc2 + " wins");
        gui.getMatchStatisticsWinPerVSClass2Label().setText(dc1VSdc2 + " win%");
    }

    private void updateValues(DeckClass dc, Matchup dcp) {
        updateTotalValues();
        if (gui.getMatchStatistics1stRadioButton().isSelected()) {
            update1stValues(dc, dcp);
        } else if (gui.getMatchStatistics2ndRadioButton().isSelected()) {
            update2ndValues(dc, dcp);
        } else {
            updateClassTotalValues(dc, dcp);
        }
    }
    
    private void updateTotalValues() {
        gui.getMatchStatisticsTotalMatches().setText("" + csk.getTotalMatches());
        gui.getMatchStatisticsTotalWins().setText("" + csk.getTotalWins());
        gui.getMatchStatisticsTotalWinPer().setText("" + StatisticsHelper.convertToPercentage(csk.getTotalWinPer()));
    }

    private void update1stValues(DeckClass dc, Matchup dcp) {
        gui.getMatchStatisticsMatchesAsClassValue().setText("" + csk.getMatchesAsClass1st(dc));
        gui.getMatchStatisticsMatchesVSClassValue().setText("" + csk.getMatchesVSClass1st(dc));
        gui.getMatchStatisticsWinsAsClassValue().setText("" + csk.getWinsAsClass1st(dc));
        gui.getMatchStatisticsWinsVSClassValue().setText("" + csk.getWinsVSClass1st(dc));
        gui.getMatchStatisticsWinPerAsClassValue().setText("" + StatisticsHelper.convertToPercentage(csk.getWinPerAsClass1st(dc)));
        gui.getMatchStatisticsWinPerVSClassValue().setText("" + StatisticsHelper.convertToPercentage(csk.getWinPerVSClass1st(dc)));
        gui.getMatchStatisticsMatchesVSClass2Value().setText("" + cvcsk.getMatchesInClassVSClass1st(dcp));
        gui.getMatchStatisticsWinsVSClass2Value().setText("" + cvcsk.getWinsInClassVSClass1st(dcp));
        gui.getMatchStatisticsWinPerVSClass2Value().setText("" + StatisticsHelper.convertToPercentage(cvcsk.getWinPerClassVSClass1st(dcp)));
    }

    private void update2ndValues(DeckClass dc, Matchup dcp) {
        gui.getMatchStatisticsMatchesAsClassValue().setText("" + csk.getMatchesAsClass2nd(dc));
        gui.getMatchStatisticsMatchesVSClassValue().setText("" + csk.getMatchesVSClass2nd(dc));
        gui.getMatchStatisticsWinsAsClassValue().setText("" + csk.getWinsAsClass2nd(dc));
        gui.getMatchStatisticsWinsVSClassValue().setText("" + csk.getWinsVSClass2nd(dc));
        gui.getMatchStatisticsWinPerAsClassValue().setText("" + StatisticsHelper.convertToPercentage(csk.getWinPerAsClass2nd(dc)));
        gui.getMatchStatisticsWinPerVSClassValue().setText("" + StatisticsHelper.convertToPercentage(csk.getWinPerVSClass2nd(dc)));
        gui.getMatchStatisticsMatchesVSClass2Value().setText("" + cvcsk.getMatchesInClassVSClass2nd(dcp));
        gui.getMatchStatisticsWinsVSClass2Value().setText("" + cvcsk.getWinsInClassVSClass2nd(dcp));
        gui.getMatchStatisticsWinPerVSClass2Value().setText("" + StatisticsHelper.convertToPercentage(cvcsk.getWinPerClassVSClass2nd(dcp)));
    }
    
    private void updateClassTotalValues(DeckClass dc, Matchup dcp) {
        gui.getMatchStatisticsMatchesAsClassValue().setText("" + csk.getMatchesAsClassTotal(dc));
        gui.getMatchStatisticsMatchesVSClassValue().setText("" + csk.getMatchesVSClassTotal(dc));
        gui.getMatchStatisticsWinsAsClassValue().setText("" + csk.getWinsAsClassTotal(dc));
        gui.getMatchStatisticsWinsVSClassValue().setText("" + csk.getWinsVSClassTotal(dc));
        gui.getMatchStatisticsWinPerAsClassValue().setText("" + StatisticsHelper.convertToPercentage(csk.getWinPerAsClassTotal(dc)));
        gui.getMatchStatisticsWinPerVSClassValue().setText("" + StatisticsHelper.convertToPercentage(csk.getWinPerVSClassTotal(dc)));
        gui.getMatchStatisticsMatchesVSClass2Value().setText("" + cvcsk.getMatchesInClassVSClassTotal(dcp));
        gui.getMatchStatisticsWinsVSClass2Value().setText("" + cvcsk.getWinsInClassVSClassTotal(dcp));
        gui.getMatchStatisticsWinPerVSClass2Value().setText("" + StatisticsHelper.convertToPercentage(cvcsk.getWinPerInClassVSClassTotal(dcp)));
    }
    
    @Override
    public void updateVisuals() {
        updatePortrait();
        updatePortraitChoosers();
        updateStats();
    }
}
