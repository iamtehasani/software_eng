package cct.mad.lab;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


public class Sprite {
    
	//x,y position of sprite - initial position (0,50)
	private int x = 0; 
	private int y = 50;
    private int xSpeed = 10;//Horizontal increment of position (speed)
    private int ySpeed = 5;// Vertical increment of position (speed)
    private GameView gameView;
    private Bitmap spritebmp;
    //Width and Height of the Sprite image
    private int bmp_width;
	private int bmp_height;
    // Needed for new random coordinates.
  	private Random random = new Random();
    
    public Sprite(GameView gameView) {
          this.gameView=gameView;
          spritebmp = BitmapFactory.decodeResource(gameView.getResources(),
                  R.drawable.ic_launcher);
          this.bmp_width = spritebmp.getWidth();
  		  this.bmp_height= spritebmp.getHeight();
     }
    //update the position of the sprite
    public void update() {
    	x = x + xSpeed;
     //	y = y + ySpeed;
        wrapAround(); //Adjust motion of sprite.
    }

    public void draw(Canvas canvas) {
       	
    	//Draw sprite image
       	canvas.drawBitmap(spritebmp, x , y, null);
    }
    
    public void wrapAround(){
    	//Code to wrap around	
      	if (x < 0) x = x + gameView.getWidth(); //increment x whilst not off screen
    	if (x >= gameView.getWidth()){ //if gone of the right sides of screen
    			x = x - gameView.getWidth(); //Reset x
    	}
    	if (y < 0) y = y + gameView.getHeight();//increment y whilst not off screen
    	if (y >= gameView.getHeight()){//if gone of the bottom of screen
    		y -= gameView.getHeight();//Reset y
    	}
    }
  
}  
