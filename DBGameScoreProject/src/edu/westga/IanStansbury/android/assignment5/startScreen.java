package edu.westga.IanStansbury.android.assignment5;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.PorterDuff;;

/**
 * 
 * @author ian
 * 
 * This activity is the main start screen, provides navigation to all other activities
 *
 */
public class startScreen extends Activity {
	
	//Button objects
	Button startButton;
	Button difficultyButton;
	Button highScoreButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);

        //asigns Button objects to their respective id's
        startButton =(Button)this.findViewById(R.id.startButton);
        difficultyButton =(Button)this.findViewById(R.id.difficultyButton);
        highScoreButton =(Button)this.findViewById(R.id.highScoresButton);
        
        //csets background of buttons to colors with lowered alpha values
        startButton.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        difficultyButton.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
        highScoreButton.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
        
        /**
         * sets on click listener for Start button, starts game activity
         */
        startButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {
				Intent startGame = new Intent(startScreen.this, gameActivity.class);
				startActivity(startGame);
				
				
			}
		});
        
        /**
         * sets on click listener for difficulty button, starts difficulty activity
         */
        difficultyButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent difficulty = new Intent(startScreen.this, DifficultyActivity.class);
				startActivity(difficulty);

				
			}
		});
        
        /**
         * sets on click listener for high score button, starts high score activity
         */
        highScoreButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View view) {

				Intent  scoreIntent= new Intent(startScreen.this,  HighScoresActivity.class);
				startActivity(scoreIntent);
				
			}
		});
        /* call for random array
		gen myGen = new gen();
		int[] gameArray = myGen.methode(5);
    	*/
    }
}