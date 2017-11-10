package dotsandboxes;


public class Dots {
	
	int x1;
	int y1;
	boolean isHighlighted;
	int team;   // 1 = team1, 2 = team2
	
	public Dots(int dX1, int dY1){
		this.x1 = dX1;
		this.y1 = dY1;
		this.isHighlighted = false;
		this.team = 0;
	}
	
	public void setHighlighted() {
		this.isHighlighted = true;
	}
	
	public boolean getHighlighted() {
		return this.isHighlighted;
	}
	
	public void setTeam(int team){
		this.team = team;
	}
	
	public int getTeam(){
		return this.team;
	}
	
	public int getX() {
		return x1;
	}

	public void setX(int x1) {
		this.x1 = x1;
	}

	public int getY() {
		return y1;
	}

	public void setY(int y1) {
		this.y1 = y1;
	}
	

	
	
}
