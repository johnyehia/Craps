/*
The purpose of this project is to play the game craps and to calculate
the odds of winning and losing, and their correlation.

The program consists of while loops, if else statements,
methods, and classes.

This was quite a fulfilling project because it introduced me into a new field (an introductory version)
: Data science. I had a lot of fun building this projects and will always be grateful for this learning experience.

There are a few issues with this program. The first is that our trials can only
hold up to an int, which limits us to 2,147,483,647 tries. This is purely hypothetical
and not useful due to us observing that we are approaching 50-50 odds of winning or losing.
In addition, random number generators are not truly random as they are given
a seed to start with. This means that it will generate the same sequence of numbers.

 */


import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Random;

public class Craps {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("/Users/johnyehia/Documents/crapsoutput.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("How many trials would you like to conduct?");
        int trials = sc.nextInt();
        //these variables below store data
        int won = 0;
        int lost = 0;
        //this below is so that we can count our wins and losses
        for (int trial = 1; trial <= trials; trial++) {
            int attempt = winOrLose();
            if (attempt == 1) {
                won++;
            }
            if (attempt == 2) {
                lost++;
            }

        }
        //we used this to time our program
        long startTime = System.currentTimeMillis();
        //this below is for timing the program
        for (int i = 0; i < trials; i++) {

        }
        //this below is to print to a file
        ps.printf("Conducted %d %n", trials);
        ps.printf("Wins and percentage:   %d , %.2f %s\n", won, 100.0 * won / trials, "%");
        ps.printf("trials lost and percentage: %d , %.2f %s\n", lost, 100.0 * lost / trials, "%");
        long endTime = System.currentTimeMillis();
        ps.println("Total execution time: " + (endTime - startTime) + "milliseconds");
        //this block of code prints to the console
        System.out.printf("Conducted %d %n", trials);
        System.out.printf("Wins and percentage:   %d , %.2f %s\n", won, 100.0 * won / trials, "%");
        System.out.printf("trials lost and percentage: %d , %.2f %s\n", lost, 100.0 * lost / trials, "%");
        System.out.println("Total execution time: " + (endTime - startTime));

    }

    //outside main method
    //this is a method that plays the game, craps.
    //this below takes the sum of the two dice
    public static int sum() {
        Random rand = new Random();
        int firstDice = rand.nextInt(6) + 1;
        int secondDice = rand.nextInt(6) + 1;
        return firstDice + secondDice;
    }
    //this below determines if we win or lose

    public static int winOrLose() {
        int s = sum();
        if (s == 7 || s == 11) {
            return 1;
        }
        if (s == 3 || s == 2 || s == 12) {
            return 2;
        }

        while (true) {
            int y = sum();
            if (y == 7) return 2;
            if (y == s) return 1;
        }
    }
}


