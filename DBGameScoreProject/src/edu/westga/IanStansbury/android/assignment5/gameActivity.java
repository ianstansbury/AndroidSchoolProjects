/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author ian
 *
 */
public class gameActivity extends Activity {
	
	Button nextLevelButton;
	static Button greenButton;
	static Button redButton;
	static Button yellowButton;
	static Button blueButton;
	static MediaPlayer beep1;
	static MediaPlayer beep2;
	static MediaPlayer beep3;
	static MediaPlayer beep4;
	static MediaPlayer wrongAnswer;
	TextView pass;
	TextView scoreText;
	
	private static int easyTime = 5000;
	private int mediumTime = 600;
	private int hardTime = 300;
	static String difficulty;
	static int level = 1;
	static levelGenerator myGen = new levelGenerator();
	public int score = 0;
	static public int currentArrayIterate = 0;
	static int[] gameArray;
	static public int arrayLength;
	
	private static Context context;

	//Handler h1 = new Handler;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen);
        
        gameActivity.context=getApplicationContext();
        
        /**
         * TODO add in way to iterate through array returned 
         * 				and produce button push,beep
         * 		make way to check wrong answer
         * 		introduce difficulty settings through DiffHolder
         * 		add scoring methods and textview
         * 		create database to hold high score
         */
    	

    	
    	//gets app info from DiffHolder, sets difficulty to string
        DiffHolder tempApp = (DiffHolder)getApplicationContext();
        difficulty = tempApp.getDifficulty();
        

        
        //assigns button object to respective Id's
        greenButton = (Button)this.findViewById(R.id.greenButton);
        redButton = (Button)this.findViewById(R.id.redButton);
        yellowButton = (Button)this.findViewById(R.id.yellowButton);
        blueButton = (Button)this.findViewById(R.id.blueButton);
        nextLevelButton = (Button)this.findViewById(R.id.nextLevel);
        pass = (TextView)this.findViewById(R.id.pass);
        scoreText = (TextView)this.findViewById(R.id.scorePrint);
        
        
        //sets background clors of buttons to low alpha game settings
        
        greenButton.setBackgroundColor(0x5500FF00);
        redButton.setBackgroundColor(0x55FF0000);
        yellowButton.setBackgroundColor(0x55ffff00);
        blueButton.setBackgroundColor(0x550000FF);
        nextLevelButton.setBackgroundColor(0x550000FF);
        
