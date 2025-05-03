/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2algorithms;
import java.util.*;
import java.util.Calendar;

/**
 *
 * @author ponye
 */
public class CA2Algorithms {
    
    enum Menu {
            CREATE_DEPARMENT,
            ADD_EMPLOYEES,
            SEARCH,
            SORT,
            GENERATE_DUMMY_DATA,
            REMOVE,
            EXIT
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Manager mgr = new Manager("Laura",122,calendar);
        Employee emp1 = new Employee("Oscar",122,calendar);
        Deparment dept = new Deparment("Finances");
        Deparment dept1 = new Deparment("Specialized Unit");
        Deparment dept2 = new Deparment("Human Rseources");
        String option;
        int choice=0;
         Scanner scanner = new Scanner(System.in);
        

        do{
            for (Menu menu1 : Menu.values()) {
                System.out.println((menu1.ordinal()+ 1)+" "+ menu1.toString() );
            }
            
            // Get user input
            System.out.print("Enter an option (1-" + Menu.values().length + "): ");
            option = scanner.nextLine();
            
            if(option.matches("[0-9]+")){               
                choice=Integer.parseInt(option);
            

            if (choice >= 1 && choice <= Menu.values().length) {
                Menu selected = Menu.values()[choice - 1];

                // Handle user choice
                switch (selected) {
                    case CREATE_DEPARMENT:
                        System.out.println("You chose to add an employee.");
                        break;
                    case ADD_EMPLOYEES:
                        System.out.println("You chose to add a manager.");
                        break;
                    case SORT:
                        System.out.println("Listing all people.");
                        break;
                    case GENERATE_DUMMY_DATA:
                        System.out.println("Listing all people.");
                        break;
                    case REMOVE:
                        System.out.println("Exiting program.");
                        
                        break;
                    case EXIT:
                        System.out.println("Exiting program.");
                        
                }
            } else {
                System.out.println("Invalid option. Try again.");
            }
            }else{
            System.out.println("Invalid input, try with an option of the Menu");
            }
        }while(choice !=7);
        
        System.out.println(mgr.getName());
        dept.assign(mgr);
        dept.assign(emp1);
        dept.assign(mgr);
        dept.assign(emp1);
        dept.assign(mgr);
        dept.assign(emp1);
        System.out.println(dept.getManager());
        System.out.println(mgr.getStartDate());
        System.out.println(mgr.getWage());
        
        System.out.println(dept.getName());
        System.out.println(dept.getSize());
        
}
}
