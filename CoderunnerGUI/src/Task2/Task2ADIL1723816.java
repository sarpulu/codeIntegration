package Task2;
//importing the array list, the scanner and the finch
import java.util.ArrayList;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

// Needs a package declaration to move to another folder





/**
 * Created by:Adil
 * Date:8/03/2019
 * A starter file to use the Finch
 */
//where i store my code for the whole task
public class Task2ADIL1723816
   {
	static ArrayList<String> RectangleList = new ArrayList<String>();//creating both array lists for rectangle and triangle
	static ArrayList<String> TriangleList = new ArrayList<String>();
	static int TriangleCount = 0;//setting the shape counts to 0
	static int RectangleCount = 0;	
	static int LargestTArea = 0;//setting largest triangle and rectangle areas to 0
	static int LargestRArea = 0;
	// Instantiating the Finch object
    static Finch myFinch = new Finch();
    static Scanner draw = new Scanner(System.in);//importing the scanner
   public void start()//main method
      {
      if(myFinch.isFinchLevel()==true) {//checks if the finch is level and if not the code won't start
      System.out.println("Enter the shape you want to draw (R for rectangle)(T for triangle)(Q to quit)");
      // Write some code here!
    
      String s = draw.next();
      switch (s) {//creating a case where the input s is assessed
      case ("R"):
    	  Rectangle();//if case is r then rectangle method is applied
      
      
    		
      case ("T"):
    	  Triangle();//if case is T then triangle method is applied
      TriangleCount++; 	 
      
      case ("Q")://if case is Q then Quit method is applied
          Quit();
      default:
    	  start();
     
      }
      }    
       } 

private void Triangle() {//method for all the methods to do with the triangle
	 System.out.println("Enter the length of the first Side (int between 20 and 80) Follow the rule (s(x) + s(y) > s(z)) s= side");
	 CheckInt ();//goes to the method to check if the input is an integer
	 int ta = draw.nextInt(); //gets user input
	 while((ta>=81||ta<=19)) {
		 System.out.println("Re-Enter the length of the First Side (int between 20 and 80) Follow the rule (s(x) + s(y) > s(z)) s= side");
		 errorLed();
		 ta = draw.nextInt(); //gets user input
	 }
	  System.out.println("Enter the length of the second Side (int between 20 and 80) Follow the rule (s(x) + s(y) > s(z)) s= side");
	  CheckInt ();    
	  int tb = draw.nextInt();
	  while((tb>=81||tb<=19)) {
			 System.out.println("Re-Enter the length of the Second Side (int between 20 and 80) Follow the rule (s(x) + s(y) > s(z)) s= side");
			 errorLed();
			 tb = draw.nextInt(); //gets user input
		 }
	  System.out.println("Enter the length of the third Side (int between 20 and 80) Follow the rule (s(x) + s(y) > s(z)) s= side");
	  CheckInt ();
	  int tc = draw.nextInt();
	  while((tc>=81||tc<=19)) {
			 System.out.println("Re-Enter the length of the Third Side (int between 20 and 80) Follow the rule (s(x) + s(y) > s(z)) s= side");
			 errorLed();
			 tc = draw.nextInt(); //gets user input
		 }
     while ((ta+tb)<tc||(tb+tc)<ta||(tc+ta)<tb) {//verifies if triangle is possible to draw given lengths inputted
    	 errorLed();
   	  System.out.println("Rules were not followed Now re Enter the length of all the Sides (int between 20 and 80) Follow the rule (s(x) + s(y) > s(z)) s= side ");
   	 Triangle();//asks the user to input lengths again
     }
     
     
     double angleta = (int) (Math.acos(((Math.pow(tb, 2))+(Math.pow(tc, 2))-(Math.pow(ta, 2)))/(2*tb*tc))*(180/Math.PI));//calculates angles 
     double angletb = (int) (Math.acos(((Math.pow(ta, 2))+(Math.pow(tc, 2))-(Math.pow(tb, 2)))/(2*ta*tc))*(180/Math.PI));
     double angletc = (int) (Math.acos(((Math.pow(ta, 2))+(Math.pow(tb, 2))-(Math.pow(tc, 2)))/(2*ta*tb))*(180/Math.PI));
     
     System.out.println("angle A ="+ angleta);
     System.out.println("angle B ="+ angletb);
     System.out.println("angle C ="+ angletc);
     
     myFinch.setWheelVelocities(255, 255, ta*(1000/30));
     myFinch.setWheelVelocities(-100, 100, (int)  (-(angletc*(7))+1252));//turns the finch at the angle given anticlockwise and goes forward
     myFinch.setWheelVelocities(255, 255, tb*(1000/30));
     myFinch.setWheelVelocities(-100, 100,(int) (-(angleta*(7))+1252));
     myFinch.setWheelVelocities(255, 255, tc*(1000/30));
     myFinch.buzz(4500, 1000);
    
     TriangleCount++;
     TriangleList.add("Triangle"+" "+ta+" "+tb+" "+tc+" "+angleta+"� "+angletb+"� "+angletc+"�");//adds data of user input to an array
     double TArea = (0.5*ta*tb*(Math.sin(tc)));//calulates area of the triangle
	// TODO Auto-generated method stub
     if(TArea>LargestTArea) {
     LargestTArea=(int) TArea;
     }
	start();//returns to main method
}
private static void CheckInt() {//checks if user input is an integer
	
	while (!draw.hasNextInt()) //user input is not an int
	{   
		errorLed();
	    draw.next(); // Read and discard offending non-int input
	    System.out.print("Please enter an integer: "); //tells them to ask again
	}
}


	


private static void errorLed() {
	// makes led go red when error occurs with user input
	myFinch.setLED(255,0,0,2000);
}

private void Rectangle() {
	System.out.println("Enter the width of the rectangle ( Int between 20 and 80)" );
	CheckInt ();
	int wr = draw.nextInt();
    while (wr>=81||wr<=19) {
    	errorLed();
  	  System.out.println("Re-Enter the width of the rectangle ( Int between 20 and 80)");
  	CheckInt ();
  	   wr = draw.nextInt();
    }
  	  System.out.println("Enter the height of the rectangle ( Int between 20 and 80)");
  	CheckInt ();
    int hr = draw.nextInt();
    while (hr>=81||hr<=19) {
    	errorLed();
  	  System.out.println("Re-Enter the height of the rectangle ( Int between 20 and 80)");
  	CheckInt ();
  	  hr = draw.nextInt();
    }
  		myFinch.setWheelVelocities(255, 255, wr*(1000/30));//moving the wheels forward at the finch (time for 1 cm) multiplied by the length
  		myFinch.setWheelVelocities(-100, 100, 626);//626 is the angle of 90 degrees and the finch turns left
  	    myFinch.setWheelVelocities(255, 255, hr*(1000/30));
  	    myFinch.setWheelVelocities(-100, 100, 626);
  	    myFinch.setWheelVelocities(255, 255, wr*(1000/30));
  	    myFinch.setWheelVelocities(-100, 100, 626);
  	    myFinch.setWheelVelocities(255, 255, hr*(1000/30));
  	    myFinch.buzz(4500, 1000);//finch beeps after completing the drawing
	// TODO Auto-generated method stub
  	   int RArea= (wr*hr);
  	 RectangleCount++;
  	RectangleList.add("Rectangle"+" "+wr+" "+hr+" "+"90�"+" "+"90�"+" "+"90�"+" "+"90�");
  	if(RArea>LargestRArea) {
  	     LargestRArea=(int) RArea;//Largest area is replaced with next area
  	     }
	start();
}
private static void Quit() {
	System.out.println("["+TriangleList+"]");//prints array for triangles
	System.out.println("");
	System.out.println("["+RectangleList+"]");//prints array for rectangles
	System.out.println("");
	if (TriangleCount>RectangleCount) {
		System.out.println("Triangle was the most drawn shape and the amount it was drawn ="+(TriangleCount));
		
	}
	else if (RectangleCount==TriangleCount) {
		System.out.println("The Rectangle and Triangle were drawn an equal amount ="+(RectangleCount));
	}	
	else if (TriangleCount<RectangleCount){ System.out.println("Rectangle was the most drawn shape and the amount it was drawn ="+(RectangleCount));
	
		
	}
	if(LargestTArea>LargestRArea) {
		System.out.println("The Largest Shape is a Triangle with an area of"+" "+LargestTArea+"cm^2");
	}
	else if(LargestTArea<LargestRArea) {
		System.out.println("The Largest Shape is a Rectangle with an area of"+" "+LargestRArea+"cm^2");
	}
	else {
		System.out.println("Rectangle ad Triangle Share the largest Area of"+" "+LargestRArea+"cm^2");
	}
	myFinch.quit();//finch stops
	System.exit(0);
	// TODO Auto-generated method stub
	
}
   }
