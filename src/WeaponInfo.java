
public class WeaponInfo {
	//The variables that get put in when creating a weapon
	String wepName;
	boolean magEqp;
	int mtBase;
	int hitBase;
	int critBase;
	int wt;
	
	public WeaponInfo(String n, boolean m, int mt, int hit, int crit, int weight) {
		wepName = n;
        magEqp = m;
        mtBase = mt;
        hitBase = hit;
        critBase = crit;
        wt = weight;
    }
	
    @Override
    public String toString() {
        return String.format("Weapon: %s\r\nMagEqp: %b\r\nMt Base: %s\r\nHit Base: %s\r\nCrit Base: %s\r\n", 
                wepName, magEqp, mtBase, hitBase, critBase, wt);
    }
}
