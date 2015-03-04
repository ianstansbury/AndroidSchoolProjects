/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;


/**
 * @author Ian Stansbury, This activity sets the difficulty through radio buttons
 * 				and loads the respective string into the DiffHolder class 
 *
 */
public class DifficultyActivity extends Activity{
	
	//radioButton objects
	RadioButton easyToggle;
	RadioButton mediumToggle;
	RadioButton hardToggle;
	
	/**
	 * called on creation of activity
	 */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficultyscreen);
        
        //assigns  Radio butttons to their respective id's
        easyToggle = (RadioButton)this.findViewById(R.id.easy);
        mediumToggle = (RadioButton)this.findViewById(R.id.medium);
        hardToggle = (RadioButton)this.findViewById(R.id.hard);
        
        
        //call diffHolder class and gets application data from it, sets localString to current set difficulty
        DiffHolder tempApp = (DiffHolder)getApplicationContext();
        String localString = tempApp.getDifficulty();
        
        /**
         * Checks localString var to check difficulty level
         */
        if (localString == "medium"){
        	mediumToggle.setChecked(true);
        }
        else if (localString == "hard"){
        	hardToggle.setChecked(true);
        }
		
        /**
         * Sets up onclick listener for toggling to easy mode, set to easy by default
         */
        easyToggle.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				if (easyToggle.isChecked()){
			        DiffHolder tempApp = (DiffHolder)getApplicationContext();
					tempApp.setDifficulty("easy");
				}
			}
		});
        
        /**
         * Sets up onclick listener for toggling to medium mode, set to easy by default
         */
        mediumToggle.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if (mediumToggle.isChecked()){
			        DiffHolder tempApp = (DiffHolder)getApplicationContext();
			       	tempApp.setDifficulty("medium");
				}
				
			}
		});
        
        /**
         * Sets up onclick listener for toggling to hard mode, set to easy by default
         */
        hardToggle.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if (hardToggle.isChecked()){
			        DiffHolder tempApp = (DiffHolder)getApplicationContext();
			        tempApp.setDifficulty("hard");
				}
				
			}
		});
        
        
    }
        
}
