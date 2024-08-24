package taskmanagerapplication.com;
import java.util.Scanner;
public class Taskopt {
   Scanner scan =new Scanner(System.in);
public void showtask() {
	   System.out.println("1. Add Task \n2. Edit Task \n3. Delete Task \n4. View All Tasks \n5. Filter Tasks by Priority \n6. Exit");
 }
   public void inputs(int i)  {
	outerloop:
	   while(true) {
		 TaskManager tskcls =new TaskManager();
	   if(i==1) {
		 tskcls.add_task();
		   break;}
	  else if(i==2) {
		   tskcls.edit_task();
		   break;}
	   else if(i==3) {
		   tskcls.delete_task();
		   break;
	   }
	   else if(i==4) {
		  TaskDAO tskdao =new TaskDAO();
		   tskdao.viewalltasks();
		   break;
	   }
	   else if(i==5) {
			  TaskDAO tskdao =new TaskDAO();
	  innerloop:
			  while(true) { 
				  System.out.println("Enter priority to filter tasks (High/Medium/Low): ");
		  String priority =scan.next();
			  if(priority.equalsIgnoreCase("High")|priority.equalsIgnoreCase("Medium")|priority.equalsIgnoreCase("Low")) {
				  tskdao.FilterTaskByPriority(priority);
				   break outerloop;}
			  else {
				  System.out.println("Invalid priority.Please enter a correct priority");
				  System.out.println("Press 7 to continue or Press 6 to exit ");
				  int useropt =scan.nextInt();
				  if(useropt==7) {
					  continue innerloop;
				  }
				  else if(useropt==6) {
					  break outerloop; 
				  }
				  break;} 
			  }}
	   else if(i==6) {
		   break;
	   }
	   else {
		   System.err.println("Enter the correct values!!!");
		   break;}
	 }
   }}
   
	   
   
