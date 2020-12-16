/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_ergm_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static one_ergm_java.Artificial_graphs_MCMC.cero_MCMC;

/**
 *
 * @author raulduarte
 */
public class MathUtils {
    
    public static void multiply_matrix(int A[][], int B[][], int C[][]){
        int V;
        V = A.length;
        
        for (int i = 0; i < V; i++){ 
        
           for (int j = 0; j < V; j++){ 
            
               C[i][j] = 0; 
               for (int k = 0; k < V; k++){ 
                
                   C[i][j] += A[i][k]*B[k][j]; 
               } 
           } 
       } 
        
    }
    
    public static int getTraza(int[][]matriz){
        
        int traza = 0;
        int V = matriz.length;
        
        for (int i = 0; i < V; i++){
            traza += matriz[i][i];
        }
        return traza;
    }
    
    public static int sumaind(int a, int b){
        int suma;
        suma = a + b;
        return suma;
    }
    
//    public static double simula_f(GraphUndirec G, List<Double> input){
//        double Zcero, pcero;
//        List <GraphUndirec> graphs_cero = new ArrayList<GraphUndirec>();
//        int graph_samples = 10000;
//        
//        graphs_cero = One_ergm_java.cero_MCMC(G, input.get(0), input.get(1), graph_samples);
//    }
    
    
    
    
    
}
