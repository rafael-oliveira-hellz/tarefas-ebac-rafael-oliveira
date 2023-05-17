import java.util.Scanner;

public class ConversaoTipoWrapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt(); 

        Integer numeroWrapper = Integer.valueOf(numero); 

        System.out.println("Valor convertido para Integer: " + numeroWrapper);
    }
}
