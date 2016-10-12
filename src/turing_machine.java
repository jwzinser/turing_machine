/*
        Calculate Circle Area using Java Example
        This Calculate Circle Area using Java Example shows how to calculate
        area of circle using it's radius.
*/

import java.io.*;
import java.util.Scanner;


public class turing_machine {
    public static void main(String[] args) throws FileNotFoundException  {
        try {

            Scanner file = new Scanner(new FileReader("/Users/juanzinser/Documents/ITAM MCC/Computabilidad y Complejidad/Complejidad de kolmogorov/Corridas " +
            		"de ejemplo/Corrida 1/1_TargetTape.txt"));

            System.out.print("");

            String s = file.next();
            String tm_thing  = s;
            System.out.print(tm_thing);
            file.close();
            /*
            for(int i = 0; i < tm_thing.length(); i++) {
                System.out.println(tm_thing.charAt(i));
            }
            */
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print("que pedo");

        }       

    	
        //Scanner in = new Scanner(new FileReader("C:/Users/juanzinser/Documents/ITAM MCC/Computabilidad y Complejidad/Complejidad de kolmogorov/Corridas de ejemplo/Corrida 1/1_TargetTape.txt"));
        
        //if invalid value was entered
        /*
        catch(NumberFormatException ne)
        {
                System.out.println("Invalid file value" + ne);
                System.exit(0);
        }
        catch(IOException ioe)
        {
                System.out.println("IO Error :" + ioe);
                System.exit(0);
        }
        */
       

        //System.out.print("Area of a circle is mis huevos son dorados " + tm_thing);
}
}
