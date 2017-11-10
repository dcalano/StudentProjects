package finalproject;

public class Square {
	
	int posX;
	int posY;
	int fillR;
	int fillG;
	int fillB;
	int highlight;
	ChessPiece chessPiece;
	
	public Square(int posX, int posY, int fillR, int fillG, int fillB) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.fillR = fillR;
		this.fillG = fillG;
		this.fillB = fillB;
		this.chessPiece = null;
		this.highlight = -1;
	}
	
	public void setPiece(ChessPiece p) {
		this.chessPiece = p;
	}
	
	public void removePiece() {
		this.chessPiece = null;
	}
}
