import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListaDePessoas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> pessoas = new ArrayList<>();
        Map<String, ArrayList<String>> grupos = new HashMap<>();

        grupos.put("M", new ArrayList<>());
        grupos.put("F", new ArrayList<>());

        while (true) {
            System.out.print("Digite o nome da pessoa (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o sexo da pessoa (M/F): ");
            String sexo = scanner.nextLine();

            if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F")) {
                pessoas.add(nome);
                grupos.get(sexo.toUpperCase()).add(nome);
            } else {
                System.out.println("Sexo inválido! Digite M ou F.");
            }
        }

        System.out.println("\nTodas as pessoas:");
        for (String nome : pessoas) {
            System.out.println(nome);
        }

        System.out.println("\nGrupo Masculino:");
        for (String nome : grupos.get("M")) {
            System.out.println(nome);
        }

        System.out.println("\nGrupo Feminino:");
        for (String nome : grupos.get("F")) {
            System.out.println(nome);
        }

        scanner.close();
    }
}
