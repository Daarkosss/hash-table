package testing;

import hashFuntions.IntegerHash;
import hashFuntions.Student;
import hashFuntions.StudentHash;
import hashTables.HashTable;
import hashTables.SeparateChainingHashTable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        SeparateChainingHashTable<Student> hashTable = new SeparateChainingHashTable<>(0.5, new StudentComparator(), new StudentHash());

        Student student1 = new Student("Marian", "Kowalski", 19);
        student1.addGrade(5.0);
        student1.addGrade(4.0);
        student1.addGrade(3.5);

        Student student2 = new Student("Ania", "Nowak", 20);
        student2.addGrade(4.0);
        student2.addGrade(3.0);
        student2.addGrade(2.0);

        Student student3 = new Student("Ania", "Nowak", 20);
        student3.addGrade(2.0);
        student3.addGrade(2.0);
        student3.addGrade(2.0);

        hashTable.insert(student1);
        hashTable.insert(student2);
        hashTable.insert(student3);

        System.out.println(hashTable);
        System.out.println(hashTable.lookUp(student1));
        System.out.println(hashTable.lookUp(student2));

        hashTable.insert(student1);
        System.out.println(hashTable);



        //makeData();
    }

    public static void makeData() {
        double[] maxLoadFactors = new double[]{0.1, 0.2, 0.5, 0.9};
        int[] numbers = new int[]{2, 5, 10, 15, 20, 30, 40, 50, 60, 70, 80, 90, 100, 150, 200, 500, 1000, 2000, 5000, 10000};

        for (double loadFactor : maxLoadFactors) {
            String fileName = loadFactor + ".txt";
            for (int number : numbers) {
                Result result = new Result(10);
                for (int i = 0; i < 10; i++) {
                    SeparateChainingHashTable<Integer> hashTable = new SeparateChainingHashTable<>(loadFactor,
                            new IntegerComparator(), new IntegerHash());
                    insertIntegers(hashTable, number);
                    result.add(hashTable.loadFactor(), hashTable.collisions(), hashTable.insertComparisons(),
                            hashTable.hashFunctionEvaluations());
                }
                saveToFile(result, fileName);
            }
        }
    }

    public static void saveToFile(Result result, String fileName) {
        result.makeAverages();
        try {
            File plik = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(plik, true));

            writer.write(String.format("%.10f", result.loadFactor));
            writer.write("\t" + result.collisions + "\t");
            writer.write(result.insertComparisons + "\t");
            writer.write(result.hashFunctionEvaluations + "\t\n");

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntegers(HashTable<Integer> hashTable, int number) {
        for (int i = 0; i < number; i++) {
            Random rand = new Random();
            hashTable.insert(rand.nextInt(1000000));
        }
    }
}
