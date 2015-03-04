package edu.uwg.IanStansbury.android.Assignment2;

import edu.uwg.IanStansbury.android.Lab2.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

/**
 * 
 * @author ian The purpose of this class is to build an android calculator that will take input and operators and return 
 * results in decimal, binary or hexadecimal
 * 
 */

public class CalculatorActivity extends Activity implements OnClickListener {

	EditText textView;
	// creates operations buttons
	Button addButton;
	Button subtractButton;
	Button divideButton;
	Button multiplyButton;
	Button clearButton;
	Button equalsButton;
	//creates string variables to hold user input and allow new numbers to be appended
	String setInput1 = "";
	String setInput2 = "";
	String setOperator;
	String stringTotal;
	//int variables for computation
	int input1;
	int input2;
	int currentTotal;
	//sets whether the input being added is the first input or the second
	boolean isInput1 = true;
	//string to set the calculation mode, defaulted to hexadecimal so all buttons show up
	String calculateType = "hexadecimal";

	// creates button objects
	Button aButton;
	Button bButton;
	Button cButton;
	Button dButton;
	Button eButton;
	Button fButton;
	Button Button0;
	Button Button1;
	Button Button2;
	Button Button3;
	Button Button4;
	Button Button5;
	Button Button6;
	Button Button7;
	Button Button8;
	Button Button9;

	// creates radio button objects
	RadioButton binaryChecked;
	RadioButton decimalChecked;
	RadioButton hexadecimalChecked;

	/**
	 * 
	 * Called when the activity is first created.
	 * 
	 * */

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//the main user input box
		textView = (EditText) findViewById(R.id.NumberDisplay);

		// assigns all button objects to corresponding view id
		// operation buttons
		addButton = (Button) this.findViewById(R.id.buttonAddition);
		subtractButton = (Button) this.findViewById(R.id.buttonSubtract);
		divideButton = (Button) this.findViewById(R.id.buttonDivide);
		multiplyButton = (Button) this.findViewById(R.id.buttonMultiply);
		clearButton = (Button) this.findViewById(R.id.buttonClear);
		equalsButton = (Button) this.findViewById(R.id.buttonEquals);

		// hexadecimal buttons
		aButton = (Button) this.findViewById(R.id.buttonA);
		bButton = (Button) this.findViewById(R.id.buttonB);
		cButton = (Button) this.findViewById(R.id.buttonC);
		dButton = (Button) this.findViewById(R.id.buttonD);
		eButton = (Button) this.findViewById(R.id.buttonE);
		fButton = (Button) this.findViewById(R.id.buttonF);
		// decimal buttons
		Button0 = (Button) this.findViewById(R.id.button0);
		Button1 = (Button) this.findViewById(R.id.button1);
		Button2 = (Button) this.findViewById(R.id.button2);
		Button3 = (Button) this.findViewById(R.id.button3);
		Button4 = (Button) this.findViewById(R.id.button4);
		Button5 = (Button) this.findViewById(R.id.button5);
		Button6 = (Button) this.findViewById(R.id.button6);
		Button7 = (Button) this.findViewById(R.id.button7);
		Button8 = (Button) this.findViewById(R.id.button8);
		Button9 = (Button) this.findViewById(R.id.button9);
		//radio buttons for setting the mode of calculator
		binaryChecked = (RadioButton) this.findViewById(R.id.binary);
		decimalChecked = (RadioButton) this.findViewById(R.id.decimal);
		hexadecimalChecked = (RadioButton) this.findViewById(R.id.hexedecimal);

