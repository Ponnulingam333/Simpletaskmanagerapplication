package taskmanagerapplication.com;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TaskManagerApplication {
public static void main(String args[]) {
	Scanner scan =new Scanner(System.in);
	int useropt;
	Taskopt topt =new Taskopt();
          while(true) 
try{
		topt.showtask();
		System.out.println("Enter your choice (1-6)");
		useropt =scan.nextInt();
		if(useropt==6) {
			System.out.println("Thank you");
			break;}
		topt.inputs(useropt);
}
catch(InputMismatchException i) {
                 scan.nextLine();
			System.out.println("Invalid choice. Please enter a number from 1 to 6");
                        System.out.println("Press enter to continue");
                      scan.nextLine();
			} 
}
		
	scan.close();
	
}
}
