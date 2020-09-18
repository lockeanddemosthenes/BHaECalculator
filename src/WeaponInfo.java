/**
 * WeaponInfo: A class dedicated to processing
 * the statblocks of each weapon.
 * 
 * 
 * @author Errica Cheng (github: lockeanddemosthenes || discord: Locrius 光复香港#9567)
 * @created February 17, 2020
 * @updated September 17, 2020
 */

public class WeaponInfo {
	//The variables that get put in when creating a weapon
	String wepName;
	boolean magEqp;
	int mtBase;
	int hitBase;
	int critBase;
	int wt;
	int weaponType;
	
	public WeaponInfo(String n, boolean m, int mt, int hit, int crit, int weight, int type) {
		wepName = n;
        magEqp = m;
        mtBase = mt;
        hitBase = hit;
        critBase = crit;
        wt = weight;
        weaponType = type;
    }
}
