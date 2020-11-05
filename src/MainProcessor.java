/**
 * FE 3H Calculator: A program specially created
 * so humans wouldn't have to deal with the
 * mathematical nightmare of a tabletop game
 * styled after Fire Emblem: Three Houses. Use
 * with caution, or maybe not.
 * 
 * MainProcessor: Because we all start somewhere.
 * Primarily contains GUI elements. One day, I
 * might make this pretty.
 * 
 * @author Errica Cheng (github: lockeanddemosthenes || discord: Locrius 光复香港#9567)
 * @created February 17, 2020
 * @updated September 17, 2020
 */
	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.io.BufferedReader;

public class MainProcessor {
	final static JTextArea resultPanel = new JTextArea();
	final static JTextArea resultPanelGambit = new JTextArea();

	public static void main(String[] args) throws IOException {
		int inputCounter = 0;
		
		Scanner weaponInput = new Scanner(new File("weapons.txt"));
		Scanner unitInput = new Scanner(new File("units.txt"));
		Scanner artInput = new Scanner(new File("arts.txt"));
		Scanner gambitInput = new Scanner(new File("gambits.txt"));
		
		WeaponInfo[] swords = new WeaponInfo[0];
		WeaponInfo[] lances = new WeaponInfo[0];
		WeaponInfo[] axes = new WeaponInfo[0];
		WeaponInfo[] bows = new WeaponInfo[0];
		WeaponInfo[] gauntlets = new WeaponInfo[0];
		WeaponInfo[] faith = new WeaponInfo[0];
		WeaponInfo[] reason = new WeaponInfo[0];
		WeaponInfo[] relics = new WeaponInfo[0];
		String[] swordsNames = new String[0];
		String[] lancesNames = new String[0];
		String[] axesNames = new String[0];
		String[] bowsNames = new String[0];
		String[] gauntletsNames = new String[0];
		String[] faithNames = new String[0];
		String[] reasonNames = new String[0];
		String[] relicsNames = new String[0];
		
		UnitInfo[] units = new UnitInfo[0];
		ArtInfo[] swordArts = new ArtInfo[0];
		ArtInfo[] lanceArts = new ArtInfo[0];
		ArtInfo[] axeArts = new ArtInfo[0];
		ArtInfo[] bowArts = new ArtInfo[0];
		ArtInfo[] gauntletArts = new ArtInfo[0];
		ArtInfo[] relicArts = new ArtInfo[0];
		String[] unitNames = new String[0];
		String[] swordArtNames = new String[0];
		String[] lanceArtNames = new String[0];
		String[] axeArtNames = new String[0];
		String[] bowArtNames = new String[0];
		String[] gauntletArtNames = new String[0];
		String[] relicArtNames = new String[0];
		
		GambitInfo[] gambits = new GambitInfo[0];
		String[] gambitNames = new String[0];
		
		// parse weapon list
		while (weaponInput.hasNext()) {
			String wepName = weaponInput.next();
			boolean magEqp = weaponInput.nextBoolean();
			int mtBase = weaponInput.nextInt();
			int hitBase = weaponInput.nextInt();
			int critBase = weaponInput.nextInt();
			int wt = weaponInput.nextInt();
			int weaponType = 0;
			inputCounter++;
			
			if ((1 <= inputCounter && inputCounter <= 22)) {
				weaponType = 1;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				swords = addWeapon(swords, newWeapon);
				swordsNames = addName(swordsNames, wepName);
			} else if ((23 <= inputCounter && inputCounter <= 46)) {
				weaponType = 2;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				lances = addWeapon(lances, newWeapon);
				lancesNames = addName(lancesNames, wepName);
			} else if (47 <= inputCounter && inputCounter <= 72) {
				weaponType = 3;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				axes = addWeapon(axes, newWeapon);
				axesNames = addName(axesNames, wepName);
			} else if (73 <= inputCounter && inputCounter <= 92) {
				weaponType = 4;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				bows = addWeapon(bows, newWeapon);
				bowsNames = addName(bowsNames, wepName);
			} else if (93 <= inputCounter && inputCounter <= 105) {
				weaponType = 5;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				gauntlets = addWeapon(gauntlets, newWeapon);
				gauntletsNames = addName(gauntletsNames, wepName);
			} else if (106 <= inputCounter && inputCounter <= 115) {
				weaponType = 6;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				faith = addWeapon(faith, newWeapon);
				faithNames = addName(faithNames, wepName);
			} else if (116 <= inputCounter && inputCounter <= 137) {
				weaponType = 7;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				reason = addWeapon(reason, newWeapon);
				reasonNames = addName(reasonNames, wepName);
			} else {
				weaponType = 8;
				WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt, weaponType);
				relics = addWeapon(relics, newWeapon);
				relicsNames = addName(relicsNames, wepName);
			}
		}
		weaponInput.close();
		final WeaponInfo[] swordsFinal = new WeaponInfo[swords.length];
		final WeaponInfo[] lancesFinal = new WeaponInfo[lances.length];
		final WeaponInfo[] axesFinal = new WeaponInfo[axes.length];
		final WeaponInfo[] bowsFinal = new WeaponInfo[bows.length];
		final WeaponInfo[] gauntletsFinal = new WeaponInfo[gauntlets.length];
		final WeaponInfo[] faithFinal = new WeaponInfo[faith.length];
		final WeaponInfo[] reasonFinal = new WeaponInfo[reason.length];
		final WeaponInfo[] relicsFinal = new WeaponInfo[relics.length];
		final String[] swordsNamesFinal = new String[swordsNames.length];
		final String[] lancesNamesFinal = new String[lancesNames.length];
		final String[] axesNamesFinal = new String[axesNames.length];
		final String[] bowsNamesFinal = new String[bowsNames.length];
		final String[] gauntletsNamesFinal = new String[gauntletsNames.length];
		final String[] faithNamesFinal = new String[faithNames.length];
		final String[] reasonNamesFinal = new String[reasonNames.length];
		final String[] relicsNamesFinal = new String[relicsNames.length];
		
