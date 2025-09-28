28import java.util.Scanner;

public class Exercicio  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite N: ");
        int N = sc.nextInt();

        int[] fib = new int[N];
        if (N > 0) fib[0] = 0;
        if (N > 1) fib[1] = 1;

        for (int i = 2; i < N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println("Fibonacci:");
        for (int f : fib) System.out.print(f + " ");
        sc.close();
    }
}
