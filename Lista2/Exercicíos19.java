public class Exercicio {
    public static void main(String[] args) {
        String[] nomes = {"Ana", "Bia", "Carlos", "Davi"};
        
        System.out.println("Antes:");
        for (String nome : nomes) System.out.print(nome + " ");

        
        for (int i = 0; i < nomes.length / 2; i++) {
            String temp = nomes[i];
            nomes[i] = nomes[nomes.length - 1 - i];
            nomes[nomes.length - 1 - i] = temp;
        }

        System.out.println("\nDepois:");
        for (String nome : nomes) System.out.print(nome + " ");
    }
}
