package br.com.ebac.tarefa.calculadorademedia.entities;

public class Student {
    public String name;
    public double[] grades;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public Student() {

    }

    public String getName() {
        return this.name;
    }

    public double[] getGrades() {
        return this.grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }
}
