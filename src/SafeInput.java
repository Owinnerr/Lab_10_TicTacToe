import java.util.Scanner;

/**
 * @author Owin Abeysinghe abeysios@mail.uc.edu
 */

public class SafeInput {
    /**
     * Gets a String from the user that has to be at least one character or more
     * @param pipe a Scanner opened to read from System.in (for user input)
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // Show prompt and add space
            retString = pipe.nextLine(); // Reads a String value from the user
            if (retString.length() == 0) { // Condition: If the length of retString variable is equal to 0,
                System.out.println("You must enter a string with some characters."); // Output that the user has to enter some characters
            }
        } while(retString.length() == 0); // Loop: While the length of retString variable is equal to 0,

        return retString; // Return retString because this is not a void method
    }

    /**
     * Gets an int value with no constraints
     * @param pipe a Scanner opened to read from System.in (for user input)
     * @param prompt prompt for the user
     * @return an int value provided by the user (unconstrained)
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retValue = 0; // Initialize retValue variable (user input)
        String trash = ""; // Initialize trash variable (bad user input)
        boolean done = false; // Initialize done variable (set to false for loop)
        do {
            System.out.print("\n" + prompt + ": "); // Show prompt and add space
            if (pipe.hasNextInt()) { // Condition: If it's safe to read in an int,
                retValue = pipe.nextInt(); // Reads an int value from the user
                pipe.nextLine(); // Clears the newline buffer
                done = true; // Set done to true since it's a valid number, and this will end the loop
            } else {
                trash = pipe.nextLine(); // Not an int so read the user input as a string
                System.out.println("You must enter a valid number, not: " + trash); // Output that the user should enter a valid number
            }
        } while(!done); // Loop: While done variable is false (loop will stop when done is true, or in other words once the user enters a valid number)

        return retValue; // Return retValue because this is not a void method
    }

    /**
     * Gets a double value with no constraints
     * @param pipe a Scanner opened to read from System.in (for user input)
     * @param prompt prompt for the user
     * @return a double value provided by the user (unconstrained)
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retValue = 0; // Initialize retValue variable (user input)
        String trash = ""; // Initialize trash variable (bad user input)
        boolean done = false; // Initialize done variable (set to false for loop)
        do {
            System.out.print("\n" + prompt + ": "); // Show prompt and add space
            if (pipe.hasNextDouble()) { // Condition: If it's safe to read in a double,
                retValue = pipe.nextDouble(); // Reads a double value from the user
                pipe.nextLine(); // Clears the newline buffer
                done = true; // Set done to true since it's a valid number, and this will end the loop
            } else {
                trash = pipe.nextLine(); // Not a double so read the user input as a string
                System.out.println("You must enter a valid number, not: " + trash); // Output that the user should enter a valid number
            }
        } while(!done); // Loop: While done variable is false (loop will stop when done is true, or in other words once the user enters a valid number)

        return retValue; // Return retValue because this is not a void method
    }

    /**
     * Gets an int value from the user within a specified inclusive low to high range
     * @param pipe a Scanner opened to read from System.in (for user input)
     * @param prompt prompt for the user (should not include the range info)
     * @param low low value for the range
     * @param high high value for the range
     * @return an int value provided by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retValue = 0; // Initialize retValue variable (user input)
        String trash = ""; // Initialize trash variable (bad user input)
        boolean done = false; // Initialize done variable (set to false for loop)
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: "); // Show prompt and add space with the addition of the range
            if (pipe.hasNextInt()) { // Condition: If it's safe to read in an int,
                retValue = pipe.nextInt(); // Reads an int value from the user
                pipe.nextLine(); // Clears the newline buffer
                if (retValue >= low && retValue <= high) { // Condition: If the retValue variable is greater than or equal than the low parameter AND retValue is less than or equal than the high parameter,
                    done = true; // Set done to true since it's a valid number, and it's in range, and this will end the loop
                } else {
                    System.out.println("You must enter a number in range, not: " + retValue); // Output that the user should enter a number in range
                }
            } else {
                trash = pipe.nextLine(); // Not an int so read the user input as a string
                System.out.println("You must enter a valid number, not: " + trash); // Output that the user should enter a valid number
            }
        } while(!done); // Loop: While done variable is false (loop will stop when done is true, or in other words once the user enters a valid number and in range)

        return retValue; // Return retValue because this is not a void method
    }

    /**
     * Gets a double value from the user within a specified inclusive low to high range
     * @param pipe a Scanner opened to read from System.in (for user input)
     * @param prompt prompt for the user (should not include the range info)
     * @param low low value for the range
     * @param high high value for the range
     * @return a double value provided by the user within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retValue = 0; // Initialize retValue variable (user input)
        String trash = ""; // Initialize trash variable (bad user input)
        boolean done = false; // Initialize done variable (set to false for loop)
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: "); // Show prompt and add space with the addition of the range
            if (pipe.hasNextDouble()) { // Condition: If it's safe to read in a double,
                retValue = pipe.nextDouble(); // Reads a double value from the user
                pipe.nextLine(); // Clears the newline buffer
                if (retValue >= low && retValue <= high) { // Condition: If the retValue variable is greater than or equal than the low parameter AND retValue is less than or equal than the high parameter,
                    done = true; // Set done to true since it's a valid number, and it's in range, and this will end the loop
                } else {
                    System.out.println("You must enter a number in range, not: " + retValue); // Output that the user should enter a number in range
                }
            } else {
                trash = pipe.nextLine(); // Not a double so read the user input as a string
                System.out.println("You must enter a valid number, not: " + trash); // Output that the user should enter a valid number
            }
        } while(!done); // Loop: While done variable is false (loop will stop when done is true, or in other words once the user enters a valid number and in range)

        return retValue; // Return retValue because this is not a void method
    }

    /**
     * Gets a Y/N confirmation from the user
     * @param pipe a Scanner opened to read from System.in (for user input)
     * @param prompt prompt for the user (should not include [Y/N])
     * @return true if user says yes or false if user says no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retBoolean = false; // Initialize retBoolean variable (y or n)
        String response = ""; // Initialize response variable (user input)
        boolean done = false; // Initialize done variable (set to false for loop)
        do {
            System.out.print("\n" + prompt + " [Y/N]: "); // Show prompt and add space with the addition of the Y or N options
            response = pipe.nextLine(); // Reads a String value from the user
            if (response.equalsIgnoreCase("Y")) { // Condition: If the response variable equals Y (lowercase or uppercase),
                done = true; // Set done to true since it's a valid String (yes or no), and this will end the loop
                retBoolean = true; // Set retBoolean to true because the user answered Y
            } else if (response.equalsIgnoreCase("N")) {
                done = true; // Set done to true since it's a valid String (yes or no), and this will end the loop
                retBoolean = false; // Set retBoolean to false because the user answered N
            } else {
                System.out.println("You must enter Y or N, not: " + response); // Output that the user should enter Y or N
            }
        } while(!done); // Loop: While done variable is false (loop will stop when done is true, or in other words once the user enters Y or N)

        return retBoolean; // Return retBoolean because this is not a void method
    }

    /**
     * Get a string that matches a RegEx pattern
     * @param pipe a Scanner opened to read from System.in (for user input)
     * @param prompt prompt for the user
     * @param regEx java style RegEx pattern to constrain the input
     * @return a String that matches the RegEx pattern supplied
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = ""; // Initialize response variable (user input)
        boolean done = false; // Initialize done variable (set to false for loop)
        do {
            System.out.print("\n" + prompt + ": "); // Show prompt and add space
            response = pipe.nextLine(); // Reads a String value from the user
            if (response.matches(regEx)) { // Condition: If response variable matches regEx (specific pattern)
                done = true; // Set done to true since it's a valid input, and this will end the loop
            } else {
                System.out.println("Invalid input: " + response); // Output that the user entered invalid input
            }
        } while(!done); // Loop: While done variable is false (loop will stop when done is true, or in other words once the user enters valid input)

        return response; // Return response because this is not a void method
    }

    /**
     * Creates a header and centers the inputted message
     * @param msg inputted message
     */
    public static void prettyHeader(String msg) {
        final int CHAR_COUNT = 60; // Create a constant variable CHAR_COUNT and set it to 60 because that is max characters
        int totalSpaces = CHAR_COUNT - 6 - msg.length(); // Make totalSpaces variable (for the spaces in the 2nd line) and set it to 60 (CHAR_COUNT) - 6 (first 3 and last 3 stars in 2nd line) - the length of the inputted string
        int leftSpaces, rightSpaces = 0; // Initialize the leftSpaces and rightSpaces variables (2nd line spaces before and after the inputted message)
        for (int i = 1; i <= CHAR_COUNT; i++) { // Loop: Initialize variable i to 1, set it less than or equal to CHAR_COUNT (60), and increase i by 1 until loop ends
            System.out.print("*"); // Output a star for each time the loop runs (print and not println so all stars are in one line)
        }
        if (totalSpaces % 2 == 0) { // Condition: If totalSpaces modulo 2 equals 0 (testing for even spaces so the message is exactly centered),
            leftSpaces = rightSpaces = totalSpaces / 2; // Set leftSpaces equal to rightSpaces equal to totalSpaces divided by 2 (since we know the total spaces is even)
        } else {
            rightSpaces = totalSpaces / 2; // Set rightSpaces to totalSpaces divided by 2 (since totalSpaces is odd, we have to make one side of the spaces less than the other)
            leftSpaces = rightSpaces + 1; // Set leftSpaces to rightSpaces plus 1 (like I said in the line above, make one side of the spaces less than the other, in this case leftSpaces is greater)
        }
        System.out.print("\n"); // New line (this line is for 2nd line)
        for (int i = 1; i <= 3; i++) { // Loop: Initialize variable i to 1, set it less than or equal to 3, and increase i by 1 until loop ends
            System.out.print("*"); // Output a star for each time the loop runs (print and not println so all stars are in one line)
        }
        for (int ch = 1; ch <= leftSpaces; ch++) { // Loop: Initialize variable ch to 1, set it less than or equal to leftSpaces, and increase ch by 1 until loop ends
            System.out.print(" "); // Output a space each time the loop runs (this is the spaces on the left of the inputted message)
        }
        System.out.print(msg); // Output the inputted message (which will be centered)
        for (int ch = 1; ch <= rightSpaces; ch++) { // Loop: Initialize variable ch to 1, set it less than or equal to rightSpaces, and increase ch by 1 until loop ends
            System.out.print(" "); // Output a space each time the loop runs (this is the spaces on the right of the inputted message)
        }
        for (int i = 1; i <= 3; i++) { // Loop: Initialize variable i to 1, set it less than or equal to 3, and increase i by 1 until loop ends
            System.out.print("*"); // Output a star for each time the loop runs
        }
        System.out.print("\n"); // New line (this line is for 3rd line)
        for (int i = 1; i <= CHAR_COUNT; i++) { // Loop: Initialize variable i to 1, set it less than or equal to CHAR_COUNT (60), and increase i by 1 until loop ends
            System.out.print("*"); // Output a star for each time the loop runs
        }
    }
}
