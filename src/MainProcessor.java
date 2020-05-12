
/**
 * FE 3H Calculator: An absolute mess of a program
 * created so humans wouldn't have to deal with
 * the mathematical nightmare of a tabletop game
 * styled after Fire Emblem: Three Houses. Use
 * with caution, or maybe not.
 * 
 * MainProcessor: Because we all start somewhere.
 * Primarily contains GUI elements. One day, I
 * might make this pretty.
 * 
 * @author Errica Cheng (github: lockeanddemosthenes)
 * @created March 01, 2020
 * @updated March 01, 2020
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import java.util.*;

import javax.swing.*;

public class MainProcessor {
	final static JTextArea resultPanel = new JTextArea();

	public static void main(String[] args) throws FileNotFoundException {

		Scanner weaponInput = new Scanner(new File("weapons.txt"));
		Scanner unitInput = new Scanner(new File("units.txt"));

		WeaponInfo[] weapons = new WeaponInfo[0];
		while (weaponInput.hasNext()) {
			int id = weaponInput.nextInt();
			String wepName = weaponInput.next();
			boolean magEqp = weaponInput.nextBoolean();
			int mtBase = weaponInput.nextInt();
			int hitBase = weaponInput.nextInt();
			int critBase = weaponInput.nextInt();
			int wt = weaponInput.nextInt();

			WeaponInfo newWeapon = new WeaponInfo(id, wepName, magEqp, mtBase, hitBase, critBase, wt);
			weapons = addWeapon(weapons, newWeapon);
		}
		weaponInput.close();
		//final WeaponInfo[] weaponsFinal = new WeaponInfo[weapons.length];

		UnitInfo[] units = new UnitInfo[0];
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
			WeaponInfo wepID = weapons[wepInd];

			UnitInfo newUnit = new UnitInfo(name, hp, str, mag, dex, spd, lck, def, res, cha, wepID);
			units = addUnit(units, newUnit);
		}
		unitInput.close();
		final UnitInfo[] unitsFinal = new UnitInfo[units.length];

		/*
		 * for (WeaponInfo weapon : weapons) { System.out.println(weapon); }
		 */
		 for (int i = 0; i < units.length; i++) {
			 unitsFinal[i] = units[i];
		 }
		 
		//System.out.println(unitsFinal[2]);
		 

			    	/********************
						 * UNITS *
						 *******************/
		  String[] unitNameList = {
				  "Adelaide", "Ahab", "Alyse", "Annette", "Ashe", "Ashley",
				  "Balthus", "Banquo", "Bernadetta", "Briar", "Byleth",
				  "Callahan", "Caspar", "Caster", "Claude", "Constance", "Cyril",
				  "Dahlia", "Dedue", "Dimitri", "Dorothea",
				  "Edelgard", "Emaline", "Erik",
				  "Felix", "Ferdinand", "Finley", "Flayn",
				  "Hanneman", "Hapi", "Hilda", "Hillevi", "Hubert",
				  "Ignatz", "Ingrid", "Jeritza", "Koreaia",
				  "Layla", "Leonie", "Linhardt", "Lorenz", "Lucy", "Lysithea",
				  "Manuela", "Mariam", "Marianne", "Matilda", "Mercedes", "Mysa",
				  "Percy", "Petra", "Raphael", "Rowan",
				  "Sabella", "Selena", "Seteth", "Shamir", "Sylvain",
				  "Thyra", "Tobias", "Tristan", "Victoria", "Viliana", "William", "Yuri", "Zegrath",
				  "Myrmidon (CoS)", "Soldier (CoS)", "Monk (CoS)", "Archer (CoS)",
				  "Fighter (CoS)"
				  };
												 

		/*********************
		 * GUI STUFF *
		 ********************/

		SwingUtilities.invokeLater(() -> {
			JPanel buttonPanel = new JPanel();
			JPanel outputPanel = new JPanel();
			
			JComboBox<String> competitorOne = new JComboBox<>(unitNameList);
			JComboBox<String> competitorTwo = new JComboBox<>(unitNameList);
			 
			JButton fightButton = new JButton("Fight!");

			buttonPanel.add(competitorOne);
			buttonPanel.add(competitorTwo);
			buttonPanel.add(fightButton);

			fightButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					UnitInfo competitorOne = unitsFinal[competitorOneIndex];
					UnitInfo competitorTwo = unitsFinal[competitorTwoIndex];
					resultPanel.setText(battle(competitorOne, competitorTwo));
				}
			});

			outputPanel.add(resultPanel);
			resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

			JFrame frame = new JFrame("Battle Calculator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			frame.getContentPane().add(outputPanel, BorderLayout.WEST);

			frame.pack();
			frame.setVisible(true);
			frame.setSize(450, 300);
		});
	}

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

	// Calculating battle info
	
	public static String battle(UnitInfo one, UnitInfo target) {
		boolean atkDouble = false;
		String results;
	  
		if(one.spd - target.spd >= 4) {
			atkDouble = true;
		}
		
		if(one.magEqp == false) {
			one.dmgFinal = one.atk - target.def;
		} else {
			one.dmgFinal = one.atk - target.res;
		}
		
		one.hitFinal = one.hit - target.avo;
		one.critFinal = one.crit - target.critAvo;
		one.critDmg = one.dmgFinal * 3;
	  
		if(atkDouble == true) {
			results = one.name + " attacks " + target.name + " with " + one.wepName + "!" + "\nMt: " + one.dmgFinal + " x2" + "\nHit: " + one.hitFinal + "\nCrit: " + one.critFinal + "\nCrit Mt: " + one.critDmg;
			} else {
				results = one.name + " attacks " + target.name + " with " + one.wepName + "!" + "\nMt: "+ one.dmgFinal + "\nHit: " + one.hitFinal + "\nCrit: " + one.critFinal + "\nCrit Mt: " + one.critDmg; }
	 
		return results;
		}
	 
}