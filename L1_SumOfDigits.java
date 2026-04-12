import java.util.Arrays;

public class L1_SumOfDigits {
    private static final int MIN_FOUR_DIGIT = 1000;
    private static final int FOUR_DIGIT_RANGE = 9000;

    public int generateFourDigitRandomNumber() {
        return (int) (Math.random() * FOUR_DIGIT_RANGE) + MIN_FOUR_DIGIT;
    }

    public int countDigits(int number) {
        int digitCount = 0;
        int workingNumber = Math.abs(number);

        if (workingNumber == 0) {
            return 1;
        }

        while (workingNumber > 0) {
            digitCount++;
            workingNumber /= 10;
        }

        return digitCount;
    }

    public int[] extractDigitsAsArray(int number, int digitCount) {
        int[] digits = new int[digitCount];
        int workingNumber = Math.abs(number);

        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = workingNumber % 10;
            workingNumber /= 10;
        }

        return digits;
    }

    public int findSumOfArrayElements(int[] values) {
        int totalSum = 0;

        for (int value : values) {
            totalSum += value;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        L1_SumOfDigits sumOfDigitsProgram = new L1_SumOfDigits();
        int randomNumber = sumOfDigitsProgram.generateFourDigitRandomNumber();
        int digitCount = sumOfDigitsProgram.countDigits(randomNumber);
        int[] digitArray = sumOfDigitsProgram.extractDigitsAsArray(randomNumber, digitCount);
        int sumOfDigits = sumOfDigitsProgram.findSumOfArrayElements(digitArray);

        System.out.println("Random Number: " + randomNumber);
        System.out.println("Digits Count: " + digitCount);
        System.out.println("Digits Array: " + Arrays.toString(digitArray));
        System.out.println("Sum of Digits: " + sumOfDigits);
    }
}
