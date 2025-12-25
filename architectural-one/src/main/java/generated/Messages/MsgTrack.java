package generated.Messages;

// PERIODIC
public class MsgTrack implements IMsg {
	private int xPos = 1000;
	private int yPos = 2000;
	private int zPos = 3000;
	private boolean validity;
	
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public void setzPos(int zPos) {
		this.zPos = zPos;
	}
	public void setValidity(boolean validity) {
		this.validity = validity;
	}
	
	
}
