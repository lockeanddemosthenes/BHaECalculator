/**
 * GambitInfo: A class dedicated to processing the
 * stat blocks of each gambit.
 * 
 * 
 * @author Errica Cheng (github: lockeanddemosthenes || discord: Locrius 光复香港#9567)
 * @created September 17, 2020
 * @updated September 17, 2020
 */

public class GambitInfo {
	String name;
	boolean magEqp;
	int mt;
	int hit;
	String note;
	
	public GambitInfo(String na, boolean mE, int m, int h, String no) {
		name = na;
		magEqp = mE;
		mt = m;
		hit = h;
		note = no;
	}
}
