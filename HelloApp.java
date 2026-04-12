// HelloApp.java - A simple Java application that displays a greeting for zero
// or more command-line names.
// 
// This version accepts zero or more command-line arguments. If names are
// provided, the program uses an enhanced for loop to build a comma-separated
// list and prints a single greeting. If no arguments are provided, it falls
// back to "World". This demonstrates array handling, conditional logic, and
// StringBuilder for building output.
// 
// @author Udbhav
// @version 5
// 

// 
// Key Java Concepts Used:
// 1. Class Declaration - Defines a blueprint for objects
// 2. Main Method - Entry point for program execution
// 3. String Argument Array - Command-line arguments parameter
// 4. Enhanced For Loop - Iterates through all provided arguments
// 5. Conditional Logic - Chooses between provided names and the default value
// 6. StringBuilder - Efficiently builds the comma-separated name list
// 7. System.out.println() - Standard output stream for printing
// 

public class HelloApp {
    public static void main(String[] args) {
        StringBuilder nameBuilder = new StringBuilder();

        if (args.length == 0) {
            nameBuilder.append("World");
        } else {
            for (String name : args) {
                if (nameBuilder.length() > 0) {
                    nameBuilder.append(", ");
                }
                nameBuilder.append(name);
            }
        }

        System.out.println("Hello, " + nameBuilder + "!");
    }
}