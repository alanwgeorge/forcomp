package interviewquestions;

import java.util.*;

public class Change {
    public static void main(String[] args) {
        Change change = new Change();

        System.out.println(change.makeChange2(100, new int[] {10,2,5,1}));
    }

    private List<Map<Integer, Integer>> makeChange(int change, int[] denomiations) {
        System.out.println("checking ways to make " + change + " with " + Arrays.toString(denomiations));
        List<Map<Integer, Integer>> solutions = new ArrayList<>();

        for (int d = 0; d < denomiations.length; d++) {
            int runningTotal = 0;
            int count = 0;
            while (change > runningTotal) {
                runningTotal += denomiations[d];
                count++;
                if (change == runningTotal) {
                    Map<Integer, Integer> solution = new HashMap<>();
                    solution.put(denomiations[d], count);
                    solutions.add(solution);
                } else {
                    solutions.addAll(makeChange(change - runningTotal, Arrays.copyOfRange(denomiations, d + 1, denomiations.length)));
                }
            }
        }

        return solutions;
    }

    private int makeChange2(int change, int[] denominations) {
        if (change == 0) return 1;
        if (change < 0) return 0;
        if (denominations.length == 0) return 0;

        System.out.println("checking ways to make " + change + " with " + Arrays.toString(denominations));


        int currentDenomionation = denominations[0];
        int[] denominationsLeft = Arrays.copyOfRange(denominations, 1, denominations.length);

        int accumilator = 0;
        while (change >= 0) {
            accumilator += makeChange2(change, denominationsLeft);
            change -= currentDenomionation;
        }

        return accumilator;
    }

    private int changePossibilitiesTopDown(int amountLeft, int[] denominationsLeft) {

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) return 1;
        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) return 0;
        // we're out of denominations
        if (denominationsLeft.length == 0) return 0;

        System.out.println("checking ways to make " + amountLeft + " with " + Arrays.toString(denominationsLeft));

        // choose a current coin
        int current_coin = denominationsLeft[0];
        int[] restOfCoins = Arrays.copyOfRange(denominationsLeft, 1, denominationsLeft.length);

        // see how many possibilities we can get
        // for each number of times to use current_coin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown(amountLeft, restOfCoins);
            amountLeft -= current_coin;
        }

        return numPossibilities;
    }
}
