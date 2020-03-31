
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
    	
    	/********************
    	 *      WEAPONS     *
    	 ********************/
    	
    	/**
    	 * SWORDS
    	 */
    	WeaponInfo trainingSword = new WeaponInfo();
    	WeaponInfo ironSword = new WeaponInfo();
    	WeaponInfo steelSword = new WeaponInfo();
    	
    	trainingSword.instWep("Training Sword", false, 3, 100, 0, 4);
    	ironSword.instWep("Iron Sword", false, 5, 90, 0, 5);
    	steelSword.instWep("Steel Sword", false, 8, 85, 0, 10);
    	
    	/**
    	 * LANCES
    	 */
    	WeaponInfo trainingLance = new WeaponInfo();
    	WeaponInfo ironLance = new WeaponInfo();
    	WeaponInfo steelLance = new WeaponInfo();
    	
    	trainingLance.instWep("Training Lance", false, 4, 90, 0, 5);
    	ironLance.instWep("Iron Lance", false, 6, 80, 0, 6);
    	steelLance.instWep("Steel Lance", false, 9, 75, 0, 11);
    	
    	/**
    	 * AXES
    	 */
    	WeaponInfo trainingAxe = new WeaponInfo();
    	WeaponInfo ironAxe = new WeaponInfo();
    	WeaponInfo steelAxe = new WeaponInfo();
    	
    	trainingAxe.instWep("Training Axe", false, 6, 80, 0, 6);
    	ironAxe.instWep("Iron Axe", false, 8, 70, 0, 7);
    	steelAxe.instWep("Steel Axe", false, 11, 65, 0, 12);
    	
    	/**
    	 * BOWS
    	 */
    	WeaponInfo trainingBow = new WeaponInfo();
    	WeaponInfo ironBow = new WeaponInfo();
    	WeaponInfo steelBow = new WeaponInfo();
    	
    	trainingBow.instWep("Training Bow", false, 3, 90, 0, 5);
    	ironBow.instWep("Iron Bow", false, 6, 85, 0, 6);
    	steelBow.instWep("Steel Bow", false, 9, 80, 0, 11);
    	
    	/**
    	 * GAUNTLETS
    	 */
    	WeaponInfo trainingGauntlets = new WeaponInfo();
    	WeaponInfo ironGauntlets = new WeaponInfo();
    	WeaponInfo steelGauntlets = new WeaponInfo();
    	
    	trainingGauntlets.instWep("Training Gauntlets", false, 0, 90, 5, 1);
    	ironGauntlets.instWep("Iron Gauntlets", false, 1, 85, 5, 3);
    	steelGauntlets.instWep("Steel Gauntlets", false, 3, 80, 5, 5);
    	
    	/**
    	 * FAITH
    	 */
    	WeaponInfo nosferatu = new WeaponInfo();
    	WeaponInfo seraphim = new WeaponInfo();
    	WeaponInfo abraxas = new WeaponInfo();
    	WeaponInfo aura = new WeaponInfo();
    	
    	nosferatu.instWep("Nosferatu", true, 1, 80, 0, 8);
    	seraphim.instWep("Seraphim", true, 8, 75, 5, 10);
    	abraxas.instWep("Abraxas", true, 14, 80, 5, 13);
    	aura.instWep("Aura", true, 12, 70, 20, 12);
    	
    	/**
    	 * REASON
    	 */
    	WeaponInfo fire = new WeaponInfo();
    	WeaponInfo thunder = new WeaponInfo();
    	WeaponInfo wind = new WeaponInfo();
    	WeaponInfo blizzard = new WeaponInfo();
    	WeaponInfo miasma = new WeaponInfo();
    	WeaponInfo mire = new WeaponInfo();
    	WeaponInfo swarm = new WeaponInfo();
    	WeaponInfo bolganone = new WeaponInfo();
    	WeaponInfo thoron = new WeaponInfo();
    	WeaponInfo cuttingGale = new WeaponInfo();
    	WeaponInfo sagittae = new WeaponInfo();
    	WeaponInfo banshee = new WeaponInfo();
    	WeaponInfo death = new WeaponInfo();
    	WeaponInfo luna = new WeaponInfo();
    	WeaponInfo bolting = new WeaponInfo();
    	WeaponInfo excalibur = new WeaponInfo();
    	WeaponInfo fimbulvetr = new WeaponInfo();
    	WeaponInfo meteor = new WeaponInfo();
    	WeaponInfo ragnarok = new WeaponInfo();
    	WeaponInfo darkSpikes = new WeaponInfo();
    	WeaponInfo agneasArrow = new WeaponInfo();
    	WeaponInfo hades = new WeaponInfo();
    	
    	fire.instWep("Fire", true, 3, 90, 0, 3);
    	thunder.instWep("Thunder", true, 4, 80, 5, 4);
    	wind.instWep("Wind", true, 2, 100, 10, 2);
    	blizzard.instWep("Blizzard", true, 3, 70, 15, 4);
    	miasma.instWep("Miasma Δ", true, 5, 80, 0, 5);
    	mire.instWep("Mire B", true, 3, 70, 0, 5);
    	swarm.instWep("Swarm Z", true, 4, 70, 0, 5);
    	bolganone.instWep("Bolganone", true, 8, 85, 0, 6);
    	thoron.instWep("Thoron", true, 9, 75, 10, 5);
    	cuttingGale.instWep("Cutting Gale", true, 7, 95, 10, 5);
    	sagittae.instWep("Sagittae", true, 7, 90, 5, 6);
    	
    	
    	/********************
    	 *       UNITS      *
    	 ********************/
    	UnitInfo adelaide = new UnitInfo();
    	UnitInfo ahab = new UnitInfo();
    	UnitInfo alyse = new UnitInfo();
    	UnitInfo andulf = new UnitInfo();
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
		UnitInfo claude = new UnitInfo();
		UnitInfo cyril = new UnitInfo();
		
		UnitInfo dahlia = new UnitInfo();
		UnitInfo dimitri = new UnitInfo();
		UnitInfo dorothea = new UnitInfo();
		UnitInfo dedue = new UnitInfo();
		
		UnitInfo eda = new UnitInfo();
		UnitInfo edelgard = new UnitInfo();
		UnitInfo emaline = new UnitInfo();
		UnitInfo emilie = new UnitInfo();
		UnitInfo erik = new UnitInfo();
		
		UnitInfo felix = new UnitInfo();
		UnitInfo ferdinand = new UnitInfo();
		UnitInfo finley = new UnitInfo();
		
		UnitInfo ghadir = new UnitInfo();
		UnitInfo grant = new UnitInfo();
		
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
		UnitInfo manuela = new UnitInfo();
		UnitInfo marianne = new UnitInfo();
		UnitInfo matilda = new UnitInfo();
		UnitInfo mercedes = new UnitInfo();
		
		UnitInfo octavia = new UnitInfo();
		UnitInfo ourania = new UnitInfo();
		
		UnitInfo percy = new UnitInfo();
		UnitInfo petra = new UnitInfo();
		
		UnitInfo raphael = new UnitInfo();
		UnitInfo rowan = new UnitInfo();
		UnitInfo sabella = new UnitInfo();
		UnitInfo seteth = new UnitInfo();
		UnitInfo sylvain = new UnitInfo();
		UnitInfo thyra = new UnitInfo();
		UnitInfo victoria = new UnitInfo();
		UnitInfo viliana = new UnitInfo();
		UnitInfo zegrath = new UnitInfo();

		UnitInfo[] unitInfoList = {adelaide, ahab, alyse, andulf, annette, ansehelm, arvyn, ashe,
				bernadetta, briar, byleth, caleb, caspar, caster, claude, cyril,
				dahlia, dedue, dimitri, dorothea, eda, edelgard, emaline, emilie, erik,
				felix, ferdinand, finley, ghadir, grant, hanneman, hilda, hubert, ignatz, ingrid,
				juniper, layla, leonie, linhardt, lorenz, lucy, lysithea,
				macey, manuela, marianne, matilda, mercedes, octavia, ourania, percy, petra, raphael, rowan,
				sabella, seteth, sylvain, thyra, victoria, viliana, zegrath};
		String[] unitNameList = {"Adelaide", "Ahab", "Alyse", "Andulf", "Annette", "Ansehelm", "Arvyn", "Ashe",
				"Bernadetta", "Briar", "Byleth", "Caleb", "Caspar", "Caster", "Claude", "Cyril",
				"Dahlia", "Dedue", "Dimitri", "Dorothea", "Eda", "Edelgard", "Emaline", "Emilie", "Erik",
				"Felix", "Ferdinand", "Finley", "Ghadir", "Grant", "Hanneman", "Hilda", "Hubert", "Ignatz", "Ingrid",
				"Juniper", "Layla", "Leonie", "Linhardt", "Lorenz", "Lucy", "Lysithea",
				"Macey", "Manuela", "Marianne", "Matilda", "Mercedes", "Octavia", "Percy", "Petra", "Raphael", "Rowan",
				"Sabella", "Seteth", "Sylvain", "Thyra", "Victoria", "Viliana", "Zegrath"};
		 

		// name, hp, str, mag, dex, spd, lck, def, res,
		// magEqp (false = phys), mtBase, hitBase, critBase, wt
		adelaide.instUnit("Adelaide", 0, 0, 0, 0, 0, 0, 0, 0, 0, ironGauntlets);
		ahab.instUnit("Ahab", 23, 8, 8, 16, 12, 5, 6, 6, 6, ironSword);
		alyse.instUnit("Alyse", 24, 7, 13, 10, 8, 6, 6, 8, 8, miasma);
		andulf.instUnit("Andulf", 30, 13, 2, 15, 10, 5, 5, 3, 7, ironGauntlets);
		annette.instUnit("Annette", 25, 6, 16, 7, 7, 6, 7, 10, 6, wind);
		ansehelm.instUnit("Ansehelm", 27, 15, 3, 12, 12, 10, 3, 3, 5, ironBow);
		arvyn.instUnit("Arvyn", 27, 15, 4, 8, 10, 6, 8, 6, 6, ironSword);
		ashe.instUnit("Ashe", 25, 10, 5, 10, 9, 8,9, 6, 8, ironBow);
		
		bernadetta.instUnit("Bernadetta", 0, 0, 0, 0, 0, 0, 0, 0, 0, ironBow);
		briar.instUnit("Briar", 27, 13, 6, 9, 8, 8, 6, 6, 7, ironSword);
		byleth.instUnit("Byleth", 27, 13, 6, 9, 8, 8, 6, 6, 7, ironSword);
		
		caleb.instUnit("Caleb", 21, 7, 12, 7, 10, 9, 7, 10, 7, wind);
		caspar.instUnit("Caspar",  0, 0, 0, 0, 0, 0, 0, 0, 0, ironAxe);
		caster.instUnit("Caster", 24, 10, 2, 10, 12, 15, 6, 8, 3, fire);
		claude.instUnit("Claude", 28, 13, 6, 10, 12, 10, 9, 7, 11, ironBow);
		cyril.instUnit("Cyril",  27, 10, 4, 8, 8, 7, 7, 3, 6, ironAxe);
		
		dahlia.instUnit("Dahlia", 26, 6, 15, 7, 11, 6, 6, 10, 3, ironSword);
		dedue.instUnit("Dedue", 30, 12, 4, 5, 9, 6, 12, 5, 10, ironAxe);
		dimitri.instUnit("Dimitri", 28, 13, 4, 9, 9, 5, 8, 5, 9, ironLance);
		dorothea.instUnit("Dorothea", 26, 5, 15, 6, 8, 6, 4, 10, 10, thunder);
		
		eda.instUnit("Eda", 0, 0, 0, 0, 0, 0, 0, 0, 0, ironBow);
		edelgard.instUnit("Edelgard", 29, 17, 6, 5, 8, 5, 6, 4, 10, ironAxe);
		emaline.instUnit("Emaline", 25,5,15, 12, 5, 3, 7, 10, 8, nosferatu);
		emilie.instUnit("Emilie", 24, 11, 7, 13, 9, 7, 9, 8, 3, ironAxe);
		erik.instUnit("Erik", 20, 6, 15, 7, 8, 6, 4, 8, 6, trainingLance);
		
		felix.instUnit("Felix", 26, 20, 5, 6, 12, 5, 8, 3,5, ironSword);
		ferdinand.instUnit("Ferdinand", 28, 12, 5, 8, 8, 6, 14, 2, 7, ironLance);
		finley.instUnit("Finley", 20, 13, 4, 15, 10, 5, 10, 5, 8, ironGauntlets);
		ghadir.instUnit("Ghadir", 22, 17, 0, 13, 7, 12, 10, 9, 0, ironSword);
		hanneman.instUnit("Hanneman", 26, 7, 15, 9, 8, 5, 6, 8, 6, wind);
		grant.instUnit("Grant", 24, 7, 13, 8, 9, 6, 5, 10, 8, trainingLance);
		hilda.instUnit("Hilda", 29, 13, 5, 9, 9, 7, 6, 4, 8, ironAxe);
		hubert.instUnit("Hubert",  0, 0, 0, 0, 0, 0, 0, 0, 0, miasma);
		
		ignatz.instUnit("Ignatz", 25, 12, 5, 7, 8, 8, 10, 10, 4, ironBow);
		ingrid.instUnit("Ingrid", 28, 8, 6, 8, 8, 8, 8, 8, 8, ironLance);
		juniper.instUnit("Juniper", 20, 6, 10, 8, 5, 15, 5, 5, 6, trainingSword);
		
		layla.instUnit("Layla", 23, 7, 12, 9, 9, 7, 5, 8, 10, fire);
		leonie.instUnit("Leonie", 0, 0, 0, 0, 0, 0, 0, 0, 0, ironLance);
		linhardt.instUnit("Linhardt", 30, 5, 20, 6, 5, 17, 5, 13, 5, nosferatu);
		lorenz.instUnit("Lorenz", 0, 0, 0, 0, 0, 0, 0, 0, 0, ironLance);
		lucy.instUnit("Lucy", 29, 15, 1, 11, 8, 2, 12, 11, 1, ironLance);
		lysithea.instUnit("Lysithea", 24, 5, 14, 8, 10, 6, 4, 10, 9, miasma);
		
		macey.instUnit("Macey", 0, 0, 0, 0, 0, 0, 0, 0, 0, ironBow);
		manuela.instUnit("Manuela", 0, 0, 0, 0, 0, 0, 0, 0, 0, ironSword);
		marianne.instUnit("Marianne", 25, 5, 16, 9, 7, 6, 6, 9, 7, nosferatu);
		matilda.instUnit("Matilda", 30, 10, 8, 8, 10, 5, 7, 7, 5, ironSword);
		mercedes.instUnit("Mercedes", 25, 6, 12, 6, 10, 5, 8, 10, 8, trainingBow);
		
		octavia.instUnit("Octavia", 25, 15, 5, 9, 4, 7, 13, 7, 5, trainingAxe);
		ourania.instUnit("Ourania", 12, 12, 19, 10, 6, 12, 5, 7, 7, ironAxe);
		percy.instUnit("Percy", 22, 12, 11, 9, 10, 5, 7, 9, 5, ironLance);
		petra.instUnit("Petra", 28, 11, 4, 10, 11, 8, 6, 6, 6, ironSword);
		raphael.instUnit("Raphael", 31, 12, 3, 7, 8, 6, 11, 8, 4, ironGauntlets);
		rowan.instUnit("Rowan", 26, 7, 7, 5, 13, 8, 7, 7, 10, ironLance);
		
		sabella.instUnit("Sabella", 24, 8, 3, 13, 13, 12, 8, 2, 7, ironSword);
		seteth.instUnit("Seteth", 0, 0, 0, 0, 0, 0, 0 , 0, 0, ironAxe);
		sylvain.instUnit("Sylvain", 27, 11, 8, 9, 8, 6, 7, 5, 9, ironLance);
		thyra.instUnit("Thyra", 25, 14, 2, 10, 8, 5, 9, 9, 8, ironLance);
		victoria.instUnit("Victoria", 20, 15, 5, 10, 10, 5, 10, 10, 5, ironSword);
		viliana.instUnit("Viliana", 20, 13, 6, 16, 14, 4, 7, 5, 5, ironSword);
		zegrath.instUnit("Zegrath", 15, 12, 9, 9, 18, 4, 7, 7, 9, ironGauntlets);
		
		
		/*********************
		 *     GUI STUFF     *
		 *********************/
		
		
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
