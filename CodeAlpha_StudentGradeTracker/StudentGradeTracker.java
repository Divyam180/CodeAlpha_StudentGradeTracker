import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");
        System.out.print("Enter total number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            double grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Enter grade (0-100): ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Please enter a valid grade between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numerical grade.");
                    scanner.next();
                }
            }
            scanner.nextLine(); // Consume newline
            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();
        String topStudent = students.get(0).getName();
        String lowestStudent = students.get(0).getName();

        for (Student s : students) {
            double g = s.getGrade();
            total += g;

            if (g > highest) {
                highest = g;
                topStudent = s.getName();
            }
            if (g < lowest) {
                lowest = g;
                lowestStudent = s.getName();
            }
        }

        double average = total / students.size();

        // Display Summary Report
        System.out.println("\n=================================");
        System.out.println("        SUMMARY REPORT           ");
        System.out.println("=================================");
        for (Student s : students) {
            System.out.printf("Name: %-15s | Grade: %.2f\n", s.getName(), s.getGrade());
        }
        System.out.println("---------------------------------");
        System.out.printf("Average Score : %.2f\n", average);
        System.out.printf("Highest Score : %.2f (%s)\n", highest, topStudent);
        System.out.printf("Lowest Score  : %.2f (%s)\n", lowest, lowestStudent);
        System.out.println("=================================");

        scanner.close();
    }
}