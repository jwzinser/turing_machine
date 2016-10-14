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
            
            // generar las maquinas de turing aleatorias e indexar cuales
            // son cada uno de los estados y la funcion de cada bit del estado
            // en este caso las maquinas de turing van a tener 64 estados de 16 bits c/u
            TM_juan turing = new TM_juan(64,16); // si es de 8 bits cada estado sera de 512
            String cinta_turing = turing.run_machine();
            System.out.print("\n probando \n");
            System.out.print(turing.states[1][2]);
            System.out.print(cinta_turing);

            // ya que inicializamos las maquinas de turing hay que correr las 
            // las maquinas de turing sobre una cinta en blanco, como saber que la
            // maquina de turing va a llegar al halt?
            
            
            //ya que hayamos corrido las maquinas sobre la cinta en blanco hay que correr
            // el algoritmo genetico sobre una funcion fitness que regrese una maquina de turing mejor
            
                       
            file.close();
                
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print("error");

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
