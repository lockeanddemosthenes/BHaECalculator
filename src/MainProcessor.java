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
 * @updated February 17, 2020
 */
	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class MainProcessor {
	final static JTextArea resultPanel = new JTextArea();

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner weaponInput = new Scanner(new File("weapons.txt"));
		Scanner unitInput = new Scanner(new File("units.txt"));
		Scanner swordArtInput = new Scanner(new File("swordarts.txt"));
		Scanner lanceArtInput = new Scanner(new File("lancearts.txt"));
		Scanner axeArtInput = new Scanner(new File("axearts.txt"));
		Scanner bowArtInput = new Scanner(new File("bowarts.txt"));
		Scanner gauntletArtInput = new Scanner(new File("gauntletarts.txt"));
		
		final String swordString = "Sword";
	    final String lanceString = "Lance";
	    final String axeString = "Axe";
	    final String bowString = "Bow";
	    final String gauntletString = "Gauntlet";
		
		// parse weapon list
		WeaponInfo[] weapons = new WeaponInfo[0];
		while (weaponInput.hasNext()) {
			String wepName = weaponInput.next();
			boolean magEqp = weaponInput.nextBoolean();
			int mtBase = weaponInput.nextInt();
			int hitBase = weaponInput.nextInt();
			int critBase = weaponInput.nextInt();
			int wt = weaponInput.nextInt();

			WeaponInfo newWeapon = new WeaponInfo(wepName, magEqp, mtBase, hitBase, critBase, wt);
			weapons = addWeapon(weapons, newWeapon);
		}
		weaponInput.close();
		
		// parse unit list
		UnitInfo[] units = new UnitInfo[0];
		String[] unitNames = new String[0];
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
			int wepInd = unitInput.nextInt();
			wepInd = wepInd - 1;
			WeaponInfo wepID = weapons[wepInd];

			UnitInfo newUnit = new UnitInfo(name, hp, str, mag, dex, spd, lck, def, res, cha, wepID);
			units = addUnit(units, newUnit);
			unitNames = addName(unitNames, name);
		}
		unitInput.close();
		final UnitInfo[] unitsFinal = new UnitInfo[units.length];
		final String[] unitNameList = new String[unitNames.length];
		
		for (int i = 0; i < units.length; i++) {
			unitsFinal[i] = units[i];
			unitNameList[i] = unitNames[i];
		}
		
		// parse sword art list
		ArtInfo[] swordArts = new ArtInfo[0];
		String[] swordArtNames = new String[0];
		while (swordArtInput.hasNext()) {
			String artName = swordArtInput.next();
			int artMt = swordArtInput.nextInt();
			int artHit = swordArtInput.nextInt();
			int artCrit = swordArtInput.nextInt();
			int artAvo = swordArtInput.nextInt();
			boolean artMagEqp = swordArtInput.nextBoolean();
			String artNote = swordArtInput.nextLine();

			ArtInfo newArt = new ArtInfo(artName, artMt, artHit, artCrit, artAvo, artMagEqp, artNote);
			swordArts = addArt(swordArts, newArt);
			swordArtNames = addName(swordArtNames, artName);
		}
		swordArtInput.close();
		final ArtInfo[] swordArtsFinal = new ArtInfo[swordArts.length];
		final String[] swordArtsNamesFinal = new String[swordArtNames.length];
		
		for (int i = 0; i < swordArtsFinal.length; i++) {
			swordArtsFinal[i] = swordArts[i];
			swordArtsNamesFinal[i] = swordArtNames[i];
		}
		
		// parse lance art list
		ArtInfo[] lanceArts = new ArtInfo[0];
		String[] lanceArtNames = new String[0];
		while (lanceArtInput.hasNext()) {
			String artName = lanceArtInput.next();
			int artMt = lanceArtInput.nextInt();
			int artHit = lanceArtInput.nextInt();
			int artCrit = lanceArtInput.nextInt();
			int artAvo = lanceArtInput.nextInt();
			boolean artMagEqp = lanceArtInput.nextBoolean();
			String artNote = lanceArtInput.nextLine();

			ArtInfo newArt = new ArtInfo(artName, artMt, artHit, artCrit, artAvo, artMagEqp, artNote);
			lanceArts = addArt(lanceArts, newArt);
			lanceArtNames = addName(lanceArtNames, artName);
		}
		lanceArtInput.close();
		final ArtInfo[] lanceArtsFinal = new ArtInfo[lanceArts.length];
		final String[] lanceArtsNamesFinal = new String[lanceArtNames.length];
		for (int i = 0; i < lanceArts.length; i++) {
			lanceArtsFinal[i] = lanceArts[i];
			lanceArtsNamesFinal[i] = lanceArtNames[i];
		}
		
		// parse axe art list
		ArtInfo[] axeArts = new ArtInfo[0];
		String[] axeArtNames = new String[0];
		while (axeArtInput.hasNext()) {
			String artName = axeArtInput.next();
			int artMt = axeArtInput.nextInt();
			int artHit = axeArtInput.nextInt();
			int artCrit = axeArtInput.nextInt();
			int artAvo = axeArtInput.nextInt();
			boolean artMagEqp = axeArtInput.nextBoolean();
			String artNote = axeArtInput.nextLine();

			ArtInfo newArt = new ArtInfo(artName, artMt, artHit, artCrit, artAvo, artMagEqp, artNote);
			axeArts = addArt(axeArts, newArt);
			axeArtNames = addName(axeArtNames, artName);
		}
		axeArtInput.close();
		final ArtInfo[] axeArtsFinal = new ArtInfo[axeArts.length];
		final String[] axeArtsNamesFinal = new String[axeArtNames.length];
		for (int i = 0; i < axeArtsFinal.length; i++) {
			axeArtsFinal[i] = axeArts[i];
			axeArtsNamesFinal[i] = axeArtNames[i];
		}
		
		// parse bow art list
		ArtInfo[] bowArts = new ArtInfo[0];
		String[] bowArtNames = new String[0];
		while (bowArtInput.hasNext()) {
			String artName = bowArtInput.next();
			int artMt = bowArtInput.nextInt();
			int artHit = bowArtInput.nextInt();
			int artCrit = bowArtInput.nextInt();
			int artAvo = bowArtInput.nextInt();
			boolean artMagEqp = bowArtInput.nextBoolean();
			String artNote = bowArtInput.nextLine();

			ArtInfo newArt = new ArtInfo(artName, artMt, artHit, artCrit, artAvo, artMagEqp, artNote);
			bowArts = addArt(bowArts, newArt);
			bowArtNames = addName(bowArtNames, artName);
		}
		bowArtInput.close();
		final ArtInfo[] bowArtsFinal = new ArtInfo[bowArts.length];
		final String[] bowArtsNamesFinal = new String[bowArtNames.length];
		
		for (int i = 0; i < bowArtsFinal.length; i++) {
			bowArtsFinal[i] = bowArts[i];
			bowArtsNamesFinal[i] = bowArtNames[i];
		}
		
		// parse gauntlet art list
		ArtInfo[] gauntletArts = new ArtInfo[0];
		String[] gauntletArtNames = new String[0];
		while (gauntletArtInput.hasNext()) {
			String artName = gauntletArtInput.next();
			int artMt = gauntletArtInput.nextInt();
			int artHit = gauntletArtInput.nextInt();
			int artCrit = gauntletArtInput.nextInt();
			int artAvo = gauntletArtInput.nextInt();
			boolean artMagEqp = gauntletArtInput.nextBoolean();
			String artNote = gauntletArtInput.nextLine();

			ArtInfo newArt = new ArtInfo(artName, artMt, artHit, artCrit, artAvo, artMagEqp, artNote);
			gauntletArts = addArt(gauntletArts, newArt);
			gauntletArtNames = addName(gauntletArtNames, artName);
		}
		gauntletArtInput.close();
		final ArtInfo[] gauntletArtsFinal = new ArtInfo[gauntletArts.length];
		final String[] gauntletArtsNamesFinal = new String[gauntletArtNames.length];
		for (int i = 0; i < gauntletArtsFinal.length; i++) {
			gauntletArtsFinal[i] = gauntletArts[i];
			gauntletArtsNamesFinal[i] = gauntletArtNames[i];
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
			
			JPanel panelSelector = new JPanel();
			JPanel panelBattleSelection = new JPanel();
			JPanel panelBattleOutput = new JPanel();
			JPanel panelCAWeapon = new JPanel();
			JPanel panelArtConfirm = new JPanel();
			
			JComboBox<String> competitorOne = new JComboBox<>(unitNameList);
			JComboBox<String> competitorTwo = new JComboBox<>(unitNameList);
			JComboBox<String> swordArtBox = new JComboBox<>(swordArtsNamesFinal);
			JComboBox<String> lanceArtBox = new JComboBox<>(lanceArtsNamesFinal);
			JComboBox<String> axeArtBox = new JComboBox<>(axeArtsNamesFinal);
			JComboBox<String> bowArtBox = new JComboBox<>(bowArtsNamesFinal);
			JComboBox<String> gauntletArtBox = new JComboBox<>(gauntletArtsNamesFinal);
			
			JButton buttonNormalFight = new JButton("Normal Fight");
			JButton buttonGambitCalc = new JButton("Gambit");
			JButton buttonFight = new JButton("Fight!");
			JButton buttonFightSwap = new JButton("Swap");
			JButton buttonFightCombatArt = new JButton("CA Selected: None");
			
			JButton none = new JButton("None");
			JButton sword = new JButton("Sword");
			JButton lance = new JButton("Lance");
			JButton axe = new JButton("Axe");
			JButton bow = new JButton("Bow");
			JButton gauntlet = new JButton("Gauntlet");
			
			JButton noneConfirm = new JButton("Confirm");
			JButton swordConfirm = new JButton("Confirm");
			JButton lanceConfirm = new JButton("Confirm");
			JButton axeConfirm = new JButton("Confirm");
			JButton bowConfirm = new JButton("Confirm");
			JButton gauntletConfirm = new JButton("Confirm");
			
			/**
			 * COMPONENTS
			 */
			
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
			
			buttonFightCombatArt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frameCombatArt.setVisible(true);
					buttonFightCombatArt.setText("CA Selected: ?");
				}
			});
			
			none.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					noneConfirm.setVisible(true);
					swordConfirm.setVisible(false);
					lanceConfirm.setVisible(false);
					axeConfirm.setVisible(false);
					bowConfirm.setVisible(false);
					gauntletConfirm.setVisible(false);
				}
			});
			
			sword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sword.setActionCommand(swordString);
					panelCAWeapon.add(swordArtBox, gbc);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					noneConfirm.setVisible(false);
					swordConfirm.setVisible(true);
					lanceConfirm.setVisible(false);
					axeConfirm.setVisible(false);
					bowConfirm.setVisible(false);
					gauntletConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			lance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lance.setActionCommand(lanceString);
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.add(lanceArtBox, gbc);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					noneConfirm.setVisible(false);
					swordConfirm.setVisible(false);
					lanceConfirm.setVisible(true);
					axeConfirm.setVisible(false);
					bowConfirm.setVisible(false);
					gauntletConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			axe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					axe.setActionCommand(axeString);
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.add(axeArtBox, gbc);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.remove(gauntletArtBox);
					noneConfirm.setVisible(false);
					swordConfirm.setVisible(false);
					lanceConfirm.setVisible(false);
					axeConfirm.setVisible(true);
					bowConfirm.setVisible(false);
					gauntletConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			bow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bow.setActionCommand(bowString);
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.add(bowArtBox, gbc);
					panelCAWeapon.remove(gauntletArtBox);
					noneConfirm.setVisible(false);
					swordConfirm.setVisible(false);
					lanceConfirm.setVisible(false);
					axeConfirm.setVisible(false);
					bowConfirm.setVisible(true);
					gauntletConfirm.setVisible(false);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			gauntlet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gauntlet.setActionCommand(gauntletString);
					panelCAWeapon.remove(swordArtBox);
					panelCAWeapon.remove(lanceArtBox);
					panelCAWeapon.remove(axeArtBox);
					panelCAWeapon.remove(bowArtBox);
					panelCAWeapon.add(gauntletArtBox, gbc);
					noneConfirm.setVisible(false);
					swordConfirm.setVisible(false);
					lanceConfirm.setVisible(false);
					axeConfirm.setVisible(false);
					bowConfirm.setVisible(false);
					gauntletConfirm.setVisible(true);
					frameCombatArt.invalidate();
					frameCombatArt.validate();
					frameCombatArt.repaint();
				}
			});
			
			noneConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> competitorOne = new JComboBox<>(unitNameList);
					JComboBox<String> competitorTwo = new JComboBox<>(unitNameList);
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo unitOne = unitsFinal[competitorOneIndex];
					UnitInfo unitTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(unitOne, unitTwo));
					buttonFightCombatArt.setText("CA Selected: None");
					frameCombatArt.setVisible(false);
				}
			});
			
			swordConfirm.addActionListener(new ActionListener() {
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
			
			lanceConfirm.addActionListener(new ActionListener() {
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
			
			axeConfirm.addActionListener(new ActionListener() {
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
			
			bowConfirm.addActionListener(new ActionListener() {
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
			
			gauntletConfirm.addActionListener(new ActionListener() {
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
			
			/**
			 * PANELS
			 */
			
			panelSelector.setLayout(new GridBagLayout());
			panelSelector.add(buttonNormalFight, gbc);
			panelSelector.add(buttonGambitCalc, gbc);

			panelBattleSelection.add(competitorOne);
			panelBattleSelection.add(competitorTwo);
			panelBattleSelection.add(buttonFight);
			panelBattleSelection.add(buttonFightSwap);
			panelBattleSelection.add(buttonFightCombatArt);
			
			panelCAWeapon.add(none, gbc);
			panelCAWeapon.add(sword, gbc);
			panelCAWeapon.add(lance, gbc);
			panelCAWeapon.add(axe, gbc);
			panelCAWeapon.add(bow, gbc);
			panelCAWeapon.add(gauntlet, gbc);
			
			panelArtConfirm.setLayout(new FlowLayout(FlowLayout.RIGHT));
			panelArtConfirm.add(noneConfirm);
			noneConfirm.setVisible(false);
			panelArtConfirm.add(swordConfirm);
			swordConfirm.setVisible(false);
			panelArtConfirm.add(lanceConfirm);
			lanceConfirm.setVisible(false);
			panelArtConfirm.add(axeConfirm);
			axeConfirm.setVisible(false);
			panelArtConfirm.add(bowConfirm);
			bowConfirm.setVisible(false);
			panelArtConfirm.add(gauntletConfirm);
			gauntletConfirm.setVisible(false);

			panelBattleOutput.add(resultPanel);
			resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
			
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
			frameMain.setSize(600, 300);
			
			frameCombatArt.getContentPane().add(panelCAWeapon, BorderLayout.CENTER);
			frameCombatArt.setLocationRelativeTo(null);
			frameCombatArt.setSize(450,400);
			frameCombatArt.add(panelArtConfirm, BorderLayout.SOUTH);
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
	
	// Calculating battle info
	public static String battle(UnitInfo attacker, UnitInfo target) {
		boolean atkDouble = false;
		String results;
		String mtFinal;
		int critDmg;
		int dmgFinal;
		int hitFinal;
		int critFinal;
	  
		if(attacker.atkSpd - target.atkSpd >= 4) {
			atkDouble = true;
		}
		
		if(attacker.magEqp) {
			dmgFinal = attacker.magAtk - target.res;
		} else {
			dmgFinal = attacker.physAtk - target.def;
		}
		
		hitFinal = attacker.hit - target.genAvo;
		critFinal = attacker.crit - target.critAvo;
		critDmg = dmgFinal * 3;
	  
		if(atkDouble == true) {
			mtFinal = "\nMt: " + dmgFinal + " x2";
		} else {
			mtFinal = "\nMt: "+ dmgFinal;
		}
		
		results = attacker.name + " attacks " + target.name + " with " + attacker.wepName + "!"
				+ mtFinal
				+ "\nHit: " + hitFinal
				+ "\nCrit: " + critFinal
				+ "\nCrit Mt: " + critDmg;
		
		return results;
		}
	
	public static String battle(UnitInfo attacker, UnitInfo target, ArtInfo combatArt) {
		String results;
		int critDmg;
		int dmgFinal;
		int hitFinal;
		int critFinal;
		
		if(attacker.magEqp || combatArt.magEqp) {
			dmgFinal = attacker.magAtk + combatArt.mt - target.res;
		} else {
			dmgFinal = attacker.physAtk + combatArt.mt - target.def;
		}
		
		hitFinal = attacker.hit - target.genAvo + combatArt.hit;
		critFinal = attacker.crit - target.critAvo + combatArt.crit;
		critDmg = dmgFinal * 3;
		
		results = attacker.name + " attacks " + target.name + " with " + combatArt.name + " (" + attacker.wepName + ")!"
				+ "\nMt: "+ dmgFinal
				+ "\nHit: " + hitFinal
				+ "\nCrit: " + critFinal
				+ "\nCrit Mt: " + critDmg
				+ "\nEffect: " + combatArt.note;
		
		return results;
	}
}