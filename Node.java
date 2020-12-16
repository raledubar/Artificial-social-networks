/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_ergm_java;

/**
 *
 * @author raulduarte
 */
public class Node {
    
   private int id;
   private String atribute;
   
    Node(int id, String atribute ){
        this.id = id;
        this.atribute = atribute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtribute() {
        return atribute;
    }

    public void setAtribute(String atribute) {
        this.atribute = atribute;
    }
    
    
    
    
}
