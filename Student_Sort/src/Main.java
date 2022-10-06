import java.util.*;

public class Main {
    static List<Student> studentList = new ArrayList<Student>();

    public static void addStudent(String name, int age, int gpa) {
        Student student1 = new Student(name, age, gpa);
        studentList.add(student1);
    }

    public static void sortByFullName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.fullName.equals(o2.fullName)) {
                    return (o1.age < o2.age)? 1: -1;
                } else {
                    return o1.fullName.compareTo(o2.fullName);
                }
            }
        });

        System.out.println("Sort by FullName:");
        System.out.println(Arrays.toString(studentList.toArray()));
        System.out.println("-------------------");
    }

    public static void sortByAge() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.age != o2.age) {
                    return (o1.age > o2.age)? 1: -1;
                } else {
                    return (o1.GPA < o2.GPA)? 1: -1;
                }
            }
        });

        System.out.println("Sort by Age ASC:");
        System.out.println(Arrays.toString(studentList.toArray()));
        System.out.println("-------------------");
    }

    public static void sortByNameOnly() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String[] o1Words = o1.fullName.split(" ");
                String[] o2Words = o2.fullName.split(" ");

                return o1Words[o1Words.length-1].compareTo(o2Words[o2Words.length-1]);
            }
        });

        System.out.println("Sort by Name:");
        System.out.println(Arrays.toString(studentList.toArray()));
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        studentList.clear();

        addStudent("Nguyen Van A", 25, 10);
        addStudent("Nguyen Van D", 34, 8);
        addStudent("Tran Van E", 18, 5);
        addStudent("Nguyen Van A", 20, 7);
        addStudent("Do Van B", 34, 9);

        sortByFullName();
        sortByAge();
        sortByNameOnly();

    }
}
