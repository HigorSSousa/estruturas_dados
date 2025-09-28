public class Exercicio {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {10, 20, 30, 40, 50};
        int[] resultado = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            resultado[i] = a[i] * b[i];
        }

        System.out.println("Resultado da multiplicação:");
        for (int r : resultado) System.out.print(r + " ");
    }
}
