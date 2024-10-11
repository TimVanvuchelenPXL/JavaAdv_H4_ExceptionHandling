package be.pxl.ja.exercise;

import java.util.Scanner;

public class PetGame {

    public static void main(String[] args) throws PetTiredException {
        Scanner scanner = new Scanner(System.in);
        // Create a new pet with initial energy
        Pet senne = new Pet(100);
        boolean gameRunning = true;

        System.out.println("Welcome to the Virtual Pet Care Game!");
        System.out.println("Take care of your pet by feeding and playing with it!");

        // Create game loop
        while(gameRunning) {
            System.out.println("\nYour pet's current energy: " + senne.getEnergy() + "/100");
            System.out.println("What would you like to do?");
            System.out.println("1. Feed the pet");
            System.out.println("2. Play with the pet");
            System.out.println("3. Exit game");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Choose food");
                    String food = scanner.nextLine();
                    try {
                        senne.feed(food);
                    } catch (WrongFoodException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        senne.play();
                    } catch (PetTiredException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    gameRunning = false;
                    break;
                default :
                    System.out.println("domme kut");
                    break;
            }
        }

        System.out.println("Thank you for playing the Virtual Pet Care Game!");
        System.out.println("Invalid choice. Please select a valid option.");

        scanner.close();
    }
}
