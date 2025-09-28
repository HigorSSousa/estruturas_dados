import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 7, 9, 11, 13, 15};
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o valor a buscar: ");
        int valor = sc.nextInt();

        int resultado = buscaBinaria(numeros, valor);

        System.out.println("Resultado da busca: " + resultado);
        sc.close();
    }

    static int buscaBinaria(int[] arr, int x) {
        int inicio = 0, fim = arr.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (arr[meio] == x) return meio;
            if (arr[meio] < x) inicio = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }
}
