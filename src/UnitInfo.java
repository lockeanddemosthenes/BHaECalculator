/**
 * UnitInfo: A class dedicated to processing the
 * stat blocks of each unit.
 * 
 * 
 * @author Errica Cheng (github: lockeanddemosthenes)
 * @created February 17, 2020
 * @updated February 17, 2020
 */

public class UnitInfo extends WeaponInfo {
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
	
	//The variables that we calculate
	int atk;
	int hit;
	int crit;
	int critAvo;
	int atkSpd;
	int avo;
	int prt;
	int rsl;
	int dmgFinal;
	int hitFinal;
	int critFinal;
	int critDmg;
	
	//Instantiating a unit
	public void instUnit(String name, int hp, int str, int mag, int dex, int spd, int lck, int def, int res, int cha,
			WeaponInfo wepInfo) {
		
		//converting stats
		this.name = name;
		this.hp = hp;
		this.str = str;
		this.mag = mag;
		this.dex = dex;
		this.spd = spd;
		this.lck = lck;
		this.def = def;
		this.res = res;
		this.cha = cha;
		this.wepName = wepInfo.wepName;
		this.magEqp = wepInfo.magEqp;
		this.mtBase = wepInfo.mtBase;
		this.hitBase = wepInfo.hitBase;
		
		//some base calculations
		if (wepInfo.magEqp == false) {
			this.atk = this.mtBase + this.str;
			this.hit = this.hitBase + this.dex;
		} else {
			this.atk = this.mtBase + this.mag;
			this.hit = this.hitBase + (this.dex + this.lck) / 2;
		}
		this.crit = this.critBase + (this.dex + this.lck) / 2;
		this.critAvo = this.lck;
		this.atkSpd = this.spd - (this.wt - (int)(this.str/5));
		this.avo = this.spd - (this.wt - (int)(this.str/5));
		this.prt = this.def;
		this.rsl = this.res;
	}
	
	public String getName() {
		return this.name;
	}
	
	//Calculating battle info
	public static String battle(UnitInfo one, UnitInfo target) {
		boolean atkDouble = false;
		String results;
		
		if(one.magEqp == false) {
			one.dmgFinal = one.atk - target.prt;
			one.hitFinal = one.hit - target.avo;
		} else {
			one.dmgFinal = one.atk - target.rsl;
			one.hitFinal = one.hit - target.avo;
		}
		
		if(one.spd - target.spd >= 4) {
			atkDouble = true;
		}
		
		one.critFinal = one.crit - target.critAvo;
		one.critDmg = one.dmgFinal * 3;
		
		if(atkDouble == true) {
			results = one.name + " attacks " + target.name + "with" + one.wepName + "!"
					+ "\nMt: "+ one.dmgFinal + " x2" + "\nHit: " + one.hitFinal + "\nCrit: " + one.critFinal + "\nCrit Mt: " + one.critDmg;
		} else {
			results = one.name + " attacks " + target.name + "!"
					+ "\nMt: "+ one.dmgFinal + "\nHit: " + one.hitFinal + "\nCrit: " + one.critFinal + "\nCrit Mt: " + one.critDmg;
		}
		
		return results;
	}
}
