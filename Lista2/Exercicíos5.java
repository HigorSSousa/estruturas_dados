public class Ex5 {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 5, 30, 25};

        int maior = Integer.MIN_VALUE;
        int segundoMaior = Integer.MIN_VALUE;

        for (int n : numeros) {
            if (n > maior) {
                segundoMaior = maior;
                maior = n;
            } else if (n > segundoMaior && n < maior) {
                segundoMaior = n;
            }
        }

        System.out.println("Segundo maior: " + segundoMaior);
    }
}
