public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 2, 1};
        boolean palindromo = true;

        for (int i = 0; i < numeros.length / 2; i++) {
            if (numeros[i] != numeros[numeros.length - 1 - i]) {
                palindromo = false;
                break;
            }
        }

        if (palindromo) {
            System.out.println("O array é um palíndromo.");
        } else {
            System.out.println("O array NÃO é um palíndromo.");
        }
    }
}
