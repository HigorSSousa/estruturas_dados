public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50, 30};
        int valor = 30;
        int indice = -1;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == valor) {
                indice = i;
                break;
            }
        }

        System.out.println("Índice da primeira ocorrência: " + indice);
    }
}
