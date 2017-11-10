package finalproject;

import processing.core.PImage;

public class King extends ChessPiece {
	
	boolean check;
	
	
	public King (int teamColor,PImage kingImg) {
		super (teamColor, kingImg);
		this.check = false;	 
	}

}
