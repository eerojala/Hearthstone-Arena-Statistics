package logic;

import domain.DeckClass;
import domain.DeckClassPair;
import gui.MainGUI;
import javax.swing.*;
import logic.ClassStatisticsKeeper;
import logic.ClassVSClassStatisticsKeeper;
import util.PortraitSetter;

public class MatchStatisticsLogic implements StatisticsGUI, GUIWithPortrait{

    private MainGUI gui;
    private JComboBox class1Chooser;
    private JComboBox class2Chooser;
    private JRadioButton mainPortraitChooser;
    private JRadioButton altPortraitChooser;
    private JRadioButton matchStatisticsTotal;
    private JRadioButton matchStatistics1st;
    private JRadioButton matchStatistics2nd;
    private JLabel classPortrait;
    private JLabel matchesAsClassLabel;
    private JLabel matchesAsClassValue;
    private JLabel matchesVSClassLabel;
    private JLabel matchesVSClassValue;
    private JLabel winsAsClassLabel;
    private JLabel winsAsClassValue;
    private JLabel winsVSClassLabel;
    private JLabel winsVSClassValue;
    private JLabel winPerAsClassLabel;
    private JLabel winPerAsClassValue;
    private JLabel winPerVSClassLabel;
    private JLabel winPerVSClassValue;
    private JLabel matchesVSClass2Label;
    private JLabel matchesVSClass2Value;
    private JLabel winsVSClass2Label;
    private JLabel winsVSClass2Value;
    private JLabel winPerVSClass2Label;
    private JLabel winPerVSClass2Value;
    private JLabel totalMatches;
    private JLabel totalWins;
    private JLabel totalWinPer;
    private ClassStatisticsKeeper csk;
    private ClassVSClassStatisticsKeeper ccsk;

    public MatchStatisticsLogic(MainGUI gui) {
        this.gui = gui;
        setObjects();
    }

    private void setObjects() {
        setJComboBoxes();
        setJRadioButtons();
        setJLabels();
    }

    private void setJComboBoxes() {
        class1Chooser = gui.getMatchStatisticsClass1Chooser();
        class2Chooser = gui.getMatchStatisticsClass2Chooser();
    }

    private void setJRadioButtons() {
        mainPortraitChooser = gui.getMatchStatisticsMainPortraitChooser();
        altPortraitChooser = gui.getMatchStatisticsAltPortraitChooser();
        matchStatisticsTotal = gui.getMatchStatisticsTotalRadioButton();
        matchStatistics1st = gui.getMatchStatistics1stRadioButton();
        matchStatistics2nd = gui.getMatchStatistics2ndRadioButton();
    }

    private void setJLabels() {
        classPortrait = gui.getMatchStatisticsPortrait();
        setLabels();
        setValues();
        setKeepers();
    }

    private void setLabels() {
        matchesAsClassLabel = gui.getMatchStatisticsMatchesAsClassLabel();
        matchesVSClassLabel = gui.getMatchStatisticsMatchesVSClassLabel();
        winsAsClassLabel = gui.getMatchStatisticsWinsAsClassLabel();
        winsVSClassLabel = gui.getMatchStatisticsWinsVSClassLabel();
        winPerAsClassLabel = gui.getMatchStatisticsWinPerAsClassLabel();
        winPerVSClassLabel = gui.getMatchStatisticsWinPerVSClassLabel();
        matchesVSClass2Label = gui.getMatchStatisticsMatchesVSClass2Label();
        winsVSClass2Label = gui.getMatchStatisticsWinsVSClass2Label();
        winPerVSClass2Label = gui.getMatchStatisticsWinPerVSClass2Label();
    }

    private void setValues() {
        matchesAsClassValue = gui.getMatchStatisticsMatchesAsClassValue();
        matchesVSClassValue = gui.getMatchStatisticsMatchesVSClassValue();
        winsAsClassValue = gui.getMatchStatisticsWinsAsClassValue();
        winsVSClassValue = gui.getMatchStatisticsWinsVSClassValue();
        winPerAsClassValue = gui.getMatchStatisticsWinPerAsClassValue();
        winPerVSClassValue = gui.getMatchStatisticsWinPerVSClassValue();
        matchesVSClass2Value = gui.getMatchStatisticsMatchesVSClass2Value();
        winsVSClass2Value = gui.getMatchStatisticsWinsVSClass2Value();
        winPerVSClass2Value = gui.getMatchStatisticsWinPerVSClass2Value();
        totalMatches = gui.getMatchStatisticsTotalMatches();
        totalWins = gui.getMatchStatisticsTotalWins();
        totalWinPer = gui.getMatchStatisticsTotalWinPer();
    }

    private void setKeepers() {
        csk = gui.getClassStatisticsKeeper();
        ccsk = gui.getClassVSClassStatisticsKeeper();
    }

    @Override
    public void updatePortrait() {
        PortraitSetter.setPortrait(mainPortraitChooser, altPortraitChooser, classPortrait, (DeckClass) class1Chooser.getSelectedItem());
    }
    
