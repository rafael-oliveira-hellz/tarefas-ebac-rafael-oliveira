import java.util.Scanner;
public class CalculateGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        double average;
        int numGrades = 4;

        for (int i = 1; i <= numGrades; i++) {
            System.out.printf("Digite a nota " + i + ": ");
            double grade = scanner.nextDouble();
            sum += grade;
        }

        average = sum / numGrades;

        int averageInt = (int) Math.round(average);

        switch (averageInt) {
            case 10:
            case 9:
            case 8:
            case 7:
                System.out.println("Aprovado, Parabéns! Sua nota foi: " + String.format("%.1f", average) + ".");
                break;
            case 6:
            case 5:
                System.out.println("Em Recuperação. Sua nota foi: " + String.format("%.1f", average) + ".");
                break;
            default:
                System.out.println("Reprovado. Sua nota foi: " + String.format("%.1f", average) + ".");
                break;
        }
    }
}
