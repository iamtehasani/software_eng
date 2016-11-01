package cct.mad.lab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * This class takes care of surface for drawing and touches
 * 
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

	/* Member (state) fields   */
	private GameLoopThread gameLoopThread;
	private Paint paint; //Reference a paint object 
    /** The drawable to use as the background of the animation canvas */
    private Bitmap mBackgroundImage;
  
	public GameView(Context context) {
		super(context);
		// Focus must be on GameView so that events can be handled.
		this.setFocusable(true);
		// For intercepting events on the surface.
		this.getHolder().addCallback(this);
	}
	 /* Called immediately after the surface created */
	public void surfaceCreated(SurfaceHolder holder) {
		// We can now safely setup the game start the game loop.
		ResetGame();//Set up a new game up - could be called by a 'play again option'
		gameLoopThread = new GameLoopThread(this.getHolder(), this);
		gameLoopThread.running = true;
		gameLoopThread.start();
	}
		
	//To initialise/reset game
	private void ResetGame(){
		/* Set paint details */
	    paint = new Paint();
		paint.setColor(Color.WHITE); 
		paint.setTextSize(20); 
	}

	//This class updates and manages the assets prior to drawing - called from the Thread
	public void update(){

	}
	/**
	 * To draw the game to the screen
	 * This is called from Thread, so synchronisation can be done
	 */
	public void doDraw(Canvas canvas) {
		//Draw all the objects on the canvas
		canvas.drawText("The Game ",5,25, paint);
	}
	
	//To be used if we need to find where screen was touched
	public boolean onTouchEvent(MotionEvent event) {
				
		return true;
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		gameLoopThread.running = false;
		
		// Shut down the game loop thread cleanly.
		boolean retry = true;
		while(retry) {
			try {
				gameLoopThread.join();
				retry = false;
			} catch (InterruptedException e) {}
		}
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}



}
