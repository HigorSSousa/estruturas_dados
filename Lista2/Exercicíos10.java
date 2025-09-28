public class Ex10 {
    public static void main(String[] args) {
        int[] numeros = {10, -5, 20, -7, 30};

        System.out.println("Antes:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < 0) numeros[i] = 0;
        }

        System.out.println("\nDepois:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }
}
