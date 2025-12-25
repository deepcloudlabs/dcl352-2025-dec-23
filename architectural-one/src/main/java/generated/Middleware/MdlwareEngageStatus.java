package generated.Middleware;


import generated.Middleware.Type.MdlwareStatusType;

public class MdlwareEngageStatus implements IMdlware{
	private int id;
	private MdlwareStatusType status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MdlwareStatusType getStatus() {
		return status;
	}
	public void setStatus(MdlwareStatusType status) {
		this.status = status;
	}
	
	
}
