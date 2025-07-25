package com.student.main;

import com.student.deo.StudentDeo;
import com.student.deo.StudentDeoInterface;
import com.student.model.Student;

import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDeoInterface dao = new StudentDeo();

        System.out.println("Welcome to Student Management application");

        while (true) {
            System.out.println("\n1. Add Student" +
                    "\n2. Show All Students" +
                    "\n3. Get student based on roll number" +
                    "\n4. Delete Student" +
                    "\n5. Update Student" +
                    "\n6. Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Add Student");

                    sc.nextLine(); // clear buffer
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter student college name: ");
                    String clgName = sc.nextLine();

                    System.out.print("Enter city: ");
                    String city = sc.nextLine();

                    System.out.print("Enter percentage: ");
                    double percentage = sc.nextDouble();

                    Student st = new Student(name, clgName, city, percentage);
                    boolean inserted = dao.insertStudent(st);

                    if (inserted)
                        System.out.println("Record inserted successfully!");
                    else
                        System.out.println("Something went wrong, please try again.");
                    break;

                case 2:
                    System.out.println("Show all students:");
                    dao.showAllStudent();
                    break;

                case 3:
                    System.out.println("Get student based on roll number");
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();

                    boolean found = dao.showStudentBtId(roll);
                    if (!found)
                        System.out.println("Student with this ID is not available in our system.");
                    break;

                case 4:
                    System.out.println("Delete Student");
                    System.out.println("enter roll number to delete");
                    int rollnum = sc.nextInt();
                    boolean del = dao.delete(rollnum);
                    if (del)
                        System.out.println("Record deleted successfully...");
                    else
                        System.out.println("Something went wrong");
                    break;

                case 5:
                    System.out.println("Update the student");
                    System.out.println("1. Update name\n2. Update clgName");
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();

                    System.out.print("Enter roll number: ");
                    int rnum = sc.nextInt();

                    sc.nextLine(); // Clear buffer

                    String newValue;
                    if (choice == 1) {
                        System.out.print("Enter new name: ");
                        newValue = sc.nextLine();
                    } else if (choice == 2) {
                        System.out.print("Enter new college name: ");
                        newValue = sc.nextLine();
                    } else {
                        System.out.println("Invalid update choice.");
                        break;
                    }

                    Student std = new Student(); // optional usage
                    boolean flag = dao.update(rnum, newValue, choice, std);

                    if (flag) {
                        if (choice == 1)
                            System.out.println("Name updated successfully.");
                        else if (choice == 2)
                            System.out.println("College name updated successfully.");
                    } else {
                        System.out.println("Student not found or something went wrong.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Student Management Application!");
                    System.exit(0);

                default:
                    System.out.println("Please enter a valid choice.");
            }
        }
    }
}
