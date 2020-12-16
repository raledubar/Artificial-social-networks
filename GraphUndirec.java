/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_ergm_java;

import java.util.*;
import java.util.HashMap;


/**
 *
 * @author raulduart
 */
public class GraphUndirec {
    
   private Node nodes ;
   private Map< Integer, List<Integer> > Adjacency_list = new HashMap<>();
//   private List<Integer> list = new LinkedList<Integer>();
   private List<Integer> list;
   private int [][] Gmatriz;  

   
   public GraphUndirec(int n){
       this.Gmatriz = new int[n][n];
   //     this.Gmatriz = matriz.clone();
        for (int i =0; i < n; i++){
            for (int j=0; j < n; j++){
                this.Gmatriz[i][j] = 0;
            }
        }
   }
   
   public GraphUndirec(int n, double p){
       this.Gmatriz = new int[n][n];
       for (int i =0; i < n; i++){
            for (int j=0; j < n; j++){
                this.Gmatriz[i][j] = 0;
            }
        }
       
       for (int i = 0; i<n; i++){
           for (int j = 0; j<n; j++){
               if ( (Math.random() < p) && (j>i)  ){
                   this.add_edge(i, j);
               }
               
           }
       }
       
//       for (int i=0; i< this.Gmatriz.length; i++ ){
//            list = new LinkedList<Integer>();
//            for (int j=0; j< this.Gmatriz.length; j++){
//                if (this.Gmatriz[i][j] != 0) {
//                   list.add(j);
//                }
//            }
//            
//        this.Adjacency_list.put(i, list);
//  
//        }
       
       
       
   }
   
    public GraphUndirec(int [][] matriz) {
       
       
//        for (int i=0; i< matriz.length; i++ ){
//            list = new LinkedList<Integer>();
//            for (int j=0; j< matriz.length; j++){
//                if (matriz[i][j] != 0) {
//                   list.add(j);
//                }
//            }
//            
//        this.Adjacency_list.put(i, list);
//  
//        }
        
        this.Gmatriz = new int[matriz.length][matriz.length];
   //     this.Gmatriz = matriz.clone();
        for (int i =0; i < matriz.length; i++){
            for (int j=0; j < matriz.length; j++){
                this.Gmatriz[i][j] = matriz[i][j];
            }
        }
        
        
    }
    
    public int number_of_nodes(){
        return this.Gmatriz.length;
    }
    
    public void print_adjacency_list(){
           for (int i=0; i< this.Gmatriz.length; i++ ){
            list = new LinkedList<Integer>();
            for (int j=0; j< this.Gmatriz.length; j++){
                if (this.Gmatriz[i][j] != 0) {
                   list.add(j);
                }
            }
            
        this.Adjacency_list.put(i, list);
  
        }
          System.out.println(Adjacency_list);
    }
    
    public int[][] get_Gmatriz(){
        return this.Gmatriz;
    }
    
    public void setElement_Gmatriz(int a, int b, int value){
        this.Gmatriz[a][b] = value;
        this.Gmatriz[b][a] = value;
 // Debi de haber usado esto en vez de escribir en vez de todos lados
       // this.Gmatriz[a][b] = 1;
       // this.Gmatriz[b][a] = 1;
    }
    
    public int getElement_Gmatriz(int a, int b){
        return this.Gmatriz[a][b];
        
    }
    
//    
    public void print_gmatrix(){
        for (int i=0; i< this.Gmatriz.length; i++){
            for (int j=0; j< this.Gmatriz.length; j++){
                System.out.print(this.Gmatriz[i][j]);
            }
            System.out.println();
        }
    }
    
    public int[][] copy_gmatrix(){
        int[][] copy = new int[Gmatriz.length][Gmatriz.length];
        for (int i=0; i< this.Gmatriz.length; i++){
            for (int j=0; j< this.Gmatriz.length; j++){
                copy[i][j] = Gmatriz[i][j];
            }
            
        }
        
        return copy;
    }
    
    public GraphUndirec my_clone(){
//        int n;
//        n = this.Gmatriz.length;
       GraphUndirec clon;
  //      int[][] new_matrix;
       int[][] new_matrix = new int[this.Gmatriz.length][this.Gmatriz.length];
       for (int i=0; i< this.Gmatriz.length; i++){
                for (int j=0; j< this.Gmatriz.length; j++){
                    new_matrix[i][j] = Gmatriz[i][j];
                }

            }
           clon = new GraphUndirec(new_matrix);
           return clon;
    }
    
