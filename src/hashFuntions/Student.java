package hashFuntions;

import java.util.ArrayList;

public class Student {

    private String name;
    private String surname;
    private Integer age;
    ArrayList<Double> grades;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grades = new ArrayList<>();
    }

    public void addGrade(Double grade) {
        grades.add(grade);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age.equals(student.age) && name.equals(student.name)  && surname.equals(student.surname)
                && grades.equals(student.grades);
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + age + " " + grades;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }
}
