package com.mycompany.exercise_oop_array;

import java.util.ArrayList;
import java.util.Scanner;

public class MainArrayList {
    static ArrayList<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Input Data");
            System.out.println("2. Show Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> inputData();
                case 2 -> showData();
                case 3 -> deleteData();
                case 4 -> System.out.println("Program exited.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    public static void inputData() {
        System.out.print("Name : ");
        String name = sc.nextLine();
        System.out.print("Pass : ");
        String pass = sc.nextLine();
        System.out.print("Phone : ");
        String phone = sc.nextLine();

        users.add(new User(name, pass, phone));
        System.out.println("New data is added");
    }

    public static void showData() {
        if (users.isEmpty()) {
            System.out.println("|No data exists!|");
            return;
        }
        System.out.println("|No\t|Name\t|Pass\t|Phone\t|");
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            System.out.println((i + 1) + "\t" + u.name + "\t" + u.password + "\t" + u.phone);
        }
    }

    public static void deleteData() {
        if (users.isEmpty()) {
            System.out.println("No data to delete!");
            return;
        }
        showData();
        System.out.print("Input data number to be deleted: ");
        int del = sc.nextInt();
        sc.nextLine();

        if (del <= 0 || del > users.size()) {
            System.out.println("Invalid number!");
            return;
        }

        users.remove(del - 1);
        System.out.println("Data is removed");
    }
}
