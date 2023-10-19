/*
Write a Java program A1p2.java with a public class A1p2 and no named packages that accepts a command line argument m that is assumed to be a multiple of 60 (e.g. 60,120,etc). Generate a string of m random upper case English characters and store them in a char array. Design three additional methods other than the main method each of which is supposed to convert one-third of the m chars in your array in place into a backward-offset lower case version (i.e. ‘A’→’z’, ‘B’→’a’, ‘C’→’b’,…, ‘Y’→’x’, ‘Z’→’y’). Print out the string (i.e. all array elements) both before and after conversion on two separate lines. You can choose which one-third of the m chars of the array each of the three methods will convert, as long as their combined work converts all m chars. Can you imagine how you would change your program if four additional methods should be created to do the conversion, each of which converts one-fourth of the m chars? What about five methods? Six methods? Just submit the three-method version. A sample run can be seen later.
*/

import java.util.*;

public class A1p2 {
    static char[] characterArray;
    static int[] rangeIndices = new int[6];

    public static void main(String[] arguments) {
        try {
            // Parse command line argument
            int totalCharacters = Integer.parseInt(arguments[0]);

            // Check if the total number of characters is a multiple of 60
            if (totalCharacters % 60 != 0) {
                System.out.println("Total characters must be a multiple of 60");
                return;
            } else {
                characterArray = new char[totalCharacters];
                rangeIndices[0] = 0;
                rangeIndices[5] = totalCharacters - 1;

                // Initialize range indices based on the specified structure
                for (int i = 1; i < 5; i++) {
                    rangeIndices[i] = rangeIndices[i - 1] + (totalCharacters / 3) - 1;
                    rangeIndices[i + 1] = rangeIndices[i] + 1;
                    i++;
                }

                int[] temporaryArray = new int[totalCharacters];
                Random randomGenerator = new Random();

                // Generate a random string of uppercase characters
                for (int i = 0; i < characterArray.length; i++) {
                    int randomCharInt = (int) (randomGenerator.nextFloat() * 26) + 65;
                    characterArray[i] = (char) randomCharInt;
                }

                System.out.println("Generated a string of " + totalCharacters + " chars.");
                System.out.println("Original random upper case string:");

                // Print the original string
                for (int i = 0; i < characterArray.length; i++) {
                    System.out.print(characterArray[i]);
                    if (i == characterArray.length - 1) {
                        System.out.print("\n");
                    }
                }

                // Call the three methods
                convertAndReverseFirstRange();
                convertAndReverseSecondRange();
                convertAndReverseThirdRange();

                System.out.println("Backward-offset lower case string:");

                // Print the modified string
                for (int i = 0; i < characterArray.length; i++) {
                    System.out.print(characterArray[i]);
                    if (i == characterArray.length - 1) {
                        System.out.print("\n");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No valid argument provided");
        }
    }

    // Convert characters in the first range to lowercase and then reverse them
    public static void convertAndReverseFirstRange() {
        int start = rangeIndices[0];
        int end = rangeIndices[1];

        // Setting all characters in the first range to lowercase.
        for (int i = start; i <= end; i++) {
            characterArray[i] = (char) ((int) characterArray[i] + 32);
        }

        // Reversing all characters in the first range.
        for (int i = start; i <= end; i++) {
            int currentChar = (int) characterArray[i];
            if (currentChar == 97) {
                characterArray[i] = 'z';
            } else {
                characterArray[i] = (char) (currentChar - 1);
            }
        }
    }

    // Convert characters in the second range to lowercase and then reverse them
    public static void convertAndReverseSecondRange() {
        int start = rangeIndices[2];
        int end = rangeIndices[3];

        // Setting all characters in the second range to lowercase.
        for (int i = start; i <= end; i++) {
            characterArray[i] = (char) ((int) characterArray[i] + 32);
        }

        // Reversing all characters in the second range.
        for (int i = start; i <= end; i++) {
            int currentChar = (int) characterArray[i];
            if (currentChar == 97) {
                characterArray[i] = 'z';
            } else {
                characterArray[i] = (char) (currentChar - 1);
            }
        }
    }

    // Convert characters in the third range to lowercase and then reverse them
    public static void convertAndReverseThirdRange() {
        int start = rangeIndices[4];
        int end = rangeIndices[5];

        // Setting all characters in the third range to lowercase.
        for (int i = start; i <= end; i++) {
            characterArray[i] = (char) ((int) characterArray[i] + 32);
        }

        // Reversing all characters in the third range.
        for (int i = start; i <= end; i++) {
            int currentChar = (int) characterArray[i];
            if (currentChar == 97) {
                characterArray[i] = 'z';
            } else {
                characterArray[i] = (char) (currentChar - 1);
            }
        }
    }
}

