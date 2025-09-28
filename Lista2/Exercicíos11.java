public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        int soma = 0;

        for (int n : numeros) {
            soma += n;
        }

        double media = (double) soma / numeros.length;
        System.out.println("Média = " + media);
    }
}
