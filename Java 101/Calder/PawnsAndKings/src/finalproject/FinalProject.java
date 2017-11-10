package finalproject;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("serial")
public class FinalProject extends PApplet {

	
	public static final int TEAM_BLACK = 0;
	public static final int TEAM_WHITE = 1;
	public static final int HIGHLIGHT_GREEN = 0;
	public static final int HIGHLIGHT_RED = 1;
	public static final int HIGHLIGHT_NONE = -1;
	
	
	public static Square activeSquare;
	public static PImage bPawnImg; 
	public static PImage wPawnImg;
	public static PImage wKing;
	public static PImage bKing;
	public static PImage rules;
	
	public static List<Square> boardSquares;
	
	
	public void setup() {
		
		//  Draw the screen
		size(800, 930);
        background(300,300,300);
        
        
        // Initialize variables
        bPawnImg = loadImage("blackPawn.png");
        wPawnImg = loadImage("whitePawn.png");
        bKing = loadImage("blackKing.png");
        wKing = loadImage("whiteKing.png");
        rules = loadImage ("rules.png");
        boardSquares = new ArrayList<>();
        
        
        setUpBoard();
		setUpPieces();
        

	
	}
	
	
	public void setUpBoard() {
		
		// 1st row
		boardSquares.add(new Square(0, 0, 0, 0, 0));
		boardSquares.add(new Square(100, 0, 255, 255, 255));
		boardSquares.add(new Square(200, 0, 0, 0, 0));
		boardSquares.add(new Square(300, 0, 255, 255, 255));
		boardSquares.add(new Square(400, 0, 0, 0, 0));
		boardSquares.add(new Square(500, 0, 255, 255, 255));
		boardSquares.add(new Square(600, 0, 0, 0, 0));
		boardSquares.add(new Square(700, 0, 255, 255, 255));
		
		// 2nd row (colors alternated)
		boardSquares.add(new Square(0, 100, 255, 255, 255));
		boardSquares.add(new Square(100, 100, 0, 0, 0));
		boardSquares.add(new Square(200, 100, 255, 255, 255));
		boardSquares.add(new Square(300, 100, 0, 0, 0));
		boardSquares.add(new Square(400, 100, 255, 255, 255));
		boardSquares.add(new Square(500, 100, 0, 0, 0));
		boardSquares.add(new Square(600, 100, 255, 255, 255));
		boardSquares.add(new Square(700, 100, 0, 0, 0));
		
		// 3rd
		boardSquares.add(new Square(0, 200, 0, 0, 0));
		boardSquares.add(new Square(100, 200, 255, 255, 255));
		boardSquares.add(new Square(200, 200, 0, 0, 0));
		boardSquares.add(new Square(300, 200, 255, 255, 255));
		boardSquares.add(new Square(400, 200, 0, 0, 0));
		boardSquares.add(new Square(500, 200, 255, 255, 255));
		boardSquares.add(new Square(600, 200, 0, 0, 0));
		boardSquares.add(new Square(700, 200, 255, 255, 255));
		
		// 4th
		boardSquares.add(new Square(0, 300, 255, 255, 255));
		boardSquares.add(new Square(100, 300, 0, 0, 0));
		boardSquares.add(new Square(200, 300, 255, 255, 255));
		boardSquares.add(new Square(300, 300, 0, 0, 0));
		boardSquares.add(new Square(400, 300, 255, 255, 255));
		boardSquares.add(new Square(500, 300, 0, 0, 0));
		boardSquares.add(new Square(600, 300, 255, 255, 255));
		boardSquares.add(new Square(700, 300, 0, 0, 0));
		
		// 5th
		boardSquares.add(new Square(0, 400, 0, 0, 0));
		boardSquares.add(new Square(100, 400, 255, 255, 255));
		boardSquares.add(new Square(200, 400, 0, 0, 0));
		boardSquares.add(new Square(300, 400, 255, 255, 255));
		boardSquares.add(new Square(400, 400, 0, 0, 0));
		boardSquares.add(new Square(500, 400, 255, 255, 255));
		boardSquares.add(new Square(600, 400, 0, 0, 0));
		boardSquares.add(new Square(700, 400, 255, 255, 255));
		
		// 6th
		boardSquares.add(new Square(0, 500, 255, 255, 255));
		boardSquares.add(new Square(100, 500, 0, 0, 0));
		boardSquares.add(new Square(200, 500, 255, 255, 255));
		boardSquares.add(new Square(300, 500, 0, 0, 0));
		boardSquares.add(new Square(400, 500, 255, 255, 255));
		boardSquares.add(new Square(500, 500, 0, 0, 0));
		boardSquares.add(new Square(600, 500, 255, 255, 255));
		boardSquares.add(new Square(700, 500, 0, 0, 0));
		
		// 7th
		boardSquares.add(new Square(0, 600, 0, 0, 0));
		boardSquares.add(new Square(100, 600, 255, 255, 255));
		boardSquares.add(new Square(200, 600, 0, 0, 0));
		boardSquares.add(new Square(300, 600, 255, 255, 255));
		boardSquares.add(new Square(400, 600, 0, 0, 0));
		boardSquares.add(new Square(500, 600, 255, 255, 255));
		boardSquares.add(new Square(600, 600, 0, 0, 0));
		boardSquares.add(new Square(700, 600, 255, 255, 255));
		
		// 8th
		boardSquares.add(new Square(0, 700, 255, 255, 255));
		boardSquares.add(new Square(100, 700, 0, 0, 0));
		boardSquares.add(new Square(200, 700, 255, 255, 255));
		boardSquares.add(new Square(300, 700, 0, 0, 0));
		boardSquares.add(new Square(400, 700, 255, 255, 255));
		boardSquares.add(new Square(500, 700, 0, 0, 0));
		boardSquares.add(new Square(600, 700, 255, 255, 255));
		boardSquares.add(new Square(700, 700, 0, 0, 0));
	}
	
