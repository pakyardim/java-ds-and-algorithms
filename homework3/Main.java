import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Getting data from students.txt
        String content;
        DoublyLinkedList<Student> students=new DoublyLinkedList<>();
        try {
            File file = new File("students.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                String[] splitContent = content.split(" ");
                Student student = new Student(Integer.parseInt(splitContent[0]), splitContent[1], Integer.parseInt(splitContent[2]), Integer.parseInt(splitContent[3]));
                students.addToEnd(student);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Menu
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1- Display the initial linked list content.");
        System.out.println("4- Find and display the math average.");
        System.out.println("5- Find and display the student(s) who has the lowest Data Structures grade.");
        System.out.println("6- Delete the student whose id is entered by the user.");
        System.out.println("7- Find and display the student count.");
        System.out.println("8- Display the successful students for each course.");
        System.out.println("Type in a number: ");
        int num = scanner.nextInt();

            switch (num) {
                case 1:
                    students.display();

                    break;
                case 2:
                    System.out.println("Couldn't make it :( ");
                    break;
                case 3:
                    System.out.println("Couldn't make it :( ");
                    break;
                case 4:
                    students.displayMathAvg(students.head);
                    break;
                case 5:
                    students.lowestDSGrade(students.head);
                    break;
                case 6:
                    System.out.println("Please enter the id of the student you want to delete: ");
                    int id = scanner.nextInt();
                    students.delete(id);
                    break;
                case 7:
                    System.out.println("Please enter the id");
                    int idNum = scanner.nextInt();
                    System.out.println("Please enter the name");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the Math Grade");
                    int math = scanner.nextInt();
                    System.out.println("Please enter the DS Grade");
                    int ds = scanner.nextInt();
                    students.insertNewStudent(idNum, name, math, ds);
                    break;
                case 8:
                    students.successfulStudents(students.head);
                    break;

            }
        }


    }
