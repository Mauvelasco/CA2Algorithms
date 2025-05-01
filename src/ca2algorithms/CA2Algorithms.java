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
            SORT,
            SEARCH,
            ADD,
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
