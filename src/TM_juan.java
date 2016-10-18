import java.util.*;

public class TM_juan {
    // initialice fields
    public int[][] states;
    public StringBuilder states_chain = new StringBuilder();
    public int aux;
    public String turing_chain;
    Random randomGenerator = new Random();


    // the turing machine class has
    // one constructor
    public TM_juan(int numberStates, int bitPerState) {
        states = new int [numberStates][bitPerState];
        int rand_int;
        states_chain.append("");

        for (int i = 0; i <numberStates; ++i){
        	for (int j = 0;j <bitPerState; ++j){
        		rand_int = randomGenerator.nextInt(2);
        		states[i][j]= rand_int;
    			states_chain.append(Integer.toString(rand_int));

        	}
    	}
        aux=0;
        turing_chain = states_chain.toString(); 
    }
      
    // the TM_juan class has
    public void increment(int increment) {
        aux += increment;
    }
    
    public String run_machine() {
    	// modificar el metdodo para que se corra a partir de un string
    	// que no necesariamente se tenga que correr a partir de una matriz
        // todo el proceso para correr la maquina de la cinta 
    	// del total de bits que tiene cada estado
    	int[] cinta = new int[1024*1024];
    	// el head original es la mitad
    	int head = 1024*512;
    	// run machine
    	int min_index = head;
    	int max_index = head;
    	boolean halt = false;
    	int current_state = 0;
    	int max_iterator = 100;
    	int iterator = 0;
    	while (!halt && iterator<=max_iterator){
    		int current_value = states[current_state][0];
    		int future_value = states[current_state][1];
    		int left_right = states[current_state][2];
    		// integer to string suppose it goes from 
    		StringBuilder sb = new StringBuilder();
    		sb.append("");
    		for(int idx=2;idx<=7;idx++){
        		sb.append(Integer.toString(states[current_state][idx]));
    		}
    		int future_state = Integer.parseInt(sb.toString(), 2);

    		if(cinta[head]==current_value){
    			cinta[head]=future_value;
    		}
    		if(left_right==0){
    			head-=1;
    		}else{
    			head+=1;
    		}
    		if(future_state==63){
    			halt=true;
    		}else{
    			current_state=future_state;
    		}
    		iterator +=1;
    		if(head<min_index){
    			min_index=head;
    		}
    		if(head>max_index){
    			max_index=head;
    		}
    		
    	}
    	// cut cinta on the significant segment, only where head was eventually
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int ct=min_index; ct<=max_index;ct++){
			sb.append(Integer.toString(cinta[ct]));
		}
        return sb.toString();
    }
    
    
    public String run_machine_from_string(String turing_tape) {
    	// modificar el metdodo para que se corra a partir de un string
    	// que no necesariamente se tenga que correr a partir de una matriz
        // todo el proceso para correr la maquina de la cinta 
    	// del total de bits que tiene cada estado
    	int[] cinta = new int[1024*1024];
    	// el head original es la mitad
    	int head = 1024*512;
    	// run machine
    	int min_index = head;
    	int max_index = head;
    	boolean halt = false;
    	int current_state = 0;
    	int max_iterator = 100;
    	int iterator = 0;
    	int chain_iterator_module = 0;
    	while (!halt && iterator<=max_iterator){
    		chain_iterator_module = 16*current_state;
    		int current_value = Character.getNumericValue(
    				turing_tape.charAt(chain_iterator_module));
    		int future_value = Character.getNumericValue(
    				turing_tape.charAt(chain_iterator_module+1));
    		int left_right = Character.getNumericValue(
    				turing_tape.charAt(chain_iterator_module+2));
    		// integer to string suppose it goes from 
    		StringBuilder sb = new StringBuilder();
    		sb.append("");
    		for(int idx=2;idx<=7;idx++){
    			char number_pos=turing_tape.charAt(chain_iterator_module+idx); 
        		sb.append(Integer.toString(Character.getNumericValue(number_pos)));
    		}
    		int future_state = Integer.parseInt(sb.toString(), 2);

    		if(cinta[head]==current_value){
    			cinta[head]=future_value;
    		}
    		if(left_right==0){
    			head-=1;
    		}else{
    			head+=1;
    		}
    		if(future_state==63){
    			halt=true;
    		}else{
    			current_state=future_state;
    		}
    		iterator +=1;
    		if(head<min_index){
    			min_index=head;
    		}
    		if(head>max_index){
    			max_index=head;
    		}
    		
    	}
    	// cut cinta on the significant segment, only where head was eventually
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for(int ct=min_index; ct<=max_index;ct++){
			sb.append(Integer.toString(cinta[ct]));
		}
        return sb.toString();
    }
    
    public int run_fitness(String cinta, String target) {

    	int penalty = 0;
    	// penalize greatly the overload 
    	int target_length = target.length();
    	int cinta_length = cinta.length();
    	int length_difference = target_length-cinta_length; 
    	double length_difference_penalty = Math.pow(length_difference, 2);
        

    	if(length_difference > 0){
    		// target is larger than cinta
    	    target = target.substring(0,cinta_length);
    	}
    	else{
    		// cinta is larger than target
    	    cinta = cinta.substring(0,target_length);
    	}
    	

        for(int i=0; i<target.length();i++){
    		if(cinta.charAt(i)!=target.charAt(i)){
    			penalty += 1;
    		}
    	}
    	penalty += length_difference_penalty;
    	// double cast_penalty = penalty;
        return penalty;
    }

}
