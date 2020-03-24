
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
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;

import javax.swing.*;

public class MainProcessor {
	final static JTextArea resultPanel = new JTextArea();
	
    public static void main(String[] args) {
    	UnitInfo adelaide = new UnitInfo();
    	UnitInfo ahab = new UnitInfo();
    	UnitInfo annette = new UnitInfo();
    	UnitInfo ansehelm = new UnitInfo();
    	UnitInfo arvyn = new UnitInfo();
    	UnitInfo ashe = new UnitInfo();
    	UnitInfo bernadetta = new UnitInfo();
		UnitInfo briar = new UnitInfo();
		UnitInfo byleth = new UnitInfo();
		UnitInfo caleb = new UnitInfo();
		UnitInfo caspar = new UnitInfo();
		UnitInfo caster = new UnitInfo();
		UnitInfo chloe = new UnitInfo();
		UnitInfo claude = new UnitInfo();
		UnitInfo cyril = new UnitInfo();
		UnitInfo dahlia = new UnitInfo();
		UnitInfo dimitri = new UnitInfo();
		UnitInfo dorothea = new UnitInfo();
		UnitInfo dedue = new UnitInfo();
		UnitInfo edelgard = new UnitInfo();
		UnitInfo emaline = new UnitInfo();
		UnitInfo emilie = new UnitInfo();
		UnitInfo erik = new UnitInfo();
		UnitInfo felix = new UnitInfo();
		UnitInfo ferdinand = new UnitInfo();
		UnitInfo finley = new UnitInfo();
		UnitInfo ghadir = new UnitInfo();
		UnitInfo hanneman = new UnitInfo();
		UnitInfo hilda = new UnitInfo();
		UnitInfo hubert = new UnitInfo();
		UnitInfo ignatz = new UnitInfo();
		UnitInfo ingrid = new UnitInfo();
		UnitInfo juniper = new UnitInfo();
		UnitInfo layla = new UnitInfo();
		UnitInfo leonie = new UnitInfo();
		UnitInfo linhardt = new UnitInfo();
		UnitInfo lorenz = new UnitInfo();
		UnitInfo lucy = new UnitInfo();
		UnitInfo lysithea = new UnitInfo();
		UnitInfo macey = new UnitInfo();
		UnitInfo marianne = new UnitInfo();
		UnitInfo matilda = new UnitInfo();
		UnitInfo mercedes = new UnitInfo();
		UnitInfo petra = new UnitInfo();
		UnitInfo raphael = new UnitInfo();
		UnitInfo rowan = new UnitInfo();
		UnitInfo sylvain = new UnitInfo();
		UnitInfo thyra = new UnitInfo();
		UnitInfo victoria = new UnitInfo();
		UnitInfo zegrath = new UnitInfo();

		UnitInfo[] unitInfoList = {adelaide, ahab, annette, ansehelm, arvyn, ashe, bernadetta, briar, byleth, caleb,
				caspar, caster, chloe, claude, cyril, dahlia, dedue, dimitri, dorothea, edelgard,
				emaline, emilie, erik, felix, ferdinand, finley, ghadir, hanneman, hilda, hubert, ignatz, ingrid,
				juniper, layla, leonie, linhardt, lorenz, lucy, lysithea, macey, marianne, matilda, mercedes,
				petra, raphael, rowan, sylvain, thyra, victoria, zegrath};
		String[] unitNameList = {"Adelaide", "Ahab", "Annette", "Ansehelm", "Arvyn", "Ashe", "Bernadetta", "Briar", "Byleth", "Caleb",
				"Caspar", "Caster", "Chloe", "Claude", "Cyril", "Dahlia", "Dedue", "Dimitri", "Dorothea", "Edelgard",
				"Emaline", "Emilie", "Erik", "Felix", "Ferdinand", "Finley", "Ghadir", "Hanneman", "Hilda", "Hubert", "Ignatz", "Ingrid",
				"Juniper", "Layla", "Leonie", "Linhardt", "Lorenz", "Lysithea", "Macey", "Marianne", "Matilda", "Mercedes",
				"Petra", "Raphael", "Rowan", "Sylvain", "Thyra", "Victoria", "Zegrath"};
		 

		// name, hp, str, mag, dex, spd, lck, def, res,
		// magEqp (false = phys), mtBase, hitBase, critBase, wt
		adelaide.instantiateUnit("Adelaide", 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		ahab.instantiateUnit("Ahab", 23, 8, 8, 16, 12, 5, 6, 6, 6, false, 5, 90, 0, 5);
		annette.instantiateUnit("Annette", 25, 6, 16, 7, 7, 6, 7, 10, 6, true, 2, 100, 10, 2);
		arvyn.instantiateUnit("Arvyn", 27, 15, 5, 8, 10, 7, 8, 6, 4, false, 5, 90, 0, 5);
		ashe.instantiateUnit("Ashe", 25, 10,5, 10, 9, 8,9, 6, 8, false, 6, 85, 0, 5);
		ansehelm.instantiateUnit("Ansehelm", 27, 15, 3, 12, 12, 10, 3, 3, 5, false, 6, 85, 0, 6);
		bernadetta.instantiateUnit("Bernadetta", 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		briar.instantiateUnit("Briar", 27, 13, 6, 9, 8, 8, 6, 6, 7, false, 5, 90, 0, 5);
		byleth.instantiateUnit("Byleth", 27, 13, 6, 9, 8, 8, 6, 6, 7, false, 5, 90, 0, 5);
		caleb.instantiateUnit("Caleb", 15, 10, 12, 7, 10, 9, 7, 10, 10, false, 5, 90, 0, 5);
		caspar.instantiateUnit("Caspar",  0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		caster.instantiateUnit("Caster", 24, 10, 2, 10, 12, 15, 6, 8, 3, true, 3, 90, 0, 3);
		chloe.instantiateUnit("Chloe", 20, 7, 18, 13, 9, 3, 8, 10, 2, true, 5, 100, 0, 5);
		claude.instantiateUnit("Claude", 26, 11, 5, 8, 10, 8, 7, 5, 10, false, 6, 85, 0, 6);
		cyril.instantiateUnit("Cyril",  0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		dimitri.instantiateUnit("Dimitri", 28, 13, 4, 9, 9, 5, 8, 5, 9, false, 5, 90, 0, 5);
		dorothea.instantiateUnit("Dorothea", 26, 5, 15, 6, 8, 6, 4, 10, 10, true, 4, 80, 5, 4);
		dedue.instantiateUnit("Dedue", 30, 12, 4, 5, 9, 6, 12, 5, 10, false, 8, 70, 0, 7);
		edelgard.instantiateUnit("Edelgard", 29, 17, 6, 5, 8, 5, 6, 4, 10, false, 8, 70, 0, 7);
		emaline.instantiateUnit("Emaline", 25, 5, 15, 12, 5, 3, 7, 10, 8, true, 1, 80, 0, 8);
		emilie.instantiateUnit("Emilie", 24, 11, 7, 13, 9, 7, 9, 8, 3, false, 8, 70, 0, 7);
		erik.instantiateUnit("Erik", 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		felix.instantiateUnit("Felix", 26, 20, 5, 6, 12, 5, 8, 3,5, false, 90, 5, 0, 5);
		ferdinand.instantiateUnit("Ferdinand", 28, 12, 5, 8, 8, 6, 14, 2, 7, false, 6, 80, 0, 6);
		finley.instantiateUnit("Finley", 20, 14, 4, 15, 11, 5, 10, 5, 6, false, 1, 85, 5, 3);
		ghadir.instantiateUnit("Ghadir", 22, 17, 0, 13, 7, 12, 10, 9, 0, false, 5, 90, 0, 5);
		hanneman.instantiateUnit("Hanneman", 26, 7, 15, 9, 8, 5, 6, 8, 6, true, 2, 100, 10, 2);
		hilda.instantiateUnit("Hilda", 29, 13, 5, 9, 9, 7, 6, 4, 8, false, 8, 70, 0, 7);
		hubert.instantiateUnit("Hubert",  0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		ignatz.instantiateUnit("Ignatz", 25, 12, 5, 7, 8, 8, 10, 10, 4, false, 6, 85, 0, 6);
		ingrid.instantiateUnit("Ingrid", 28, 8, 6, 8, 8, 8, 8, 8, 8, false, 6, 80, 0, 6);
		juniper.instantiateUnit("Juniper", 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		layla.instantiateUnit("Layla", 23, 7, 12, 9, 9, 7, 5, 8, 10, true, 3, 90, 3, 0);
		leonie.instantiateUnit("Leonie", 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		linhardt.instantiateUnit("Linhardt", 30, 5, 20, 6, 5, 17, 5, 13, 5, true, 1, 80, 0, 8);
		lorenz.instantiateUnit("Lorenz", 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0);
		lucy.instantiateUnit("Lucy", 29, 15, 1, 11, 8, 2, 12, 11, 1, false, 6, 80, 0, 6);
		lysithea.instantiateUnit("Lysithea", 24, 5, 14, 8, 10, 6, 4, 10, 9, true, 5, 80, 0, 5);
		marianne.instantiateUnit("Marianne", 25, 5, 16, 9, 7, 6, 6, 9, 7, true, 1, 80, 0, 8); 
		matilda.instantiateUnit("Matilda", 30, 10, 8, 8, 10, 5, 7, 7, 5, false, 5, 90, 0, 5);
		mercedes.instantiateUnit("Mercedes", 25, 6, 12, 6, 10, 5, 8, 10, 8, false, 3, 90, 0, 5);
		petra.instantiateUnit("Petra", 28, 11, 4, 10, 11, 8, 6, 6, 6, false, 5, 90, 0, 5);
		raphael.instantiateUnit("Raphael", 31, 12, 3, 7, 8, 6, 11, 8, 4, false, 1, 85, 5, 3);
		rowan.instantiateUnit("Rowan", 26, 7, 7, 5, 13, 8, 7, 7, 10, false, 5, 90, 0, 5);
		sylvain.instantiateUnit("Sylvain", 27, 11, 8, 9, 8, 6, 7, 5, 9, false, 6, 80, 0, 6);
		thyra.instantiateUnit("Thyra", 25, 14, 2, 10, 8, 5, 9, 9, 8, false, 6, 80, 0, 6);
		victoria.instantiateUnit("Victoria", 20, 15, 5, 10, 10, 5, 10, 10, 5, false, 5, 90, 0, 5);
		zegrath.instantiateUnit("Zegrath", 15, 12, 9, 9, 18, 4, 7, 7, 9, false, 1, 85, 5, 3);
		
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
					//resultPanel.setText("");
					int competitorOneIndex = competitorOne.getSelectedIndex();
					int competitorTwoIndex = competitorTwo.getSelectedIndex();
					resultPanel.setText(UnitInfo.battle(unitInfoList[competitorOneIndex], unitInfoList[competitorTwoIndex]));
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
			frame.setSize(300, 300);
		});

	}
}
