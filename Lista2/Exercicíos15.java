import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class Exercício {
    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] numeros = new Integer[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(100); // valores aleatórios de 0 a 99
        }

        System.out.println("Antes:");
        for (int n : numeros) System.out.print(n + " ");

        Arrays.sort(numeros, Collections.reverseOrder());

        System.out.println("\nDepois (decrescente):");
        for (int n : numeros) System.out.print(n + " ");
    }
}
