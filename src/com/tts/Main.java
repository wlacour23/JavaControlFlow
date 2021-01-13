package com.tts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int MAX_MAGIC = 75;
    private static final int MAX_BALL = 60;
    private static final int BALL_PULL = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName = "";
        String response = "";
        boolean keepGoing = false;

        // The program is running to the world!
        System.out.println("Hello world!");

        // Display the valid input characters
        AsciiChars.printNumbers();
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();

        // Ask for the user's name and display it
        System.out.println("Please tell us your name?");
        System.out.print("Name: ");
        userName = scan.nextLine();
        System.out.println("Hello, " + userName);

        // Ask if user wants to begin the interactive portion
        System.out.println("Would you like to continue to the interactive zone?");
        System.out.print("(Y/N): ");
        response = scan.nextLine();

        keepGoing = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));
//        System.out.println("Will we keep going: " + keepGoing);  // For debugging


        while (keepGoing) {
            System.out.println("As we continue...");

            // Question: Does the user own a car?
            System.out.println("Do you have a red car? (yes, no): ");
            String redCar = scan.nextLine();
            boolean redCarBool = false;
            if (redCar.equalsIgnoreCase("y") || redCar.equalsIgnoreCase("yes")) {
                System.out.println("Cool red car!");
                redCarBool = true;
            } else System.out.println("No red car detected!");


            // Question: User's favorite pet?
            String favPet = "";
            System.out.println("What's the name of your favorite pet? : ");
            favPet = scan.nextLine();
            System.out.println("Your pet's name is Raziel?" + favPet + ", Cool!");


            // Question: Age of the Pet?
            System.out.println("What is the age of " + favPet + " in years? (##): ");
            int petAge = scan.nextInt();
            response = scan.nextLine();
            System.out.println("So the, " + favPet + " is already " + petAge + "? That's impressive! :)");
            //

            // Question: User Lucky Number?
            System.out.println("What's your lucky number? (int only): ");
            int luckyNumber = scan.nextInt();
            response = scan.nextLine();
            System.out.println("Wow, your lucky number is " + luckyNumber + "? Lucky!!");
            //

            // Question: QB Jersey Number?
            boolean favQB = false;
            System.out.println("Do you have a favorite qb? (Y/N): ");
            response = scan.nextLine();
            favQB = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));

            if (favQB) {
                System.out.println("Cool! What's their jersey number? (##): ");


            } else System.out.println("Give me a number between 1 and 99! (##): ");
            int jerseyNum = scan.nextInt();
            response = scan.nextLine();
            System.out.println("Cool! Your jersey number is " + jerseyNum + ", good choice!");

            
            // Question: Model Year
            System.out.println("What are the last two digits of your car's model year? (##): ");
            int modelYear = scan.nextInt();
            response = scan.nextLine();
            System.out.println("A wise choice mate! '" + modelYear + ", it suits you well!");


            // Question: Favorite Actor
            System.out.println("Who is your favorite actor or actress? (name): ");
            String favActor = scan.nextLine();
            System.out.println("Really? " + favActor + "? Is your favorite?");


            // Question: Random Number 1-50
            System.out.println("Enter any random number between 0 and 50! (0-50): ");
            int randomNumber = scan.nextInt();
            response = scan.nextLine();
            System.out.println("Okay, " + randomNumber + ",Interesting!");


            // Generate the lotto numbers!
            int ball_magic = 0;
            int rando_magic = (int) Math.floor(Math.random() * MAX_MAGIC) + 1;
            int rando_ball1 = (int) Math.floor(Math.random() * MAX_BALL) + 1;
            int rando_ball2 = (int) Math.floor(Math.random() * MAX_BALL) + 1;

            // Final Magic Ball Result
            int userProvidedNumber = Math.random() > 0.5 ? jerseyNum : randomNumber;
            int finalMagicBall = (int) (Math.floor(Math.random() * userProvidedNumber + 1));
            finalMagicBall = reduceMagic(finalMagicBall);

            ArrayList<Integer> resultHopper = new ArrayList<>();

            // Final Pet Ball Result
            int finalFavoritePet = favPet.charAt(2);
            finalFavoritePet = reduceNormal(finalFavoritePet);
            resultHopper.add(finalFavoritePet);

            // Final Model Year + Lucky Number Result
            int finalModelYearAndLucky = modelYear + luckyNumber;
            finalModelYearAndLucky = reduceNormal(finalModelYearAndLucky);
            resultHopper.add(finalModelYearAndLucky);

            // Final Random Number Result
            int finalRandomNumber = randomNumber - (Math.random() < 0.5 ? rando_ball1 : rando_ball2);
            finalRandomNumber = reduceNormal(finalRandomNumber);
            resultHopper.add(finalRandomNumber);

            // Final Fav Actor Result
            int finalFavActor = favActor.charAt(0);
            finalFavActor = reduceNormal(finalFavActor);
            resultHopper.add(finalFavActor);

            // Final End Fav Actor Result
            int finalEndFavActor = favActor.charAt(favActor.length() - 1);
            finalEndFavActor = reduceNormal(finalEndFavActor);
            resultHopper.add(finalEndFavActor);

            // Final 42 Result
            int final42 = 42;
            final42 = reduceNormal(final42);
            resultHopper.add(final42);

            // Final Pet Age + Model Year Result
            int finalPetAgeAndModelYear = petAge + modelYear;
            finalPetAgeAndModelYear = reduceNormal(finalPetAgeAndModelYear);
            resultHopper.add(finalPetAgeAndModelYear);

            // Final Fav QB + Pet Age + Lucky Num Result
            int finalQBAndPetAgeAndLuckyNum = jerseyNum + petAge + luckyNumber;
            finalQBAndPetAgeAndLuckyNum = reduceNormal(finalQBAndPetAgeAndLuckyNum);
            resultHopper.add(finalQBAndPetAgeAndLuckyNum);

            // Select BALL_PULL results
            int[] yourResults = new int[BALL_PULL];
            for (int i = 0; i < BALL_PULL; i++) {
                int randomPull = (int) Math.floor(Math.random() * resultHopper.size());
                yourResults[i] = resultHopper.get(randomPull);
                resultHopper.remove(randomPull);
            }

            // Print the final results!
            System.out.print("\n\nYour lottery numbers: ");
            for (int i = 0; i < BALL_PULL; i++
            ) {
                System.out.print(yourResults[i]);
                if (i < BALL_PULL - 1) System.out.print(",");
                System.out.print(" ");
            }
            System.out.print("Magic Ball: " + finalMagicBall + "\n\n");

            // Play Again?
            System.out.println("Care to play again? (Y/N): ");
            response = scan.nextLine();
            keepGoing = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));

        }

        System.out.println("Finished!");
    }

    private static int reduceBall(int ballSeed, int max) {
        while (ballSeed > max) ballSeed -= max;
        return ballSeed;
    }

    private static int reduceMagic(int magicBallSeed) {
        return reduceBall(magicBallSeed, MAX_MAGIC);
    }

    private static int reduceNormal(int normalBallSeed) {
        return reduceBall(normalBallSeed, MAX_BALL);
    }
}
