package Task6;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Stack;

public class HexConverter {
	
	public static int fromHextoInt(String hex) {
		int x = fromHexCharToInt(hex.charAt(0));
		int y = fromHexCharToInt(hex.charAt(1));
		 		
		//conversion into decimal
		
		int decimal = x*16+y;
		
		return decimal;
	}
	
	private static int fromHexCharToInt(char charInput) {
		int result;
		if (charInput == 'A' || charInput=='a') {
			result = 10;
		}
		else if (charInput == 'B' || charInput=='b') {
			result = 11;
		}
		else if (charInput == 'C' || charInput=='c') {
			result = 12;
		}
		else if (charInput == 'D' || charInput=='d') {
			result = 13;
		}
		else if (charInput == 'E' || charInput=='e') {
			result = 14;
		}
		else if (charInput == 'F' || charInput=='f') {
			result = 15;
		}
		else {
			result = Character.getNumericValue(charInput);
		}
		return result;
	}

	public static int fromDecimalToOctal(int decimal) {	
		int oquotient= decimal;
		int oremainder;
		Stack<Integer> octallist = new Stack<Integer>();
		
		while(oquotient>0) {
			oremainder=oquotient%8;
			octallist.push(oremainder);
			oquotient=oquotient/8;
		}
		  	
		String octalstring = "";
		while (!octallist.isEmpty()) {  
	       octalstring += octallist.pop();     
	    }  
		
		int octal=Integer.valueOf(octalstring);
		// testing...
		return octal;
	}

	public static ArrayList<Integer> fromDecimalToBinary(int decimal) {
		//binary
				int bquotient= decimal;
				int bremainder;
				ArrayList<Integer> binarylist =new ArrayList<Integer>();
				
				while(bquotient>0) {
					bremainder=bquotient%2;
					binarylist.add(bremainder);
					bquotient=bquotient/2;
					
				}
				  
				//Collections.reverse(binarylist);
				return binarylist;
	}
}
