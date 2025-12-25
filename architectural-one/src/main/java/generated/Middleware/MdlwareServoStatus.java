package generated.Middleware;


import generated.Middleware.Type.MdlwareOffOnType;

public class MdlwareServoStatus implements IMdlware{
	private int id;
	private MdlwareOffOnType status;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setStatus(MdlwareOffOnType status) {
		this.status = status;
	}
}
