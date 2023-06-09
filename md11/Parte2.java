import java.util.*;

public class Parte2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes e sexos separados por vírgula e traço (ex: Rafael - Masculino, Fernanda - Feminino): ");
        String input = scanner.nextLine();

        String[] dadosArray = input.split(",");

        Map<String, List<String>> grupos = new HashMap<>();

        for (String dado : dadosArray) {
            String[] dados = dado.split("-");

            if (dados.length != 2) {
                System.out.println("Entrada inválida: " + dado);
                continue;
            }

            String nome = dados[0].trim();
            String sexo = dados[1].trim();

            if (!grupos.containsKey(sexo)) {
                grupos.put(sexo, new ArrayList<>());
            }

            grupos.get(sexo).add(nome);
        }

        System.out.println("Nomes separados por grupos (por gênero):");
        for (String sexo : grupos.keySet()) {
            System.out.println("Grupo " + sexo + ": " + grupos.get(sexo));
        }
    }
}