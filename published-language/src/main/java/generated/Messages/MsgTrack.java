package generated.Messages;

// PERIODIC
public class MsgTrack implements IMsg {
	public int xPos = 1000;
	public int yPos = 2000;
	public int zPos = 3000;
	public boolean validity;
	
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
