package Task4;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ZigZag {
 
 
 /*finch top speed per second is 38cm/s
  255 = 38cm/s
  */
 
 static Scanner scan = new Scanner(System.in); // this allows the user to input a value
 static Scanner newscan = new Scanner(System.in); // this allows the user to input a value
 
 
 static Finch myfinch = new Finch();
 
 static int NoOfZigzSections = 1; //This is the number of  zigzag sections
 static int ZigzSectionLength = 1; //This is the length of a zigzag section
 
 static Random speed = new Random(); // This randomly generates the range.
 static final int randomNumber =  50 + speed.nextInt(200) ; //speed range will go up to 250
 
 
 
 static final int tone1 = 1100; // the value assigned will make the finch sound
 static final int tone2 = 2500; // the value assigned will make the finch sound
 static final int finchTime = 1000;
 
 static double SpeedperSecondOfFinch = (38* randomNumber)/255;  //This will workout the speed depending on the distance per second in the units  cm/s.
 static double totalDistanceTraversed;
 static double distancefromStartToEnd;
 static double MovementOfFinchInSeconds;
 static int integerFinchMovementInSeconds;  

  public void start() throws IOException {
   
   System.out.println("WELCOME TO THE MY FINCH ZIGZAG - PROGRAM"+ "\n" + "Finch Robot Has Connected"+ "\n" + "Finch Speed: "+SpeedperSecondOfFinch + " cm/s");
   ArrayList<String> log = new ArrayList<String>(); // this is creating an array called log.
   
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" HH:mm:ss ");  // this is the format the time will get displayed back to the user
   LocalDateTime now = LocalDateTime.now();  							//This will display the start time of when the program is executed.
   System.out.println(" Start Time: " + dtf.format(now));  
   log.add("\n" + " Start Time: " + now ); // this will open and write all the i which is each value in the array log on to the text file mylog
   
   while (!((NoOfZigzSections%2==0))  || !(NoOfZigzSections <=10)){
    
    System.out.println("\n" +"Please enter the number of zigzag sections" + "\n" + "(The value entered must be an even number and not pass 10)");  
    NoOfZigzSections = scan.nextInt(); // this will scan the users input as a integer
   
    System.out.println(NoOfZigzSections); // displays the user input to the console
    log.add("\n" + " Number of Zigzag Sections is: " + NoOfZigzSections ); // this will open and write all the i which is each value in the array log on to the text file mylog

   //validation // 
    if(!((NoOfZigzSections%2==0))  || !(NoOfZigzSections <=10)){ // if statement in case the statement is not met.
    System.out.println("You have entered an invalid value of zigzag sections, please re-enter a valid value"); // this will be displayed back to the user if the user enters a invalid number
    } 
    else {
     System.out.println("Thank You"); // the system will display thank you to the user through the console
    }
   
   }
  
   while(ZigzSectionLength >80  || ZigzSectionLength <20){
    
    System.out.println("Please enter the zigzag length" + "\n" + "(the value entered must be between 20cm and 80cm)");
    ZigzSectionLength = newscan.nextInt();  // this will scan the users input as a integer
    
    System.out.println(ZigzSectionLength);// displays the user input to the console
    log.add("\n" + " Section Length is: " + ZigzSectionLength ); // this will open and write all the i which is each value in the array log on to the text file mylog
    
    if(ZigzSectionLength >80  || ZigzSectionLength <20){  // if statement in case the statement is not met.
    System.out.println("You have entered an invalid value for zigzag length, please re-enter a valid number");  // this will be displayed back to the user if the user enters a invalid number
    }
    else {
     System.out.println("Thank You");  // the system will display thank you to the user through the console
    }
   }
   
   System.out.println("Finch ZigZag Program Has Started " +"\n" + "Number of Zigzag Sections: " + NoOfZigzSections + "  Length of a Zigzag section: " + ZigzSectionLength +"cm"   
         + "\n\n" + "FINCH STATUS -" );
   
   MovementOfFinchInSeconds = ((ZigzSectionLength/SpeedperSecondOfFinch)*1000);
   integerFinchMovementInSeconds = (int) Math.round(MovementOfFinchInSeconds); // round the value up.
   
   
   for(int i = 0; i < (NoOfZigzSections/2); i++){ //This is a for loop that will execute let the finch move in a zigzag forwards.
    
    myfinch.setLED(0, 255, 0);// finch led is set to green
    System.out.println("Setting Finch LED green");  // this is a message which will get displayed back to the user, as step of what the finch is doing  
    myfinch.buzz(tone1, integerFinchMovementInSeconds);//Finch plays tone 1
    System.out.println("Finch Plays Tone 1");  //this is a message which will get displayed back to the user, as step of what the finch is doing
    myfinch.setWheelVelocities(randomNumber,randomNumber, integerFinchMovementInSeconds); // The speed the finch will move at this speed
    System.out.println("Finch Moves to the Right");   //this is a message which will get displayed back to the user, as step of what the finch is doing
    
    
    myfinch.sleep(finchTime);//delay finch
    
    myfinch.setLED(0, 0,0);// finch led is reset
    System.out.println("reset Finch LED "); //this is a message which will get displayed back to the user, as step of what the finch is doing
    myfinch.setWheelVelocities(-100, 150, finchTime);// this line is where the finch will rotate
    System.out.println("Finch Rotates orthogonal"); //this is a message which will get displayed back to the user, as step of what the finch is doing
   
    myfinch.setLED(255, 0,0);// finch sets led to red
    System.out.println("Setting Finch LED red"); // this is a message which will get displayed back to the user, as step of what the finch is doing
    myfinch.buzz(tone2, integerFinchMovementInSeconds );//Finch plays tone 2
    System.out.println("Finch Plays tone 2");// this is a message which will get displayed back to the user, as step of what the finch is doing
    myfinch.setWheelVelocities(randomNumber, randomNumber, integerFinchMovementInSeconds);// The speed the finch will move at this speed
    System.out.println("Finch Moves to the Left"); // this is a message which will get displayed back to the user, as step of what the finch is doing
    
    
    myfinch.sleep(finchTime);// delay finch
    
    if (i!= (NoOfZigzSections/2) -1) { // this if statement is in place to avoid the finch from doing and extra rotation.
     myfinch.setLED(0, 0,0);// finch led is reset
     System.out.println("reset Finch LED "); // this is a message which will get displayed back to the user, as step of what the finch is doing
     myfinch.setWheelVelocities(150, -100, finchTime);// this line is where the finch will rotate
     System.out.println("Finch Rotates orthogonal"); // this is a message which will get displayed back to the user, as step of what the finch is doing
    }
   
    }
   
   myfinch.sleep(4000);// delay finch
   System.out.println("\n" + "Retrace Begins"); // this is a message which will get displayed back to the user, as step of what the finch is doing
   myfinch.setWheelVelocities(250, 0, finchTime);// finch will turn around 180 degrees.
   System.out.println("Finch turns around 180 degrees"); // this is a message which will get displayed back to the user, as step of what the finch is doing
   
   
   
   for(int i =(NoOfZigzSections/2) -1 ; i >=0 ; i--){ // //This  for loop that will execute the code in which it will remove one zigzag section each time, working opposite to the first loop.
     
   myfinch.setLED(255,0,0);// finch sets led to red
   System.out.println("Setting Finch LED red");// this is a message which will get displayed back to the user, as step of what the finch is doing
   myfinch.buzz(tone2, integerFinchMovementInSeconds );//finch will playing tone 2
   System.out.println("Finch Plays tone 2");// this is a message which will get displayed back to the user, as step of what the finch is doing
   myfinch.setWheelVelocities(randomNumber, randomNumber, integerFinchMovementInSeconds);// The speed the finch will move at this speed
   System.out.println("Finch Moves Back Right"); // this is a message which will get displayed back to the user, as step of what the finch is doing
     
   
   myfinch.sleep(finchTime);//delay finch
     
   myfinch.setLED(0, 0,0);// Finch led is reset
   System.out.println("reset Finch LED ");   // this is a message which will get displayed back to the user, as step of what the finch is doing
   myfinch.setWheelVelocities(150, -100, finchTime);// this line is where the finch will rotate
   System.out.println("Finch Rotating orthogonal"); // this is a message which will get displayed back to the user, as step of what the finch is doing
   
   
   myfinch.setLED(0, 255, 0);// finch led is set to green
   System.out.println("Setting Finch LED green"); // this is a message which will get displayed back to the user, as step of what the finch is doing   
   myfinch.buzz(tone1, integerFinchMovementInSeconds );//finch will playing tone 1 
   System.out.println("Finch Plays tone 1");  // this is a message which will get displayed back to the user, as step of what the finch is doing
   myfinch.setWheelVelocities(randomNumber, randomNumber, integerFinchMovementInSeconds);// The speed the finch will move at this speed
   System.out.println("Finch Moves Back Left"); // this is a message which will get displayed back to the user, as step of what the finch is doing
     
     
   myfinch.sleep(finchTime);// delay finch
     
   myfinch.setLED(0, 0,0);// reset of the finch is reset
   System.out.println("reset Finch LED "); // this is a message which will get displayed back to the user, as step of what the finch is doing
   myfinch.setWheelVelocities(-100, 150, finchTime);// this line is where the finch will rotate
   System.out.println("Finch Rotating orthogonal"); // this is a message which will get displayed back to the user, as step of what the finch is doing
     
   }
    
   
   DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(" HH:mm:ss ");  
   LocalDateTime now1 = LocalDateTime.now();  								// This will display the end time of the program
   System.out.println(" End Time: " + dtf1.format(now1));  
   log.add("\n" + " End Time: " + now ); // this will open and write all the i which is each value in the array log on to the text file mylog
   
      myfinch.quit(); // the finch will stop
      
      System.out.println("\n" + "Finch ZigZag Program Has Finished" +"\n" + "Number of Zigzag Sections: " + NoOfZigzSections + "\n" + "Length of a section: " + ZigzSectionLength +"cm" ); //this is an output that gets displayed on the console.
     
      totalDistanceTraversed = (NoOfZigzSections*ZigzSectionLength); //this is a calculation used to work out the total distance the finch has travelled.
      System.out.println("Total Length Finch has Travelled: " + totalDistanceTraversed + "cm" ); //this is an output that gets displayed on the console.
      log.add("\n" + " Total Length Finch has travelled: " + totalDistanceTraversed + " cm " ); //the log array is called and this value is add and stored into the array.

      
      distancefromStartToEnd = ((NoOfZigzSections/2)*1.414*ZigzSectionLength); //this is the calculation used to work out the distance from start to end in a straight line.
      System.out.println("Distance From Start point to End point: " + distancefromStartToEnd + "cm" ); //this is an output that gets displayed on the console.
      log.add("\n" + " Distance between Start point to End point: " + distancefromStartToEnd + " cm " ); //the log array is called and this value is add and stored into the array.

      
      System.out.println("\n" + "THANK YOU FOR USING MY FINCH ZIGZAG PROGRAM "); // this message will be displayed back to the user through the console.
      
      
      System.out.println("The log is " + log.size()); // this is an output that gets displayed on the console.
      
      FileWriter writer = new FileWriter("H:\\Desktop\\ZigZag\\src\\mylog.txt", false); // this is where the array list log, will get create a text file in the location give and call it mylog.
      for (int i=0 ;i<log.size( ); i++ ){ // This log will look for all the place log gets called for.
       System.out.println(log.get( i )); 
       writer.write(log.get( i )); // this will open and write all the i which is each value in the array log on to the text file mylog
       
      }
      writer.close( ); //This will close the text file.
      
      
      
   System.exit(0); // The whole program is stopped.
   }
  
    
 }
