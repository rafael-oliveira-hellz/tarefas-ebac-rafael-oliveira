package br.com.ebac.tarefa.calculadorademedia;


import br.com.ebac.tarefa.calculadorademedia.entities.Student;
import br.com.ebac.tarefa.calculadorademedia.utils.MediaCalculator;

public class Main {
    public static void main(String[] args) {

        MediaCalculator mediaCalculator = new MediaCalculator();

        Student student1 = new Student();
        student1.name = "João";

        Student student2 = new Student();
        student2.name = "Maria";

        Student student3 = new Student();
        student3.name = "José";

        Student student4 = new Student();
        student4.name = "Ana";

        student1.grades = new double[] { 10, 9, 8, 7 };
        student2.grades = new double[] { 10, 9.3, 6.48, 7.7 };
        student3.grades = new double[] { 4, 9.4, 5.5, 5 };
        student4.grades = new double[] { 4.7, 9.9, 8.3, 7.5 };

        double average1 = mediaCalculator.calculate(student1.grades[0], student1.grades[1], student1.grades[2], student1.grades[3]);
        double average2 = mediaCalculator.calculate(student2.grades[0], student2.grades[1], student2.grades[2], student2.grades[3]);
        double average3 = mediaCalculator.calculate(student3
.grades[0], student3.grades[1], student3.grades[2], student3.grades[3]);
        double average4 = mediaCalculator.calculate(student4.grades[0], student4.grades[1], student4.grades[2], student4.grades[3]);

        average1 = Math.round(average1 * 100.0) / 100.0;
        average2 = Math.round(average2 * 100.0) / 100.0;
        average3 = Math.round(average3 * 100.0) / 100.0;
        average4 = Math.round(average4 * 100.0) / 100.0;

        System.out.println("A média do aluno " + student1.name + " é " + average1);
        System.out.println("A média do aluno " + student2.name + " é " + average2);
        System.out.println("A média do aluno " + student3.name + " é " + average3);
        System.out.println("A média do aluno " + student4.name + " é " + average4);

    }
}