package Tools;

public class ToCode {

    public String[] ToCodeValue = new String; // String a ser Analisada
    public int cont = 1; // contador
    private String[] Chracter = new String;  // Vetor para armazenar os caracteres não-repetidos
    private String[] Frequency = new String; // Vetor para armazenar a Frequência dos caracteres não-repetidos

    public String[] getChracter() {
        return Chracter;
    }

    public void setChracter(String[] chracter) {
        Chracter = chracter;
    }

    public String[] getFrequency() {
        return Frequency;
    }

    public void setFrequency(String[] frequency) {
        Frequency = frequency;
    }

    public count(String toCodeValue){
        for (int i = 0; i < ToCodeValue.length; i++){

            for (int k = 0; k < Chracter.length; k++){

                // Se já estiver, aumentaremos sua frequência em 1
                if(ToCodeValue[i] != Chracter[k]){  // Se o caractere não estiver na String auxiliar, será inserido
                    setChracter(Chracter[k] == ToCodeValue[i]);
                    setFrequency(Frequency[k] = cont);
                }
                else setFrequency(Frequency[k] = cont + 1);
            }

        }
    }






}
