/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import edu.westga.IanStansbury.android.assignment5.HighScoreDB.Scores;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author ian
 *
 */
public class ScoresDBAdapter {
	private ScoresDBHelper databaseHelper = null;
	private SQLiteDatabase theDB = null;
	private Context context = null;

	/**
	 * @param context the context to set
	 */
	public void scoresDBAdapter(Context context) {
		this.context = context;
	}
	
	public ScoresDBAdapter open() throws SQLException {
		this.databaseHelper = new ScoresDBHelper(this.context);
		this.theDB = this.databaseHelper.getWritableDatabase();
		return this;
		}
	
	//closes database
	public void close() {
		this.databaseHelper.close();
	}
	
	public long createHighScore(String name, String score){
		ContentValues initialValues = new ContentValues();
		initialValues.put(Scores.NAME, name);
		initialValues.put(Scores.SCORE, score);
		return theDB.insert(Scores.SCORES_TABLE_NAME, null,
		initialValues);
		
	}
	
	public Cursor fetchHighScores(){
		String[] columns = new String[] {Scores.ID, Scores.NAME,
				Scores.SCORE};
		return this.theDB.query(Scores.SCORES_TABLE_NAME, columns,
				null, null, null, null, null);
	}
	
	//update db table with specified id
	public boolean updateStudent(long rowId, String name, String score){
		ContentValues args = new ContentValues();
		args.put(Scores.SCORE, score);
		args.put(Scores.NAME, name);
		return this.theDB.update(Scores.SCORES_TABLE_NAME, args,
		Scores.ID + "=" + rowId, null) > 0;
	}
	
	
	
	
}
