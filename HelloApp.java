// HelloApp.java - A simple Java application that displays a greeting for zero
// or more command-line names.
// 
// This version accepts zero or more command-line arguments. If names are
// provided, the program uses String.join() to concatenate names with a
// comma-space delimiter and print a single greeting. If no arguments are
// provided, it falls back to "World". This demonstrates array handling,
// conditional logic, and built-in string joining utilities.
// 
// @author Udbhav
// @version 7
// 

// 
// Key Java Concepts Used:
// 1. Class Declaration - Defines a blueprint for objects
// 2. Main Method - Entry point for program execution
// 3. String Argument Array - Command-line arguments parameter
// 4. String.join() - Concatenates names with an automatic delimiter
// 5. Conditional Logic - Chooses between provided names and the default value
// 6. Delimiter Management - Avoids trailing separators automatically
// 7. System.out.println() - Standard output stream for printing
// 

public class HelloApp {
    public static void main(String[] args) {
        String names = (args.length == 0) ? "World" : String.join(", ", args);

        System.out.println("Hello, " + names + "!");
    }
}