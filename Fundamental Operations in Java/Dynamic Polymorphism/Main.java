package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // polymorphism = many shapes/forms
        // dynamic = after compilation (during runtime)

        //ex. A corvette is a: corvette, and a car, and a vehicle, and an object.

        Animal animal;

        while (true) {
            System.out.println("What animal do you want?");
            System.out.println("(1=dog) or (2=cat)");
            int choice = scanner.nextInt();

            if (choice == 1) {
                animal = new Dog();
                animal.speak();
                System.out.println();
            } else if (choice == 2) {
                animal = new Cat();
                animal.speak();
                System.out.println();
            } else {
                animal = new Animal();
                System.out.println("That choice was invalid");
                animal.speak();
                System.out.println();
            }
        }
    }
}