		for (int i = 0; i < swordsNames.length; i++) {
			swordsFinal[i] = swords[i];
			swordsNamesFinal[i] = swordsNames[i];
		}
		for (int i = 0; i < lancesNames.length; i++) {
			lancesFinal[i] = lances[i];
			lancesNamesFinal[i] = lancesNames[i];
		}
		for (int i = 0; i < axesNames.length; i++) {
			axesFinal[i] = axes[i];
			axesNamesFinal[i] = axesNames[i];
		}
		for (int i = 0; i < bowsNames.length; i++) {
			bowsFinal[i] = bows[i];
			bowsNamesFinal[i] = bowsNames[i];
		}
		for (int i = 0; i < gauntletsNames.length; i++) {
			gauntletsFinal[i] = gauntlets[i];
			gauntletsNamesFinal[i] = gauntletsNames[i];
		}
		for (int i = 0; i < faithNames.length; i++) {
			faithFinal[i] = faith[i];
			faithNamesFinal[i] = faithNames[i];
		}
		for (int i = 0; i < reasonNames.length; i++) {
			reasonFinal[i] = reason[i];
			reasonNamesFinal[i] = reasonNames[i];
		}
		for (int i = 0; i < relicsNames.length; i++) {
			relicsFinal[i] = relics[i];
			relicsNamesFinal[i] = relicsNames[i];
		}
		
		inputCounter = 0;
		
		// parse unit list
		while (unitInput.hasNext()) {
			String name = unitInput.next();
			int hp = unitInput.nextInt();
			int str = unitInput.nextInt();
			int mag = unitInput.nextInt();
			int dex = unitInput.nextInt();
			int spd = unitInput.nextInt();
			int lck = unitInput.nextInt();
			int def = unitInput.nextInt();
			int res = unitInput.nextInt();
			int cha = unitInput.nextInt();
			int wepTyp = unitInput.nextInt();
			int wepInd = unitInput.nextInt();
			String crestStart = unitInput.next();
			String crest = crestStart + unitInput.nextLine();
			String personal = unitInput.nextLine();
			WeaponInfo wepID = null;
			
			switch(wepTyp) {
				case 0:
					wepID = swords[wepInd];
					break;
				case 1:
					wepID = lances[wepInd];
					break;
				case 2:
					wepID = axes[wepInd];
					break;
				case 3:
					wepID = bows[wepInd];
					break;
				case 4:
					wepID = gauntlets[wepInd];
					break;
				case 5:
					wepID = faith[wepInd];
					break;
				case 6:
					wepID = reason[wepInd];
					break;
				case 7:
					wepID = relics[wepInd];
			}

			UnitInfo newUnit = new UnitInfo(name, hp, str, mag, dex, spd, lck, def, res, cha, wepTyp, wepInd, wepID, crest, personal);
			units = addUnit(units, newUnit);
			unitNames = addName(unitNames, name);
		}
		unitInput.close();
		final UnitInfo[] unitsFinal = new UnitInfo[units.length];
		final String[] unitNamesFinal = new String[unitNames.length];
		
		for (int i = 0; i < units.length; i++) {
			unitsFinal[i] = units[i];
			unitNamesFinal[i] = unitNames[i];
		}
		
		// parse art list
		while (artInput.hasNext()) {
			String artName = artInput.next();
			int artMt = artInput.nextInt();
			int artHit = artInput.nextInt();
			int artCrit = artInput.nextInt();
			int artAvo = artInput.nextInt();
			boolean artMagEqp = artInput.nextBoolean();
			String artNote = artInput.nextLine();
			ArtInfo newArt = new ArtInfo(artName, artMt, artHit, artCrit, artAvo, artMagEqp, artNote);
			inputCounter++;
			
			if(1 <= inputCounter && inputCounter <= 9) {
				swordArts = addArt(swordArts, newArt);
				swordArtNames = addName(swordArtNames, artName);
			} else if (10 <= inputCounter && inputCounter <= 19) {
				lanceArts = addArt(lanceArts, newArt);
				lanceArtNames = addName(lanceArtNames, artName);
			} else if (20 <= inputCounter && inputCounter <= 28) {
				axeArts = addArt(axeArts, newArt);
				axeArtNames = addName(axeArtNames, artName);
			} else if (29 <= inputCounter && inputCounter <= 38) {
				bowArts = addArt(bowArts, newArt);
				bowArtNames = addName(bowArtNames, artName);
			} else if (39 <= inputCounter && inputCounter <= 47){
				gauntletArts = addArt(gauntletArts, newArt);
				gauntletArtNames = addName(gauntletArtNames, artName);
			} else {
				relicArts = addArt(relicArts, newArt);
				relicArtNames = addName(relicArtNames, artName);
			}
		}
		artInput.close();
		
		final ArtInfo[] swordArtsFinal = new ArtInfo[swordArts.length];
		final String[] swordArtsNamesFinal = new String[swordArtNames.length];
		final ArtInfo[] lanceArtsFinal = new ArtInfo[lanceArts.length];
		final String[] lanceArtsNamesFinal = new String[lanceArtNames.length];
		final ArtInfo[] axeArtsFinal = new ArtInfo[axeArts.length];
		final String[] axeArtsNamesFinal = new String[axeArtNames.length];
		final ArtInfo[] bowArtsFinal = new ArtInfo[bowArts.length];
		final String[] bowArtsNamesFinal = new String[bowArtNames.length];
		final ArtInfo[] gauntletArtsFinal = new ArtInfo[gauntletArts.length];
		final String[] gauntletArtsNamesFinal = new String[gauntletArtNames.length];
		final ArtInfo[] relicArtsFinal = new ArtInfo[relicArts.length];
		final String[] relicArtsNamesFinal = new String[relicArtNames.length];
		
		for (int i = 0; i < swordArtsFinal.length; i++) {
			swordArtsFinal[i] = swordArts[i];
			swordArtsNamesFinal[i] = swordArtNames[i];
		}
		
		for (int i = 0; i < lanceArtsFinal.length; i++) {
			lanceArtsFinal[i] = lanceArts[i];
			lanceArtsNamesFinal[i] = lanceArtNames[i];
		}
		
