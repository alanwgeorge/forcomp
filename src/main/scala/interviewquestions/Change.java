package interviewquestions;

import java.util.*;

public class Change {
    public static void main(String[] args) {
        Change change = new Change();

        System.out.println(change.makeChange(100, new int[] {10,2,5,1}));
    }

    public List<Map<Integer, Integer>> makeChange(int change, int[] denomiations) {
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
}
