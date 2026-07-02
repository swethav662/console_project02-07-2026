import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int roomNo;
    String department;

    Student(int rollNo, String name, int roomNo, String department) {
        this.rollNo = rollNo;
        this.name = name;
        this.roomNo = roomNo;
        this.department = department;
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("Roll No     : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Room No     : " + roomNo);
        System.out.println("Department  : " + department);
    }
}

public class HostelManagementSystem {

    static Student students[] = new Student[100];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Room Number: ");
        int room = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        students[count] = new Student(roll, name, room, dept);
        count++;

        System.out.println("\nStudent Added Successfully!\n");
    }

    public static void viewStudents() {

        if (count == 0) {
            System.out.println("No student records found.\n");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }

    public static void searchStudent() {

        System.out.print("Enter Roll Number to Search: ");
        int roll = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (students[i].rollNo == roll) {
                students[i].display();
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Student Not Found.");
    }

    public static void removeStudent() {

        System.out.print("Enter Roll Number to Remove: ");
        int roll = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (students[i].rollNo == roll) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                count--;
                found = true;
                System.out.println("Student Removed Successfully.");
                break;
            }
        }

        if (!found)
            System.out.println("Student Not Found.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("=======================================");
            System.out.println("     HOSTEL MANAGEMENT SYSTEM");
            System.out.println("=======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}