		for (int i = 0; i < axeArtsFinal.length; i++) {
			axeArtsFinal[i] = axeArts[i];
			axeArtsNamesFinal[i] = axeArtNames[i];
		}
		
		for (int i = 0; i < bowArtsFinal.length; i++) {
			bowArtsFinal[i] = bowArts[i];
			bowArtsNamesFinal[i] = bowArtNames[i];
		}
		
		for (int i = 0; i < gauntletArtsFinal.length; i++) {
			gauntletArtsFinal[i] = gauntletArts[i];
			gauntletArtsNamesFinal[i] = gauntletArtNames[i];
		}
		
		for (int i = 0; i < relicArtsFinal.length; i++) {
			relicArtsFinal[i] = relicArts[i];
			relicArtsNamesFinal[i] = relicArtNames[i];
		}
		
		while (gambitInput.hasNext()) {
			String gambitName = gambitInput.next();
			boolean gambitMagEqp = gambitInput.nextBoolean();
			int gambitMt = gambitInput.nextInt();
			int gambitHit = gambitInput.nextInt();
			String gambitNote = gambitInput.nextLine();
			
			GambitInfo newGambit = new GambitInfo(gambitName, gambitMagEqp, gambitMt, gambitHit, gambitNote);
			gambits = addGambit(gambits, newGambit);
			gambitNames = addName(gambitNames, gambitName);
		}
		gambitInput.close();
		final GambitInfo[] gambitsFinal = new GambitInfo[gambits.length];
		final String[] gambitNamesFinal = new String[gambitNames.length];
		
		for (int i = 0; i < gambits.length; i++) {
			gambitsFinal[i] = gambits[i];
			gambitNamesFinal[i] = gambitNames[i];
		}

		/*********************
		 *     GUI STUFF     *
		 ********************/

