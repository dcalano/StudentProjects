package finalproject;

import processing.core.PImage;

public class Pawn extends ChessPiece {


		boolean moveOne;
		
		
		public Pawn(int teamColor, PImage pawnImage) {
			
			
			super(teamColor, pawnImage);
			this.moveOne = true;
		}
		

}
