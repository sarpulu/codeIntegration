package Task6;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import Task6.DanceSettings;
import Task6.HexConverter;
import Task6.danceFinish;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

/**
* Created by:
* Date:
* A starter file to use the Finch
*/

public class task6 
{
public void start(String hexno) {
	
		Finch Dancer = new Finch();	
		/*System.out.println("Enter hex");
		Scanner scanner = new Scanner(System.in);
		String userinput = scanner.next();
		
		System.out.println("hexadecimal is "+ userinput);
		*/
		
		ArrayList<String> hexLog=new ArrayList<String>();
		hexLog.add(hexno);
		//user input storage
		
		int decimal = HexConverter.fromHextoInt(hexno);
		int octal = HexConverter.fromDecimalToOctal(decimal); 
		ArrayList<Integer> binarylist = HexConverter.fromDecimalToBinary(decimal);
		DanceSettings settings = new DanceSettings(decimal, octal, binarylist, hexno);
		
		//settings.printLedSettings();
		//settings.printSpeed();
		//settings.printDanceMoves();
		System.out.println(settings.getDanceMovesAsString());
		
		Dancer.setLED(settings.getRedValue(), 
				settings.getGreenValue(), 
				settings.getBlueValue());
		
		ArrayList<Integer> moves = settings.getDanceMoves();
		
		for(int i=0 ;i<moves.size();i++)  
	    {   int elem = moves.get(i);
			System.out.println(elem);
	    	if (elem==0) {
				Dancer.setWheelVelocities(-settings.getSpeed(), -settings.getSpeed(),1000);
			}
			else {		
				Dancer.setWheelVelocities(settings.getSpeed(), settings.getSpeed(), 1000);
			}
	    }
		//textgen(hexLog);
		Dancer.setLED(0,0,0);
	} 
}
/*public void textgen(ArrayList<String> hexLog) { 
BufferedWriter bw = null;
  try {
 
     //Specify the file name and path here
 File file = new File("c:\\temp\\file.txt");

 /* This logic will make sure that the file 
  * gets created if it is not present at the
  * specified location
  if (!file.exists()) {
     file.createNewFile();
  }

  FileWriter fw = new FileWriter(file);
  bw = new BufferedWriter(fw);
  for(int i=0;i<hexLog.size();++i)
   {
      String line = hexLog.get(i);
      bw.write(line);
      bw.newLine();
   }

      System.out.println("File written Successfully");

  } catch (IOException ioe) {
   ioe.printStackTrace();
}
finally
{ 
   try{
      if(bw!=null)
	 bw.close();
   }catch(Exception ex){
       System.out.println("Error in closing the BufferedWriter"+ex);
    }
}
}*/

