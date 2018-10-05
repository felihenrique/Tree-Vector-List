package treelist;

import java.util.*;

/**
 *
 * @authors Thyago, Jessiele, Philipe e Fernando.
 *
 * Essa classe implementa uma árvore genérica usando uma lista linear de nós.
 * Cada nó usa internamente uma lista encadeada para armazenar seus filhos.
 */
public class TreeList<T> {

    ArrayList< Node<T>> nodes;
    Stack<Integer> emptySlots;

    /**
     * Construtor
     */
    public TreeList() {
        this.nodes = new ArrayList<>();
        this.emptySlots = new Stack<>();
    }

    /**
     * Busca por um valor na árvore
     *
     * @param data O valor a ser buscado
     * @return Uma lista de nós que tem o valor buscado
     */
    public ArrayList< Node<T>> searchNode(T data) {
        ArrayList< Node<T>> found = new ArrayList<>();
        for (Node<T> no : nodes) {
            if (no.getData() == data) {
                found.add(no);
            }
        }
        return found;
    }

    /**
     * Adiciona um nó na árvore
     *
     * @param node O nó a ser adicionado
     * @param paren O pai do nó
     */
    public void addNode(Node<T> node, Node<T> paren) {
        if (paren != null) {
            paren.addChild(node);
        }
        if (emptySlots.empty()) {
            nodes.add(node);
            node.index = nodes.size() - 1;
        } else {
            int slot = emptySlots.pop();
            nodes.set(slot, node);
            node.index = slot;
        }
        node.tree = this;
    }
    /**
     * Adiciona um nó na árvore
     * @param value O valor a ser adicionado.
     * @param paren O nó pai
     */
    public void addNode(T value, Node<T> paren) {
        Node<T> node = new Node<>(value);
        this.addNode(node, paren);
    }

    /**
     * Remove um nó da árvore
     * @param no 
     */
    public void removeNode(Node<T> no) {
        if (no.index == 0) {
            nodes.clear();
            emptySlots.clear();
            return;
        }

        while (!no.ifLeaf()) {
            removeNode(no.getChildren().get(no.getChildren().size() - 1));
        }
        no.getParent().getChildren().remove(no);
        removeLeaf(no.index);
        no.clear();
    }

    private void removeLeaf(int index) {
        emptySlots.add(index);
        nodes.set(index, null);

    }
    
    /**
     * Retorna a altura da árvore
     * @return 
     */
    public int getHeight() {
        int maior = 0;
        for (Node<T> no : nodes) {
            if (no.getDepth() > maior) {
                maior = no.getDepth();
            }
        }
        return maior;
    }

    /**
     * Retorna o nó raiz da árvore
     *
     * @return O nó raiz
     */
    public Node<T> getRoot() {
        return nodes.size() > 0 ? nodes.get(0) : null;
    }
    
    public Node<T> bffSearch(T value) {
        if(getRoot().getData() == value) {
            return getRoot();
        }
        return this.bffSearchAuxiliar(getRoot().getChildren(), value);
    }
    
    private Node<T> bffSearchAuxiliar(List<Node<T>> list, T data) {
        if(list.isEmpty()) {
            return null;
        }
        ArrayList<Node<T>> currentList = new ArrayList<>();
        for(Node<T> node : list) {
            if(node.getData() == data) {
                return node;
            }
            currentList.addAll(node.getChildren());
        }
        return bffSearchAuxiliar(currentList, data);
    }

    // Saber descendentes
    // Buscar descendentes
}
