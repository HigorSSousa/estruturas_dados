public class Exercicio {
    public static void main(String[] args) {
        char[] letras = {'a', 'b', 'c', 'e', 'i', 'o', 'u', 'x'};
        int cont = 0;

        for (char c : letras) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                cont++;
            }
        }

        System.out.println("Número de vogais = " + cont);
    }
}
