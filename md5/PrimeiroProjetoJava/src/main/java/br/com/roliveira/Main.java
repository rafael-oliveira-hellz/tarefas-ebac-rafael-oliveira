package br.com.roliveira;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nHello world!\n");

        String ennvironment = args[0];

        if (ennvironment.equalsIgnoreCase("DEV")) {
            System.out.println("Executando em DEV");
        } else if (ennvironment.equalsIgnoreCase("TEST")) {
            System.out.println("Executando em TEST");
        } else {
            System.out.println(ennvironment);
        }
    }
}