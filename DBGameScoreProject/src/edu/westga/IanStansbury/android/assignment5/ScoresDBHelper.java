/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import edu.westga.IanStansbury.android.assignment5.HighScoreDB.Scores;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author ian
 *
 */
public class ScoresDBHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "score.db";
	private static final int DATABASE_VERSION = 1;
	
	public ScoresDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		// Create the Students table
		db.execSQL("CREATE TABLE " + Scores.SCORES_TABLE_NAME + " ("
		+ Scores.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
		+ Scores.NAME + " TEXT"
		+ ");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
