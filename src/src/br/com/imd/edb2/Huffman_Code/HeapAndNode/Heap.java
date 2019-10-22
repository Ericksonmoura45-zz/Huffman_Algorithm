package br.com.imd.edb2.Huffman_Code.HeapAndNode;
import java.util.Arrays;


public class Heap {
    private Node[] node;
    private int tamanho;
    private int capacidade;

    public Heap() {
        this.capacidade = 0;
        this.tamanho = 0;
        node = new Node[capacidade];
    }

    public void insert(Node no) {
        GCapacidade();
        node[getTamanho()] = no;
        heapifyUp(getTamanho());
        tamanho++;
    }

    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 0) {
            return;
        }

        Node root = node[parentIndex];
        Node no = node[index];

        if (no.getQuantity() < root.getQuantity()) {
            node[index] = root;
            node[parentIndex] = no;
            heapifyUp(parentIndex);
        }
    }

    public int getParentIndex(int index) {

        return (int) Math.floor((index - 1) / 2);
    }

    private void GCapacidade() {
        if (tamanho == capacidade) {
            node = Arrays.copyOf(node, capacidade * 2);
            capacidade = capacidade * 2;
        }
    }

    public int getTamanho() {

        return tamanho;
    }

    public Node peek() {
        if (getTamanho() == 0) {
            return null;
        }
        return node[0];
    }

    public void remove() {
        node[0] = node[getTamanho() - 1];
        node[getTamanho() - 1] = null;
        tamanho--;
        heapifyDown(0);
    }

    private void heapifyDown(int index) {
        int filhoEsquerdo = index * 2 + 1;
        int filhoDireito = index * 2 + 2;

        int childIndex = -1;
        if (filhoEsquerdo < getTamanho()) {
            childIndex = filhoEsquerdo;
        }

        if (childIndex == -1) {
            return;
        }

        if (filhoDireito < getTamanho()) {
            if (node[filhoDireito].getQuantidade() < node[filhoEsquerdo].getQuantidade()) {
                childIndex = filhoDireito;
            }
        }

        if (node[index].getQuantidade() > node[childIndex].getQuantidade()) {
            Node temp = node[index];
            node[index] = node[childIndex];
            node[childIndex] = temp;
            heapifyDown(childIndex);
        }
    }
}
