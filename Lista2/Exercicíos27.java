import java.util.Scanner;
import java.util.ArrayList;

public class Exercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite N: ");
        int N = sc.nextInt();

        ArrayList<Integer> perfeitos = new ArrayList<>();

        for (int i = 2; i < N; i++) {
            if (ehPerfeito(i)) {
                perfeitos.add(i);
            }
        }

        System.out.println("Números perfeitos menores que " + N + ": " + perfeitos);
        sc.close();
    }

    static boolean ehPerfeito(int n) {
        int soma = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) soma += i;
        }
        return soma == n;
    }
}