		// sets listener for binary radio button and disables all but binary
		// buttons
		binaryChecked.setOnClickListener(new OnClickListener() {

			public void onClick(View binView) {
				if (((RadioButton) binView).isChecked()) {
					//gets user input currently displayed in text box
					String tempString = textView.getText().toString();
					//checks to make sure of length then converts from other types
					if (tempString.length() > 0) {
						if (calculateType == "decimal") {
							int tempInt = Integer.parseInt(tempString);
							String setText = Integer.toBinaryString(tempInt);
							textView.setText(setText);
						} else if (calculateType == "hexadecimal") {
							int tempInt = Integer.valueOf(tempString, 16)
									.intValue();
							String setText = Integer.toBinaryString(tempInt);
							textView.setText(setText);
						}
					} else {
						textView.setText("");
					}
					//set calculator type
					calculateType = "binary";
					aButton.setEnabled(false);
					bButton.setEnabled(false);
					cButton.setEnabled(false);
					dButton.setEnabled(false);
					eButton.setEnabled(false);
					fButton.setEnabled(false);
					Button2.setEnabled(false);
					Button3.setEnabled(false);
					Button4.setEnabled(false);
					Button5.setEnabled(false);
					Button6.setEnabled(false);
					Button7.setEnabled(false);
					Button8.setEnabled(false);
					Button9.setEnabled(false);
				}

			}
		});

		// sets listener for binary radio button and disables all but binary
		// buttons
		decimalChecked.setOnClickListener(new OnClickListener() {

			public void onClick(View decView) {
				if (((RadioButton) decView).isChecked()) {
					//gets user input currently displayed in text box
					String tempString = textView.getText().toString();
					//checks to make sure of length then converts from other types
					if (tempString.length() > 0) {
						if (calculateType == "binary") {
							int tempInt = Integer.parseInt(tempString, 2);
							String setText = Integer.toString(tempInt);
							textView.setText(setText);
						} else if (calculateType == "hexadecimal") {
							int tempInt = Integer.valueOf(tempString, 16)
									.intValue();
							String setText = Integer.toString(tempInt);
							textView.setText(setText);
						}

					} else {
						textView.setText("");
					}
					//set calculator type
					calculateType = "decimal";
					aButton.setEnabled(false);
					bButton.setEnabled(false);
					cButton.setEnabled(false);
					dButton.setEnabled(false);
					eButton.setEnabled(false);
					fButton.setEnabled(false);
					Button2.setEnabled(true);
					Button3.setEnabled(true);
					Button4.setEnabled(true);
					Button5.setEnabled(true);
					Button6.setEnabled(true);
					Button7.setEnabled(true);
					Button8.setEnabled(true);
					Button9.setEnabled(true);
				}

			}
		});

