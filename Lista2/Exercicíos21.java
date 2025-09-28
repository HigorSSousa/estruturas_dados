public class Exercicio {
    public static void main(String[] args) {
        char[] letras = {'a', 'b', 'c', 'e', 'i', 'o', 'u', 'x'};

        System.out.println("Antes:");
        for (char c : letras) System.out.print(c + " ");

        for (int i = 0; i < letras.length; i++) {
            if ("aeiouAEIOU".indexOf(letras[i]) != -1) {
                letras[i] = '*';
            }
        }

        System.out.println("\nDepois:");
        for (char c : letras) System.out.print(c + " ");
    }
}
