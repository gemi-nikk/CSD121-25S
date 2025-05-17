package lab1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int doubleNumber(int number) {
        return number * 2; // return the number multiplied by 2
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a Scanner object to read input from the console
        String name;
        int age;
        System.out.print("What is your name? "); // user to enter their name
        name = input.nextLine(); // Read the entire line of input and store it in the name variable
        System.out.print("How old are you ? "); // user to enter their age
        age = Integer.parseInt(input.nextLine()); // Read the age from the input, convert it from a string to an integer, and store it in the age variable
        if (age >= 18) { // Check if the age is greater than or equal to 18
            System.out.println("You are an adult."); // Print this message if the condition is true
        } else {
            System.out.println("You are a minor."); // Print this message if the condition is false
        }
        ArrayList<Integer> numbersList = new ArrayList<>(); // Create an ArrayList to store a list of integers.  ArrayLists can grow in size.
        for (int i = 0; i < 2; i++) { // Loop twice (i goes from 0 to 1)
            System.out.print("Enter a number for the list: "); // Ask the user to enter a number
            int num = Integer.parseInt(input.nextLine());  // Read the number, convert it to an integer, and store it in 'num'
            numbersList.add(num);  // Add the number to the ArrayList
        }
        for (int num : numbersList) { // Enhanced for loop:  Go through each 'num' in 'numbersList'
            System.out.println(num + " doubled is " + doubleNumber(num)); // Print the number and its double using our function
        }
        int[] numbersArray = new int[2]; // Create an array  with a fixed size of 2.
        for (int i = 0; i < 2; i++) {  // Loop twice
            System.out.print("Enter a number for the array: "); // Ask the user for a number
            numbersArray[i] = Integer.parseInt(input.nextLine()); // Read the number, convert it to an integer, and store it in the array at index 'i'
        }
        for (int num : numbersArray) { // Enhanced for loop: Go through each 'num' in 'numbersArray'
            System.out.println(num + " doubled is " + doubleNumber(num)); // Print the number and its double
        }
        try {
            FileWriter writer = new FileWriter("output.txt"); // Create a FileWriter object to write to a file named "output.txt"
            writer.write("Name: " + name + "\n");// Write the user's name to the file, followed by a newline character
            writer.write("Age: " + age + "\n"); // Write the user's age to the file, followed by a newline character
            writer.write("List numbers: " + numbersList + "\n"); // Write the list of numbers to the file, followed by a newline character
            writer.write("Array numbers: "); // Write the label "Array numbers: " to the file
            for (int num : numbersArray) { // Loop through each number in the array
                writer.write(num + " "); // Write the number and a space to the file
            }
            writer.write("\n"); // Write a newline character to the file
            writer.close(); // Close the file writer to save the changes
            System.out.println("Info saved to output.txt"); // Print a message indicating that the information has been saved
        } catch (IOException e) { // Catch any Input/Output exceptions that might occur during file writing
            System.out.println("Could not write to file."); // Print an error message if writing to the file fails
        } finally {
            input.close(); // Close the scanner to prevent resource leaks
        }
    }
}