		SwingUtilities.invokeLater(() -> {
			GridBagConstraints gbc = new GridBagConstraints();
			
			/**
			 * INITIALIZATION
			 */
			JFrame frameSelector = new JFrame ("BHaE Battle Calculator");
			JFrame frameMain = new JFrame("BHaE Battle Calculator");
			JFrame frameCombatArt = new JFrame("Combat Art Selection");
			JFrame frameWeaponSelect = new JFrame("Weapon Select");
			JFrame frameGambit = new JFrame("BHaE Gambit Calculator");
			
			JPanel panelSelector = new JPanel();
			JPanel panelBattleSelection = new JPanel();
			JPanel panelBattleOutput = new JPanel();
			JPanel panelGambitOutput = new JPanel();
			JPanel panelWeaponSelect = new JPanel();
			JPanel panelWeaponConfirm = new JPanel();
			JPanel panelCAWeapon = new JPanel();
			JPanel panelArtConfirm = new JPanel();
			JPanel panelGambitSelection = new JPanel();
			
			JComboBox<String> competitorOne = new JComboBox<>(unitNamesFinal);
			JComboBox<String> competitorTwo = new JComboBox<>(unitNamesFinal);
			JComboBox<String> competitorOneGambit = new JComboBox<>(unitNamesFinal);
			JComboBox<String> competitorTwoGambit = new JComboBox<>(unitNamesFinal);
			
			JComboBox<String> swordsBox = new JComboBox<>(swordsNamesFinal);
			JComboBox<String> lancesBox = new JComboBox<>(lancesNamesFinal);
			JComboBox<String> axesBox = new JComboBox<>(axesNamesFinal);
			JComboBox<String> bowsBox = new JComboBox<>(bowsNamesFinal);
			JComboBox<String> gauntletsBox = new JComboBox<>(gauntletsNamesFinal);
			JComboBox<String> faithBox = new JComboBox<>(faithNamesFinal);
			JComboBox<String> reasonBox = new JComboBox<>(reasonNamesFinal);
			JComboBox<String> relicsBox = new JComboBox<>(relicsNamesFinal);
			
			JComboBox<String> swordArtBox = new JComboBox<>(swordArtsNamesFinal);
			JComboBox<String> lanceArtBox = new JComboBox<>(lanceArtsNamesFinal);
			JComboBox<String> axeArtBox = new JComboBox<>(axeArtsNamesFinal);
			JComboBox<String> bowArtBox = new JComboBox<>(bowArtsNamesFinal);
			JComboBox<String> gauntletArtBox = new JComboBox<>(gauntletArtsNamesFinal);
			JComboBox<String> relicsArtBox = new JComboBox<>(relicArtsNamesFinal);
			
			JComboBox<String> gambitBox = new JComboBox<>(gambitNamesFinal);
			
			JButton buttonNormalFight = new JButton("Normal Fight");
			JButton buttonGambitSwitch = new JButton("Gambit");
			JButton buttonFight = new JButton("Fight!");
			JButton buttonFightSwap = new JButton("Swap");
			JButton buttonWeaponChange = new JButton("Change Weapon");
			JButton buttonFightCombatArt = new JButton("CA Selected: None");
			
			JButton selectSword = new JButton("Sword");
			JButton selectLance = new JButton("Lance");
			JButton selectAxe = new JButton("Axe");
			JButton selectBow = new JButton("Bow");
			JButton selectGauntlet = new JButton("Gauntlets");
			JButton selectFaith = new JButton("Faith");
			JButton selectReason = new JButton("Reason");
			JButton selectRelic = new JButton("Relic");
			
			JButton selectSwordConfirm = new JButton("Confirm");
			JButton selectLanceConfirm = new JButton("Confirm");
			JButton selectAxeConfirm = new JButton("Confirm");
			JButton selectBowConfirm = new JButton("Confirm");
			JButton selectGauntletConfirm = new JButton("Confirm");
			JButton selectFaithConfirm = new JButton("Confirm");
			JButton selectReasonConfirm = new JButton("Confirm");
			JButton selectRelicConfirm = new JButton("Confirm");
			JButton selectWeaponCancel = new JButton("Cancel");
			
			JButton artNone = new JButton("None");
			JButton artSword = new JButton("Sword");
			JButton artLance = new JButton("Lance");
			JButton artAxe = new JButton("Axe");
			JButton artBow = new JButton("Bow");
			JButton artGauntlet = new JButton("Gauntlet");
			JButton artRelic = new JButton("Relic");
			
			JButton artNoneConfirm = new JButton("Confirm");
			JButton artSwordConfirm = new JButton("Confirm");
			JButton artLanceConfirm = new JButton("Confirm");
			JButton artAxeConfirm = new JButton("Confirm");
			JButton artBowConfirm = new JButton("Confirm");
			JButton artGauntletConfirm = new JButton("Confirm");
			JButton artRelicConfirm = new JButton("Confirm");
			
			JButton buttonGambitFight = new JButton("Fight!");
			
			/**
			 * COMPONENTS
			 */
			
			buttonGambitSwitch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameGambit.setVisible(true);
					frameSelector.setVisible(false);
				}
			});
			
			buttonNormalFight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameMain.setVisible(true);
					frameSelector.setVisible(false);
				}
			});
			

			buttonFight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo));
				}
			});
			
			buttonFightSwap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int unitOneIndexTemp = competitorOne.getSelectedIndex();
					int unitTwoIndexTemp = competitorTwo.getSelectedIndex();
					
					competitorOne.setSelectedIndex(unitTwoIndexTemp);
					competitorTwo.setSelectedIndex(unitOneIndexTemp);
					
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					
					UnitInfo competitorOne = unitsFinal[competitorOneIndex];
					UnitInfo competitorTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(competitorOne, competitorTwo));
				}
			});
			
			buttonWeaponChange.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameWeaponSelect.setVisible(true);
				}
			});
			
			selectWeaponCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectSword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.add(swordsBox, gbc);
					panelWeaponSelect.remove(lancesBox);
					panelWeaponSelect.remove(axesBox);
					panelWeaponSelect.remove(bowsBox);
					panelWeaponSelect.remove(gauntletsBox);
					panelWeaponSelect.remove(faithBox);
					panelWeaponSelect.remove(reasonBox);
					panelWeaponSelect.remove(relicsBox);
					selectSwordConfirm.setVisible(true);
					selectLanceConfirm.setVisible(false);
					selectAxeConfirm.setVisible(false);
					selectBowConfirm.setVisible(false);
					selectGauntletConfirm.setVisible(false);
					selectFaithConfirm.setVisible(false);
					selectReasonConfirm.setVisible(false);
					selectRelicConfirm.setVisible(false);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectLance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.remove(swordsBox);
					panelWeaponSelect.add(lancesBox, gbc);
					panelWeaponSelect.remove(axesBox);
					panelWeaponSelect.remove(bowsBox);
					panelWeaponSelect.remove(gauntletsBox);
					panelWeaponSelect.remove(faithBox);
					panelWeaponSelect.remove(reasonBox);
					panelWeaponSelect.remove(relicsBox);
					selectSwordConfirm.setVisible(false);
					selectLanceConfirm.setVisible(true);
					selectAxeConfirm.setVisible(false);
					selectBowConfirm.setVisible(false);
					selectGauntletConfirm.setVisible(false);
					selectFaithConfirm.setVisible(false);
					selectReasonConfirm.setVisible(false);
					selectRelicConfirm.setVisible(false);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectAxe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.remove(swordsBox);
					panelWeaponSelect.remove(lancesBox);
					panelWeaponSelect.add(axesBox, gbc);
					panelWeaponSelect.remove(bowsBox);
					panelWeaponSelect.remove(gauntletsBox);
					panelWeaponSelect.remove(faithBox);
					panelWeaponSelect.remove(reasonBox);
					panelWeaponSelect.remove(relicsBox);
					selectSwordConfirm.setVisible(false);
					selectLanceConfirm.setVisible(false);
					selectAxeConfirm.setVisible(true);
					selectBowConfirm.setVisible(false);
					selectGauntletConfirm.setVisible(false);
					selectFaithConfirm.setVisible(false);
					selectReasonConfirm.setVisible(false);
					selectRelicConfirm.setVisible(false);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectBow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.remove(swordsBox);
					panelWeaponSelect.remove(lancesBox);
					panelWeaponSelect.remove(axesBox);
					panelWeaponSelect.add(bowsBox, gbc);
					panelWeaponSelect.remove(gauntletsBox);
					panelWeaponSelect.remove(faithBox);
					panelWeaponSelect.remove(reasonBox);
					panelWeaponSelect.remove(relicsBox);
					selectSwordConfirm.setVisible(false);
					selectLanceConfirm.setVisible(false);
					selectAxeConfirm.setVisible(false);
					selectBowConfirm.setVisible(true);
					selectGauntletConfirm.setVisible(false);
					selectFaithConfirm.setVisible(false);
					selectReasonConfirm.setVisible(false);
					selectRelicConfirm.setVisible(false);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectGauntlet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.remove(swordsBox);
					panelWeaponSelect.remove(lancesBox);
					panelWeaponSelect.remove(axesBox);
					panelWeaponSelect.remove(bowsBox);
					panelWeaponSelect.add(gauntletsBox, gbc);
					panelWeaponSelect.remove(faithBox);
					panelWeaponSelect.remove(reasonBox);
					panelWeaponSelect.remove(relicsBox);
					selectSwordConfirm.setVisible(false);
					selectLanceConfirm.setVisible(false);
					selectAxeConfirm.setVisible(false);
					selectBowConfirm.setVisible(false);
					selectGauntletConfirm.setVisible(true);
					selectFaithConfirm.setVisible(false);
					selectReasonConfirm.setVisible(false);
					selectRelicConfirm.setVisible(false);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectFaith.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.remove(swordsBox);
					panelWeaponSelect.remove(lancesBox);
					panelWeaponSelect.remove(axesBox);
					panelWeaponSelect.remove(bowsBox);
					panelWeaponSelect.remove(gauntletsBox);
					panelWeaponSelect.add(faithBox, gbc);
					panelWeaponSelect.remove(reasonBox);
					panelWeaponSelect.remove(relicsBox);
					selectSwordConfirm.setVisible(false);
					selectLanceConfirm.setVisible(false);
					selectAxeConfirm.setVisible(false);
					selectBowConfirm.setVisible(false);
					selectGauntletConfirm.setVisible(false);
					selectFaithConfirm.setVisible(true);
					selectReasonConfirm.setVisible(false);
					selectRelicConfirm.setVisible(false);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectReason.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.remove(swordsBox);
					panelWeaponSelect.remove(lancesBox);
					panelWeaponSelect.remove(axesBox);
					panelWeaponSelect.remove(bowsBox);
					panelWeaponSelect.remove(gauntletsBox);
					panelWeaponSelect.remove(faithBox);
					panelWeaponSelect.add(reasonBox, gbc);
					panelWeaponSelect.remove(relicsBox);
					selectSwordConfirm.setVisible(false);
					selectLanceConfirm.setVisible(false);
					selectAxeConfirm.setVisible(false);
					selectBowConfirm.setVisible(false);
					selectGauntletConfirm.setVisible(false);
					selectFaithConfirm.setVisible(false);
					selectReasonConfirm.setVisible(true);
					selectRelicConfirm.setVisible(false);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectRelic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelWeaponSelect.remove(swordsBox);
					panelWeaponSelect.remove(lancesBox);
					panelWeaponSelect.remove(axesBox);
					panelWeaponSelect.remove(bowsBox);
					panelWeaponSelect.remove(gauntletsBox);
					panelWeaponSelect.remove(faithBox);
					panelWeaponSelect.remove(reasonBox);
					panelWeaponSelect.add(relicsBox, gbc);
					selectSwordConfirm.setVisible(false);
					selectLanceConfirm.setVisible(false);
					selectAxeConfirm.setVisible(false);
					selectBowConfirm.setVisible(false);
					selectGauntletConfirm.setVisible(false);
					selectFaithConfirm.setVisible(false);
					selectReasonConfirm.setVisible(false);
					selectRelicConfirm.setVisible(true);
					frameWeaponSelect.invalidate();
					frameWeaponSelect.validate();
					frameWeaponSelect.repaint();
				}
			});
			
			selectSwordConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 0;
					int weaponIndex = swordsBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(swordsFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectLanceConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 1;
					int weaponIndex = lancesBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(lancesFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectAxeConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 2;
					int weaponIndex = axesBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(axesFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectBowConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 3;
					int weaponIndex = bowsBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(bowsFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectGauntletConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 4;
					int weaponIndex = gauntletsBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(gauntletsFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectFaithConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 5;
					int weaponIndex = faithBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(faithFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectReasonConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 6;
					int weaponIndex = reasonBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(reasonFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			selectRelicConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int weaponTypeIndex = 7;
					int weaponIndex = relicsBox.getSelectedIndex();
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					try {
						modifyFile("units.txt", unitsFinal, competitorOneIndex, weaponTypeIndex, weaponIndex);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
				    unitOne.changeUnitWep(relicsFinal, weaponIndex);
					resultPanel.setText(battle(unitOne, unitTwo));
					frameWeaponSelect.setVisible(false);
				}
			});
			
			buttonFightCombatArt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameCombatArt.setVisible(true);
					buttonFightCombatArt.setText("CA Selected: ?");
				}
			});
			
			artNone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					panelCAWeapon.remove(relicsArtBox);
					artNoneConfirm.setVisible(true);
					artSwordConfirm.setVisible(false);
					artLanceConfirm.setVisible(false);
					artAxeConfirm.setVisible(false);
					artBowConfirm.setVisible(false);
					artGauntletConfirm.setVisible(false);
					artRelicConfirm.setVisible(false);
				}
			});
			
			artSword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.add(swordArtBox, gbc);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					panelCAWeapon.remove(relicsArtBox);
					artNoneConfirm.setVisible(false);
					artSwordConfirm.setVisible(true);
					artLanceConfirm.setVisible(false);
					artAxeConfirm.setVisible(false);
					artBowConfirm.setVisible(false);
					artGauntletConfirm.setVisible(false);
					artRelicConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			artLance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.add(lanceArtBox, gbc);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					panelCAWeapon.remove(relicsArtBox);
					artNoneConfirm.setVisible(false);
					artSwordConfirm.setVisible(false);
					artLanceConfirm.setVisible(true);
					artAxeConfirm.setVisible(false);
					artBowConfirm.setVisible(false);
					artGauntletConfirm.setVisible(false);
					artRelicConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			artAxe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.add(axeArtBox, gbc);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					panelCAWeapon.remove(relicsArtBox);
					artNoneConfirm.setVisible(false);
					artSwordConfirm.setVisible(false);
					artLanceConfirm.setVisible(false);
					artAxeConfirm.setVisible(true);
					artBowConfirm.setVisible(false);
					artGauntletConfirm.setVisible(false);
					artRelicConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			artBow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.add(bowArtBox, gbc);
					panelCAWeapon.remove(gauntletArtBox);
					panelCAWeapon.remove(relicsArtBox);
					artNoneConfirm.setVisible(false);
					artSwordConfirm.setVisible(false);
					artLanceConfirm.setVisible(false);
					artAxeConfirm.setVisible(false);
					artBowConfirm.setVisible(true);
					artGauntletConfirm.setVisible(false);
					artRelicConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			artGauntlet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.add(gauntletArtBox, gbc);
					panelCAWeapon.remove(relicsArtBox);
					artNoneConfirm.setVisible(false);
					artSwordConfirm.setVisible(false);
					artLanceConfirm.setVisible(false);
					artAxeConfirm.setVisible(false);
					artBowConfirm.setVisible(false);
					artGauntletConfirm.setVisible(true);
					artRelicConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			artRelic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					panelCAWeapon.add(relicsArtBox, gbc);
					artNoneConfirm.setVisible(false);
					artSwordConfirm.setVisible(false);
					artLanceConfirm.setVisible(false);
					artAxeConfirm.setVisible(false);
					artBowConfirm.setVisible(false);
					artGauntletConfirm.setVisible(false);
					artRelicConfirm.setVisible(true);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			artNoneConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonFightCombatArt.setText("CA Selected: None");
					frameCombatArt.setVisible(false);
				}
			});
			
			artSwordConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int artWeaponTypeIndex = swordArtBox.getSelectedIndex();
					ArtInfo selectedArt = swordArtsFinal[artWeaponTypeIndex];
					String combatArtNameSelected = swordArtsNamesFinal[artWeaponTypeIndex];
					buttonFightCombatArt.setText("CA Selected: " + combatArtNameSelected);
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo, selectedArt));
					frameCombatArt.setVisible(false);
				}
			});
			
			artLanceConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int artWeaponTypeIndex = lanceArtBox.getSelectedIndex();
					ArtInfo selectedArt = lanceArtsFinal[artWeaponTypeIndex];
					String combatArtNameSelected = lanceArtsNamesFinal[artWeaponTypeIndex];
					buttonFightCombatArt.setText("CA Selected: " + combatArtNameSelected);
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo, selectedArt));
					frameCombatArt.setVisible(false);
				}
			});
			
			artAxeConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int artWeaponTypeIndex = axeArtBox.getSelectedIndex();
					ArtInfo selectedArt = axeArtsFinal[artWeaponTypeIndex];
					String combatArtNameSelected = axeArtsNamesFinal[artWeaponTypeIndex];
					buttonFightCombatArt.setText("CA Selected: " + combatArtNameSelected);
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo, selectedArt));
					frameCombatArt.setVisible(false);
				}
			});
			
			artBowConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int artWeaponTypeIndex = bowArtBox.getSelectedIndex();
					ArtInfo selectedArt = bowArtsFinal[artWeaponTypeIndex];
					String combatArtNameSelected = bowArtsNamesFinal[artWeaponTypeIndex];
					buttonFightCombatArt.setText("CA Selected: " + combatArtNameSelected);
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo, selectedArt));
					frameCombatArt.setVisible(false);
				}
			});
			
			artGauntletConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int artWeaponTypeIndex = gauntletArtBox.getSelectedIndex();
					ArtInfo selectedArt = gauntletArtsFinal[artWeaponTypeIndex];
					String combatArtNameSelected = gauntletArtsNamesFinal[artWeaponTypeIndex];
					buttonFightCombatArt.setText("CA Selected: " + combatArtNameSelected);
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo, selectedArt));
					frameCombatArt.setVisible(false);
				}
			});
			
			artRelicConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int artWeaponTypeIndex = relicsArtBox.getSelectedIndex();
					ArtInfo selectedArt = relicArtsFinal[artWeaponTypeIndex];
					String combatArtNameSelected = gauntletArtsNamesFinal[artWeaponTypeIndex];
					buttonFightCombatArt.setText("CA Selected: " + combatArtNameSelected);
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo, selectedArt));
					frameCombatArt.setVisible(false);
				}
			});
			
			buttonGambitFight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int competitorOneIndex = competitorOneGambit.getSelectedIndex();
					int competitorTwoIndex = competitorTwoGambit.getSelectedIndex();
					int gambitIndex = gambitBox.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					GambitInfo gambit = gambitsFinal[gambitIndex];
					resultPanelGambit.setText(gambit(unitOne, unitTwo, gambit));
				}
			});
			
			/**
			 * PANELS
			 */
			
			panelSelector.setLayout(new GridBagLayout());
			panelSelector.add(buttonNormalFight, gbc);
			panelSelector.add(buttonGambitSwitch, gbc);

			panelBattleSelection.add(competitorOne);
			panelBattleSelection.add(competitorTwo);
			panelBattleSelection.add(buttonFight);
			panelBattleSelection.add(buttonFightSwap);
			panelBattleSelection.add(buttonWeaponChange);
			panelBattleSelection.add(buttonFightCombatArt);
			
			panelWeaponSelect.add(selectSword);
			panelWeaponSelect.add(selectLance);
			panelWeaponSelect.add(selectAxe);
			panelWeaponSelect.add(selectBow);
			panelWeaponSelect.add(selectGauntlet);
			panelWeaponSelect.add(selectFaith);
			panelWeaponSelect.add(selectReason);
			panelWeaponSelect.add(selectRelic);
			
			panelWeaponConfirm.setLayout(new FlowLayout(FlowLayout.RIGHT));
			panelWeaponConfirm.add(selectSwordConfirm);
			selectSwordConfirm.setVisible(false);
			panelWeaponConfirm.add(selectLanceConfirm);
			selectLanceConfirm.setVisible(false);
			panelWeaponConfirm.add(selectAxeConfirm);
			selectAxeConfirm.setVisible(false);
			panelWeaponConfirm.add(selectBowConfirm);
			selectBowConfirm.setVisible(false);
			panelWeaponConfirm.add(selectGauntletConfirm);
			selectGauntletConfirm.setVisible(false);
			panelWeaponConfirm.add(selectFaithConfirm);
			selectFaithConfirm.setVisible(false);
			panelWeaponConfirm.add(selectReasonConfirm);
			selectReasonConfirm.setVisible(false);
			panelWeaponConfirm.add(selectWeaponCancel);
			panelWeaponConfirm.add(selectRelicConfirm);
			selectRelicConfirm.setVisible(false);
			selectWeaponCancel.setVisible(true);
			
			panelCAWeapon.add(artNone, gbc);
			panelCAWeapon.add(artSword, gbc);
			panelCAWeapon.add(artLance, gbc);
			panelCAWeapon.add(artAxe, gbc);
			panelCAWeapon.add(artBow, gbc);
			panelCAWeapon.add(artGauntlet, gbc);
			panelCAWeapon.add(artRelic, gbc);
			
			panelArtConfirm.setLayout(new FlowLayout(FlowLayout.RIGHT));
			panelArtConfirm.add(artNoneConfirm);
			artNoneConfirm.setVisible(false);
			panelArtConfirm.add(artSwordConfirm);
			artSwordConfirm.setVisible(false);
			panelArtConfirm.add(artLanceConfirm);
			artLanceConfirm.setVisible(false);
			panelArtConfirm.add(artAxeConfirm);
			artAxeConfirm.setVisible(false);
			panelArtConfirm.add(artBowConfirm);
			artBowConfirm.setVisible(false);
			panelArtConfirm.add(artGauntletConfirm);
			artGauntletConfirm.setVisible(false);
			panelArtConfirm.add(artRelicConfirm);
			artRelicConfirm.setVisible(false);
			
			panelGambitSelection.add(competitorOneGambit);
			panelGambitSelection.add(competitorTwoGambit);
			panelGambitSelection.add(gambitBox);
			panelGambitSelection.add(buttonGambitFight);

			panelBattleOutput.add(resultPanel);
			resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
			
			panelGambitOutput.add(resultPanelGambit);
			resultPanelGambit.setAlignmentX(Component.LEFT_ALIGNMENT);
			
			/**
			 * FRAMES
			 */
			
			frameSelector.setVisible(true);
			frameSelector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frameSelector.getContentPane().add(panelSelector, BorderLayout.CENTER);
			frameSelector.pack();
			frameSelector.setLocationRelativeTo(null);
			frameSelector.setSize(300, 200);
			
			frameMain.getContentPane().add(panelBattleSelection, BorderLayout.SOUTH);
			frameMain.getContentPane().add(panelBattleOutput, BorderLayout.WEST);
			frameMain.pack();
			frameMain.setLocationRelativeTo(null);
			frameMain.setSize(800, 375);
			
			frameWeaponSelect.setLocationRelativeTo(null);
			frameWeaponSelect.add(panelWeaponSelect);
			frameWeaponSelect.setSize(650,400);
			frameWeaponSelect.add(panelWeaponConfirm, BorderLayout.SOUTH);
			
			frameCombatArt.getContentPane().add(panelCAWeapon, BorderLayout.CENTER);
			frameCombatArt.setLocationRelativeTo(null);
			frameCombatArt.setSize(550,400);
			frameCombatArt.add(panelArtConfirm, BorderLayout.SOUTH);
			
			frameGambit.getContentPane().add(panelGambitOutput);
			frameGambit.getContentPane().add(panelGambitSelection, BorderLayout.SOUTH);
			frameGambit.setSize(800,300);
			frameGambit.setLocationRelativeTo(null);
		});
	}
	
	/**************************************
	 *     GUI STUFF ENDS                 *
	 *                                    *
	 *     i really wish i                *
	 *     understood how gui works       *
	 *     this is a haiku                *
	 **************************************/

	// addWeapon helper method
	private static WeaponInfo[] addWeapon(WeaponInfo[] weapons, WeaponInfo weaponToAdd) {
		WeaponInfo[] newWeapons = new WeaponInfo[weapons.length + 1];
		System.arraycopy(weapons, 0, newWeapons, 0, weapons.length);
		newWeapons[newWeapons.length - 1] = weaponToAdd;

		return newWeapons;
	}
	
	// addUnit helper method
	private static UnitInfo[] addUnit(UnitInfo[] units, UnitInfo unitToAdd) {
		UnitInfo[] newUnits = new UnitInfo[units.length + 1];
		System.arraycopy(units, 0, newUnits, 0, units.length);
		newUnits[newUnits.length - 1] = unitToAdd;

		return newUnits;
	}
	
	// addName helper method
	private static String[] addName(String[] names, String nameToAdd) {
		String[] newNames = new String[names.length + 1];
		System.arraycopy(names, 0, newNames, 0, names.length);
		newNames[newNames.length - 1] = nameToAdd;
		
		return newNames;
	}
	
	// addArt helper method
	private static ArtInfo[] addArt(ArtInfo[] arts, ArtInfo artToAdd) {
		ArtInfo[] newArts = new ArtInfo[arts.length + 1];
		System.arraycopy(arts, 0, newArts, 0, arts.length);
		newArts[newArts.length - 1] = artToAdd;

		return newArts;
	}
	
	// addGambit helper method
	private static GambitInfo[] addGambit(GambitInfo[] gambits, GambitInfo gambitToAdd) {
		GambitInfo[] newGambits = new GambitInfo[gambits.length + 1];
		System.arraycopy(gambits, 0, newGambits, 0, gambits.length);
		newGambits[newGambits.length - 1] = gambitToAdd;

		return newGambits;
	}
	
	// modifyFile helper method
    static void modifyFile(String filePath, UnitInfo[] unitArray, int unitInd, int newWepTyp, int newWepID) throws IOException {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
         
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
            
            //Making the newString
            
            String oldName = unitArray[unitInd].name;
            int oldHP = unitArray[unitInd].hp;
            int oldStr = unitArray[unitInd].str;
            int oldMag = unitArray[unitInd].mag;
            int oldDex = unitArray[unitInd].dex;
            int oldSpd = unitArray[unitInd].spd;
            int oldLck = unitArray[unitInd].lck;
            int oldDef = unitArray[unitInd].def;
            int oldRes = unitArray[unitInd].res;
            int oldCha = unitArray[unitInd].cha;
            int oldWeaponType = unitArray[unitInd].wepTypeInd;
            int oldWeaponID = unitArray[unitInd].wepInd;
            int newWeaponType = newWepTyp;
            int newWeaponID = newWepID;

            String oldString =
            		oldName
            		+ " " + oldHP + " " + oldStr + " " + oldMag + " " + oldDex + " " + oldSpd + " " + oldLck
            		+ " " + oldDef + " " + oldRes + " " + oldCha + " " + oldWeaponType + " " + oldWeaponID;
            String newString =
            		oldName
            		+ " " + oldHP + " " + oldStr + " " + oldMag + " " + oldDex + " " + oldSpd + " " + oldLck
            		+ " " + oldDef + " " + oldRes + " " + oldCha + " " + newWeaponType + " " + newWeaponID;
            
            String newContent = oldContent.replaceAll(oldString, newString);
            
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e)  {
                e.printStackTrace();
            }
        }
    }
    
	// Calculating battle info
	public static String battle(UnitInfo attacker, UnitInfo target) {
		String results;
		int critDmgAttacker;
		int dmgFinalAttacker;
		String dmgFinalAttackerString;
		int hitFinalAttacker;
		int critFinalAttacker;
		int critDmgTarget;
		int dmgFinalTarget;
		String dmgFinalTargetString;
		int hitFinalTarget;
		int critFinalTarget;
		
		if(attacker.magEqp) {
			dmgFinalAttacker = attacker.magAtk - target.res;
		} else {
			dmgFinalAttacker = attacker.physAtk - target.def;
		}
		hitFinalAttacker = attacker.hit - target.genAvo;
		critFinalAttacker = attacker.crit - target.critAvo;
		critDmgAttacker = dmgFinalAttacker * 3;
		
		if(target.magEqp) {
			dmgFinalTarget = target.magAtk - attacker.res;
		} else {
			dmgFinalTarget = target.physAtk - attacker.def;
		}
		hitFinalTarget = target.hit - attacker.genAvo;
		critFinalTarget = target.crit - attacker.critAvo;
		critDmgTarget = dmgFinalTarget * 3;
		
		
		if(attacker.atkSpd - target.atkSpd >= 4) {
			dmgFinalAttackerString = "\nMt: " + dmgFinalAttacker + " x2";
		} else {
			dmgFinalAttackerString = "\nMt: "+ dmgFinalAttacker;
		}
		critDmgAttacker = dmgFinalAttacker * 3;
		
		if(target.atkSpd - attacker.atkSpd >= 4) {
			dmgFinalTargetString = "\nMt: " + dmgFinalTarget + " x2";
		} else {
			dmgFinalTargetString = "\nMt: "+ dmgFinalTarget;
		}
		critDmgAttacker = dmgFinalAttacker * 3;
		
		results = attacker.name + " attacks " + target.name + " with " + attacker.wepName + "!"
				+ dmgFinalAttackerString
				+ "\nHit: " + hitFinalAttacker
				+ "\nCrit: " + critFinalAttacker
				+ "\nCrit Mt: " + critDmgAttacker
				
				+ "\n\n If " + target.name + " counters:"
				+ dmgFinalTargetString
				+ "\nHit: " + hitFinalTarget
				+ "\nCrit: " + critFinalTarget
				+ "\nCrit Mt: " + critDmgTarget
				
				+ "\n\n" + attacker.name + "'s Crest: " + attacker.crest
				+ "\n" + attacker.name + "'s Personal: " + attacker.personal
				+ "\n\n" + target.name + "'s Crest: " + target.crest
				+ "\n" + target.name + "'s Personal: " + target.personal;
		
		return results;
	}
	
	public static String battle(UnitInfo attacker, UnitInfo target, ArtInfo combatArt) {
		String results;
		String dmgFinalTargetString;
		int critDmgAttacker;
		int dmgFinalAttacker;
		int hitFinalAttacker;
		int critFinalAttacker;
		int critDmgTarget;
		int dmgFinalTarget;
		int hitFinalTarget;
		int critFinalTarget;
		
		if(attacker.magEqp || combatArt.magEqp) {
			dmgFinalAttacker = attacker.magAtk + combatArt.mt - target.res;
		} else {
			dmgFinalAttacker = attacker.physAtk + combatArt.mt - target.def;
		}
		hitFinalAttacker = attacker.hit - target.genAvo + combatArt.hit;
		critFinalAttacker = attacker.crit - target.critAvo + combatArt.crit;
		critDmgAttacker = dmgFinalAttacker * 3;
		
		if(target.magEqp) {
			dmgFinalTarget = target.magAtk - attacker.res;
		} else {
			dmgFinalTarget = target.physAtk - attacker.def;
		}
		hitFinalTarget = target.hit - attacker.genAvo - combatArt.avo;
		critFinalTarget = target.crit - attacker.critAvo;
		critDmgTarget = dmgFinalTarget * 3;
		
		if(target.atkSpd - attacker.atkSpd >= 4) {
			dmgFinalTargetString = "\nMt: " + dmgFinalTarget + " x2";
		} else {
			dmgFinalTargetString = "\nMt: "+ dmgFinalTarget;
		}
		critDmgAttacker = dmgFinalAttacker * 3;
		
		results = attacker.name + " attacks " + target.name + " with " + combatArt.name + " (" + attacker.wepName + ")!"
				+ "\nMt: "+ dmgFinalAttacker
				+ "\nHit: " + hitFinalAttacker
				+ "\nCrit: " + critFinalAttacker
				+ "\nCrit Mt: " + critDmgAttacker
				+ "\nEffect: " + combatArt.note
				
				+ "\n\n If " + target.name + " counters:"
				+ dmgFinalTargetString
				+ "\nHit: " + hitFinalTarget
				+ "\nCrit: " + critFinalTarget
				+ "\nCrit Mt: " + critDmgTarget
				
				+ "\n\n" + attacker.name + "'s Crest: " + attacker.crest
				+ "\n" + attacker.name + "'s Personal: " + attacker.personal
				+ "\n\n" + target.name + "'s Crest: " + target.crest
				+ "\n" + target.name + "'s Personal: " + target.personal
				;
		
		return results;
	}
	
	public static String gambit(UnitInfo attacker, UnitInfo target, GambitInfo gambit) {
		String results = null;
		int gambitDmg;
		int gambitHit;
		int attackerCha5 = attacker.cha / 5;
		int attackerMag3 = attacker.mag / 3;
		
		if(gambit.name.compareTo("ResonantWhiteMagic") == 0) {
			gambitDmg = gambit.mt + attackerMag3;
		}
		else if(gambit.magEqp) {
			gambitDmg = gambit.mt + attackerCha5 + attacker.magAtk - target.res;
		} else {
			gambitDmg = gambit.mt + attackerCha5 + attacker.physAtk - target.def;
		}
		
		gambitHit = gambit.hit + (attacker.cha - target.cha) * 5;
		
		results = attacker.name + " orders " + gambit.name + " on " + target.name + "!"
				+ "\nMt: " + gambitDmg
				+ "\nHit: " + gambitHit
				+ "\nEffect: " + gambit.note
				+ "\n\n" + attacker.name + "'s Crest: " + attacker.crest
				+ "\n" + attacker.name + "'s Personal: " + attacker.personal
				+ "\n\n" + target.name + "'s Crest: " + target.crest
				+ "\n" + target.name + "'s Personal: " + target.personal
				+ "\n\n(unit authority proficiency modifier not added to Mt)";
		
		return results;
	}
}