import java.util.InputMismatchException;
import java.util.Scanner;

public class CharSorter {

    public static void alphabeticalSort(char[] charArray) {
        //if userOption == 1

        //The goal of this method is to sort all of the characters
        //in alphabetical order

        //THIS WORKS

        int[] charFreq = new int[127];

        for(int j = 0; j < 127; j++) {
            for(int i = 0; i < charArray.length; i++){
                if(charArray[i] == j){
                    ++charFreq[j];
                }
            }
            if (charFreq[j] != 0) {
                System.out.println((char)j + " freq: " + charFreq[j]);
            }
        }

        System.out.print("\n");
    }

    public static void frequencySort(char[] charArray) {
        //if userOption == 2

        //The goal of this method is to sort all of the characters
        //from highest frequency to lowest.

        System.out.println("The sorted by frequency characters are:\n");

        int[] charFreq = new int[127];

        for(int j = 0; j < 127; j++) {
            for(int i = 0; i < charArray.length; i++){
                if(charArray[i] == j){
                    ++charFreq[j];
                }
            }
        }

        for (int i = charArray.length; i > 0; i--) {
            for (int j = 0; j < 127; j++) {
                if (charFreq[j] == i && charFreq[j] != 0) {
                    System.out.println((char)j + " freq: " + charFreq[j]);
                }
            }
        }

        System.out.print("\n");

    }

    public static void charTypes(char[] charArray) {
        //if userOption == 3

        //The goal of this method is to sort the data into four categories:
        //Textual characters, Numeric characters, WhiteSpace characters,
        //and Symbolic characters

        //THIS WORKS

        int asciiNum;
        int textCharCount = 0;
        int numCharCount = 0;
        int whiteSpaceCount = 0;
        int symbolCount = 0;

        for (int i = 0; i < charArray.length; i++) {
            asciiNum = (int) charArray[i];
            if ((asciiNum >= 65 && asciiNum <= 90) || (asciiNum >= 97 && asciiNum <=122)) {
                ++textCharCount;
            }
            if (asciiNum >= 48 && asciiNum <= 59) {
                ++numCharCount;
            }
            if (asciiNum == 32) {
                ++whiteSpaceCount;
            }
            if (asciiNum >= 33 && asciiNum <=47) {
                ++symbolCount;
            }
            if (asciiNum >= 58 && asciiNum <= 64) {
                ++symbolCount;
            }
            if (asciiNum >= 91 && asciiNum <= 96) {
                ++symbolCount;
            }
            if (asciiNum >=123 && asciiNum <= 126) {
                ++symbolCount;
            }
        }

        System.out.println("Textual Character count: " + textCharCount);
        System.out.println("Numerical Character count: " + numCharCount);
        System.out.println("WhiteSpace Character count: " + whiteSpaceCount);
        System.out.println("Symbol Character count: " + symbolCount);

        System.out.print("\n");
    }

    public static void main(String args[]) {

        System.out.println("Welcome to Character Sorter Program\nPlease input a string to be sorted");
        Scanner scnr = new Scanner(System.in);
        String userInputString = scnr.nextLine();
        char[] charArray = userInputString.toCharArray();

        int userOption = 0;

        while (userOption != 4) {



            System.out.println("\nPlease select the option you would like to see\n");
            //Start Menu
            System.out.println("1. Display character frequencies alphabetically");
            System.out.println("2. Display sorted frequencies");
            System.out.println("3. Show types of character frequencies");
            System.out.println("4. Exit");
            //End Menu

            try {
                userOption = scnr.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Error, bad input, please enter a number 1-4");
                scnr.nextLine();
                continue;
            }

            if (userOption == 1) {
                alphabeticalSort(charArray);
            }
            else if (userOption == 2) {
                frequencySort(charArray);
            }
            else if (userOption == 3) {
                charTypes(charArray);
            }
            else if (userOption != 4){
                System.out.println("Error, bad input, please enter a number 1-4");
            }
        }

        //If userOption == 4
        System.out.println("\nCharacter Sorter Exited Successfully");

    }

    }








