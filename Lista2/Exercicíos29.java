import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite N: ");
        int N = sc.nextInt();

        int[] lucas = new int[N];
        if (N > 0) lucas[0] = 2;
        if (N > 1) lucas[1] = 1;

        for (int i = 2; i < N; i++) {
            lucas[i] = lucas[i - 1] + lucas[i - 2];
        }

        System.out.println("Sequência de Lucas:");
        for (int l : lucas) System.out.print(l + " ");
        sc.close();
    }
}

