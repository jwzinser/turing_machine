import java.util.*;

public class TM_juan {
    // initialice fields
    public int[][] states;
    public int aux;
    Random randomGenerator = new Random();


    // the Bicycle class has
    // one constructor
    public TM_juan(int numberStates, int bitPerState) {
        states = new int [numberStates][bitPerState];
        for (int i = 0; i <numberStates; ++i){
        	for (int j = 0;j <bitPerState; ++j){
        		states[i][j]= randomGenerator.nextInt(2);
        	}
    	}
        aux=0;
    }
       
    // the TM_juan class has
    public void increment(int increment) {
        aux += increment;
    }
    
    public String run_machine() {
        // todo el proceso para correr la maquina de la cinta 
    	// del total de bits que tiene cada estado
    	
    	
        return cinta_final;
    }
}
