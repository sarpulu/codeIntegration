package Task3;
import java.util.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.time.*;
//import java.io.FileNotFoundException;
import java.io.*;
import java.text.SimpleDateFormat;
public class navigate {
    
public void start() throws IOException //This method can throw certain exceptions depending on what has been inputted by the user. 
{
Finch MoveFinch = new Finch(); //Representing the finch as an instance
Scanner userinput = new Scanner(System.in); //Getting input for the user 
boolean shouldTerminate = false; //Name of the main program. I have declared it as false so that it continously run. 
ArrayList<Integer> speedduration = new ArrayList<Integer>();//Creating an arraylist for the speed and duration for the finch
ArrayList<String> commands = new ArrayList<String>(); //Creating an arraylist for all commands inputted. 
ArrayList<String> log = new ArrayList<String>(); //Creating an arraylist to store everything inside a log. 
while (!shouldTerminate) {
System.out.println("Enter the command"); //Declaring the input 'choice' as a command and then waits for the input to be entered
char command = userinput.next().charAt(0); //This will return the first character of the string 

int a = 0; int b = 0;
switch (command) { //This is the switch statement which will then show all of the possible executions 
case 'Q': 
shouldTerminate = true;
break;
    case 'F': 
    case 'B':
    case 'R':
    case 'L':
    while (true)
    {
System.out.println("Enter duration: "); //Displays message for user to enter the duration 
b = userinput.nextInt(); //User enters the duration 
if (b>0 && b<7)
{
break;
}
else
{
System.out.println("Incorrect duration entered");
continue;
}
   
    }
while (true)
{
System.out.println("Enter speed from 0 to 200"); //Displays message for user to enter the speed
a = userinput.nextInt(); //user enters the speed
 
if (a>1 && a<201)
{
break;
}
else
{
System.out.println("Incorrect speed entered");
continue;
}
}
   
executeCommand(MoveFinch, command, a, b);
commands.add(Character.toString(command));
speedduration.add(b);
speedduration.add(a);
log.add("The command is: " + command + " duration is " + b + " the speed is " + a);
break; //Ends the 1st possible execution
   
    case 'W': 
   
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    System.out.println(sdf.format(date));
    log.add("The date is " + sdf.format(date));
   
    FileWriter writer = new FileWriter("mylog.txt", false);
for (int i=0;i<log.size(); i++) {
System.out.println(log.get(i));
writer.write(log.get(0));
}
writer.close();
    break;
    
    case 'T':
    System.out.println(commands.size());
    System.out.println("Enter the number of commands to be repeated:");
    int repetition = userinput.nextInt();
    while (repetition>commands.size()) {
    System.out.println("Wrong. Enter the number of commands to be repeated. "
    + "Should be less than " + commands.size());
    repetition = userinput.nextInt(); 
    }
    int len = commands.size();
    int count = 1; 
    int countSpeedDuration = 1; 
    log.add("We are repeating " + repetition + " commands");
   
    while (repetition>0) {
    char c = commands.get(len - count).charAt(0); 
    int speed = speedduration.get(2*len - countSpeedDuration);
    int duration = speedduration.get(2*len - countSpeedDuration -1);
    System.out.println("The command is " + c);
    System.out.println("The speed is " + speed);
    System.out.println("The duration is " + duration);
    executeCommand(MoveFinch, c, speed, duration);
    repetition --; 
    count++;
    countSpeedDuration = countSpeedDuration +2;
    System.out.println("One command done");
    }
    break;
    default:
    System.out.println("Incorrect command enter please try again");
System.out.println("");
continue;
}
}
}
public static void executeCommand(Finch MoveFinch, char command, int speed, int duration) { 
int a = speed;
int b = duration; 
switch (command) { //This is the switch statement which will then show all of the possible executions 
    case 'F': //1st possible execution 
    MoveFinch.setLED(200, 0, 0);
    MoveFinch.setWheelVelocities(a, a, b*1000); //Sets the finch's left wheel and right wheel of the speed and b which is the duration of the movement of the finch.
    MoveFinch.setLED(0, 0, 0);
break; //Ends the 1st possible execution 
    case 'B':
    MoveFinch.setLED(0, 200, 0);
    MoveFinch.setWheelVelocities(-a, -a, b*1000);
    MoveFinch.setLED(0, 0, 0);
            break;
    case 'R':
    MoveFinch.setLED(0, 0, 200);
    MoveFinch.setWheelVelocities(150,-200,550);
MoveFinch.setWheelVelocities(a, a, b*1000);
MoveFinch.setLED(0, 0, 0);
break;    
    
    case 'L':
    MoveFinch.setLED(100, 100, 100);
    MoveFinch.setWheelVelocities(-200,150,550);
        MoveFinch.setWheelVelocities(a, a, b*1000);
MoveFinch.setLED(0, 0, 0);
break;
default:
char c;
System.out.println(" Invalid Command Retry");
}
}
} 

	
	

