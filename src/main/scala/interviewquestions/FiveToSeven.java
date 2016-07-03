package interviewquestions;

import java.security.SecureRandom;
import java.util.Arrays;

public class FiveToSeven {
    static SecureRandom random = new SecureRandom();

    public static int rand5() {
        return random.nextInt(5) + 1;
    }

    public static int rand7() {
        while (true) {
            int rand = (rand5() -1) * 5 + (rand5() - 1) + 1;
            if (rand > 21) continue;
            return (rand % 7) + 1 ;
        }
    }

    public static void main(String[] args) {
        int[] valueCounts = new int[7];
        int numOfRandoms = 30000;

        for (int i = 0; i < numOfRandoms; i++) {
            int value = FiveToSeven.rand7();

            valueCounts[value - 1]++;
        }

        System.out.println("value counts: " + Arrays.toString(valueCounts));
    }
}
