/**
 * 
 */
package edu.westga.IanStansbury.android.assignment5;

import java.util.Random;

/**
 * @author ian
 *
 */
public class levelGenerator {

	public int[] arrayGenerator(int level){
	Random randNumGenerator = new Random();
	 
	
	
	int[] myArray = new int[level];
	for (int i=0; i<myArray.length; i++)
	{
	myArray[i] = (randNumGenerator.nextInt(4)+1);
	System.out.println(myArray[i]);
	}
	return myArray;
	}
	
	
	
	
}
