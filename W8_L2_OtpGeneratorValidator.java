import java.util.Arrays;

public class W8_L2_OtpGeneratorValidator {
    private static final int OTP_LENGTH = 6;
    private static final int OTP_RUN_COUNT = 10;
    private static final int OTP_MIN = 100000;
    private static final int OTP_RANGE = 900000;

    public static int generateSixDigitOtp() {
        return (int) (Math.random() * OTP_RANGE) + OTP_MIN;
    }

    public static int[] generateOtpArray(int size) {
        int[] otpArray = new int[size];

        for (int index = 0; index < size; index++) {
            otpArray[index] = generateSixDigitOtp();
        }

        return otpArray;
    }

    public static boolean areOtpsNotAllSame(int[] otpArray) {
        int firstOtp = otpArray[0];

        for (int otp : otpArray) {
            if (otp != firstOtp) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] generatedOtps = generateOtpArray(OTP_RUN_COUNT);
        boolean uniquenessValidation = areOtpsNotAllSame(generatedOtps);

        System.out.println("OTP length requirement: " + OTP_LENGTH);
        System.out.println("Generated OTPs: " + Arrays.toString(generatedOtps));
        System.out.println("Validation (not all identical): " + uniquenessValidation);
    }
}
