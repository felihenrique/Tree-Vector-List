/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
//package treelist;

/**
 *
 * @author fernando
 */
public class Node<T> {
    private T data = null;
 
    private List<Integer> children = new ArrayList<>();
       
    private int index;
    private int parent;
    private int depth;
    
    public Node(T data, int index, int parent) {
        this.data = data;
        this.index = index;
        this.parent = parent;
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child.index);
        //return child;
    }

//    public void addChildren(List<int> children) {
//        children.forEach(each -> each.setParent(this));
//        this.children.addAll(children);
//    }

    public List<Integer> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent.index;
        this.depth = parent.depth + 1;
    }

    public int getParent() {
        return parent;
    }    
    
    public int getDepth() {
        return depth;
    }
    
    public boolean isChildOf(Node<T> father) {
        return parent == father.index;
    }
}
