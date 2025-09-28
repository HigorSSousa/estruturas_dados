import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30};
        int novoElemento = 40;

        System.out.println("Antes: " + Arrays.toString(numeros));

        int[] novoArray = Arrays.copyOf(numeros, numeros.length + 1);
        novoArray[novoArray.length - 1] = novoElemento;

        System.out.println("Depois: " + Arrays.toString(novoArray));
    }
}
