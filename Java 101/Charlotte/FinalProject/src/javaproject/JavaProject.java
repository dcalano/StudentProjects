package javaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;


@SuppressWarnings("serial")
public class JavaProject extends PApplet  {

	PImage background; 
	PImage paddleImage;
	PImage soapImage;
	
	public Random randomGenerator = new Random();
	
	public Paddle player;
	public List<Bubble> bubbles = new ArrayList<>(); 
	
	int numBubbles = 5;
	
	public static void main(String _args[]) {
        PApplet.main(new String[] { 
        	javaproject.JavaProject.class.getName() 
        });
	}
	
	public void setup() {
		size(800, 600);
        background = loadImage("background.png");
        paddleImage = loadImage("bird.png");
        soapImage = loadImage("soapbubble.png");
        
        player = new Paddle(paddleImage, width / 2, height / 2);
        
        for (int i = 0; i < numBubbles; i++) {
        	bubbles.add(new Bubble(soapImage, randomGenerator.nextInt(width), randomGenerator.nextInt(height)));
        }
	}

	public void draw() {
		if (bubbles.size() > 0) {
			background(background);
			
			player.update();
			for (int i = 0; i < bubbles.size(); i++) {
				Bubble b = bubbles.get(i);
				b.update();
				if (checkCollision(b)) {
					bubbles.remove(b);
				}
			}
			
			player.drawPaddle();
			for (int i = 0; i < bubbles.size(); i++) {
				bubbles.get(i).drawBubble();
			}
		} else {
			clear();
			background(background);
			textSize(40);
			text("Game over!", width / 2, height / 2, 300, 300);
		}
	}
	
	public boolean checkCollision(Bubble b) {
    	if ((b.xPos < player.xRightBound && b.xRightBound > player.xPos)
			&& 
			(b.yPos < player.yBottomBound && b.yBottomBound > player.yPos)) {
    		
    		return true;
    	}
    	
    	return false;
    }
	
	public void keyPressed() {
        // Left / right
		if (key == 'd' || key == 'D') {
            player.moveRight = true;
        } 
		
        if (key == 'a' || key == 'A') {
            player.moveLeft = true;
        }
        
        // Up/down
        if (key == 'w' || key == 'W') {
            player.moveUp = true;
        } 
        if (key == 's' || key == 'S') {
            player.moveDown = true;
        }
    }
	
	public void keyReleased() {
		// Left / right
		if (key == 'd' || key == 'D') {
            player.moveRight = false;
        } 
        
        if (key == 'a' || key == 'A') {
            player.moveLeft = false;
        }
        
        // Up/down
        if (key == 'w' || key == 'W') {
            player.moveUp = false;
        } 
        if (key == 's' || key == 'S') {
            player.moveDown = false;
        }
    }
	    
	public class Paddle {
        PImage sprite;
        
        float xPos;
        float xRightBound;
        float yPos;
        float yBottomBound;
        
        int speed = 10;
        public boolean moveRight = false;
        public boolean moveLeft = false;
        public boolean moveUp = false;
        public boolean moveDown = false;
        
        public Paddle(PImage paddleSprite, float startX, float startY) {
            this.sprite = paddleSprite;
            this.xPos = startX;
            this.yPos = startY;
            this.xRightBound = this.xPos + this.sprite.width;
            this.yBottomBound = this.yPos + this.sprite.height;
        }
        
        public void drawPaddle() {
            image(sprite, xPos, yPos);
        }
        
        public void update() {
        	// Left /right
            if (this.moveRight) {
            	this.xPos += this.speed;
            }
            
            if (this.moveLeft) {
            	this.xPos -= this.speed;
            }
            
            // Up / down
            if (this.moveUp) {
            	this.yPos -= this.speed;
            }
            
            if (this.moveDown) {
            	this.yPos += this.speed;
            }
            
            if (this.xPos < 0 ) {
                this.xPos = 0;
                moveLeft = false;
            }
       	 
            if (this.xPos + this.sprite.width > width) {
                this.xPos = width - this.sprite.width;
                moveRight = false;
            }
            
            if (this.yPos < 0) {
				this.yPos = 0;
				moveUp= false;
            }
           	 
           	 
            if (this.yPos + this.sprite.height > height) {
                this.yPos = height - this.sprite.height;
                moveDown = false; 
            }
            
            this.xRightBound = this.xPos + this.sprite.width;
            this.yBottomBound = this.yPos + this.sprite.height;
        }
	}
	
	public class Bubble {
		PImage sprite;
        float xPos;
        float yPos;
        float xRightBound;
        float yBottomBound;
        
        int velocity = 6;
        int xSpeed = 6;
        int ySpeed = 6;
        
        public Bubble(PImage ballSprite, float startX, float startY) {
            this.sprite = ballSprite;
            this.xPos = startX;
            this.yPos = startY;
            this.xRightBound = this.xPos + this.sprite.width;
            this.yBottomBound = this.yPos + this.sprite.height;
        }
        
        public void drawBubble() {
        	image(this.sprite, this.xPos, this.yPos);
        }
        
        public void update() {
        	this.xPos += this.xSpeed;
    		this.yPos += this.ySpeed;
    		
            if (this.xPos < 0) {
                this.xSpeed = this.velocity;
            }
            
            if (this.xRightBound > width) {
                this.xSpeed = -this.velocity;
            }
            
            if (this.yPos < 0) {
                this.ySpeed = this.velocity;
            }

            if (this.yBottomBound > height) {
                this.ySpeed = -this.velocity;
            }
            
            this.xRightBound = this.xPos + this.sprite.width;
            this.yBottomBound = this.yPos + this.sprite.height;
        }
	}
}



