/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treelist;

import java.util.*;

/**
 *
 * @author fernando
 */
public class TreeList<T> {
    ArrayList< Node<T> > nodes;
    
    public TreeList() {
        this.nodes = new ArrayList<>();
    }
    
    public ArrayList< Node<T> > searchNode(T data){
        ArrayList< Node<T> > found = null;
        for(Node<T> no : nodes) {
            if(no.getData() == data) {
               found.add(no);
            }
        }
        return found;
    }
    
    
    public void addNode(Node<T> no, T parent){
        int i = 1;
        ArrayList< Node<T> > possibleParents = searchNode(parent);
        if(possibleParents.isEmpty()) {
            System.out.println("Parent not found!");
        } else {
            for(Node<T> no : possibleParents) {
                System.out.println(i + " data " + no.getData() + "\nParent: " + no.getParent());
                i++;
            }
            System.out.println("Choose the parent: ");
            Scanner readParent = new Scanner(System.in);
            nodes.add(possibleParents.hashCode(readParent.nextInt()-1));
            
        }
                
    }
    
    //public void removeNode(Node<T> no){
        
    //}

    
    //public getRoot(){}
    
    //public getHeight(){}
    
    //public addNode(Node<T> no){}
    
    //public removeNode(Node<T> no){}
    
    //public searchNode(Node<T> no){}
    
    // Saber descendentes
    // Buscar descendentes
    
    
    
    public static void main(String[] args) {
        
    }

    private void foreach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
