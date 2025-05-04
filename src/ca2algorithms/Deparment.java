/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ponye
 */
public class Deparment{
    private String name;
    private AssignablePerson assignedPerson;
    private ArrayList<String> deparmentList; // List of employees in the deparment
    int flag =0;
 
    
    /** Creates a new Manager */
    public Deparment(String name)
      {
        this.name = name;
        this.deparmentList = new ArrayList<>();
        
      }
    
    public void assign(AssignablePerson person) {
        
        
        if(person.getClass().getSimpleName().trim().equalsIgnoreCase("employee") || flag!=1){
        this.assignedPerson = person;
        System.out.println("Assigned: "+ person.getName());
        String record =person.getClass().getSimpleName().trim()+" "+ person.getName();
        deparmentList.add(record);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name+".txt"))) {
            for (String i : deparmentList) {
                writer.write(i +"\n");
            }
            System.out.println("The "+person.getClass().getSimpleName()+" have been added to the file: " + name+ ".txt file!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        }
        else{
            System.out.println("You cannot add more than 1 manager");
        }
        if (person.getClass().getSimpleName().trim().equalsIgnoreCase("manager")){
        flag=1;
        }
      
    }

    public String getManager() {
        
        return assignedPerson.getName();
        }

    public int getSize() {
        return deparmentList.size();
    }
    
   public String getName() {
        return name;
    }

   public void showEmployees(){
       for (String i : deparmentList) {
               System.out.println(i);
            }
       
   }

    
}
