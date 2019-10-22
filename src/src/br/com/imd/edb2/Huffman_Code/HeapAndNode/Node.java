package br.com.imd.edb2.Huffman_Code.HeapAndNode;

public class Node {

    private Integer caracter;
    private Integer quantidade;
    private Node esquerda;
    private Node direita;

    public Node() {
        this.esquerda = null;
        this.direita = null;
    }

    public Node(Integer cas, Integer sas) {
        this.caracter = cas;
        this.quantidade = sas;
        this.esquerda = null;
        this.direita = null;
    }

    public Node(Integer aux, Node esquerda, Node direita) {
        this.quantidade = aux;
        this.esquerda = esquerda;
        this.direita = direita;

    }

    public Integer getCaracter() {
        return caracter;
    }

    public void setCaracter(Integer caracter) {
        this.caracter = caracter;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }
}