package interviewquestions;

import java.util.Arrays;

public class CakeThief {

    private int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        Arrays.sort(cakeTypes);
        System.out.println(Arrays.toString(cakeTypes));

        int remainingCapacity = capacity;
        int totalValue = 0;

            for (int i = cakeTypes.length - 1; i >= 0; i--) {
                System.out.println("cakeType: "+ cakeTypes[i]);
                while (cakeTypes[i].weight <= remainingCapacity) {
                    totalValue = totalValue + cakeTypes[i].value;
                    remainingCapacity = remainingCapacity - cakeTypes[i].weight;
                }
                System.out.println("totalValue: " + totalValue);
                System.out.println("remainingCapacity: " + remainingCapacity);
            }

        return totalValue;
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
            if (other.efficency() == efficency()) return 0;
            if (other.efficency() > efficency()) {
                return -1;
            } else {
                return 1;
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
