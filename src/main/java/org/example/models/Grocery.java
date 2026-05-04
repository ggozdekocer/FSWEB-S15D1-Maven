package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("0: Durdur, 1: Ekle, 2: Çıkar");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
                String input = scanner.nextLine();
                addItems(input);
            } else if (choice == 2) {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz:");
                String input = scanner.nextLine();
                removeItems(input);
            }
        }

    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim();
            if (!checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim();
            if (checkItemIsInList(product)) {
                groceryList.remove(product);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Liste: " + groceryList);
    }
}
