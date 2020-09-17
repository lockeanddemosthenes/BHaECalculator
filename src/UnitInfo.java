/**
 * UnitInfo: A class dedicated to processing the
 * stat blocks of each unit.
 * 
 * 
 * @author Errica Cheng (github: lockeanddemosthenes || discord: Locrius 光复香港#9567)
 * @created February 17, 2020
 * @updated February 17, 2020
 */

public class UnitInfo {
	//The variables that get put in when creating a unit
	String name;
	int hp;
	int str;
	int mag;
	int dex;
	int spd;
	int lck;
	int def;
	int res;
	int cha;
	int wepInd;
	int wepTypeInd;
	WeaponInfo wep;
	
	String wepName;
	boolean magEqp;
	int magAtk;
	int physAtk;
	int hit;
	int crit;
	int critAvo;
	int atkSpd;
	int genAvo;
	
	public UnitInfo(String n, int h, int s, int m, int d, int speed, int l, int defense, int r, int c, int wTypInd, int wInd, WeaponInfo w) {

		//The variables that get put in when creating a unit
		name = n;
		hp = h;
		str = s;
		mag = m;
		dex = d;
		spd = speed;
		lck = l;
		def = defense;
		res = r;
		cha = c;
		wep = w;
		wepTypeInd = wTypInd;
		wepInd = wInd;
		wepName = wep.wepName;
		magEqp = wep.magEqp;
		
		//calculated boyos
		int wepMt = wep.mtBase;
		int wepHit = wep.hitBase;
		int wepCrit = wep.critBase;
		int wepWt = wep.wt;
		int wepAdjWt = wepWt - (int)(str/5);
		wepAdjWt = wepAdjWt < 0? 0 : wepAdjWt;
		
		if((wep.wepName.compareTo("Heal") == 0) || (wep.wepName.compareTo("Physic") == 0) || (wep.wepName.compareTo("Recover") == 0)) {
			magAtk = wepMt + mag/3;
		} else {
			magAtk = wepMt + mag;
			physAtk = wepMt + str;
			hit = wepHit + dex + lck/2;
			crit = wepCrit + dex + lck/2;
			critAvo = lck;
			genAvo = lck + atkSpd/2;
			atkSpd = spd - wepAdjWt;
			atkSpd = atkSpd < 0? 0 : atkSpd;
		}
	}
	
	public void changeUnitWep(WeaponInfo[] weptype, int wInd) {
		this.wep = weptype[wInd];
		wepName = wep.wepName;
		magEqp = wep.magEqp;
		
		int wepMt = wep.mtBase;
		int wepHit = wep.hitBase;
		int wepCrit = wep.critBase;
		int wepWt = wep.wt;
		int wepAdjWt = wepWt - (int)(str/5);
		wepAdjWt = wepAdjWt < 0? 0 : wepAdjWt;
		
		if((wep.wepName.compareTo("Heal") == 0) || (wep.wepName.compareTo("Physic") == 0) || (wep.wepName.compareTo("Recover") == 0)) {
			magAtk = wepMt + mag/3;
		} else {
			magAtk = wepMt + mag;
			physAtk = wepMt + str;
			hit = wepHit + dex + lck/2;
			crit = wepCrit + dex + lck/2;
			critAvo = lck;
			genAvo = lck + atkSpd/2;
			atkSpd = spd - wepAdjWt;
			atkSpd = atkSpd < 0? 0 : atkSpd;
		}
	}
}