    public void updatePortrait(DeckClass dc) {
        PortraitSetter.setPortrait(mainPortraitChooser, altPortraitChooser, classPortrait, dc);
    }

    @Override
    public void updatePortraitChoosers() {
        PortraitSetter.updatePortraitChoosers(mainPortraitChooser, altPortraitChooser, (DeckClass) class1Chooser.getSelectedItem());
    }

    @Override
    public void updateStats() {
        DeckClass dc1 = (DeckClass) class1Chooser.getSelectedItem();
        DeckClass dc2 = (DeckClass) class2Chooser.getSelectedItem();
        DeckClassPair dcp = new DeckClassPair(dc1, dc2);
        updateLabels(dc1, dc2);
        updateValues(dc1, dcp);
    }

    private void updateLabels(DeckClass dc1, DeckClass dc2) {
        String dc1VSdc2 = dc1 + " vs " + dc2;
        matchesAsClassLabel.setText("Matches as " + dc1);
        matchesVSClassLabel.setText("Matches vs " + dc1);
        winsAsClassLabel.setText("Wins as " + dc1);
        winsVSClassLabel.setText("Wins vs " + dc1);
        winPerAsClassLabel.setText("Win% as " + dc1);
        winPerVSClassLabel.setText("Win% vs " + dc1);
        matchesVSClass2Label.setText(dc1VSdc2 + " matches");
        winsVSClass2Label.setText(dc1VSdc2 + " wins");
        winPerVSClass2Label.setText(dc1VSdc2 + " win%");
    }

    private void updateValues(DeckClass dc, DeckClassPair dcp) {
        updateTotalValues();
        if (matchStatisticsTotal.isSelected()) {
            update1stValues(dc, dcp);
        } else if (matchStatistics2nd.isSelected()) {
            update2ndValues(dc, dcp);
        } else {
            updateClassTotalValues(dc, dcp);
        }
    }
    
    private void updateTotalValues() {
        totalMatches.setText("" + csk.getTotalMatches());
        totalWins.setText("" + csk.getTotalWins());
        totalWinPer.setText("" + csk.getTotalWinPer());
    }

    private void update1stValues(DeckClass dc, DeckClassPair dcp) {
        matchesAsClassValue.setText("" + csk.getMatchesAsClass1st(dc));
        matchesVSClassValue.setText("" + csk.getMatchesVSClass1st(dc));
        winsAsClassValue.setText("" + csk.getWinsAsClass1st(dc));
        winsVSClassValue.setText("" + csk.getWinsVSClass1st(dc));
        winPerAsClassValue.setText("" + csk.getWinPerAsClass1st(dc));
        winPerVSClassValue.setText("" + csk.getWinPerVSClass1st(dc));
        matchesVSClass2Value.setText("" + ccsk.getMatchesInClassVSClass1st(dcp));
        winsVSClass2Value.setText("" + ccsk.getWinsInClassVSClass1st(dcp));
        winPerVSClass2Value.setText("" + ccsk.getWinPerClassVSClass1st(dcp));
    }

    private void update2ndValues(DeckClass dc, DeckClassPair dcp) {
        matchesAsClassValue.setText("" + csk.getMatchesAsClass2nd(dc));
        matchesVSClassValue.setText("" + csk.getMatchesVSClass2nd(dc));
        winsAsClassValue.setText("" + csk.getWinsAsClass2nd(dc));
        winsVSClassValue.setText("" + csk.getWinsVSClass2nd(dc));
        winPerAsClassValue.setText("" + csk.getWinPerAsClass2nd(dc));
        winPerVSClassValue.setText("" + csk.getWinPerVSClass2nd(dc));
        matchesVSClass2Value.setText("" + ccsk.getMatchesInClassVSClass2nd(dcp));
        winsVSClass2Value.setText("" + ccsk.getWinsInClassVSClass2nd(dcp));
        winPerVSClass2Value.setText("" + ccsk.getWinPerClassVSClass2nd(dcp));
    }
    
    private void updateClassTotalValues(DeckClass dc, DeckClassPair dcp) {
        matchesAsClassValue.setText("" + csk.getMatchesAsClassTotal(dc));
        matchesVSClassValue.setText("" + csk.getMatchesVSClassTotal(dc));
        winsAsClassValue.setText("" + csk.getWinsAsClassTotal(dc));
        winsVSClassValue.setText("" + csk.getWinsVSClassTotal(dc));
        winPerAsClassValue.setText("" + csk.getWinPerAsClassTotal(dc));
        winPerVSClassValue.setText("" + csk.getWinPerVSClassTotal(dc));
        matchesVSClass2Value.setText("" + ccsk.getMatchesInClassVSClassTotal(dcp));
        winsVSClass2Value.setText("" + ccsk.getWinsInClassVSClassTotal(dcp));
        winPerVSClass2Value.setText("" + ccsk.getWinPerInClassVSClassTotal(dcp));
    }
    
    @Override
    public void updateVisuals() {
        updatePortrait();
        updatePortraitChoosers();
        updateStats();
    }
}
