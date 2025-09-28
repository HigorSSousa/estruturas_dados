import java.util.Arrays;

public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {50, 10, 30, 20, 40};

        Arrays.sort(numeros);

        System.out.println("Array em ordem crescente:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }
}
