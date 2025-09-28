public class Exercicio {
    public static void main(String[] args) {
        int[] origem = {1, 2, 3, 4, 5};
        int[] copia = new int[origem.length];

        for (int i = 0; i < origem.length; i++) {
            copia[i] = origem[i];
        }

        System.out.println("Array original:");
        for (int n : origem) System.out.print(n + " ");

        System.out.println("\nArray copiado:");
        for (int n : copia) System.out.print(n + " ");
    }
}
