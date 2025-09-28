import java.util.ArrayList;

public class Exercicio {
    public static void main(String[] args) {
        String[] palavras = {"java", "c", "python", "java", "c++", "java"};
        String remover = "java";

        ArrayList<String> lista = new ArrayList<>();

        for (String p : palavras) {
            if (!p.equals(remover)) {
                lista.add(p);
            }
        }

        System.out.println("Array sem \"" + remover + "\":");
        for (String p : lista) System.out.print(p + " ");
    }
}
