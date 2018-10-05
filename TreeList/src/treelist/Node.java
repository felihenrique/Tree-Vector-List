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
 * @param <T>
 */
public class Node<T> {
    private T data;
    private List<Node<T>> children;
    private int depth;
    private Node<T> parent;
    
    Integer index;
    TreeList tree;
    
    /**
     * Cria um nó
     * @param data O valor do nó
     */
    public Node(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    void addChild(Node<T> child) {
        child.parent = this;
        child.depth = this.depth + 1;
        this.children.add(child);
    }
    
    void clear() {
        depth = 0;
        children.clear();
        parent = null;
        index = null;
    }

    /**
     * Retorna a lista de filhos.
     * @return 
     */
    public List<Node<T>> getChildren() {
        return children;
    }
    
    /**
     * Calcula e retorna o caminho para a raiz
     * @return 
     */
    public ArrayList<Node<T>> getRootPath() {
        ArrayList<Node<T>> path = new ArrayList<>();
        Node<T> actual = this;
        while(actual.parent != null) {
            path.add(actual);
            actual = actual.parent;
        }
        return path;
    }

    /**
     * Retorna o dado do nó
     * @return 
     */
    public T getData() {
        return data;
    }

    /**
     * Modifica o dado do nó
     * @param data O novo dado
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Retorna o nó pai
     * @return 
     */
    public Node<T> getParent() {
        return parent;
    }    
    
    /**
     * Retorna a profundidade do nó na árvore.
     * @return 
     */
    public int getDepth() {
        return depth;
    }
    
    /**
     * Verifica se o nó é filho de outro nó
     * @param father Nó pai para ser verificado
     * @return 
     */
    public boolean isChildOf(Node<T> father) {
        return parent == father;
    }
    
    /**
     * Verifica se o nó é folha.
     * @return 
     */
    public boolean ifLeaf() {
        return children.isEmpty();
    }

    @Override
    public String toString() {
        return "Dado: " + data.toString();
    }
    
    
}



