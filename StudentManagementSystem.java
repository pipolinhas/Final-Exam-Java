import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String studentID;
    private String name;
    private int age;
    private List<String> courses;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
        System.out.println();
    }

    public void updateAge(int newAge) {
        this.age = newAge;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding sample students
        Student student1 = new Student("001", "Felipe Didone", 20);
        student1.addCourse("Computer Science");
        student1.addCourse("Mathematics");
        students.add(student1);

        Student student2 = new Student("002", "Felipe Cayres", 22);
        student2.addCourse("Physics");
        student2.addCourse("Chemistry");
        students.add(student2);

        Student student3 = new Student("003", "Pedro Froes", 21);
        student3.addCourse("Computer Science");
        student3.addCourse("History");
        students.add(student3);

        // Display details of all students
        System.out.println("Details of all students:");
        students.forEach(Student::displayDetails);

        // Find and display students enrolled in "Computer Science"
        String targetCourse = "Computer Science";
        System.out.println("Students enrolled in " + targetCourse + ":");
        List<Student> computerScienceStudents = students.stream()
                .filter(student -> student.getCourses().contains(targetCourse))
                .collect(Collectors.toList());
        computerScienceStudents.forEach(Student::displayDetails);

        // Update the age of a specific student (e.g., student with ID "002")
        String studentToUpdateID = "002";
        int newAge = 23;
        students.stream()
                .filter(student -> student.getStudentID().equals(studentToUpdateID))
                .findFirst()
                .ifPresent(student -> student.updateAge(newAge));

        // Calculate and display the average age of all students
        double averageAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average age of all students: " + averageAge);
    }
}
