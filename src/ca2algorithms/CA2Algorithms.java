/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2algorithms;
import java.util.*;

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
           Scanner input = new Scanner(System.in);
           Menu menu1 = Menu.values()[0];
           int select1;
           select = Integer.parseInt(input.nextLine());
          while (Menu.values()[select] !=menu1.EXIT)    
        {
             try
            {
                menu1 = Menu.valueOf(input.nextLine());  
                select = Integer.parseInt(input.nextLine());
            }catch (IllegalArgumentException e)
            {
                
            }
    
    }
    
}
}