	public void setUpPieces() {
		// Add white pawns
		for (int i = 8; i < 16; i++) {
			boardSquares.get(i).setPiece(new Pawn(TEAM_BLACK, bPawnImg));
		}
		
		// Add black pawns
		for (int i = 48; i < 56; i++) {
			boardSquares.get(i).setPiece(new Pawn(TEAM_WHITE, wPawnImg));
		}
	
		
		boardSquares.get(3).setPiece(new King(TEAM_BLACK, bKing));
		boardSquares.get(59).setPiece(new King(TEAM_WHITE, wKing));
	}
	
	public void mousePressed() {
	    Square selectedSquare = getBoardSquare();
	    
	    if (selectedSquare.highlight == HIGHLIGHT_NONE) {
	    	if (selectedSquare.chessPiece != null) {
	        	// Remove board highlights
	            for (int i = 0; i < boardSquares.size(); i++) {
	                boardSquares.get(i).highlight = HIGHLIGHT_NONE;
	            }
	        	
	            activeSquare = selectedSquare;
	            highlightPieceMoves();
	        } else {
	            activeSquare = null;
	            
	            // Remove board highlights
	            for (int i = 0; i < boardSquares.size(); i++) {
	                boardSquares.get(i).highlight = HIGHLIGHT_NONE;
	            }
	        }
	    } else {
	        if (selectedSquare.highlight == HIGHLIGHT_GREEN) { // Green, standard move
	        	if (activeSquare.chessPiece instanceof Pawn) {
	        		Pawn pawn = (Pawn) activeSquare.chessPiece;
	        		if (pawn.moveOne == true)
	        			pawn.moveOne = false;
	        	}
	        	
	        	selectedSquare.setPiece(activeSquare.chessPiece);
	            activeSquare.removePiece();
	        } else { // Red. attack enemy move
	        	selectedSquare.setPiece(activeSquare.chessPiece);
	            activeSquare.removePiece();
	        }
	        
	        // Winning condition check
	        if (selectedSquare.chessPiece != null && selectedSquare.chessPiece instanceof Pawn &&  selectedSquare.chessPiece.teamColor == TEAM_BLACK && selectedSquare.posY == 700) {
	        	System.out.println("Black, you win!");
	        	System.exit(0);
	        }
	        else if (selectedSquare.chessPiece != null && selectedSquare.chessPiece instanceof Pawn && selectedSquare.chessPiece.teamColor == TEAM_WHITE && selectedSquare.posY == 0) {
	        	System.out.println("White, you win!");
	        	System.exit(0);
	        }
	        
	        // Remove board highlights
	        for (int i = 0; i < boardSquares.size(); i++) {
	            boardSquares.get(i).highlight = HIGHLIGHT_NONE;
	            
	        }
	    }
	}
		
