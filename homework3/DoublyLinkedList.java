import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedList<T extends Comparable>  {
    DNode<T> head;
    Student student;

    public void addToFront(T val){
        DNode<T> newNode=new DNode<>(val);
        if (head==null)
            head=newNode;
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
    }

    public void delete(T val){
        if(head==null)
            return;
        if(head.value.compareTo(val)==0){
            head=head.next;
            if(head!=null)
                head.prev=null;
            return;
        }
        DNode<T> iterator = head.next;
        while(iterator!=null){
            if(iterator.value.compareTo(val) == 0){
                iterator.prev.next = iterator.next;
                if(iterator.next != null)
                    iterator.next.prev = iterator.prev;
                break;
            }
            iterator = iterator.next;
        }
    }


    public void addToEnd(T val){
        if (head==null)
            addToFront(val);
        else{
            DNode<T> iterator = head;
            while(iterator.next!=null)
                iterator=iterator.next;
            iterator.next=new DNode<T>(val);
            }
    }

    public void display(){
        DNode<T> iterator=head;
        while(iterator!=null){
            System.out.println(iterator);
            iterator=iterator.next;
        }
    }

    //done
    public void lowestDSGrade(DNode<Student> headStart){
        String lowest = null;
        if(headStart!=null){
            DNode<Student> iterator = headStart;
            while(iterator.next!=null){
                if(iterator.value.dsGrade > iterator.next.value.dsGrade) {
                    lowest = iterator.next.value.name;
                }
                iterator=iterator.next;
            }
            System.out.println(lowest);
        }

    }



    public void displayStudentsByDSGrades(DNode<Student> headStart){
        DNode<Student> iterator = headStart;
        DNode<Student> nextStudent;
        DNode<Student> temp;
        while(iterator!=null){
            nextStudent = iterator.next;
            while (nextStudent != null) {
                if (iterator.value.dsGrade > nextStudent.value.dsGrade) {
                    temp = iterator;
                    iterator = nextStudent;
                    nextStudent = temp;
                }
                nextStudent = nextStudent.next;
            }
            iterator = iterator.next;
        }
    }

    //done
    public void displayMathAvg(DNode<Student> headStart){
        int total = 0;
        if(headStart!=null){
            DNode<Student> iterator = headStart;
            while(iterator!=null){
                total += headStart.value.mathGrade;
                iterator=iterator.next;
            }
            int count = studentCount();
            System.out.println(total/count);
        }

    }

    //done
    public void insertNewStudent(int id, String name, int mathGrade, int DSGrade){

        Student newStudent = new Student(id,name,mathGrade,DSGrade);

        addToEnd((T) newStudent);
    }

    //done
    public int studentCount(){
        int count = 0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }

    //done
    public void successfulStudents(DNode<Student> headStart){
        //finding average grades for each of the lessons
        int numOfStudents = 0;
        int totalMath = 0;
        int totalDS = 0;
        DNode<Student> iterator = headStart;
        while(iterator!=null){
            numOfStudents++;
            totalMath += iterator.value.mathGrade;
            totalDS += iterator.value.dsGrade;
            iterator=iterator.next;
        }

        int mathAvg = totalMath / numOfStudents;
        int dsAvg = totalDS / numOfStudents;


        DNode<Student> iterator2 = headStart;
        while(iterator2!=null){
            if(iterator2.value.mathGrade > mathAvg){
                System.out.println(iterator2.value.name + " passed Math.");
            }
            if(iterator2.value.dsGrade > dsAvg)
                System.out.println(iterator2.value.name + " passed Data Structures.");
            iterator2 = iterator2.next;
        }

    }
}