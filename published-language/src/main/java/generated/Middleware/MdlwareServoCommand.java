package generated.Middleware;


import generated.Middleware.Type.MdlwareOffOnType;

public class MdlwareServoCommand implements IMdlware{
	private int id;
	private MdlwareOffOnType command;
	
	
	public int getId() {
		return id;
	}
	public MdlwareOffOnType getCommand() {
		return command;
	}
	
	
}
