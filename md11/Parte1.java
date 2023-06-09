import java.util.*;

public class Parte1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os nomes separados por vírgula: ");
        String input = scanner.nextLine();

        String[] nomesArray = input.split(",");

        List<String> nomesLista = new ArrayList<>();
        for (String nome : nomesArray) {
            nomesLista.add(nome.trim());
        }

        Collections.sort(nomesLista);

        System.out.println("Nomes em ordem alfabética:\n");
        for (String nome : nomesLista) {
            System.out.println(nome);
        }
    }
}