import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student implements Comparable {

    public String name;
    public int id, mathGrade, dsGrade;
    public double average;

    public Student(int id, String name, int mathGrade, int dsGrade) {
        this.name = name;
        this.id = id;
        this.mathGrade = mathGrade;
        this.dsGrade = dsGrade;

        average = (mathGrade + dsGrade) / 2;
    }

    public String toString() {
        return id + " " + name + " " + mathGrade + " " + dsGrade;
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        if(id == student.id)
            return 0;
        return 1;
    }
}
