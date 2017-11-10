package dotsandboxes;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;


@SuppressWarnings("serial")
public class DotsAndBoxes extends PApplet {

	private static final int DOT_RADIUS = 30;
	private static final int DOT_GAP = 100;
	boolean p1Turn = true;
	int p1 = color(255, 0, 0);
	int p2 = color(0, 0, 255);
	boolean gameOver = false;
	boolean turnOne = true;
	String winnerText = "";
	
	List<Dots> dots = new ArrayList<>();
	List<Line> lines = new ArrayList<>();

	Dots selectedDot = null;

	public void setup() {
		size(400, 400);
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				Dots dot = new Dots(DOT_GAP * i, DOT_GAP * j);
				dots.add(dot);
			}
		}
	}

	public void draw() {
		if (turnOne == false)
			checkWin();
		
		if (gameOver == false) {
			clear();
			background(255, 255, 255);
			fill (0,0,0);
			if (p1Turn == true) {
				text("player 1", 200, 380, 250, 100);
			} else {
				text("player 2", 200, 380, 250, 100);
			}
			
			for (int i = 0; i < dots.size(); i++) {
				Dots dot = dots.get(i);
				
				if (dot.equals(selectedDot)) {
					fill(100, 100, 100);
				}else if (dot.getTeam() == 1) {
					fill(255, 0, 0);
				} else if(dot.getTeam() == 2){
					fill(0, 0, 255);
				} else {
					fill(255, 255, 255);
				}
				
				// TODO: make the colors change and stay that color
				ellipse(dot.getX(), dot.getY(), DOT_RADIUS, DOT_RADIUS);
			}
			
			for (int i = 0; i < lines.size(); i++) {
				Line l = lines.get(i);
				line(l.x1, l.y1, l.x2, l.y2);
			}
		} else {
			if (p1Turn) {
				winnerText = "Player 1 wins";
			} else {
				winnerText = "Player 2 wins";
			}
			
			clear();
			background(255, 255, 255);
			fill (0,0,0);
			textSize(30);
			text("Game over", 100, 100, 300, 100);
			text(winnerText, 100, 150, 300, 100);
		}
		

	}
	
	public void checkWin() {
		gameOver = true;
		for (int i = 0; i < dots.size(); i++) {
			if (dots.get(i).getTeam() != 1 && dots.get(i).getTeam() != 2) {
				gameOver = false;
				break;
			}
		}
	}
	
	public void mouseClicked() {
		int x = mouseX;
		int y = mouseY;
		
		for (int i = 0; i < dots.size(); i++) {
			Dots dot = dots.get(i);
			if (x > dot.getX() - DOT_RADIUS && x < dot.getX() + DOT_RADIUS 
					&& y > dot.getY() - DOT_RADIUS && y < dot.getY() + DOT_RADIUS) {
				if (selectedDot == null) {
					selectedDot = dot;
				} else {
					if (Math.abs(selectedDot.getX() - dot.getX()) == DOT_GAP 
							|| Math.abs(selectedDot.getY() - dot.getY()) == DOT_GAP) {
						if (p1Turn) {
							if (dot.getTeam() != 1)
								dot.setTeam(1);
							if (selectedDot.getTeam() != 1)
								selectedDot.setTeam(1);
						} else {
							if (dot.getTeam() != 2)
								dot.setTeam(2);
							if (selectedDot.getTeam() != 2)
								selectedDot.setTeam(2);
						}
						
						lines.add(new Line(selectedDot.getX(), selectedDot.getY(), dot.getX(), dot.getY()));
						
						turnOne = false;
						p1Turn = !p1Turn;
						//TODO: check for a box and put a string in the middle or color it in
						
						selectedDot = null;
						
					} else {
						selectedDot = null;
					}
				}
				
				
				break;
			}
		}
	}
}
