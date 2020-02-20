
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
 * @created February 17, 2020
 * @updated February 17, 2020
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
    	UnitInfo annette = new UnitInfo();
    	UnitInfo arvyn = new UnitInfo();
    	UnitInfo ashe = new UnitInfo();
    	UnitInfo bernadetta = new UnitInfo();
		UnitInfo briar = new UnitInfo();
		UnitInfo byleth = new UnitInfo();
		UnitInfo caleb = new UnitInfo();
		UnitInfo caspar = new UnitInfo();
		UnitInfo claude = new UnitInfo();
		UnitInfo cyril = new UnitInfo();
		UnitInfo dimitri = new UnitInfo();
		UnitInfo dorothea = new UnitInfo();
		UnitInfo dedue = new UnitInfo();
		UnitInfo edelgard = new UnitInfo();
		UnitInfo emilie = new UnitInfo();
		UnitInfo felix = new UnitInfo();
		UnitInfo ferdinand = new UnitInfo();
		UnitInfo ghadir = new UnitInfo();
		UnitInfo hilda = new UnitInfo();
		UnitInfo hubert = new UnitInfo();
		UnitInfo ignatz = new UnitInfo();
		UnitInfo ingrid = new UnitInfo();
		UnitInfo layla = new UnitInfo();
		UnitInfo leonie = new UnitInfo();
		UnitInfo linhardt = new UnitInfo();
		UnitInfo lorenz = new UnitInfo();
		UnitInfo lysithea = new UnitInfo();
		UnitInfo marianne = new UnitInfo();
		UnitInfo matilda = new UnitInfo();
		UnitInfo mercedes = new UnitInfo();
		UnitInfo petra = new UnitInfo();
		UnitInfo raphael = new UnitInfo();
		UnitInfo rowan = new UnitInfo();
		UnitInfo sylvain = new UnitInfo();
		UnitInfo thyra = new UnitInfo();

		UnitInfo[] unitInfoList = {annette, arvyn, ashe, bernadetta, briar, byleth, caleb, caspar, claude, cyril, dimitri,
				dorothea, dedue, edelgard, emilie, felix, ferdinand, ghadir, hilda, hubert, ignatz, ingrid, layla, leonie,
				linhardt, lorenz, lysithea, marianne, matilda, mercedes, petra, raphael, rowan, sylvain, thyra};
		String[] unitNameList = {"Annette", "Arvyn", "Ashe", "Bernadetta", "Briar", "Byleth", "Caleb", "Caspar", "Claude", "Cyril", "Dimitri",
				"Dorothea", "Dedue", "Edelgard", "Emilie", "Felix", "Ferdinand", "Ghadir", "Hilda", "Hubert", "Ignatz", "Ingrid", "Layla", "Leonie",
				"Linhardt", "Lorenz", "Lysithea", "Marianne", "Matilda", "Mercedes", "Petra", "Raphael", "Rowan", "Sylvain", "Thyra"};
		 

		// name, hp, str, mag, def, res, dex, spd, lck, cha, magEqp (false = phys),
		// mtBase, hitBase, critBase, wt
		/*annette.instantiateUnit("Annette", );
		arvyn.instantiateUnit("Arvyn", );
		ashe.instantiateUnit("Ashe", );
		bernadetta.instantiateUnit("Bernadetta", );*/
		briar.instantiateUnit("Briar", 27, 13, 6, 9, 8, 8, 6, 6, 7, false, 5, 90, 0, 5);
		byleth.instantiateUnit("Byleth", 27, 13, 6, 9, 8, 8, 6, 6, 7, false, 5, 90, 0, 5);
		/*caleb.instantiateUnit("Caleb", );
		caspar.instantiateUnit("Caspar", );*/
		claude.instantiateUnit("Claude", 26, 11, 5, 8, 10, 8, 7, 5, 10, false, 6, 85, 0, 6);
		/*cyril.instantiateUnit("Cyril", );
		dimitri.instantiateUnit("Dimitri", );
		dorothea.instantiateUnit("Dorothea", );
		dedue.instantiateUnit("Dedue", );
		edelgard.instantiateUnit("Edelgard", );
		emilie.instantiateUnit("Emilie", );
		felix.instantiateUnit("Felix", );
		ferdinand.instantiateUnit("Ferdinand", );*/
		ghadir.instantiateUnit("Ghadir", 33, 17, 0, 13, 10, 9, 4, 4, 0, false, 5, 90, 0, 5);
		/*hilda.instantiateUnit("Hilda", );
		hubert.instantiateUnit("Hubert", );
		ignatz.instantiateUnit("Ignatz", );
		ingrid.instantiateUnit("Ingrid", );*/
		layla.instantiateUnit("Layla", 23, 7, 12, 9, 9, 7, 5, 8, 10, true, 3, 90, 3, 0);
		/*leonie.instantiateUnit("Leonie", );
		linhardt.instantiateUnit("Linhardt", );
		lorenz.instantiateUnit("Lorenz", );*/
		lysithea.instantiateUnit("Lysithea", 24, 5, 14, 8, 10, 6, 4, 10, 9, true, 5, 80, 0, 5);
		/* marianne.instantiateUnit("Marianne", ); */
		matilda.instantiateUnit("Matilda", 30, 12, 10, 10, 10, 5, 9, 9, 5, false, 5, 90, 0, 5);
		mercedes.instantiateUnit("Mercedes", 25, 6, 12, 6, 10, 5, 8, 10, 8, false, 3, 90, 0, 5);
		/*petra.instantiateUnit("Petra", );
		raphael.instantiateUnit("Rowan", );
		rowan.instantiateUnit("Rowan", );*/
		sylvain.instantiateUnit("Sylvain", 27, 11, 8, 9, 8, 6, 7, 5, 9, false, 6, 80, 0, 6);
		thyra.instantiateUnit("Thyra", 25, 14, 2, 9, 10, 5, 8, 8, 9, false, 6, 80, 0, 6);
		
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
