# Codificação de Huffman

 ### Estrutura de Dados Básicas II - IMD - UFRN - 2019.2

 *Alunos:*
  Erickson Moura de Lima | Márcio Tenório Júnior
 
 ***Como Comprimir:***
 
 > java -jav projeto.jar compress <local do aquivo de texto> <local e novo nome para aquivo binario> <local e novo nome para arquivo de chave>
  
 >*Exemplo: $java -jav huffman.jar compress "../huffman_algorithm/Testes/teste1.txt" "../huffman_algorithm/Out/codigo1.edz" "../huffman_algorithm/Out/chave/chave1.edt"*

***Como Descomprimir:***
 
 > java -jav projeto.jar compress <local aquivo binario> <local arquivo de chave> <local e novo nome aquivo de texto>
  
 >*Exemplo: $java -jav huffman.jar extract "../huffman_algorithm/Out/codigo1.edt" "../huffman_algorithm/Out/chave/chave1.edz" "../huffman_algorithm/Testes/TestesFeitos/testeC.txt"* 

  




