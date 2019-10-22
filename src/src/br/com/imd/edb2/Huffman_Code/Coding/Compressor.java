package br.com.imd.edb2.Huffman_Code.Coding;


import br.com.imd.edb2.nataly.datesStructure.Heap;
import br.com.imd.edb2.nataly.datesStructure.Node;

import java.io.*;
import java.util.*;

public class Compressor {

    private Heap heap = new Heap();
    private static String tabelaCodigo = "";
    private boolean key = true;
    private Map <Character, String> bin = new HashMap<>();
    private Map <Integer, Integer> map = new HashMap<>();
    private Node tree = new Node();
    private String texto, palavras, dicionario;

    public Compressor(String texto, String palavras, String dicionario) {
        this.texto = texto;
        this.palavras = palavras;
        this.dicionario = dicionario;
    }

    public void criaDicionario() {

        try {
            FileInputStream meta = new FileInputStream(texto);

            BufferedInputStream reader = new BufferedInputStream(meta);

            byte line[] = reader.readAllBytes();
            String file = new String(line, "UTF8");

            for (int i = 0; i < file.length(); i++) {
                if (map.containsKey((int) file.charAt(i))) {
                    int value = (map.get((int) file.charAt(i))) + 1;
                    map.put((int) file.charAt(i), value);
                } 
                else {
                    map.put((int) file.charAt(i), 1);
                }
            }

        } 
        catch (IOException e) {
            System.out.println("Invalid param" + e.getMessage());
        }


        for (Integer i : map.keySet()) {
            Node no = new Node(i, map.get(i));
            heap.insert(no);
        }

        do {
            if (heap.getSize() == 1) {
                key = false;
                break;
            }
            Node left = heap.peek();
            heap.remove();
            
            Node direita = heap.peek();
            heap.remove();
            tree = new Node(esquerda.getQuantidade() + direita.getQuantidade(), left, direita);
            
            heap.insert(tree);

        } while (heap.getSize() > 1);

    }


    public void criaTabela() throws IOException { // Responsável Por criar a(s) tabela(s)

        String bit[] = retornaBinario(tree, key);

        FileWriter tabelaCodigo = new FileWriter(dicionario);

        for (int i = 0; i < bit.length;) {
            tabelaCodigo.write((char) Integer.parseInt(bit[i]) + String.valueOf((char) 351) + bit[i + 1] + String.valueOf((char)351));
            bin.put((char) Integer.parseInt(bit[i]), bit[i + 1]);
            i += 2;
        }
        tabelaCodigo.close();


    }


    public void CodificaTexto() throws IOException {  // Responsável por codificar o texto
        
        FileOutputStream nome = new FileOutputStream(palavras);
        FileInputStream arquivo = new FileInputStream(texto);
        BufferedInputStream leitor = new BufferedInputStream(arquivo);

        int cont = 0;

        BitSet bitSet = new BitSet();

        byte text[] = leitor.readAllBytes();
        String file = new String(text, "UTF8");

        for (int i = 0; i < file.length(); i++) {

            if (bin.containsKey(file.charAt(i))) {
                for (int j = 0; j < bin.get(file.charAt(i)).length(); j++) {
                    if (bin.get(file.charAt(i)).charAt(j) == '1') {
                        bitSet.set(cont);
                    } 
                    else {
                        bitSet.set(cont, false);
                    }
                    cont += 1;
                }
            }

        }


        int rest = 0;

        if (cont % 8 == 0) {
            nome.write(bitSet.toByteArray());
            nome.close();
            arquivo.close();
        }
        else {
            rest = (int) ((1 - (((float) cont / 8) - (cont / 8))) * 8);
            for (int i = 0; i < rest; i++) {
                bitSet.set(cont , false);
                cont += 1;

            }
            nome.write(bitSet.toByteArray());
            nome.close();
            arquivo.close();
        }
    }

    public static String[] retornaBinario(Node no, boolean key) {

            tabelaCodigo = retornaBinario(no, "");
            return tabelaCodigo.split(" ");


    }

    private static String retornaBinario(Node no, String codigo) {
        if (no.getLeft() == no.getRight()) {
            tabelaCodigo += no.getCharacter() + " " + codigo + " " ;
            return tabelaCodigo;
        }
        else {
            retornaBinario(no.getRight(), codigo + "1");
            retornaBinario(no.getLeft(), codigo + "0");
        }
        return tabelaCodigo;

    }

}
