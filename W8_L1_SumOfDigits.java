import java.util.Arrays;

public class W8_L1_SumOfDigits {
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

    public int[] getDigitsArray(int number, int digitCount) {
        int[] digits = new int[digitCount];
        int workingNumber = Math.abs(number);

        for (int index = digitCount - 1; index >= 0; index--) {
            digits[index] = workingNumber % 10;
            workingNumber /= 10;
        }

        return digits;
    }

    public int findSumOfDigitsInArray(int[] digits) {
        int totalSum = 0;
        for (int digit : digits) {
            totalSum += digit;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        W8_L1_SumOfDigits program = new W8_L1_SumOfDigits();
        int randomNumber = program.generateFourDigitRandomNumber();
        int digitCount = program.countDigits(randomNumber);
        int[] digitsArray = program.getDigitsArray(randomNumber, digitCount);
        int sumOfDigits = program.findSumOfDigitsInArray(digitsArray);

        System.out.println("Random Number: " + randomNumber);
        System.out.println("Digit Count: " + digitCount);
        System.out.println("Digits: " + Arrays.toString(digitsArray));
        System.out.println("Sum of Digits: " + sumOfDigits);
    }
}