	public void highlightPieceMoves() {
		//System.out.println("Active square index: " + boardSquares.indexOf(activeSquare));
		
		Square leftSquare = null;
	    Square topSquare = null;
	    Square rightSquare = null;
	    Square bottomSquare = null;
	    Square topLeftSquare = null;
	    Square topRightSquare = null;
	    Square bottomLeftSquare = null;
	    Square bottomRightSquare = null;
	    
	    Square bonusVerticalSquare = null;
		
		ChessPiece p = activeSquare.chessPiece;
	    
	    // Set squares to check
	    boolean onLeftWall = (activeSquare.posX == 0);
	    boolean onTopWall = activeSquare.posY == 0;
	    boolean onRightWall = activeSquare.posX == 700;
	    boolean onBottomWall = activeSquare.posY == 700;
	    
	    // King highlight squares setup
	    if (p instanceof King) {
	        // Squares to initialize
	        boolean top = true, bottom = true, left = true, right = true, topLeft = true, topRight = true, bottomLeft = true, bottomRight = true;
	        
	        if (onTopWall) {
	            top = false;
	            topLeft = false;
	            topRight = false;
	        }
	        
	        if (onBottomWall) {
	            bottom = false;
	            bottomLeft = false;
	            bottomRight = false;
	        }
	        
	        if (onLeftWall) {
	            left = false;
	            topLeft = false;
	            bottomLeft = false;
	        }
	        
	        
	        if (onRightWall) {
	            right = false;
	            topRight = false;
	            bottomRight = false;
	        }
	            
	        
	        if (top)
	            topSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) - 8 );
	            
