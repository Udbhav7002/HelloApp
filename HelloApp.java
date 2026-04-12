// HelloApp.java - A simple Java application that displays a greeting for zero
// or more command-line names.
// 
// This version accepts zero or more command-line arguments. If names are
// provided, the program uses an enhanced for loop to build a comma-separated
// list and uses substring() to remove the trailing delimiter before printing
// a single greeting. If no arguments are provided, it falls back to "World".
// This demonstrates array handling, conditional logic, StringBuilder, and
// substring() for string cleanup.
// 
// @author Udbhav
// @version 6
// 

// 
// Key Java Concepts Used:
// 1. Class Declaration - Defines a blueprint for objects
// 2. Main Method - Entry point for program execution
// 3. String Argument Array - Command-line arguments parameter
// 4. Enhanced For Loop - Iterates through all provided arguments
// 5. Conditional Logic - Chooses between provided names and the default value
// 6. StringBuilder - Efficiently builds the comma-separated name list
// 7. substring() - Removes the trailing delimiter after the loop
// 8. System.out.println() - Standard output stream for printing
// 

public class HelloApp {
    public static void main(String[] args) {
        String names;

        if (args.length == 0) {
            names = "World";
        } else {
            StringBuilder nameBuilder = new StringBuilder();
            for (String name : args) {
                nameBuilder.append(name).append(", ");
            }
            names = nameBuilder.substring(0, nameBuilder.length() - 2);
        }

        System.out.println("Hello, " + names + "!");
    }
}