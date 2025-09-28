public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50, 60};
        int soma = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (i % 2 == 0) {
                soma += numeros[i];
            }
        }

        System.out.println("Soma nas posições pares = " + soma);
    }
}
