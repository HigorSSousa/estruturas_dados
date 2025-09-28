public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};

        System.out.println("Antes:");
        for (int n : numeros) System.out.print(n + " ");

        int primeiro = numeros[0];
        for (int i = 0; i < numeros.length - 1; i++) {
            numeros[i] = numeros[i + 1];
        }
        numeros[numeros.length - 1] = primeiro;

        System.out.println("\nDepois (rotacionado à esquerda):");
        for (int n : numeros) System.out.print(n + " ");
    }
}
