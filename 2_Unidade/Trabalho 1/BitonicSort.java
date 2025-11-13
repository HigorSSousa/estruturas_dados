//Pseudocodigo
import java.util.Random;

public class BitonicSort {

    // Função principal que chama o bitonic sort
    public static void bitonicSort(int[] array, boolean ascending) {
        int n = array.length;
        bitonicSortRecursive(array, 0, n, ascending);
    }

    // Função recursiva que constrói uma sequência bitônica e a ordena
    private static void bitonicSortRecursive(int[] array, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;

            // Cria duas metades: uma crescente e outra decrescente
            bitonicSortRecursive(array, low, k, true);
            bitonicSortRecursive(array, low + k, k, false);

            // Combina as duas metades de forma ordenada
            bitonicMerge(array, low, count, ascending);
        }
    }

    // Combina (merge) uma sequência bitônica em ordem crescente ou decrescente
    private static void bitonicMerge(int[] array, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;

            // Compara e troca elementos conforme a direção (asc/desc)
            for (int i = low; i < low + k; i++) {
                if (ascending == (array[i] > array[i + k])) {
                    // troca se a direção exigir
                    int temp = array[i];
                    array[i] = array[i + k];
                    array[i + k] = temp;
                }
            }

            // Aplica o merge recursivamente em cada metade
            bitonicMerge(array, low, k, ascending);
            bitonicMerge(array, low + k, k, ascending);
        }
    }

    // Gera um vetor aleatório de inteiros
    public static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }

    // Exibe o vetor (limitado a um número de elementos)
    public static void printArray(int[] array, int limit) {
        for (int i = 0; i < Math.min(array.length, limit); i++) {
            System.out.print(array[i] + " ");
        }
        if (array.length > limit) System.out.print("...");
        System.out.println();
    }

    // Método principal para testar o Bitonic Sort
    public static void main(String[] args) {

        //O tamanho deve ser potência de 2 (2, 4, 8, 16, 32, ...)
        int[] sizes = {8, 16, 32};

        for (int size : sizes) {
            System.out.println("Tamanho do vetor: " + size);

            int[] array = generateRandomArray(size, 100);

            System.out.println("Antes da ordenação:");
            printArray(array, 16);

            // Ordena em ordem crescente
            bitonicSort(array, true);

            System.out.println("Depois da ordenação:");
            printArray(array, 16);
            System.out.println("---------------------------------------");
        }
    }
}
