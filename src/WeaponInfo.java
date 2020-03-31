
public class WeaponInfo {
	//The variables that get put in when creating a weapon
	boolean magEqp;
	int mtBase;
	int hitBase;
	int critBase;
	int wt;
	String wepName;
	
	public void instWep(String name, boolean magEqp, int mtBase, int hitBase, int critBase, int wt) {
		this.wepName = name;
		this.magEqp = magEqp;
		this.mtBase = mtBase;
		this.hitBase = hitBase;
		this.wt = wt;
	}
}
