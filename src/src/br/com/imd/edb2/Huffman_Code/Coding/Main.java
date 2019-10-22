package br.com.imd.edb2.Huffman_Code.Coding;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // para comprimir: java -jav projeto.jar compress "local do aquivo de texto" "local e novo nome para aquivo binario" "local e novo nome para arquivo de chave"
        if (args[0].equals("ComprimirArquivo")) {
            Compressor compressor = new Compressor(args[1], args[2], args[3]);
            compressor.criaDicionario();
            compressor.criaTabela();
            compressor.codificaTexto();

        }
        // para extract: java -jav projeto.jar compress "local aquivo binario" "local arquivo de chave" "local e novo nome aquivo de texto"
        else if (args[0].equals("DescomprimirArquivo")) {
            Descompressor descompressor = new Descompressor(args[1], args[2], args[3]);
            descompressor.pegaTabela();
            descompressor.decodificaTexto();
        }

    }
}
