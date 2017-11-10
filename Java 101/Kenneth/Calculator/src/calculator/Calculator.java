package calculator;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;


//NOTE: FIX ADDENDS
public class Calculator extends PApplet {
	TheCalculator calc1 = new TheCalculator();
	public List<Integer> addends = new ArrayList<>();
	public int x = 0;
	public void setup() {
		size(500,700);
		background(255,255,255);
		fill(0,255,0);
		calc1.drawButtons();
	}

	public void draw() {
		x = 0;
	}
	public void mousePressed(){
		
		if(mouseX > 0 && mouseX < 100 && mouseY > 100 && mouseY < 200){
			addends.add(1);
		}else if(mouseX > 125 && mouseX < 250 && mouseY > 100 && mouseY < 200){
			addends.add(2);
		}
		if(mouseX > 375 && mouseX < 500 && mouseY >400 && mouseY < 500){
			for(int i = 0; i < addends.size(); i++){
					
					x += addends.get(i);
					
			}
			System.out.println("Answer: " + x);
			
			
		}
		
		
	}
	
	public class TheCalculator{
		 
		 
		 public void drawButtons(){
			 textSize(75);
			 
			 rect(0, 100, 125, 100);
			 fill(255,255,255);
			 text("1", 50,100,125,100);
			 
			 fill(0,255,0);
			 rect(125, 100, 125, 100);
			 fill(255,255,255);
			 text("2", 175,100,125,100);
			 
			 fill(0,255,0);
			 rect(250, 100, 125, 100);
			 fill(255,255,255);
			 text("3", 300,100,125,100);
			 
			 fill(0,255,0);
			 rect(0,200, 125, 100);
			 fill(255,255,255);
			 text("4", 50,200,125,100);
			 
			 fill(0,255,0);
			 rect(125, 200, 125, 100);
			 fill(255,255,255);
			 text("5", 175,200,125,100);
			 
			 fill(0,255,0);
			 rect(250, 200, 125, 100);
			 fill(255,255,255);
			 text("6", 300,200,125,100);
			 
			 fill(0,255,0);
			 rect(0, 300, 125, 100);
			 fill(255,255,255);
			 text("7", 50,300,125,100);
			 
			 fill(0,255,0);
			 rect(125, 300, 125, 100);
			 fill(255,255,255);
			 text("8", 175,300,125,100);
			 
			 fill(0,255,0);
			 rect(250, 300, 125, 100);
			 fill(255,255,255);
			 text("9", 300,300,125,100);
			 
			 fill(0,255,0);
			 rect(125, 400, 125, 100);
			 fill(255,255,255);
			 text("0", 175,400,125,100);
			 
			 fill(0,255,0);
			 rect(375, 400, 125, 100);
			 fill(255,255,255);
			 text("=", 425, 400, 125, 100);
			 
		 }
	}
}
