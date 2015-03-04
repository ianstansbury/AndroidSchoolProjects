/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author ian
 *
 */
public class gameLoop extends Activity{

	
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
	
	public static void loop(){
		  
    	if (difficulty == "easy"){
    		//Thread thread = new Thread();
    		//thread.start();
        	gameArray = myGen.arrayGenerator(level);
        	//String temp = Arrays.toString(gameArray);
        	for (int i=0; i<gameArray.length; i++){

               	 if (gameArray[i] == 1){
          
          		                  	gameActivity.buttonChangeRed();

  
        			
        		}
           		else if (gameArray[i] == 2){
 
      		                  	gameActivity.buttonChangeYellow();

      
        		}
           		else if (gameArray[i] == 3){
   
      		                  	gameActivity.buttonChangeGreen();

     
        		}
        		else if (gameArray[i] == 4){
   
      		                  	gameActivity.buttonChangeBlue();

      	
        		}
        		
        	}
        	
    		
    	}

    	
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
