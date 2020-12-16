/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_ergm_java;

import java.lang.Math;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.* ;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Arrays;

/**
 *
 * @author raulduarte
 */
public class Artificial_graphs_MCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         List <Double> best_fvals, bestXs;
        double dist_prueba;
        List<ArrayList<Double>> myxs = new ArrayList<ArrayList<Double>>();
        int MAXiter, LSITER, m, n, conta;
     
        long startTime = System.nanoTime();
        GraphUndirec gprueba, gprueba_dos;
        Erdos_Renyi erdos_prueba, erdos_dos, erdos_tres, erdos_cuatro;
        int edges;
        File file, filedos;
        File output;
        int [][] matriz, matriz_dos;
        file = new File("/Users/raulduarte/NetBeansProjects/ERGM_java/one_ergm_java/src/one_ergm_java/esc1.txt");
        filedos = new File("/Users/raulduarte/NetBeansProjects/ERGM_java/one_ergm_java/src/one_ergm_java/florentine_family.txt");
        output = new File("/Users/raulduarte/NetBeansProjects/ERGM_java/one_ergm_java/src/one_ergm_java/out_1.txt");
        int  actors = 108;
        int actors_dos;
        actors_dos = 15;
        matriz = new int[actors][actors];
        matriz_dos = new int[actors_dos][actors_dos];
        try {       
            matriz = read_matrix(file, actors);
            matriz_dos = read_matrix(filedos, actors_dos);
        } catch (Exception ex) {
            Logger.getLogger(Artificial_graphs_MCMC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
       //print_matrix_file(matriz, output, 108); 
       gprueba = new GraphUndirec(matriz);
       gprueba_dos = new GraphUndirec(matriz_dos);
       List <Double> fit = new ArrayList<Double>();
       int pruebafit;
       
       GraphUndirec G;
       G = new GraphUndirec(matriz_dos);
       
       int coef_samples = 10; 
       int graph_samples = 100;
       double [] ar_double_fit ;
       double doble_fit ;
       int int_fit;  
         
       double start_edgecoeff, start_trianglecoeff;
       start_edgecoeff = -1.25;
       start_trianglecoeff = 0.15;
         
        // doble_fit = arBubble_MCMC(gprueba_dos, start_edgecoeff, start_trianglecoeff, 10000);
        // System.out.println(doble_fit);
        
        ar_double_fit =  arBubble_fit_ergm(gprueba_dos, coef_samples, graph_samples);
        System.out.println(ar_double_fit);
        
     //  ar_double_fit =  arBubble_fit_ergm(gprueba_dos, coef_samples, graph_samples);
        
       for (int i =0; i < ar_double_fit.length; i++){
           System.out.println(ar_double_fit[i]);
       } 
//                 
//       for (int i = 0; i < 1000; i++) {
//           doble_fit = ar_cero_MCMC(gprueba_dos, start_edgecoeff, start_trianglecoeff, 1000);
//          
//     }        
         
     //   int[] int_fit;
       
      // double_fit = new double[coef_samples];
     // int_fit = new int[coef_samples];
       
//       double_fit = ar_fit_ergm(gprueba_dos, coef_samples, 400);
//       for (int i=0; i< double_fit.length; i++){
//           System.out.println(double_fit[i]);
//       }
        
//         int_fit = ar_fit_ergm(gprueba_dos, coef_samples, 10);
//         for (int i=0; i< int_fit.length; i++){
//           System.out.println(int_fit[i]);
//         }
//      
     //ESTO TARDO 188 MINUTOS Y NO TERMINO FALTA CHECAR EL NUMERO DE ITERACIONES
    //   fit = fit_ergm(gprueba_dos, 20, 1000);
    //   pruebafit = fit_ergm(gprueba_dos, 20, 30);
    //   System.out.println(pruebafit);
     //ESTO TARDO 188 MINUTOS Y NO TERMINO FALTA CHECAR EL NUMERO DE ITERACIONES
//       
//       for (Double elem : fit){
//           System.out.println(elem);
//       }
      
 

    // GraphUndirec[] gmain_list = new GraphUndirec[1000];
     
//     gmain_list = ar_cero_MCMC(gprueba_dos, start_edgecoeff, start_trianglecoeff, 1000);
//     
//     int count = 0;
//     for (int i = 0; i < 1000; i++) {
//           gmain_list = ar_cero_MCMC(gprueba_dos, start_edgecoeff, start_trianglecoeff, 1000);
//          //count += 1;
//     }
//     System.out.println(count);
       
  //   List <GraphUndirec> gmain_list = cero_MCMC(gprueba_dos, start_edgecoeff, start_trianglecoeff, 1000);
 //   List <GraphUndirec> gmain_list = cero_MCMC(duarte, start_edgecoeff, start_trianglecoeff, 5000);
 
 
//for (int i = 0; i< 100; i++){ 
//  List <GraphUndirec> gmain_list = cero_MCMC(gprueba_dos, start_edgecoeff, start_trianglecoeff, 10000); 
//  
//}
// LO DE ARRIBA DURO 11 MINUTOS 30 SEGUNDOS imax = 1000 y 10000 en gmain_list


 // Para un millon esto tado 68 segundos ///
 //   List <GraphUndirec> gmain_list = cero_MCMC(gprueba_dos, start_edgecoeff, start_trianglecoeff, 1000000);  
 // Para un millon esto tado 68 segundos /// 
 
 
   // List <GraphUndirec> gmain_list = MCMC(duarte, start_edgecoeff, start_trianglecoeff, 10); 
   //  List <GraphUndirec> gmain_list = cero_MCMC(gprueba, start_edgecoeff, start_trianglecoeff, 5000);
 
   
       
      
      long endTime = System.nanoTime();
      
      long timeElapsed = endTime - startTime;
      
      System.out.println("Execution time in nanoseconds  : " + timeElapsed);
 
      System.out.println("Execution time in milliseconds : " +
                                timeElapsed / 1000000);
      
      System.out.println("Execution time in seconds : " +
                                timeElapsed / 1000000000);
        
    }
    
    public static List<Double> fit_ergm(GraphUndirec G, int coeff_samples, int graph_samples){
  //  public static int fit_ergm(GraphUndirec G, int coeff_samples, int graph_samples){     
     //   List <Double> edge_coeffs, triangle_coeffs, probs;
        List <GraphUndirec> graphs = new ArrayList<GraphUndirec>();
         List <GraphUndirec> graphs_cero = new ArrayList<GraphUndirec>();
        List <Double> edge_coeffs = new ArrayList<Double>();
        List <Double> triangle_coeffs = new ArrayList<Double>();
        List <Double> probs = new ArrayList<Double>();
        List <Double> results = new ArrayList<Double>();
        List prueba_list = new ArrayList();
        
        double ed_coeff, tr_coeff, s, Z, p, best_p, best_edcoef, best_trcoef;
        double edcero, trcero, Zcero, pcero;
        int ind_max, count_opera;
        Random rand = new Random();
        
       // edcero = rand.nextGaussian();
        edcero = -0.5;
       // trcero = rand.nextGaussian();
        trcero = 0.5;
        graphs_cero =cero_MCMC(G, edcero, trcero, graph_samples);
        Zcero = sum_weights(graphs_cero, edcero, trcero);
        pcero = graph_weight(G, edcero, trcero)/(Zcero);
        
        edge_coeffs.add(edcero);
        triangle_coeffs.add(trcero);
        probs.add(pcero);
        count_opera = 0;
        
        while(probs.size() < coeff_samples){
            s = Math.sqrt(5.0/probs.size()); //no estoy seguro de ese DOS
            ed_coeff = edge_coeffs.get(edge_coeffs.size()-1) +(s*rand.nextGaussian());
            tr_coeff = triangle_coeffs.get(triangle_coeffs.size()-1) +(s*rand.nextGaussian());
            graphs = cero_MCMC(G, ed_coeff, tr_coeff, graph_samples);
            Z = sum_weights(graphs, ed_coeff, tr_coeff);
            p = graph_weight(G, ed_coeff, tr_coeff)/Z;
            
            if (p > probs.get(probs.size()-1) || Math.random() < (p/probs.get(probs.size()-1)) ){
                edge_coeffs.add(ed_coeff);
                triangle_coeffs.add(tr_coeff);
                probs.add(p);
            }//else{// esto no deberia de ir solo es para contar iteraciones del algoritmo
//                 edge_coeffs.add(edge_coeffs.get(edge_coeffs.size()-1 ) );
//                 triangle_coeffs.add(triangle_coeffs.get(triangle_coeffs.size()-1));
//                 probs.add(pcero);
//            }// esto no deberia de ir solo es para contar iteraciones del algoritmo
//            
           ///PROBAR ESTE BLOQUE SIN EL IF PARA VER CUANTAS ITERACIONES HACE// 
//            edge_coeffs.add(ed_coeff);
//            triangle_coeffs.add(tr_coeff);
//            probs.add(p);
           ///PROBAR ESTE BLOQUE SIN EL IF PARA VER CUANTAS ITERACIONES HACE//
            count_opera += 1;
                 
        }
        
        ind_max = probs.indexOf(Collections.max(probs));
        best_p = probs.get(ind_max);
        best_edcoef = edge_coeffs.get(ind_max);
        best_trcoef = triangle_coeffs.get(ind_max);
        results.add(best_p);
        results.add(best_edcoef);
        results.add(best_trcoef);
        results.add((double)count_opera);
        
       // return results;
       //return probs;
     //  return edge_coeffs;
     //  return triangle_coeffs;
     //    return ind_max;
       prueba_list.add(count_opera);
       prueba_list.add(probs);
       prueba_list.add(ind_max);
       prueba_list.add(edge_coeffs);
       prueba_list.add(triangle_coeffs);
       return prueba_list;
    }
    //public static double[]
    public static int[] ar_fit_ergm(GraphUndirec G, int coeff_samples, int graph_samples){
         GraphUndirec [] graphs = new GraphUndirec [graph_samples];
         GraphUndirec [] graphs_cero = new GraphUndirec [graph_samples];
         double [] edge_coeffs = new double [coeff_samples];
         double [] triangle_coeffs = new double [coeff_samples];
         double [] probs = new double [coeff_samples];
         int [] results;
         results = new int[2];
         
        double ed_coeff, tr_coeff, s, Z, p, best_p, best_edcoef, best_trcoef, max;
        double edcero, trcero, Zcero, pcero;
        int ind_max, count, count_opera;
        Random rand = new Random();
        
        edcero = -0.5;
       // trcero = rand.nextGaussian();
        trcero = 0.5;
        graphs_cero =ar_cero_MCMC(G, edcero, trcero, graph_samples);
        Zcero = ar_sum_weights(graphs_cero, edcero, trcero);
        pcero = graph_weight(G, edcero, trcero)/(Zcero);
        
        edge_coeffs[0] =edcero;
        triangle_coeffs[0] = trcero;
        probs[0] = pcero;
        count = 1;
        count_opera = 1;
         while(count < coeff_samples){
             s = Math.sqrt(1.2/count); //no estoy seguro de ese DOS
             ed_coeff = edge_coeffs[count-1] +(s*rand.nextGaussian());
             tr_coeff = triangle_coeffs[count-1]+(s*rand.nextGaussian());
             graphs = ar_cero_MCMC(G, ed_coeff, tr_coeff, graph_samples);
             Z = ar_sum_weights(graphs, ed_coeff, tr_coeff);
             p = graph_weight(G, ed_coeff, tr_coeff)/Z;
             count_opera += 1;
             if (p > probs[count-1] || Math.random() < (p/probs[count-1]) ){
                 edge_coeffs[count] = ed_coeff;
                 triangle_coeffs[count] = tr_coeff;
                 probs[count] = p;
                 count += 1;
             }
             
         }
          
         
         results[0] = count_opera;
         results[1] = count;
         return results;
         // max = Collections.max(Arrays.asList(probs));
         // max = Arrays.stream(probs).max().getAsDouble();
         // return edge_coeffs;
         
         
    }
    
    public static double[] arBubble_fit_ergm(GraphUndirec G, int coeff_samples, int graph_samples){
         double [] edge_coeffs = new double [coeff_samples];
         double [] triangle_coeffs = new double [coeff_samples];
         double [] probs = new double [coeff_samples];
         double [] results;
         results = new double[2];
        
         double ed_coeff, tr_coeff, s, Z, p, best_p, best_edcoef, best_trcoef, max;
         double edcero, trcero, Zcero, pcero;
         int ind_max, count, count_opera;
         Random rand = new Random();
         
         edcero = -0.5;
       // trcero = rand.nextGaussian();
         trcero = 0.5;
         
         pcero = arBubble_MCMC(G, edcero, trcero, graph_samples) ;
         edge_coeffs[0] =edcero;
         triangle_coeffs[0] = trcero;
         probs[0] = pcero;
         count = 1;
         count_opera = 1;
         
         while(count < coeff_samples){
             s = Math.sqrt(1.2/count); //no estoy seguro de ese DOS
             ed_coeff = edge_coeffs[count-1] +(s*rand.nextGaussian());
             tr_coeff = triangle_coeffs[count-1]+(s*rand.nextGaussian());
             p = arBubble_MCMC(G, ed_coeff, tr_coeff, graph_samples) ;
             if (p > probs[count-1] || Math.random() < (p/probs[count-1]) ){
                 edge_coeffs[count] = ed_coeff;
                 triangle_coeffs[count] = tr_coeff;
                 probs[count] = p;
                 count += 1;
             }
             
             
         }     
         
         //List<Double> list = Arrays.asList(probs);
         
         
         // max = Collections.max(Arrays.asList(probs));
         //max = Arrays.stream(probs).max().getAsDouble();
         
         // max = Collections.max(Arrays.asList(probs));
          max = Arrays.stream(probs).max().getAsDouble();
         
               
        int index  = Arrays.asList(probs).indexOf(max);
        
 
         return edge_coeffs;
//        return index;
//         
//         results[0] = edge_coeffs[index];
//         results[1] = triangle_coeffs[index];
//         return results;
         
        
        
    }
    
    
    
   // public static GraphUndirec[] MCMC(GraphUndirec G,double edge_coef, double triangle_coef, int n ){
     public static List <GraphUndirec> MCMC(GraphUndirec G,double edge_coef, double triangle_coef, int n ){
        int v;
        double p,current_w, new_w ;
        GraphUndirec current_graph, new_graph;
       // GraphUndirec[] graphs_list = new GraphUndirec[n];
       // int count;
       // count = 0;
                
        v = G.number_of_nodes();
        p = G.density_graph();
      //  current_graph = new Erdos_Renyi(v, p);
       current_graph = new GraphUndirec(v, p);
       // new_graph = new GraphUndirec(v);
       // current_graph = G.my_clone();
        current_w = graph_weight(current_graph, edge_coef, triangle_coef);
        List <GraphUndirec> graphs_list = new ArrayList<GraphUndirec>(n);
        while (graphs_list.size() < n){
     //   while (graphs_list.length < n){
           
            new_graph = current_graph.toggle_edge();            
            new_w = graph_weight(new_graph, edge_coef, triangle_coef);
            if ( (new_w>current_w) || ( Math.random() < (new_w/current_w) ) ){
                graphs_list.add(new_graph.my_clone());
       //         graphs_list.add(new_graph);                
            //    graphs_list[count] = new_graph;
                current_w = new_w;
             //FALTA ALGO ASI   current_graph = new_graph; ACTUALIZAR CURRENT_GRAPH
                current_graph = new_graph.my_clone();
            //    count += 1;
            }
            
        }
        
        return graphs_list;
    }
     
    public static List <GraphUndirec> cero_MCMC(GraphUndirec G,double edge_coef, double triangle_coef, int n ){
        int v;
        double p,current_w, new_w ;
        GraphUndirec current_graph, new_graph;
                
        v = G.number_of_nodes();
        p = G.density_graph();
       // current_graph = new Erdos_Renyi(v, p);
        current_graph = new GraphUndirec(v, p);
       // new_graph = new GraphUndirec(v);
       // current_graph = G.my_clone();
        current_w = graph_weight(current_graph, edge_coef, triangle_coef);
        List <GraphUndirec> graphs_list = new ArrayList<GraphUndirec>();
        graphs_list.add(current_graph);
    //AUTOMATICAMENTE ME GENER LISTA DE ADYACENCIA FALTANTE EN CONSTRUCTOR   
       // graphs_list.add(current_graph.my_clone());
        while (graphs_list.size() < n){
           
          //  new_graph = graphs_list.get(graphs_list.size()-1).my_clone().toggle_edge();
            new_graph = graphs_list.get(graphs_list.size()-1).toggle_edge();
            new_w = graph_weight(new_graph, edge_coef, triangle_coef);
            if ( (new_w>current_w) || ( Math.random() < (new_w/current_w) ) ){
                graphs_list.add(new_graph.my_clone());
       //         graphs_list.add(new_graph);                
            //    graphs_list[count] = new_graph;
                current_w = new_w;
             //FALTA ALGO ASI   current_graph = new_graph; ACTUALIZAR CURRENT_GRAPH
             //   current_graph = new_graph.my_clone();
            //    count += 1;
            }
            
        }
        
        return graphs_list;
    }
    
    public static GraphUndirec [] ar_cero_MCMC(GraphUndirec G,double edge_coef, double triangle_coef, int n){
        int v;
        double p,current_w, new_w ;
        GraphUndirec current_graph, new_graph;
        
        v = G.number_of_nodes();
        p = G.density_graph();
       // current_graph = new Erdos_Renyi(v, p);
        current_graph = new GraphUndirec(v, p); 
        current_w = graph_weight(current_graph, edge_coef, triangle_coef);
        GraphUndirec [] graphs_list = new GraphUndirec [n];
        graphs_list[0] = current_graph;
        int count = 1; // UNO PORQUE YA TIENE EL CURRENT_GRAPH
        while (count < n){
           // new_graph = graphs_list[count-1].my_clone().toggle_edge();
            new_graph = graphs_list[count-1].toggle_edge();
            new_w = graph_weight(new_graph, edge_coef, triangle_coef);
            if ( (new_w>current_w) || ( Math.random() < (new_w/current_w) ) ){
                graphs_list[count] = new_graph.my_clone();
                current_w = new_w;
                count += 1;
            }
        }
        
        
        
        return graphs_list;
    }
    
    public static double arBubble_MCMC(GraphUndirec G,double edge_coef, double triangle_coef, int n){
         int v;
        double p,current_w, new_w ;
        GraphUndirec current_graph, new_graph, aux_graph, copia;
        double [] weights = new double [n];
        
        v = G.number_of_nodes();
        p = G.density_graph();
       // current_graph = new Erdos_Renyi(v, p);
        current_graph = new GraphUndirec(v, p); 
        current_w = graph_weight(current_graph, edge_coef, triangle_coef);
        int count = 0; // 
        while (count < n) {
            aux_graph = current_graph.toggle_edge(); //crea uno nuevo y ademas hace toggle
            new_w = graph_weight(aux_graph, edge_coef, triangle_coef);
            if ( (new_w>current_w) || ( Math.random() < (new_w/current_w) ) ){
                current_graph = aux_graph.my_clone();
                current_w = graph_weight(current_graph, edge_coef, triangle_coef );
              //  weights[count] = graph_weight(current_graph, edge_coef, triangle_coef );
                weights[count] = current_w ;
                count += 1;
            }
            
        }
        
        p = graph_weight(G, edge_coef, triangle_coef)/suma_lista(weights);
        
        return p;
        
    }
    
    public static double suma_lista(double [] list){
        double total;
        total = 0.0;
        
        for (int i=0; i< list.length; i++){
            total += list[i];
        }
          return total;
        
        
    }
     
    public static List <GraphUndirec> pru_arrayli(){
        //FALTA PROBAR CUANTAS MATRICES DE TAMAÑO GRANDE 
        //PUEDE SOPORTAR EL ARRAYLIST
        //FALTA PROBAR GRAFO = GRAFO.TOGGGLE()
        // ES DECIR DESTRUIR EL OBJETO EN Y RENOVARLO EN EL MISMO PASO
        GraphUndirec graph, new_graph;
     //   Erdos_Renyi  graph;
        int n, iteraciones;
        n = 108;
        iteraciones = 5000;
        List <GraphUndirec> graphs_list = new ArrayList<GraphUndirec>();
    //    new_graph = new GraphUndirec(n);
    //    graph = new Erdos_Renyi(n, 0.01);
        graph = new GraphUndirec(n);
       // graphs_list.add(graph.my_clone());
        while (graphs_list.size() < iteraciones){
            graph = graph.toggle_edge();
            graphs_list.add(graph.my_clone());
           // graph = new_graph.my_clone();
        }
        return graphs_list;
        
    }  
    
    public static double sum_weights(List <GraphUndirec> graphs, double edge_coef, double triangle_coef ){
        double total;
        total = 0.0;
        for(GraphUndirec g : graphs){
            total += graph_weight(g, edge_coef, triangle_coef);
        }
        
        return total;
        
    }
    
    public static double ar_sum_weights(GraphUndirec [] graphs,double edge_coef, double triangle_coef ){
        double total;
        total = 0.0;
        for (int i=0; i< graphs.length; i++){
            total += graph_weight(graphs[i], edge_coef, triangle_coef);
        }
          return total;
    }
    
    public static double graph_weight(GraphUndirec G, double edge_coef, double triangle_coef ) {
    
        int edge_num, triangle_num;
        
        edge_num = G.edges_graph();
        triangle_num = G.triangles_graph();
        return Math.exp(edge_num * edge_coef + triangle_num * triangle_coef );
       //return Math.exp((-1)*(edge_num * edge_coef + triangle_num * triangle_coef) );
        
    }
    
    public static int edges_graph(int[][] admatriz){
        int edges = 0;
 //       int filas = admatriz.length();
        int filas = 108;
        for (int i =0; i< filas; i++){
            for (int j=0; j< filas; j++){
                if ( j>i){
                   edges += admatriz[i][j]; 
                }
                
            }
        }
        
        return edges;
    }
    
    public static int[][] read_matrix(File file, int actors) throws Exception{
        Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
        int [][] myArray = new int[actors][actors];
    //    Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
      while (sc.hasNextLine()) {
        
    
         for (int i =0; i< actors; i++){
            
             String[] line = sc.nextLine().trim().split(" ");
             for (int j=0; j< actors; j++){
               
                myArray[i][j] = Integer.parseInt(line[j]);
             }
         }
      }
      
      return myArray;
        
    }
    
    public static void print_matrix_file(int[][] matriz, File output, int actors) {
        
        try{
            PrintWriter out
                    = new PrintWriter(new BufferedWriter(new FileWriter(output)));
            for (int i =0; i< actors; i++){
                ArrayList<Integer> innerList = new ArrayList<Integer>();
                for (int j=0; j < actors; j++){
                  innerList.add(matriz[i][j]);
                }
                out.println(innerList);
  //              innerList.clear();
  //              pline.add(innerList);
              //    innerList.clear();
                              
            }
            
//            for (ArrayList<Integer> s: pline ) {
//                out.println(s);
//            }
            out.close();
        }catch (IOException ex) {
            Logger.getLogger(Artificial_graphs_MCMC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//    public static void toggleEdges(GraphUndirec G){
//        double d =G.density_graph();
//        
//        
//    }
    
    
}
