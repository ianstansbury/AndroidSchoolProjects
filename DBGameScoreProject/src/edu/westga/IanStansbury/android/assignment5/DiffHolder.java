/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import android.app.Application;
import android.os.Bundle;

/**
 * @author Ian Stansbury 
 * 
 * This class extends application and provides access to the String difficulty through all activities
 *
 */
public class DiffHolder extends Application{
	
	private String difficulty;
	/**
	 * called when activity is accessed
	 */
	@Override
    public void onCreate() {
        difficulty = "easy";
		super.onCreate();
	}
	/**
	 * @return the difficulty
	 */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	

}
