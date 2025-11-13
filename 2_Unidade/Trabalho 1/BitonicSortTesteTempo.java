import java.util.Random;

public class BitonicSortTesteTempo {

    public static void bitonicSort(int[] array, boolean ascending) {
        int n = array.length;
        bitonicSortRecursive(array, 0, n, ascending);
    }

    // Função recursiva que cria e ordena a sequência bitônica
    private static void bitonicSortRecursive(int[] array, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;

            // Cria duas metades: uma crescente e outra decrescente
            bitonicSortRecursive(array, low, k, true);
            bitonicSortRecursive(array, low + k, k, false);

            // Mescla as duas metades na direção desejada
            bitonicMerge(array, low, count, ascending);
        }
    }

    // Mescla uma sequência bitônica em ordem crescente ou decrescente
    private static void bitonicMerge(int[] array, int low, int count, boolean ascending) {
        if (count > 1) {
            int k = count / 2;
            for (int i = low; i < low + k; i++) {
                if (ascending == (array[i] > array[i + k])) {
                    int temp = array[i];
                    array[i] = array[i + k];
                    array[i + k] = temp;
                }
            }
            bitonicMerge(array, low, k, ascending);
            bitonicMerge(array, low + k, k, ascending);
        }
    }

    // Gera um vetor aleatório de inteiros
    public static int[] generateRandomArray(int size, Random rnd) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(10000); // valores entre 0 e 9999
        }
        return array;
    }

    // Copia um vetor
    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }

    // Verifica se o número é potência de 2
    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }

    // Teste de tempo médio do Bitonic Sort
    public static void main(String[] args) {

        // Tamanhos devem ser potências de 2 (2, 4, 8, 16, 32, 64, ...)
        int[] sizes = {8, 16, 32, 64, 128, 256, 512, 1024};
        int repetitions = 10;

        System.out.println("===== TESTE DE TEMPO DO BITONIC SORT =====\n");

        Random rnd = new Random(12345);

        // Aquecimento (para estabilizar o JIT do Java)
        for (int w = 0; w < 5; w++) {
            int[] warm = generateRandomArray(256, rnd);
            bitonicSort(warm, true);
        }

        // Teste real
        for (int size : sizes) {
            if (!isPowerOfTwo(size)) {
                System.out.println("Ignorando tamanho " + size + " (não é potência de 2)");
                continue;
            }

            System.out.println("Tamanho do vetor: " + size);

            int[] baseArray = generateRandomArray(size, rnd);
            long totalTime = 0;

            for (int i = 0; i < repetitions; i++) {
                int[] testArray = copyArray(baseArray);

                long startTime = System.nanoTime();
                bitonicSort(testArray, true); // crescente
                long endTime = System.nanoTime();

                totalTime += (endTime - startTime);
            }

            double averageTimeNs = (double) totalTime / repetitions;
            double averageTimeMs = averageTimeNs / 1_000_000.0;

            System.out.printf("Tempo médio: %.6f ms (%d repetições)\n\n", averageTimeMs, repetitions);
        }
    }
}
