package generated.util;

import generated.Middleware.IMdlware;

public class MdlwareReporter {
	
	private static MdlwareReporter INSTANCE = new MdlwareReporter();
	
	private MdlwareReporter() {
		// TODO Auto-generated constructor stub
	}
	
	public static MdlwareReporter getInstance() {
		return INSTANCE;
	}
	
	public void report(IMdlware mdlware) {
		//report 
	}
}
