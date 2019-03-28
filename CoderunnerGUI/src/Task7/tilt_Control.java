package Task7;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class tilt_Control {
static int inerval;
static Timer timer;
static Finch myFinch = new Finch();
private static Scanner uinput;

	public void start() throws InterruptedException {
	uinput = new Scanner (System.in); 
	int a;
	
	System.out.println("Enter how long..: ");
	a = uinput.nextInt(); //asks user for input

	while (!(a>0 && a <21)) { //asks if value input if between 1-20secs
		System.out.print("Invalid entry, enter between 1-20 seconds: ");
		a = uinput.nextInt(); //asks user to re-input if invalid
	}
	
	ArrayList<String> commands = recording(a); //calling method for recording
	
	Thread.sleep(2000); //finch waits 2secs for user to put down
	Random rand = new Random(); //generates random number for speed
	int speed = rand.nextInt(255); //uses random number and makes sure it doesn't exceed 255
	
	
	for (int i=0; i<commands.size();i++) { //
		executeCommand(commands.get(i), speed); //calling method for execution
		Thread.sleep(500); //waits 500milliseconds in-between movement
		
	}
	myFinch.buzz(500, 500);
	myFinch.sleep(500);
	myFinch.buzz(500, 500);
	System.out.println(commands); //outputs commands at the end
	}
	{
	myFinch.setLED(0, 0, 0);
	myFinch.quit();
	System.exit(0);

}
	
	public static ArrayList<String> recording(int allowedTime) throws InterruptedException {
		
		long startTime = System.currentTimeMillis();
		long totalTime = 0;
		ArrayList<String> commands = new ArrayList<String>(); //creates new array
		myFinch.setLED(Color.RED); //sets led red whilst recording
		
		while (totalTime < allowedTime) { //doesnt let allowed time exceed total
		System.out.println(totalTime); //outputs total ime
	   
		boolean beakup = myFinch.isBeakUp(); 
		if (beakup == true) {
			commands.add("F"); //adds command to list
		}
		boolean beakdown = myFinch.isBeakDown(); 
		if (beakdown == true) {
			commands.add("B");
		}
		
		if (myFinch.isFinchLevel() == true) {
			commands.add("S");
		}
		
		if (myFinch.isRightWingDown() == true) {
			commands.add("R");
		}
		
		if (myFinch.isLeftWingDown() == true) {
			commands.add("L");
		}
		totalTime = ((System.currentTimeMillis() - startTime)/1000); //divides time to display in seconds
		Thread.sleep(500); //sleeps inbetween recordings
		}
		myFinch.setLED(0, 0, 0); //sets led to nothing after recording
		myFinch.buzz(500, 500); //requirement for finch to buzz when recording finished
		return commands;
	}
	
	public static void executeCommand(String command, int speed) {
		myFinch.setLED(Color.GREEN); //sets led green while recording
		switch(command) {
			case "F": 
				myFinch.setWheelVelocities(speed, speed, 500); //sets finch wheels to move forward
				break;
			case "B": 
				myFinch.setWheelVelocities((-1)*speed, speed*(-1), 500); //sets finch wheel to move back
				break;
			case "R": 
				myFinch.setWheelVelocities(speed, 0, 500); //moves right
				break;
			case "L": 
				myFinch.setWheelVelocities(0, speed, 500); //moves left
				break;
			case "S": 
				myFinch.setWheelVelocities(0, 0, 0); //stops finch
				break;
		}
	}
	
}
