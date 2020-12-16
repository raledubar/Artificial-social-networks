/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_ergm_java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author raulduarte
 */
public class Erdos_Renyi extends GraphUndirec {
    
   private double p; 
   private List<Integer> erdos_list;
   private Map< Integer, List<Integer> > erdos_Adjacency_list = new HashMap<>();
   
   
   public Erdos_Renyi(int n, double p){
       super(n);
       this.p = p;
       
       for (int i = 0; i<n; i++){
           for (int j = 0; j<n; j++){
               if (  (Math.random() < p) && (j>i)  ){
                   this.add_edge(i, j);
               }
               
           }
       }
       
       
       
   }

    @Override
    public void print_adjacency_list() {
    // if i had known how to encapsulate right i wouldnt have written this again
        for (int i=0; i< this.get_Gmatriz().length; i++ ){
           erdos_list = new LinkedList<Integer>();
            for (int j=0; j< this.get_Gmatriz().length; j++){
                if (this.getElement_Gmatriz(i, j) != 0) {
                   erdos_list.add(j);
                }
            }
            
        this.erdos_Adjacency_list.put(i, erdos_list);
  
        }
        
        System.out.println(erdos_Adjacency_list);
        
        
    }
   
   
   
    
    
    
}
