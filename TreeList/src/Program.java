/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import treelist.*;

/**
 *
 * @author felihenrique
 */
public class Program {
    public static void main(String[] args) {
        TreeList<Integer> tree = new TreeList<>();
        Node<Integer> node1 = new Node<>(10);
        Node<Integer> node2 = new Node<>(5);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(3);
        Node<Integer> node5 = new Node<>(9);
        Node<Integer> node6 = new Node<>(15);
        Node<Integer> node7 = new Node<>(15);
        
        tree.addNode(node1, null);
        tree.addNode(node2, node1);
        tree.addNode(node4, node2);
        tree.addNode(node5, node2);
        tree.addNode(node3, node1);
        tree.addNode(node6, node3);
        tree.addNode(node7, node2);
        
        Node<Integer> result1 = tree.bffSearch(15);
        Node<Integer> result2 = tree.bffSearch(10);
        Node<Integer> result3 = tree.bffSearch(100);
        Node<Integer> result4 = tree.bffSearch(9);
        
        System.out.println("teste");
        
    }
}