		// sets listener for binary radio button and disables all but binary
		// buttons
		hexadecimalChecked.setOnClickListener(new OnClickListener() {

			public void onClick(View hexdecView) {
				if (((RadioButton) hexdecView).isChecked()) {
					//gets user input currently displayed in text box
					String tempString = textView.getText().toString();
					//checks to make sure of length then converts from other types
					if (tempString.length() > 0) {
						if (calculateType == "decimal") {
							int tempInt = Integer.parseInt(tempString);
							String setText = Integer.toHexString(tempInt);
							textView.setText(setText);
						} else if (calculateType == "binary") {
							int tempInt = Integer.parseInt(tempString, 2);
							String setText = Integer.toHexString(tempInt);
							textView.setText(setText);
						}

					} else {
						textView.setText("");
					}
					//set calculator type
					calculateType = "hexadecimal";
					aButton.setEnabled(true);
					bButton.setEnabled(true);
					cButton.setEnabled(true);
					dButton.setEnabled(true);
					eButton.setEnabled(true);
					fButton.setEnabled(true);
					Button2.setEnabled(true);
					Button3.setEnabled(true);
					Button4.setEnabled(true);
					Button5.setEnabled(true);
					Button6.setEnabled(true);
					Button7.setEnabled(true);
					Button8.setEnabled(true);
					Button9.setEnabled(true);
				}

			}
		});
		//sets listeners to all other buttons besides radio buttons
		Button0.setOnClickListener(this);
		Button1.setOnClickListener(this);
		Button2.setOnClickListener(this);
		Button3.setOnClickListener(this);
		Button4.setOnClickListener(this);
		Button5.setOnClickListener(this);
		Button6.setOnClickListener(this);
		Button7.setOnClickListener(this);
		Button8.setOnClickListener(this);
		Button9.setOnClickListener(this);
		addButton.setOnClickListener(this);
		multiplyButton.setOnClickListener(this);
		subtractButton.setOnClickListener(this);
		divideButton.setOnClickListener(this);
		clearButton.setOnClickListener(this);
		equalsButton.setOnClickListener(this);
		aButton.setOnClickListener(this);
		bButton.setOnClickListener(this);
		cButton.setOnClickListener(this);
		dButton.setOnClickListener(this);
		eButton.setOnClickListener(this);
		fButton.setOnClickListener(this);

	}

	public void onClick(View v) {
		//checks to make sure this is the second input set, then each button appends to string value setInput2
		if (isInput1 == false) {
			if (v == aButton) {
				String strToAppend = aButton.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == bButton) {
				String strToAppend = bButton.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == cButton) {
				String strToAppend = cButton.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == dButton) {
				String strToAppend = dButton.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == eButton) {
				String strToAppend = eButton.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == fButton) {
				String strToAppend = fButton.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button0) {
				String strToAppend = Button0.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button1) {
				String strToAppend = Button1.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button2) {
				String strToAppend = Button2.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button3) {
				String strToAppend = Button3.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button4) {
				String strToAppend = Button4.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button5) {
				String strToAppend = Button5.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button6) {
				String strToAppend = Button6.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button7) {
				String strToAppend = Button7.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button8) {
				String strToAppend = Button8.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			if (v == Button9) {
				String strToAppend = Button9.getText().toString();
				textView.append(strToAppend);
				setInput2 = setInput2 + strToAppend;
			}
			/*
			 * all operator buttons:
			 * gets text of button pressed
			 * based on calculator mode parses int variables to input1 or input2
			 * calculates answer based what the operator was set to 
			 * converts answer to correct mode ie, decimal hex or binary
			 * changes operator to current button press
			 * appends text operator to text view
			 */
			if (v == multiplyButton) {
				String strToAppend = multiplyButton.getText().toString();
				
				if (calculateType == "decimal"){
					input1 = Integer.parseInt(setInput1);
					input2 = Integer.parseInt(setInput2);
				}
				else if (calculateType == "binary"){
					input1 = Integer.parseInt(setInput1, 2);
					input2 = Integer.parseInt(setInput2, 2);
				}
				else if (calculateType == "hexadecimal"){
					input1 = Integer.parseInt(setInput1, 16);
					input2 = Integer.parseInt(setInput2, 16);
				}
				//checks for operator then makes calculation
				if (setOperator == "multiply") {
					currentTotal = input1 * input2;
				} else if (setOperator == "divide") {
					currentTotal = input1 / input2;
				} else if (setOperator == "subtract") {
					currentTotal = input1 - input2;
				} else if (setOperator == "add") {
					currentTotal = input1 + input2;
				}
				stringTotal = Integer.toString(currentTotal);
				if (calculateType == "decimal") {
					textView.setText(stringTotal);
					textView.append(strToAppend);
				} else if (calculateType == "binary") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toBinaryString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);

				} else if (calculateType == "hexadecimal") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toHexString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);
				}
				//sets all variables to ready to recieve second input
				setOperator = "multiply";
				setInput1 = stringTotal;
				setInput2 = "";
				input1 = currentTotal;
				input2 = 0;

			}
			if (v == divideButton) {
				String strToAppend = divideButton.getText().toString();
				
				if (calculateType == "decimal"){
					input1 = Integer.parseInt(setInput1);
					input2 = Integer.parseInt(setInput2);
				}
				else if (calculateType == "binary"){
					input1 = Integer.parseInt(setInput1, 2);
					input2 = Integer.parseInt(setInput2, 2);
				}
				else if (calculateType == "hexadecimal"){
					input1 = Integer.parseInt(setInput1, 16);
					input2 = Integer.parseInt(setInput2, 16);
				}
				
				if (setOperator == "multiply") {
					currentTotal = input1 * input2;
					textView.append(strToAppend);
				} else if (setOperator == "divide") {
					currentTotal = input1 / input2;
				} else if (setOperator == "subtract") {
					currentTotal = input1 - input2;
				} else if (setOperator == "add") {
					currentTotal = input1 + input2;
				}
				stringTotal = Integer.toString(currentTotal);
				if (calculateType == "decimal") {
					textView.setText(stringTotal);
					textView.append(strToAppend);
				} else if (calculateType == "binary") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toBinaryString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);

				} else if (calculateType == "hexadecimal") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toHexString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);
				}
				setOperator = "divide";
				setInput1 = stringTotal;
				setInput2 = "";
				input1 = currentTotal;
				input2 = 0;

			}
			if (v == subtractButton) {
				String strToAppend = subtractButton.getText().toString();
				
				if (calculateType == "decimal"){
					input1 = Integer.parseInt(setInput1);
					input2 = Integer.parseInt(setInput2);
				}
				else if (calculateType == "binary"){
					input1 = Integer.parseInt(setInput1, 2);
					input2 = Integer.parseInt(setInput2, 2);
				}
				else if (calculateType == "hexadecimal"){
					input1 = Integer.parseInt(setInput1, 16);
					input2 = Integer.parseInt(setInput2, 16);
				}
				
				if (setOperator == "multiply") {
					currentTotal = input1 * input2;
				} else if (setOperator == "divide") {
					currentTotal = input1 / input2;
				} else if (setOperator == "subtract") {
					currentTotal = input1 - input2;
				} else if (setOperator == "add") {
					currentTotal = input1 + input2;
				}
				stringTotal = Integer.toString(currentTotal);
				if (calculateType == "decimal") {
					textView.setText(stringTotal);
					textView.append(strToAppend);
				} else if (calculateType == "binary") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toBinaryString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);

				} else if (calculateType == "hexadecimal") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toHexString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);
				}
				setOperator = "subtract";
				setInput1 = stringTotal;
				setInput2 = "";
				input1 = currentTotal;
				input2 = 0;

			}
			if (v == addButton) {
				String strToAppend = addButton.getText().toString();
				
				if (calculateType == "decimal"){
					input1 = Integer.parseInt(setInput1);
					input2 = Integer.parseInt(setInput2);
				}
				else if (calculateType == "binary"){
					input1 = Integer.parseInt(setInput1, 2);
					input2 = Integer.parseInt(setInput2, 2);
				}
				else if (calculateType == "hexadecimal"){
					input1 = Integer.parseInt(setInput1, 16);
					input2 = Integer.parseInt(setInput2, 16);
				}
				
				if (setOperator == "multiply") {
					currentTotal = input1 * input2;
				} else if (setOperator == "divide") {
					currentTotal = input1 / input2;
				} else if (setOperator == "subtract") {
					currentTotal = input1 - input2;
				} else if (setOperator == "add") {
					currentTotal = input1 + input2;
				}
				stringTotal = Integer.toString(currentTotal);
				if (calculateType == "decimal") {
					textView.setText(stringTotal);
					textView.append(strToAppend);
				} else if (calculateType == "binary") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toBinaryString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);

				} else if (calculateType == "hexadecimal") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toHexString(temp);
					textView.setText(stringTotal);
					textView.append(strToAppend);
				}
				setOperator = "add";
				setInput1 = stringTotal;
				setInput2 = "";
				input1 = currentTotal;
				input2 = 0;
				currentTotal = 0;
				stringTotal = "";

			}
			//clears text box and resets all variables to 0 or empty
			if (v == clearButton) {
				textView.setText("");
				isInput1 = true;
				currentTotal = 0;
				setInput1 = "";
				setInput2 = "";
				input1 = 0;
				input2 = 0;
			}
			//same as operators but sets isInput1 = true, that way it is ready to recieve new operator
			if (v == equalsButton) {
				if (calculateType == "decimal"){
					input1 = Integer.parseInt(setInput1);
					input2 = Integer.parseInt(setInput2);
				}
				else if (calculateType == "binary"){
					input1 = Integer.parseInt(setInput1, 2);
					input2 = Integer.parseInt(setInput2, 2);
				}
				else if (calculateType == "hexadecimal"){
					input1 = Integer.parseInt(setInput1, 16);
					input2 = Integer.parseInt(setInput2, 16);
				}
				
				if (setOperator == "multiply") {
					currentTotal = input1 * input2;
				} else if (setOperator == "divide") {
					currentTotal = input1 / input2;
				} else if (setOperator == "subtract") {
					currentTotal = input1 - input2;
				} else if (setOperator == "add") {
					currentTotal = input1 + input2;
				}
				stringTotal = Integer.toString(currentTotal);
				if (calculateType == "decimal") {
					textView.setText(stringTotal);
				} else if (calculateType == "binary") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toBinaryString(temp);
					textView.setText(stringTotal);

				} else if (calculateType == "hexadecimal") {
					int temp = Integer.parseInt(stringTotal);
					stringTotal = Integer.toHexString(temp);
					textView.setText(stringTotal);
				}

				setInput1 = stringTotal;
				setInput2 = "";
				input1 = currentTotal;
				input2 = 0;
				isInput1 = true;
			}
		}
		//checks to make sure this is the second input set, then each button appends to string value setInput2
		if (isInput1 == true) {
			if (v == aButton) {
				String strToAppend = aButton.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == bButton) {
				String strToAppend = bButton.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == cButton) {
				String strToAppend = cButton.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == dButton) {
				String strToAppend = dButton.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == eButton) {
				String strToAppend = eButton.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == fButton) {
				String strToAppend = fButton.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}

			if (v == Button0) {
				String strToAppend = Button0.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;

			}
			if (v == Button1) {
				String strToAppend = Button1.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button2) {
				String strToAppend = Button2.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button3) {
				String strToAppend = Button3.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button4) {
				String strToAppend = Button4.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button5) {
				String strToAppend = Button5.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button6) {
				String strToAppend = Button6.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button7) {
				String strToAppend = Button7.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button8) {
				String strToAppend = Button8.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			if (v == Button9) {
				String strToAppend = Button9.getText().toString();
				textView.append(strToAppend);
				setInput1 = setInput1 + strToAppend;
			}
			/*
			 * all operator buttons:
			 * gets text of button pressed
			 * based on calculator mode parses int variables to input1 or input2
			 * changes operator to current button press
			 * appends text operator to text view
			 */
			if (v == multiplyButton) {
				String strToAppend = multiplyButton.getText().toString();
				textView.append(strToAppend);
				isInput1 = false;
				setOperator = "multiply";
			}
			if (v == divideButton) {
				String strToAppend = divideButton.getText().toString();
				textView.append(strToAppend);
				isInput1 = false;
				setOperator = "divide";
			}
			if (v == subtractButton) {
				String strToAppend = subtractButton.getText().toString();
				textView.append(strToAppend);
				isInput1 = false;
				setOperator = "subtract";
			}
			if (v == addButton) {
				String strToAppend = addButton.getText().toString();
				textView.append(strToAppend);
				isInput1 = false;
				setOperator = "add";
			}
			if (v == clearButton) {
				textView.setText("");
				isInput1 = true;
				currentTotal = 0;
				setInput1 = "";
				setInput2 = "";
				input1 = 0;
				input2 = 0;

			}
			if (v == equalsButton) {
				stringTotal = textView.getText().toString();
				textView.setText(stringTotal);
				setInput1 = stringTotal;
			}
		}

	}

}