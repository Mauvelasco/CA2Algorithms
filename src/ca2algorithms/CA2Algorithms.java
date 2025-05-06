/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2algorithms;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
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
            READ_DUMMY_DATA,
            SHOW_INFO,
            REMOVE,
            EXIT
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        Calendar calendar;
        Manager mgr;
        Employee emp;
        String name;
        int salary;
      
        List<Employee> employeeList = new ArrayList<>();
        ArrayList<Deparment> deparments=new ArrayList<>();
        
        Deparment dept;
        
        dept = new Deparment("Finances");
        deparments.add(dept);
        dept = new Deparment("Specialized Unit");
        deparments.add(dept);
        dept = new Deparment("Human Resources");
        deparments.add(dept);
        dept = deparments.get(0);
        System.out.println(dept.getName());
       
        
        String option;
        int choice=0;
         Scanner scanner = new Scanner(System.in);
        

        do{
            for (Menu menu1 : Menu.values()) {
                System.out.println((menu1.ordinal()+ 1)+" "+ menu1.toString() );
            }
            
            // Get user input
            System.out.print("Select an option from the menu: ");
            option = scanner.nextLine();
            
            if(option.matches("[0-9]+")){               
                choice=Integer.parseInt(option);
                }else{
            System.out.println("Invalid input, try with an option of the Menu");
            }
            

            if (choice >= 1 && choice <= Menu.values().length) {
                Menu selected = Menu.values()[choice - 1];

                // Handle user choice
                switch (selected) {
                    case CREATE_DEPARMENT:
                        if(deparments.size()<6){
                        System.out.println("Enter the name of the new deparment!");
                        name = scanner.nextLine();
                        dept = new Deparment(name);
                        deparments.add(dept);}
                        else{
                            System.out.println("No possible add more deparments");
                        }
                        
                        break;
                    case ADD_EMPLOYEES:
                        System.out.println("In Which Deparment would you like to add an employee");
                        for (int i=0;i<deparments.size();i++) {
                            System.out.println((i+1)+".- "+deparments.get(i).getName());                          
                            }
                        
                        option = scanner.nextLine();
            
                        if(option.matches("[0-9]+")){               
                            choice=Integer.parseInt(option)-1;
                        
                            dept= deparments.get(choice);
                        
                                System.out.println("What Would you like to add ?(Select an option): \n 1.-Manager \n2.-Employee");
                                option = scanner.nextLine();
                                if(option.equalsIgnoreCase("1")){
                                
                                System.out.println("Enter the name of the manager");
                                name = scanner.nextLine();
                                System.out.println("Enter salary in Euros");
                                salary = scanner.nextInt();
                                calendar=Calendar.getInstance();
                                mgr= new Manager (name,salary,calendar);
                                dept.assignManager(mgr);
                                
                                } else if(option.equalsIgnoreCase("2")){
                                    
                                System.out.println("Enter the name of the Employee");
                                name = scanner.nextLine();
                                System.out.println("Enter salary in Euros");
                                salary = scanner.nextInt();
                                calendar=Calendar.getInstance();
                                emp= new Employee (name,salary,calendar);
                                dept.assignEmployee(emp);
                                    }
                                else{
                                    System.out.println("Option no valid!");
                                }
                        
                        
                        }
                        else{
                            System.out.println("No valid input!");   } 
                        
                        
                                
                        break;
                    case SEARCH:
                               System.out.print("What is te name of the person you are searching ");
                            option = scanner.nextLine();
            
                         int pos3 = dept.binarySearch_nonRecursive(option,0,dept.getSize()-1);
        
                             if(pos3 == -1){
                                    System.out.println("The name: "+ option+ " was no found");
                            }else
                                 System.out.println("The position of:"+ option +" is "+ pos3);
         
    
                        break;
                    case SORT:
                        dept.bubbleRecursiveSort();
                        dept.showdeparment();
                        break;
                    case GENERATE_DUMMY_DATA:
                        System.out.println("For Which Deparment would you like to generate dummy Data:");
                        for (int i=0;i<deparments.size();i++) {
                            System.out.println((i+1)+".- "+deparments.get(i).getName()); 
                        }
                             option = scanner.nextLine();
            
                        if(option.matches("[0-9]+")){               
                            choice=Integer.parseInt(option)-1;
                            
                            dept= deparments.get(choice);
                            dept.generateRandomUser(50);
                            dept.showdeparment();
                        }
                        else{
                            System.out.println("No valid input!");   }  
                            

                        break;
                    case REMOVE:
                        System.out.println("From Which Deparment would you like to delete someone:");
                        for (int i=0;i<deparments.size();i++) {
                            System.out.println((i+1)+".- "+deparments.get(i).getName()); 
                        }
                             option = scanner.nextLine();
            
                        if(option.matches("[0-9]+")){               
                            choice=Integer.parseInt(option)-1;
                            dept= deparments.get(choice);
                            System.out.println("Select an option: \n1.-Delete all the person in the deparment\n2.-Delete the manager\n3.-Enter the Quantity of employees you want to delete\n4.-Delete the last person added");
                            option = scanner.nextLine();
                            switch(option){
                                case "1":
                                    dept.GetEmpty();
                                    dept.showdeparment();
                                    break;
                                case "2":
                                    dept.DeleteManager();
                                    dept.showdeparment();
                                    break;
                                case "3":
                                    System.out.println("How many employees do you want to delete?");
                                    option = scanner.nextLine();
                                    if(option.matches("[0-9]+")){            
                                        choice=Integer.parseInt(option)-1;}
                                        for(int i=0;i< choice;i++){
                                          dept.DeleteEmployees();  
                                        }
                                    dept.showdeparment();
                                    break;
                            }
                            

                        
                        }
                        
                        break;
                    case READ_DUMMY_DATA:
                        dept.loadDummyData();
                        break;
                        case SHOW_INFO:
                            System.out.println("For Which Deparment would you like to see the info");
                        for (int i=0;i<deparments.size();i++) {
                            System.out.println((i+1)+".- "+deparments.get(i).getName()); 
                        }
                             option = scanner.nextLine();
            
                        if(option.matches("[0-9]+")){               
                            choice=Integer.parseInt(option)-1;
                            
                            dept= deparments.get(choice);
                            
                        dept.showdeparment();
                        }
                        break;
                    case EXIT:
                        System.out.println("Exiting program.");
                        break;
                }
            } else {
                System.out.println("Invalid option. Try again.");
            }
            
        }while(choice !=9);
        

    
     

        
}
}
