package testing;

import hashFuntions.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        if(o1.getSurname().equals(o2.getSurname()) && o1.getName().equals(o2.getName()) && o1.getAge() - o2.getAge() == 0
            && o1.getGrades().equals(o2.getGrades())) {
            return 0;
        }
        return -1;
    }
}
