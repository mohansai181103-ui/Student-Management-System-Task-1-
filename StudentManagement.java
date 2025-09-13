package Task$1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	ArrayList<Student> students = new ArrayList<Student>();
	Scanner sc = new Scanner(System.in);

	public void addStudent() {
		System.out.print("Enter Student ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Student Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Student Grade: ");
		String grade = sc.nextLine();

		students.add(new Student(id, name, grade));

		System.out.println("Student Data added succesfully");
	}

	public void removeStudent() {
		System.out.print("Enter Student ID to remove: ");
		int id = sc.nextInt();
		sc.nextLine();

		boolean removed = false;
		for (Student s : students) {
			if (s.getId() == id) {
				students.remove(s);
				removed = true;
				System.out.println("Student removed successfully");
				break;
			}
		}

		if (!removed) {
			System.out.println("Student with ID " + id + "not found");
		}
	}

	public void displayStudents() {
		if (students.isEmpty()) {
			System.out.println("No students to display");
		} else {
			System.out.println("----- Student List -----");
			for (Student s : students) {
				System.out.println(s);
			}
			System.out.println();
		}
	}

	public void start() {
		while (true) {
			System.out.println("1.Add Student");
			System.out.println("2.Remove Student");
			System.out.println("3.Display Student");
			System.out.println("4.Exit");
			System.out.print("Enter Choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> addStudent();
			case 2 -> removeStudent();
			case 3 -> displayStudents();
			case 4 -> {
				System.out.println("Exiting.....");
				return;
			}

			default -> System.out.println("Invalid Choice");
			}
		}
	}

	public static void main(String[] args) {
		StudentManagement sm = new StudentManagement();

		sm.students.add(new Student(1, "Ram", "10.0"));
		sm.students.add(new Student(2, "Gandhi", "8.5"));
		sm.students.add(new Student(3, "Mayank", "9.2"));
		sm.students.add(new Student(4, "Abhishek", "7.2"));

		sm.start();
	}

}
