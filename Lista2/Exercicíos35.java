import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        int posicao = 2; 

        System.out.println("Antes: " + Arrays.toString(numeros));

        int[] novoArray = new int[numeros.length - 1];
        for (int i = 0, j = 0; i < numeros.length; i++) {
            if (i != posicao) {
                novoArray[j++] = numeros[i];
            }
        }

        System.out.println("Depois: " + Arrays.toString(novoArray));
    }
}
