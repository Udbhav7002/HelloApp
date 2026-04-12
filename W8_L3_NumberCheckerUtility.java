import java.util.Arrays;
import java.util.Scanner;

public class W8_L3_NumberCheckerUtility {
    public static int countDigits(int number) {
        int workingNumber = Math.abs(number);
        int digitCount = 0;

        if (workingNumber == 0) {
            return 1;
        }

        while (workingNumber > 0) {
            digitCount++;
            workingNumber /= 10;
        }

        return digitCount;
    }

    public static int[] getDigitsArray(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        int workingNumber = Math.abs(number);

        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = workingNumber % 10;
            workingNumber /= 10;
        }

        return digits;
    }

    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static double findSumOfSquaresOfDigits(int[] digits) {
        double sum = 0.0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int index = 1; index < digits.length; index++) {
            if (digits[index] == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += (int) Math.pow(digit, power);
        }
        return sum == Math.abs(number);
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sumOfDigits = findSumOfDigits(digits);
        return sumOfDigits != 0 && Math.abs(number) % sumOfDigits == 0;
    }

    public static int[][] findDigitFrequencies(int[] digits) {
        int[][] digitFrequency = new int[10][2];
        for (int digit = 0; digit < 10; digit++) {
            digitFrequency[digit][0] = digit;
        }

        for (int digit : digits) {
            digitFrequency[digit][1]++;
        }

        return digitFrequency;
    }

    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int index = 0; index < digits.length; index++) {
            reversed[index] = digits[digits.length - 1 - index];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] firstArray, int[] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        }

        for (int index = 0; index < firstArray.length; index++) {
            if (firstArray[index] != secondArray[index]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeNumber(int[] digits) {
        int[] reversedDigits = reverseDigitsArray(digits);
        return areArraysEqual(digits, reversedDigits);
    }

    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int[] squareDigits = getDigitsArray(square);
        return findSumOfDigits(squareDigits) == number;
    }

    public static boolean isSpyNumber(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        int product = 1;

        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }

        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        String numberText = String.valueOf(number);
        String squareText = String.valueOf(square);
        return squareText.endsWith(numberText);
    }

    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static int findSumOfProperDivisors(int number) {
        int sum = 0;

        for (int divisor = 1; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                sum += divisor;
            }
        }

        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        return number > 0 && findSumOfProperDivisors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return number > 0 && findSumOfProperDivisors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return number > 0 && findSumOfProperDivisors(number) < number;
    }

    public static int findFactorial(int number) {
        int factorial = 1;

        for (int value = 2; value <= number; value++) {
            factorial *= value;
        }

        return factorial;
    }

    public static boolean isStrongNumber(int number) {
        int[] digits = getDigitsArray(number);
        int factorialSum = 0;

        for (int digit : digits) {
            factorialSum += findFactorial(digit);
        }

        return factorialSum == number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int inputNumber = scanner.nextInt();

        if (inputNumber < 0) {
            System.out.println("Please enter a non-negative integer.");
            scanner.close();
            return;
        }

        int[] digits = getDigitsArray(inputNumber);
        int[] reversedDigits = reverseDigitsArray(digits);
        int[][] frequencies = findDigitFrequencies(digits);
        int[] largestPair = findLargestAndSecondLargest(digits);
        int[] smallestPair = findSmallestAndSecondSmallest(digits);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Digit count: " + countDigits(inputNumber));
        System.out.println("Sum of digits: " + findSumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + findSumOfSquaresOfDigits(digits));
        System.out.println("Is duck number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong number: " + isArmstrongNumber(inputNumber, digits));
        System.out.println("Largest and second largest: " + Arrays.toString(largestPair));
        System.out.println("Smallest and second smallest: " + Arrays.toString(smallestPair));
        System.out.println("Is Harshad number: " + isHarshadNumber(inputNumber, digits));
        System.out.println("Reversed digits: " + Arrays.toString(reversedDigits));
        System.out.println("Is palindrome number: " + isPalindromeNumber(digits));
        System.out.println("Is prime number: " + isPrimeNumber(inputNumber));
        System.out.println("Is neon number: " + isNeonNumber(inputNumber));
        System.out.println("Is spy number: " + isSpyNumber(inputNumber));
        System.out.println("Is automorphic number: " + isAutomorphicNumber(inputNumber));
        System.out.println("Is buzz number: " + isBuzzNumber(inputNumber));
        System.out.println("Is perfect number: " + isPerfectNumber(inputNumber));
        System.out.println("Is abundant number: " + isAbundantNumber(inputNumber));
        System.out.println("Is deficient number: " + isDeficientNumber(inputNumber));
        System.out.println("Is strong number: " + isStrongNumber(inputNumber));

        System.out.println("Digit frequencies (digit -> count):");
        for (int[] row : frequencies) {
            System.out.println(row[0] + " -> " + row[1]);
        }

        scanner.close();
    }
}
