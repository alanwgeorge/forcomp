package interviewquestions;

import java.security.SecureRandom;
import java.util.Arrays;

public class SevenToFive {
    static SecureRandom random = new SecureRandom();

    public static int rand7() {
        return random.nextInt(7) + 1;
    }

    public static int rand5() {
        int rand = rand7();

        while (rand >= 6) {
            rand = rand7();
        }

        return rand;
    }

    public static void main(String[] args) {
        int[] valueCounts = new int[5];
        int numOfRandoms = 30000;

        for (int i = 0; i < numOfRandoms; i++) {
            int value = SevenToFive.rand5();

            valueCounts[value - 1]++;
        }

        System.out.println("value counts: " + Arrays.toString(valueCounts));
    }
}
