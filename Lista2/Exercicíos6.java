public class Execicios {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        int soma = 0;

        for (int n : numeros) {
            soma += n;
        }

        System.out.println("Soma dos elementos = " + soma);
    }
}
