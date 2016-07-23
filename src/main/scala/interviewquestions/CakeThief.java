package interviewquestions;

import java.util.Arrays;

public class CakeThief {

    private int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        System.out.println(Arrays.toString(cakeTypes));

        int[] maxWeight = new int[capacity + 1];

        maxWeight[0] = 0;

        for (int i = 1; i <= capacity; i++) {
            maxWeight[i] = 0;
            for (CakeType cakeType : cakeTypes) {
                if (cakeType.weight == i) {
                    maxWeight[i] = Math.max(maxWeight[i], cakeType.value);
                } else if (cakeType.weight < i) {
                    maxWeight[i] = Math.max(maxWeight[i], maxWeight[cakeType.weight] + maxWeight[i - cakeType.weight]);
                }
            }
        }

        System.out.println(Arrays.toString(maxWeight));

        return maxWeight[capacity];
    }

    public static void main(String[] args) {

        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        CakeThief thief = new CakeThief();

        int capacity = 20;

        System.out.println(thief.maxDuffelBagValue(cakeTypes, capacity));

        CakeType[] cakeTypes2 = new CakeType[]{
                new CakeType(3, 40),
                new CakeType(5, 70),
        };

        capacity = 9;

        System.out.println(thief.maxDuffelBagValue(cakeTypes2, capacity));
    }

    public static class CakeType implements Comparable<CakeType> {
        private int weight;
        private int value;

        public CakeType(int weight, int value) {
            if (weight < 0) throw new IllegalArgumentException("weight must be > 0");
            if (value < 0) throw new IllegalArgumentException("value must be > 0");

            this.weight = weight;
            this.value = value;
        }

        public double efficency() {
            return value / weight;
        }

        @Override
        public int compareTo(CakeType other) {
            if (other.weight == weight) {
                if (other.value == value) return 0;
                if (other.value > value) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                if (other.weight > weight) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }

        @Override
        public String toString() {
            return "CakeType{" +
                    "weight=" + weight +
                    ", value=" + value +
                    ", effiency=" + efficency() +
                    '}';
        }
    }
}
