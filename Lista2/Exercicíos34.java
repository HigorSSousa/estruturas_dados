import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40};
        int posicao = 2;
        int novoElemento = 99;

        System.out.println("Antes: " + Arrays.toString(numeros));

        int[] novoArray = new int[numeros.length + 1];
        for (int i = 0, j = 0; i < novoArray.length; i++) {
            if (i == posicao) {
                novoArray[i] = novoElemento;
            } else {
                novoArray[i] = numeros[j++];
            }
        }

        System.out.println("Depois: " + Arrays.toString(novoArray));
    }
}
