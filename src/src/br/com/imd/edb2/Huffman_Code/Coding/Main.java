package br.com.imd.edb2.Huffman_Code.Coding;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        if (args[0].equals("compress")) {
            Compressor compressor = new Compressor(args[1], args[2], args[3]);
            compressor.criaDicionario();
            compressor.criaTabela();
            compressor.codificaTexto();

        }
        else if (args[0].equals("extract")) {
            Descompressor descompressor = new Descompressor(args[1], args[2], args[3]);
            descompressor.pegaTabela();
            descompressor.decodificaTexto();
        }

    }
}