        //assigns media objects to their respective sounds
		beep1 = MediaPlayer.create(this, R.raw.beep1);
		beep2 = MediaPlayer.create(this, R.raw.beep2);
		beep3 = MediaPlayer.create(this, R.raw.beep3);
		beep4 = MediaPlayer.create(this, R.raw.beep4);
		wrongAnswer = MediaPlayer.create(this, R.raw.wrong);

		
		/**
		 * On lcick listener for Green button, includes color change, sound play and delay on button press
		 */
        greenButton.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				gameActivity.buttonChangeGreen();
				score = score +1;
				scoreText.setText("Score " + score);
				

			}
		});
        
        /**
         * On click listener for Red button, includes color change, sound play and delay on button press
         */
        redButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				gameActivity.buttonChangeRed();

			}
		});
        
        /**
         * On click listener for Yellow button, includes color change, sound play and delay on button press
         */
        yellowButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				gameActivity.buttonChangeYellow();
				
				
			}
		});
        
        /**
         * On click listener for Blue button, includes color change, sound play and delay on button press
         */
        blueButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				gameActivity.buttonChangeBlue();
			}
		});
        
        nextLevelButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				gameActivity.play();
				
			}
		});
        //gameActivity.play();
        
    }
       

    
 
    
    /**
     * Plays sequence of lights and beeps. 
     * red=1
     * yellow=2
     * green=3
     * blue=4
     */
    public static void play(){
    	if (difficulty == "easy"){
    		//Thread thread = new Thread();
    		//thread.start();
        	gameArray = myGen.arrayGenerator(level);
        	//String temp = Arrays.toString(gameArray);
        	for (int i=0; i<gameArray.length; i++){
 		
        		
 
               	 if (gameArray[i] == 1){
            			final Handler handler4 = new Handler(); 
          		      
          		        Runnable r = new Runnable() { 
          		               public void run() { 
          		                  	gameActivity.buttonChangeRed();

          		                                } 
          		                        }; 
          		                
          		        handler4.postDelayed(r, 5000);
        			//gameActivity.buttonChangeRed();
        			
        		}
           		else if (gameArray[i] == 2){
        			final Handler handler4 = new Handler(); 
      		      
      		        Runnable r = new Runnable() { 
      		               public void run() { 
      		                  	gameActivity.buttonChangeYellow();

      		                                } 
      		                        }; 
      		                
      		        handler4.postDelayed(r, 5000);
        			//gameActivity.buttonChangeYellow();
        		}
           		else if (gameArray[i] == 3){
        			final Handler handler4 = new Handler(); 
      		      
      		        Runnable r = new Runnable() { 
      		               public void run() { 
      		                  	gameActivity.buttonChangeGreen();

      		                                } 
      		                        }; 
      		                
      		        handler4.postDelayed(r, 5000);
        			//gameActivity.buttonChangeGreen();
        		}
        		else if (gameArray[i] == 4){
        			final Handler handler4 = new Handler(); 
      		      
      		        Runnable r = new Runnable() { 
      		               public void run() { 
      		                  	gameActivity.buttonChangeBlue();

      		                                } 
      		                        }; 
      		                
      		        handler4.postDelayed(r, 5000);
        			//gameActivity.buttonChangeBlue();
        		}
        		
        	}
        	
    		
    	}
    	else if (difficulty == "medium"){
    		//TODO add working code as above but with med tim
    		
    	}
    	else if (difficulty == "hard"){
    		//TODO add working code but with hard time
    	}
    	
    }
    /*
	// Loop for Simon AI
	public void GameLoop() {
		
		// Handler to handle thread messages
		handler = new Handler();
		
		// Game loop thread so UI can be updated in real time
		r = new Runnable() {
		    public void run() {
		    	
		    	// Determine if AI turn has ended
		    	if (//Make sure AI game needs to keep running) {
				// Do AI stuff

		    		// Continue loop
			    	handler.postDelayed(this, iTime);
		    	} else {
		    		// AI turn ended, do player stuff
		    		handler.removeCallbacks(r);
		    	}
		    }
		};
		
		// Start loop
		handler.postDelayed(r, 1000);
		
	}
*/    
    /**
     * 
     */
    public static void buttonChangeBlue(){
		applyAlpha("blue");
		beep4.start();
		if (gameActivity.checkAnswer("blue") == false)
		{
			gameActivity.wrongAnswer();
		}
		else if(level == gameArray.length){
			level = level+1;
		}
		currentArrayIterate = currentArrayIterate +1;

    }
    
    /**
     * 
     */
    public static void buttonChangeRed(){
		applyAlpha("red");
		beep2.start();
		if (gameActivity.checkAnswer("red") == false)
		{
			gameActivity.wrongAnswer();
			
		}
		else if(level == gameArray.length){
			level = level+1;
		}
		currentArrayIterate = currentArrayIterate +1;
		
    }
	   
    /**
     * 
     */
	 public static void buttonChangeYellow(){
			applyAlpha("yellow");
			beep3.start();
			if (gameActivity.checkAnswer("yellow") == false)
			{
				gameActivity.wrongAnswer();
			}
			else if(level == gameArray.length){
				level = level+1;
			}
			currentArrayIterate = currentArrayIterate +1;
	 }
	 
	 
	 public static void buttonChangeGreen(){
/*			greenButton.setBackgroundColor(0xFF00FF00);
			beep1.start();
			final Handler handler = new Handler(); 
		       Timer t = new Timer(); 
		        t.schedule(new TimerTask() { 
		                public void run() { 
		                        handler.post(new Runnable() { 
		                                public void run() { 
		                                	greenButton.setBackgroundColor(0x5500FF00);

		                                } 
		                        }); 
		                } 
		        }, easyTime);*/
			applyAlpha("green");
			beep1.start();
			if (gameActivity.checkAnswer("green") == false)
			{
				gameActivity.wrongAnswer();
			}
			else if(level == gameArray.length){
				level = level+1;
			}
			currentArrayIterate = currentArrayIterate +1;
	 }


		public static void applyAlpha(String color){
			   Animation a = AnimationUtils.loadAnimation(gameActivity.context, R.anim.alpha);
			    a.reset();
			    if (color == "green"){
			    greenButton.clearAnimation();
			   
			    greenButton.startAnimation(a);
			    }
			    else if (color == "yellow"){
			    	yellowButton.clearAnimation();
			    	yellowButton.startAnimation(a);
			    	
			    	
			    }
			    else if (color == "red"){
			    	redButton.clearAnimation();
			    	redButton.startAnimation(a);
			    }
			    else if (color == "blue"){
			    	blueButton.clearAnimation();
			    	blueButton.startAnimation(a);
			    }
		}
	 
		/*
		public static void animationSequence(ViewGroup ){
			AnimationSet set = new AnimationSet(true);
			
		}
    */
		public static boolean checkAnswer(String color){
			arrayLength = gameArray.length;
			if (color == "red" && gameArray[currentArrayIterate] == 1){
				currentArrayIterate = currentArrayIterate +1;
				return true;
			}
			if (color == "yellow" && gameArray[currentArrayIterate] == 2){
				currentArrayIterate = currentArrayIterate +1;
				return true;
			}
			if (color == "green" && gameArray[currentArrayIterate] == 3){
				currentArrayIterate = currentArrayIterate +1;
				return true;
			}
			if (color == "blue" && gameArray[currentArrayIterate] == 4){
				currentArrayIterate = currentArrayIterate +1;
				return true;
			}
			else
			{
			return false;
			}
		}
		
		public static void wrongAnswer(){
			wrongAnswer.start();
			level = 0;
			
		}
		
    
    
		   /**
	     * Plays sequence of lights and beeps. 
	     * red=1
	     * yellow=2
	     * green=3
	     * blue=4
	     */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
