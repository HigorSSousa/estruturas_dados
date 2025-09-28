public class Exercicios {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int cont = 0;

        for (int n : numeros) {
            if (n % 2 == 0) cont++;
        }

        System.out.println("Quantidade de números pares = " + cont);
    }
}