	        if (bottom)
	            bottomSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) + 8 );
	            
	        if (left)
	            leftSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) - 1 );
	            
	        if (right)
	            rightSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) + 1 );
	        
	        if (topLeft)
	            topLeftSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) - 9 );
	            
	        if (topRight)
	            topRightSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) - 7 );
	        
	        if (bottomLeft)
	            bottomLeftSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) + 7 );
	        
	        if (bottomRight)
	            bottomRightSquare = boardSquares.get ( boardSquares.indexOf(activeSquare) + 9 );
	    } else if (p instanceof Pawn) {
	    	Pawn pawn = (Pawn) p;
	        if (pawn.teamColor == TEAM_BLACK) {
	            if (!onBottomWall) {
	                if (pawn.moveOne) {
	            		bonusVerticalSquare = boardSquares.get( boardSquares.indexOf(activeSquare) + 16 );
	            	}
	                
	                bottomSquare = boardSquares.get( boardSquares.indexOf(activeSquare) + 8 );
	        	    
	        	    
	            	if (!onLeftWall)
	            		bottomLeftSquare = boardSquares.get( boardSquares.indexOf(activeSquare) + 7 );
	        	    
	            	if (!onRightWall)
	            		bottomRightSquare = boardSquares.get( boardSquares.indexOf(activeSquare) + 9 );
	            }
	        } else if (pawn.teamColor == TEAM_WHITE) {
	            if (!onTopWall) {
	                if (pawn.moveOne) {
	            		bonusVerticalSquare = boardSquares.get( boardSquares.indexOf(activeSquare) - 16 );
	            	}
	            	
	                topSquare = boardSquares.get( boardSquares.indexOf(activeSquare) - 8 );
	        	    
	            	if (!onLeftWall)
	            		topLeftSquare = boardSquares.get( boardSquares.indexOf(activeSquare) - 9 );
	        	    
	            	if (!onRightWall)
	            		topRightSquare = boardSquares.get( boardSquares.indexOf(activeSquare) - 7 );
	            }
	        }
	    }
	     
	    // Remove any previous highlights
	    for (int i = 0; i < boardSquares.size(); i++) {
	        boardSquares.get(i).highlight = HIGHLIGHT_NONE;
	    }
	    
	    if (topSquare != null) {
	        if (topSquare.chessPiece == null) {
	            topSquare.highlight = HIGHLIGHT_GREEN;
	            
	            if (p instanceof Pawn) {
	            	Pawn pawn = (Pawn) p;
	            	if (pawn.moveOne == true && bonusVerticalSquare.chessPiece == null) {
	            		bonusVerticalSquare.highlight = HIGHLIGHT_GREEN;
	            	}
		        }  
	        } else if (p instanceof King) {
	            if (topSquare.chessPiece != null  && topSquare.chessPiece.teamColor != p.teamColor) {
	                topSquare.highlight = HIGHLIGHT_RED;
	            }
	        }
	    }
	    
	    if (topLeftSquare != null) {
	        if (topLeftSquare.chessPiece != null  && topLeftSquare.chessPiece.teamColor != p.teamColor) {
	    		topLeftSquare.highlight = HIGHLIGHT_RED;
	    	}
	    	
	    	if (p instanceof King)
	    	    if (topLeftSquare.chessPiece == null)
	    	        topLeftSquare.highlight = HIGHLIGHT_GREEN;
	    }
	    
	    if (topRightSquare != null) {
	        if (topRightSquare.chessPiece != null  && topRightSquare.chessPiece.teamColor != p.teamColor) {
	    		topRightSquare.highlight = HIGHLIGHT_RED;
	    	}
	    	
	    	if (p instanceof King) {
	    	    if (topRightSquare.chessPiece == null) {
	    	        topRightSquare.highlight = HIGHLIGHT_GREEN;
	    	    }
	    	}
	    }
	    
	    if (bottomSquare != null) {
	        if (bottomSquare.chessPiece == null) {
	            bottomSquare.highlight = HIGHLIGHT_GREEN;
	                
	            if (p instanceof Pawn) {
	            	Pawn pawn = (Pawn) p;
	            	if (pawn.moveOne == true && bonusVerticalSquare.chessPiece == null) {
	            		bonusVerticalSquare.highlight = HIGHLIGHT_GREEN;
	            	}
		        }
	            
	        } else if (p instanceof King) {
	            if (bottomSquare.chessPiece != null  && bottomSquare.chessPiece.teamColor != p.teamColor) {
	                bottomSquare.highlight = HIGHLIGHT_RED;
	            }
	        }
	    }
	    
	    if (bottomLeftSquare != null) {
	        if (bottomLeftSquare.chessPiece != null  && bottomLeftSquare.chessPiece.teamColor != p.teamColor) {
	    		bottomLeftSquare.highlight = HIGHLIGHT_RED;
	    	}
	    	
	    	if (p instanceof King) {
	    	    if (bottomLeftSquare.chessPiece == null) {
	    	        bottomLeftSquare.highlight = HIGHLIGHT_GREEN;
	    	    }
	    	}
	    }
	    
	    if (bottomRightSquare != null) {
	        if (bottomRightSquare.chessPiece != null  && bottomRightSquare.chessPiece.teamColor != p.teamColor) {
	    		bottomRightSquare.highlight = HIGHLIGHT_RED;
	    	}
	    	
	    	if (p instanceof King) {
	    	    if (bottomRightSquare.chessPiece == null) {
	    	        bottomRightSquare.highlight = HIGHLIGHT_GREEN;
	    	    }
	    	}
	    }
	    
	    if (leftSquare != null) {
	        if (p instanceof King) {
	    	    if (leftSquare.chessPiece != null  && leftSquare.chessPiece.teamColor != p.teamColor) {
	    		    leftSquare.highlight = HIGHLIGHT_RED;
	        	} else if (leftSquare.chessPiece == null) {
	        	    leftSquare.highlight = HIGHLIGHT_GREEN;
	        	}
	    	}
	    }
	    
	    if (rightSquare != null) {
	        if (p instanceof King) {
	    	    if (rightSquare.chessPiece != null  && rightSquare.chessPiece.teamColor != p.teamColor) {
	    		    rightSquare.highlight = HIGHLIGHT_RED;
	        	} else if (rightSquare.chessPiece == null){
	        	    rightSquare.highlight = HIGHLIGHT_GREEN;
	        	}
	    	}
	    }
	}


	public Square getBoardSquare() {
	    Square s = null;
	    
	    for (int i = 0; i < 64; i++) {
	        s = boardSquares.get(i);
	        
	        if ((mouseX >= s.posX && mouseX < s.posX + 100) && (mouseY >= s.posY && mouseY < s.posY + 100)) {
	            break;
	        }
	    }
	    
	  //  System.out.println("Selected square: " + s.posX + ", " + s.posY);
	    return s;
	}


	public void draw() {
		image (rules, 0, 830);
		// For every board square
		for (int i = 0; i < boardSquares.size(); i++) {
			// Draw the square
			Square s = boardSquares.get(i);
		
		
			if (s.highlight == HIGHLIGHT_GREEN) {
				fill(0, 255, 0);
			} else if (s.highlight == HIGHLIGHT_RED) {
				fill (255, 0, 0);
			} else {
				fill(s.fillR, s.fillG, s.fillB);
			}
			
			rect(s.posX, s.posY, 100, 100);
			
			// Draw the pawn on that square, if there is one
			if (s.chessPiece != null) {
				
				image(s.chessPiece.pieceImage, s.posX, s.posY);
			}
			
			
		}
	}
}