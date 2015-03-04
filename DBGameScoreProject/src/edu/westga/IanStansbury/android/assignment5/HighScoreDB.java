/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import android.provider.BaseColumns;

/**
 * @author ian
 *
 */
public final class HighScoreDB {

	private HighScoreDB() {

	}
	
	static final class Scores implements BaseColumns{
		
		public static final String SCORES_TABLE_NAME = "scores";
		public static final String ID = "_id";
		public static final String NAME = "name";
		public static final String SCORE = "score";
	}
	
	

}
