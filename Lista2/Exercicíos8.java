public class Exercicios {
    public static void main(String[] args) {
        int[] numeros = {2, 4, 6, 8, 10};
        int multiplicador = 3;

        System.out.println("Antes:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] *= multiplicador;
        }

        System.out.println("\nDepois:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }
}
