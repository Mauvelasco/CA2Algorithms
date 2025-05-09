/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2algorithms;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
            SHOW_INFO,
            REMOVE,
            EXIT
}
public static int numberInput(String prompt) {
    Scanner scanner = new Scanner(System.in);
    
        System.out.print(prompt);
        String option = scanner.nextLine();
        int choice=0;    
            if(option.matches("[0-9]+")){               
                choice=Integer.parseInt(option);
                }else{
            System.out.println("Invalid input, try with an option of the Menu");
            }
    return choice;

}

public static int displayDeparmentList(ArrayList<Deparment> deparments, String prompt) {
            
                        for (int i=0;i<deparments.size();i++) {
                            System.out.println((i+1)+".- "+deparments.get(i).getName());                          
                            }
                        int choice = numberInput(prompt+"\n");
               
                            if (choice >= 1 && choice <= deparments.size()) {
                            choice =choice - 1;
                            
                            return choice;}
                            else{
                                System.out.println("Invalid option!");
                                return 0;
                            }
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

        ArrayList<Deparment> deparments=new ArrayList<>();
        
        Deparment dept;
        
        dept = new Deparment("Finances");
        deparments.add(dept);
        dept = new Deparment("Specialized Unit");
        deparments.add(dept);
        dept = new Deparment("Human Resources");
        deparments.add(dept);

       
        
        String option;
        int choice=0;
         Scanner scanner = new Scanner(System.in);
        

        do{
            for (Menu menu1 : Menu.values()) {
                System.out.println((menu1.ordinal()+ 1)+" "+ menu1.toString() );
            }
            
            // Get user input
            choice = numberInput("Select an option from the menu: ");
           
            if (choice >= 1 && choice <= Menu.values().length) {
                Menu selected = Menu.values()[choice - 1];

                // Handle user choice
                switch (selected) {
                    case CREATE_DEPARMENT:
                        if(deparments.size()<6){
                        System.out.println("Enter the name of the new deparment!\n");
                        name = scanner.nextLine();
                        dept = new Deparment(name);
                        deparments.add(dept);
                            System.out.println(dept.getName()+" Deparment added successful!\n\n----------------------------------------------\n");
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dept.getName()+".txt"))) {
                    for (String j : dept.getList()) {
                        writer.write(j +"\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
                        }
                        else{
                            System.out.println("No possible add more deparments");
                        }
                        
                        break;
                    case ADD_EMPLOYEES:
                            choice = displayDeparmentList(deparments,"In Which Deparment would you like to add an employee\n");
                            
                            dept= deparments.get(choice);
                            
                            choice = numberInput("which method would you like add employees: \n1.-Read text file \n2.-Generate Random \n3.-Manually\n");
                            switch(choice){
                                case 1:
                                    dept.loadDummyData();
                                    break;
                                case 2:
                                    choice = numberInput("How many entry you want to generate\n");
                            dept.generateRandomUser(choice);
                            dept.showdeparment();
                                    break;
                                case 3:
                                    choice = numberInput("What Would you like to add ?(Select an option): \n1.-Manager \n2.-Employee\n");

                    switch (choice) {
                        case 1:
                            System.out.println("Enter the name of the manager\n");
                            name = scanner.nextLine();
                            System.out.println("Enter salary in Euros\n");
                            salary = scanner.nextInt();
                            calendar=Calendar.getInstance();
                            mgr= new Manager (name,salary,calendar);
                            dept.assignManager(mgr);
                            
                            break;
                        case 2:
                            System.out.println("Enter the name of the Employee\n");
                            name = scanner.nextLine();
                            System.out.println("Enter salary in Euros\n");
                            salary = scanner.nextInt();
                            calendar=Calendar.getInstance();
                            emp= new Employee (name,salary,calendar);
                            dept.assignEmployee(emp);
                            break;
                        default:
                            System.out.println("Option no valid!\n");
                            break;
                    
                            }
                     
                            break;
                            }
  
                        break;

                    case SEARCH:
                            choice = displayDeparmentList(deparments,"In Which Deparment would you like to search\n");
                            dept= deparments.get(choice);
                            if(dept.getSize()>0){
                               System.out.print("What is te name of the person you are searching ");
                            option = scanner.nextLine();
                                dept.bubbleRecursiveSort();
                         int pos3 = dept.binarySearch_nonRecursive(option,0,dept.getSize()-1);
        
                             if(pos3 == -1){
                                    System.out.println("The name: "+ option+ " was no found");
                            }else
                                 System.out.println("The position of:"+ option +" is "+ pos3);
                            }else
                                    System.out.println("There is nobody in the deparment");
                            break;
                            
                    case SORT:
                        choice= displayDeparmentList(deparments,"Which Deparment would you like to sort");
                        dept= deparments.get(choice);
                        dept.bubbleRecursiveSort();
                        dept.showdeparment20();
                        break;
                    
                    case REMOVE:
                        choice= displayDeparmentList(deparments,"From Which Deparment would you like to delete someone:");
                        
                            dept= deparments.get(choice);
                            choice = numberInput("Select an option: \n1.-Delete all the person in the deparment\n2.-Delete the manager\n3.-Enter the Quantity of employees you want to delete\n4.-Delete the last person added");
                            
                            switch(choice){
                                case 1:
                                    dept.GetEmpty();
                                    dept.showdeparment();
                                    break;
                                case 2:
                                    dept.DeleteManager();
                                    System.out.println("Would you like to see updated list? yes/no");
                                    option = scanner.nextLine();
                                    if(option.equalsIgnoreCase("yes")){
                                    dept.showdeparment();}
                                    break;
                                case 3:
                                    choice = numberInput("How many employees you want to delete");
                                    if(choice>=1 && choice <= dept.getSize())
                                        for(int i=0;i< choice;i++){
                                          dept.DeleteEmployees();     
                                          dept.showdeparment();}
                                    else{
                                    System.out.println("Number out the bounds");
                                    }
                                    
                                    break;
                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                        
                        
                        break;
                   
                        case SHOW_INFO:
                            
                       choice = displayDeparmentList(deparments,"Which Deparment would you like to see information\n");
                            dept= deparments.get(choice);
                            dept.showdeparment();
                        
                        break;
                    case EXIT:
                        System.out.println("Exiting program... Would you like to save the states of deparments? yes/no");
                        option = scanner.nextLine();
                                    if(option.equalsIgnoreCase("yes")){
                                     for (int i=0;i<deparments.size();i++) {
                                         dept= deparments.get(i);
                                            
                            }
                                    
                                    }
                                    
                        break;
                }
            } else {
                System.out.println("Invalid option. Try again.");
            }
            
        }while(choice !=7);
        

    
     

        
}
}