    public int edges_graph(){
        int edges = 0;
 //       int filas = admatriz.length();
        int filas = this.Gmatriz.length;
        for (int i =0; i< filas; i++){
            for (int j=0; j< filas; j++){
                if ( j>i){
                   edges += this.Gmatriz[i][j]; 
                }
                
            }
        }
        
        return edges;
    }
    
    public double density_graph(){
        int num = 2 * this.edges_graph();
        int n = this.Gmatriz.length;
        double deno;
          deno  = (double) n*(n-1);
        
        return num/deno;
    }
    
    
    
    
    public int triangles_graph(){
        int V;
        V = this.Gmatriz.length;
        
        int[][] aux2 = new int[V][V];
        int[][] aux3 = new int[V][V];
        
        for (int i=0; i < V; i++){
            for (int j=0; j < V; j++){
                aux2[i][j] = aux3[i][j]=0;
            }
        }
          
        MathUtils.multiply_matrix(this.Gmatriz, this.Gmatriz, aux2);
        MathUtils.multiply_matrix(this.Gmatriz, aux2, aux3);
                
        int traza = MathUtils.getTraza(aux3);
        
        return traza/6;
    }
    
   
    
    public boolean has_edge(int a, int b){

//        System.out.println(Adjacency_list.get(a).contains(b));
//        return(Adjacency_list.get(a).contains(b));
       return this.Gmatriz[a][b] != 0;
        
    }
    
    public void add_edge(int a, int b){
        if (!this.has_edge(a, b)) {
//            this.Adjacency_list.get(a).add(b);
//            this.Adjacency_list.get(b).add(a);
            this.Gmatriz[a][b] = 1;
            this.Gmatriz[b][a] = 1;
        }
    }
    
    public void remove_edge(int a, int b){
        
        if (this.has_edge(a, b)) {
            // no necesito la lista de adyacencia
//            this.Adjacency_list.get(a).remove(Integer.valueOf(b));
//            this.Adjacency_list.get(b).remove(Integer.valueOf(a));
            // no necesito la lista de adyacencia
            
        //NO FUNCIONAN REMOVE TAKE THE POSITION RATHER THAN VALUE
 //          this.Adjacency_list.get(a).remove(b);
 //           this.Adjacency_list.remove(a, b);
 //           this.Adjacency_list.get(a);
     //NO FUNCIONAN REMOVE TAKE THE POSITION RATHER THAN VALUE             
            this.Gmatriz[a][b] = 0;
            this.Gmatriz[b][a] = 0;
 //           System.out.println(list_dt);
        }
    }
    
    public int select_node(){
        int min = 0;
        int max = this.Gmatriz.length-1;
        
        int chosen_node = (int)(Math.random() * (max - min + 1)) + min;
        
        return chosen_node;
        
    }
    
    public GraphUndirec toggle_edge(){
//        int n;
//        n = this.Gmatriz.length;
         GraphUndirec copia;
//        int[][] new_matrix;
//        new_matrix = new int[n][n];
//       new_matrix = this.copy_gmatrix(this.Gmatriz);
//       copia = new GraphUndirec(new_matrix);
         copia = this.my_clone();
//// falta cambiar void por GraphUndirec
       double d = copia.density_graph();
       double r = Math.random();
       int n1, n2;
       if (( r < 0.5 || d == 0) && d!= 1){
           do{
                    
             n1= copia.select_node();
             n2 = copia.select_node();
           }
           while ( (n1 == n2) || (copia.has_edge(n1, n2)) ); // si lo tiene no puedo agregarlo
           copia.add_edge(n1, n2);
       }else {
           do{
           
             n1 = copia.select_node();
             n2 = copia.select_node();
           } while ( (n1 == n2) || (!copia.has_edge(n1, n2)) );// si lo tiene puedo removerlo
           copia.remove_edge(n1, n2);
       }
       
       return copia; 
    }
    
    public void cero_toggle_edge(){

       double d = this.density_graph();
       double r = Math.random();
       int n1, n2;
       if (( r < 0.5 || d == 0) && d!= 1){
           do{
           
             n1 = this.select_node();
             n2 = this.select_node();
           }
           while ( (n1 == n2) && (this.has_edge(n1, n2)) ); // si lo tiene no puedo agregarlo
           this.add_edge(n1, n2);
       }else {
           do{
           
             n1 = this.select_node();
             n2 = this.select_node();
           } while ( (n1 == n2) && (!this.has_edge(n1, n2)) );// si lo tiene puedo removerlo
           this.remove_edge(n1, n2);
       }
       
        
    }
    
}
