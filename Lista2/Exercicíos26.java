import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite N: ");
        int N = sc.nextInt();
        int[] primos = new int[N];

        int count = 0, num = 2;
        while (count < N) {
            if (ehPrimo(num)) {
                primos[count] = num;
                count++;
            }
            num++;
        }

        System.out.println("Primeiros " + N + " primos:");
        for (int p : primos) System.out.print(p + " ");
        sc.close();
    }

    static boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
