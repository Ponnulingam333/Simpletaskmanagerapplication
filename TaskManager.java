package taskmanagerapplication.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TaskManager {
        int id;
        String title;
        String description;
        String priority;
        String status;
        Scanner scan =new Scanner(System.in);   
        BufferedReader buf =new BufferedReader(new InputStreamReader(System.in));
public void add_task() {
	try {  TaskDAO tskdao =new TaskDAO();
	TaskManager tskclass =new TaskManager();
	 System.out.println("Enter task title:");
	  tskclass.title =scan.nextLine();
	  System.out.println("Enter task description:");
	  tskclass.description =scan.nextLine(); 
	  outerloop:
	  while(true) { 
	  System.out.println("Enter task priority (High/Medium/Low):");
	  priority =scan.next();
	  if(priority.equalsIgnoreCase("High")|priority.equalsIgnoreCase("Medium")|priority.equalsIgnoreCase("Low")) {
		  tskclass.priority=priority;
	  }
	  else {
		  System.out.println("Invalid priority.Please enter a correct priority");
		  System.out.println("Press 7 to continue or Press 6 to exit ");
		  int useropt =scan.nextInt();
		if (useropt==7) {
			continue outerloop;
		}
		else {
			break outerloop;
		}
	  }
	  innerloop:
	  while(true) {
	  System.out.println("Enter task status (Pending/In Progress/Completed):");
	status =buf.readLine();
	  if(status.equalsIgnoreCase("Pending")|status.equalsIgnoreCase("In progress")|status.equalsIgnoreCase("Completed")) {
		  tskclass.status=status;
		  break innerloop;
	  }
	  else {
		  System.out.println("Invalid status.Please enter a correct status");
			  System.out.println("Press 7 to continue or Press 6 to exit ");
			  int useropt =scan.nextInt();
			if (useropt==7) {
				continue innerloop;
			}
			else {
				break innerloop;
			}
	  }}
	tskdao.addtask(tskclass);
	break;}}
	catch(IOException i) {
		System.out.println("Please enter the valid values");
	}
  }

  public void edit_task(){
	 try { while(true){
		 TaskDAO tskdao =new TaskDAO();
	  TaskManager tskclass =new TaskManager();
	  System.out.println("Enter your task ID to edit:");
	  tskclass.id = scan.nextInt();
	  if(tskdao.istrue(tskclass.id)){
      System.out.println("Enter new title(leave blank to keep existing):");
	  tskclass.title =buf.readLine();
	  if(!(tskclass.title.equals(" ")||tskclass.title.isEmpty())) {
		  tskdao.edittasktitle(tskclass.title,tskclass.id);}
	 
	  System.out.println("Enter new description(leave blank to keep existing):");
       tskclass.description = buf.readLine();
      if (!(tskclass.description.equals(" ")||tskclass.description.isEmpty())) {
		  tskdao.edittaskdescription(tskclass.description,tskclass.id);}
	  
	  System.out.println("Enter new priority (leave blank to keep existing):");
	  tskclass.priority = buf.readLine();
      if (!(tskclass.priority.equals(" ")||tskclass.priority.isEmpty())) {
		  tskdao.edittaskpriority(tskclass.priority,tskclass.id);}
  
     System.out.println("Enter task status (leave blank to keep existing):");
     tskclass.status = buf.readLine();
     if (!(tskclass.status.equals(" ")||tskclass.status.isEmpty())) {
		  tskdao.edittaskstatus(tskclass.status,tskclass.id);}
     break;
     }
	  else {
	 System.out.println("Invalid task ID.Please enter a correct valid ID");
		  System.out.println("Press 7 to continue Press 6 to exit");
		  int useropt =scan.nextInt();
		  if(useropt==7) {
			  continue;
		  }
		  else if(useropt==6) {
			  break;
		  }
	  }}}
	 catch(IOException |InputMismatchException i) {
		 System.out.println("Invalid task ID.Please enter correct valid ID");
		 }
	 }
     public void delete_task() {
        	 TaskDAO tskdao =new TaskDAO();
        	System.out.println("Enter your task ID to delete");
        	id =scan.nextInt();	
          if(tskdao.istrue(id)){
        	 tskdao.deletetask(id);}
          else {
        	  System.out.println("Invalid task ID.Please enter a correct valid ID");
          }
        }
  
}
