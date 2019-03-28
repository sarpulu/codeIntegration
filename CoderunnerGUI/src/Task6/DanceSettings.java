package Task6;

import java.util.ArrayList;

import java.util.Collections;
// class for settings
public class DanceSettings {
	int redvalue;
	int greenval;
	int blueval;
	int speed;
	ArrayList<Integer> danceMoves;
	int initDecimal; 
	int initOctal;
	ArrayList<Integer> initBinary; 
	String hexno;
	
	public DanceSettings(int decimal, int octal, ArrayList<Integer> binary, String hex) {
	     	
		initDecimal = decimal; 
		initOctal = octal; 
		initBinary = binary;
		redvalue = decimal;
		greenval = ((decimal%80)+60);
		blueval = ((decimal+greenval)/2);
		hexno = hex;
		
		if (octal>255) {
			speed=255;
		}
		else if (octal<60) {
			speed=octal+30;
		}
		else {
			speed=octal;
		}
		
		danceMoves = binary;
	}
	
	/*public void printLedSettings() {
		System.out.println("blueval is "+ this.blueval);
		System.out.println("greenval is "+ this.greenval);
		System.out.println("decimal is "+ this.redvalue);
	}
	*/

	/*public void printDanceMoves() {
		System.out.println(this.danceMoves);
	} 
	*/
	/*public void printSpeed() {
		System.out.println("Speed is "+ speed);
	}
	*/
	public int getRedValue() {
		return redvalue;
	}
	
	public int getBlueValue() {
		return blueval;
	}
	
	public int getGreenValue() {
		return greenval;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public ArrayList<Integer> getDanceMoves() {
		return danceMoves;
	}
	
	public String getDanceMovesAsString() {
		String binarystring = "";
		for(int i=danceMoves.size()-1;i>=0;i--)  
	      {  
	       binarystring += String.valueOf(danceMoves.get(i));     
	      }  
		
		//int binary= Integer.valueOf(binarystring);
		//System.out.println("Binary is "+binary);
		return binarystring;
	}
}
