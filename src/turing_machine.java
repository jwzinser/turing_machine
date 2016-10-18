/*
        Calculate Circle Area using Java Example
        This Calculate Circle Area using Java Example shows how to calculate
        area of circle using it's radius.
*/

import java.io.*;
import java.util.*;


public class turing_machine {
    public static void main(String[] args) throws FileNotFoundException  {
        try {

            Scanner file = new Scanner(new FileReader("/Users/juanzinser/Documents/ITAM MCC/Computabilidad y Complejidad/Complejidad de kolmogorov/Corridas " +
            		"de ejemplo/Corrida 1/1_TargetTape.txt"));

            System.out.print("target chain \n");

            String s = file.next();
            String tm_thing  = s;
            System.out.print(tm_thing);
            
             
            int number_turing_iterations=1000;
            String[] turing_iterations = new String[number_turing_iterations];
            String[] turing_chains = new String[number_turing_iterations];
            double[] turing_iterations_penalties = new double[number_turing_iterations];
            int min_fit_id = 0;
            int min_fit_valor = 1000;
            int max_fit_id = 0;
            int max_fit_valor = 0;
            int penal_valor;
            for(int gi=0;gi<number_turing_iterations;gi++){
            	// saca las maquinas de turing
            	TM_juan turing = new TM_juan(64,16);
            	turing_chains[gi] = turing.turing_chain;
            	String current_tape = turing.run_machine();
            	turing_iterations[gi] = current_tape;
            	penal_valor = turing.run_fitness(current_tape, tm_thing);
            	turing_iterations_penalties[gi]=penal_valor;
            	if(penal_valor<min_fit_valor){
            		min_fit_valor = penal_valor;
            		min_fit_id = gi;
            	}
            	if(penal_valor>max_fit_valor){
            		max_fit_valor = penal_valor;
            		max_fit_id = gi;
            	}
            }

            String best_chain = turing_chains[min_fit_id];
            String worst_chain = turing_chains[max_fit_id];
            System.out.println("\n se fini");
            int number_generations = 100;
            Random randomGenerator = new Random();
            for(int gix=0;gix<number_generations;gix++){
            	// saca las generaciones
                System.out.println(gix);

            	/*
            	 * tomamos la cadena de mejor y peor score
            	 * esas cadenas las unimos en forma de anillo
            	 * para el cruzamiento (.9) tomamos un numero aleatorio
            	 * entre 0-1023 y de ahi tomamos 512 y los intercambiamos de anillo
            	 * luego la mutacion (.05) tomamos para cada bit y si se acepta la 
            	 * mutacion intercambiamos el bit
            	 */
                min_fit_id = 0;
                min_fit_valor = 1000;
                max_fit_id = 0;
                max_fit_valor = 0;
                String[] new_turing_chains = new String[number_turing_iterations];
                String[] new_turing_iterations = new String[number_turing_iterations];
                double[] new_turing_iterations_penalties = new double[number_turing_iterations];
                for(int ng=0;ng<number_turing_iterations;ng=ng+2){
	              
	        		int rand_cruzamiento_mut = randomGenerator.nextInt(100);
	        		String new_best_string;
	        		String new_worst_string;
	        		if(rand_cruzamiento_mut<90){
	            		int initial_pos = randomGenerator.nextInt(1024);
	            		int final_pos = (initial_pos + 512) % 1024;
	
	            		if(initial_pos<final_pos){
	            			// regular way 
	        				String best_half_string = best_chain.substring(initial_pos,final_pos);
	        				String worst_half_string = worst_chain.substring(initial_pos,final_pos);
	        				new_best_string = best_chain.substring(0,initial_pos)+
	        						worst_half_string+best_chain.substring(final_pos);
	        				new_worst_string = worst_chain.substring(0,initial_pos)+
	        						best_half_string+worst_chain.substring(final_pos);
	            		}
	            		else{
	        				String best_half_string_p1 = best_chain.substring(initial_pos);
	        				String best_half_string_p2 = best_chain.substring(0,final_pos);
	        				String worst_half_string_p1 = worst_chain.substring(initial_pos);
	        				String worst_half_string_p2 = worst_chain.substring(0,final_pos);
	        				new_best_string = worst_half_string_p2 + best_chain.substring(final_pos,initial_pos)+
	        						worst_half_string_p1;
	        				new_worst_string = best_half_string_p2 + worst_chain.substring(final_pos,initial_pos)+
	        						best_half_string_p1;
	            		}
	        		}
	        		else{
	        			new_best_string = best_chain;
	        			new_worst_string = worst_chain;
	        		}
	            		
	
	        	    char[] chars_best = new_best_string.toCharArray();
	        	    char[] chars_worst = new_worst_string.toCharArray();
	
	        		for(int mut=0; mut<1024; mut++){
	        			// for the best string
	        			int rand_int = randomGenerator.nextInt(100);
	            		if(rand_int<5){
	            			if(chars_best[mut]=='0'){
	                    	    chars_best[mut] = '1';
	            			}
	            			else{
	            				chars_best[mut] = '0';
	            			}
	            		}
	        			// for the worst string
	        			int rand_intw = randomGenerator.nextInt(100);
	            		if(rand_intw<5){
	            			if(chars_worst[mut]=='0'){
	            				chars_worst[mut] = '1';
	            			}
	            			else{
	            				chars_worst[mut] = '0';
	            			}
	            		}
	        		}
	        	    new_best_string =  String.valueOf(chars_best);
	        	    new_worst_string =  String.valueOf(chars_worst);
	        	    new_turing_chains[ng] = new_best_string;
	        	    new_turing_chains[ng+1] = new_worst_string;
	            	TM_juan turing = new TM_juan(64,16);
	            	String current_tape = turing.run_machine_from_string(new_best_string);
	        	    new_turing_iterations[ng] = current_tape;
	        	    penal_valor = turing.run_fitness(current_tape, tm_thing);
	            	new_turing_iterations_penalties[ng]=penal_valor;
	            	if(penal_valor<min_fit_valor){
	            		min_fit_valor = penal_valor;
	            		min_fit_id = ng;
	            	}
	            	if(penal_valor>max_fit_valor){
	            		max_fit_valor = penal_valor;
	            		max_fit_id = ng;
	            	}
	            	
	            	current_tape = turing.run_machine_from_string(new_worst_string);
	        	    new_turing_iterations[ng+1] = current_tape;
	        	    penal_valor = turing.run_fitness(current_tape, tm_thing);
	            	new_turing_iterations_penalties[ng+1]=penal_valor;
	            	if(penal_valor<min_fit_valor){
	            		min_fit_valor = penal_valor;
	            		min_fit_id = ng+1;
	            	}
	            	if(penal_valor>max_fit_valor){
	            		max_fit_valor = penal_valor;
	            		max_fit_id = ng+1;
	            	}
	        	    		
                }
                turing_iterations = new_turing_iterations;
                turing_chains = new_turing_chains;
                turing_iterations_penalties = new_turing_iterations_penalties;
                best_chain = turing_chains[min_fit_id];
                worst_chain = turing_chains[max_fit_id];
            }
            
            System.out.println("ahiva");
            String best_result = turing_iterations[min_fit_id];
            System.out.println(tm_thing);
            System.out.println(best_result);

            file.close();
                
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print("error");

        }       

    	

    }
}
