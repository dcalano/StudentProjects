package spoonassassin;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;


@SuppressWarnings("serial")
public class SpoonAssassin extends PApplet 
{
	
	public static Random random = new Random();
	
    PImage background;
    PImage paddleImage;
    PImage spoonImage;
    PImage enemyImage;
     
    public Paddle player;
    public Ball spoon;
    public Enemy enemy;
     
    public void setup() 
    {
        size(800, 600);
        background = loadImage("Background.png");
        paddleImage = loadImage("Player.png");
        spoonImage = loadImage("Spoon.png");
        enemyImage = loadImage("Enemy.png");
         
        player = new Paddle(paddleImage, width/2, height * 4/5);
        spoon = new Ball(spoonImage, 0, height / 2);
        enemy = new Enemy(enemyImage, width/2, 30);
        enemy.xSpeed = 4;
        enemy.ySpeed = -2;
    }
 
    public void draw() 
    {     
        background(background);
        player.drawPaddle();
        player.update();
        spoon.update();
        spoon.drawBall();
        enemy.update();
        enemy.drawEnemy();
    }
    
    
    
    public void keyPressed(){
    	if(key=='a' || key=='A'){
    		player.moveLeft = true;
    	}
    	if(key=='d' || key=='D'){
    		player.moveRight = true;
    	}
    	if(key==' '){
    		spoon.move = true;
    	}
    }
    public void keyReleased(){
    	if(key=='a' || key=='A'){
    		player.moveLeft = false;
    	}
    	if(key=='d' || key=='D'){
    		player.moveRight = false;
    	}
    }
    
     
    public class Paddle{
        PImage sprite;
        float xPos;
        float yPos;
         
        int speed = 10;
        public boolean moveRight = false;
        public boolean moveLeft = false;
         
        public Paddle(PImage paddleSprite, float startX, float startY){
            sprite = paddleSprite;
            xPos = startX;
            yPos = startY;
        }
         
        public void drawPaddle(){
            image(sprite, xPos, yPos);
        }
        
        public void update(){
       	 if(this.moveRight)
            {
                this.xPos += this.speed;
            }
            if(this.moveLeft)
            {
                this.xPos -= this.speed;
            }
            checkBounds();
       }
        public void checkBounds(){
        	if(this.xPos < 0){
        		this.xPos = 0;
        		moveLeft = false;
        	}
        	if(this.xPos + this.sprite.width > width){
                this.xPos = width - this.sprite.width;
                moveRight = false;
            }
        }
    }
    
    
    public class Ball{
    	boolean move;
    	PImage sprite;
    	float xPos;
    	float yPos;
    	
    	int xSpeed = 8;
    	int ySpeed = 8;
    	
    	
    	public Ball(PImage ballSprite, float startX, float startY){
    		sprite = ballSprite;
    		xPos = startX;
    		yPos = startY;
    		move = false;
    	}
    	
    	public void update(){
    		if(move){
    		this.xPos += this.xSpeed;
    		this.yPos += this.ySpeed;
    		checkBounds();
    		checkCollision();
    		} else {
    			this.xPos = player.xPos;
                this.yPos = player.yPos - this.sprite.height;
    		}
    	}
    	public void drawBall(){
    		image(sprite, xPos, yPos);
    	}
    	
    	public void checkCollision(){
    		if(this.xPos + this.sprite.width > player.xPos && this.xPos < player.xPos + player.sprite.width){
    			if(this.yPos > player.yPos - player.sprite.height) {
                    this.ySpeed = -this.ySpeed;
                    this.yPos = player.yPos - this.sprite.height;
                }
    		}
    	}
    	
    	public void checkBounds(){
    		if(this.yPos > 600){
    			move = false;
    		}
            if(this.yPos < 0){
                this.ySpeed = -this.ySpeed;
            }
            if(this.xPos < 0)
            {
                this.xSpeed = -this.xSpeed;
                this.xPos = 0;
            }
            if(this.xPos + this.sprite.width > width){
                this.xSpeed = -this.xSpeed;
                this.xPos = width - this.sprite.width;
            }
             
            if(this.yPos > height){
                this.xPos = player.xPos;
                this.yPos = player.yPos - this.sprite.height;
                 
                this.ySpeed = -this.ySpeed;
            }
        }
    }
    

    public class Enemy{
    	PImage sprite;
    	float xPos;
    	float yPos;
    	
    	int xSpeed = 8;
    	int ySpeed = 8;
    	boolean alive = true;
    	
    	
    	public Enemy(PImage enemySprite, float startX, float startY){
    		sprite = enemySprite;
    		xPos = startX;
    		yPos = startY;
    		
    	}
    	
    	public void update(){
    		if(this.alive){
    		this.xPos += this.xSpeed;
    		this.yPos += this.ySpeed;
    		checkBounds();
    		checkCollision();
    		}
    	}
    	public void drawEnemy(){
    		if(this.alive){
    			image(sprite, xPos, yPos);
    		}
    	}
    	
    	public void checkCollision(){
    		if(this.xPos + this.sprite.width > spoon.xPos && this.xPos < spoon.xPos + spoon.sprite.width){
    			if(this.yPos > spoon.yPos - spoon.sprite.height) {
                    this.alive = false;
                }
    		}
    	}
    	
    	public void checkBounds(){
            if(this.yPos < 0){
                this.ySpeed = -this.ySpeed;
                this.ySpeed += random.nextInt(5) - 2;
            }
            if(this.xPos < 0)
            {
                this.xSpeed = -this.xSpeed;
                this.ySpeed += random.nextInt(5) - 2;
                this.xPos = 0;
            }
            if(this.xPos + this.sprite.width > width){
                this.xSpeed = -this.xSpeed;
                this.ySpeed += random.nextInt(5) - 2;
                this.xPos = width - this.sprite.width;
            }
             
            if(this.yPos > height / 2){
                this.ySpeed = -this.ySpeed;
                this.ySpeed += random.nextInt(5) - 2;
            }
        }
    }
    
    
     
    public static void main(String _args[]) {
        PApplet.main(new String[] { spoonassassin.SpoonAssassin.class.getName() });
    }
    
}