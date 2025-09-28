public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        int valor = 30;
        boolean encontrado = false;

        for (int n : numeros) {
            if (n == valor) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Valor " + valor + " encontrado no array.");
        } else {
            System.out.println("Valor " + valor + " NÃO está no array.");
        }
    }
}
