/**
 * ArtInfo: A class dedicated to processing the
 * stat blocks of each combat art.
 * 
 * 
 * @author Errica Cheng (github: lockeanddemosthenes || discord: Locrius 光复香港#9567)
 * @created February 17, 2020
 * @updated February 17, 2020
 */

public class ArtInfo {
	//The variables that get put in when creating a unit
	String name;
	int mt;
	int hit;
	int crit;
	int avo;
	boolean magEqp;
	String note;
	
	public ArtInfo(String na, int m, int h, int c, int a, boolean me, String nt) {

		//The variables that get put in when creating a unit
		name = na;
		mt = m;
		hit = h;
		crit = c;
		avo = a;
		magEqp = me;
		note = nt;
	}
}
