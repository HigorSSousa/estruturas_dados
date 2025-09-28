import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = {10, 20, 30, 40, 50};

        System.out.print("Digite a posição: ");
        int pos = sc.nextInt();

        System.out.print("Digite o novo elemento: ");
        int elem = sc.nextInt();

        if (pos >= 0 && pos < numeros.length) {
            numeros[pos] = elem;
        } else {
            System.out.println("Posição inválida!");
        }

        System.out.println("Array atualizado:");
        for (int n : numeros) System.out.print(n + " ");

        sc.close();
    }
}
