package br.com.imd.edb2.Huffman_Code.HeapAndNode;
import java.util.Arrays;


public class Heap {
    private Node[] node;
    private int size;
    private int capacity;

    public Heap() {
        this.capacity = 10;
        this.size = 0;
        node = new Node[capacity];
    }

    public void insert(Node no) {
        ensureCapacity();
        node[getSize()] = no;
        heapifyUp(getSize());
        size++;
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

    private void ensureCapacity() {
        if (size == capacity) {
            node = Arrays.copyOf(node, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int getSize() {

        return size;
    }

    public Node peek() {
        if (getSize() == 0) {
            return null;
        }
        return node[0];
    }

    public void remove() {
        node[0] = node[getSize() - 1];
        node[getSize() - 1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;
        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex == -1) {
            return;
        }

        if (rightChild < getSize()) {
            if (node[rightChild].getQuantity() < node[leftChild].getQuantity()) {
                childIndex = rightChild;
            }
        }

        if (node[index].getQuantity() > node[childIndex].getQuantity()) {
            Node tmp = node[index];
            node[index] = node[childIndex];
            node[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }
}
