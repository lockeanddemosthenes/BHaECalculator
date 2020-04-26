/**
 * UnitInfo: A class dedicated to processing the
 * stat blocks of each unit.
 * 
 * 
 * @author Errica Cheng (github: lockeanddemosthenes)
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
	
	String wepName;
	boolean magEqp;
	int atk;
	int hit;
	int crit;
	int critAvo;
	int atkSpd;
	int avo;
	
	int critDmg;
	int dmgFinal;
	int hitFinal;
	int critFinal;
	
	public UnitInfo(String n, int h, int s, int m, int d, int speed, int l, int defense, int r, int c,
			WeaponInfo w) {

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
		WeaponInfo wep = w;
		wepInd = wep.wepInd;
		wepName = wep.wepName;
		magEqp = wep.magEqp;
		
		//calculated boyos
		int wepMt = wep.mtBase;
		int wepHit = wep.hitBase;
		int wepCrit = wep.critBase;
		int wepWt = wep.wt;

		if(magEqp == false) {
			atk = wepMt + str;
			hit = wepHit + dex;
		} else {
			atk = wepMt + mag;
			hit = wepHit + (dex + lck) / 2;
		}
		
		crit = wepCrit + (dex + lck) / 2;
		critAvo = lck;
		atkSpd = spd - (wepWt - (int)(str/5));
		avo = spd - (wepWt - (int)(str/5));
	}
	
    @Override
    public String toString() {
        return String.format("Name: %s\r\nStr: %s\r\nWep: %s", name, str, wepName);
    }
}
