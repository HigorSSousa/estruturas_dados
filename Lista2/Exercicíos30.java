import java.util.LinkedHashSet;

public class Exercicio  {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 2, 3, 4, 4, 5, 1};

        LinkedHashSet<Integer> conjunto = new LinkedHashSet<>();
        for (int n : numeros) {
            conjunto.add(n);
        }

        System.out.println("Array sem repetidos: " + conjunto);
    }
}
