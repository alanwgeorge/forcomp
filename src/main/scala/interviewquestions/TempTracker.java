package interviewquestions;

public class TempTracker {
    private static final int MAX_TEMP_INDEX = 111;

    private int[] temps = new int[MAX_TEMP_INDEX];
    private int totalNumberOfTemps = 0;
    private int sumOfAllTemps = 0;
    private int minTemp = -1;
    private int maxTemp = -1;
    private int mode = -1;

    public void insert(int temp) {
        if (temp >= 0 && temp <= 110) {
            temps[temp]++;
            totalNumberOfTemps++;
            sumOfAllTemps = sumOfAllTemps + temp;
            if (minTemp == -1 || minTemp > temp) minTemp = temp;
            if (maxTemp == -1 || maxTemp < temp) maxTemp = temp;
            if (mode == -1 || temps[temp] > temps[mode]) mode = temp;
        }
    }

    public int getMax() {
        return maxTemp;
    }

    public int getMin() {
        return minTemp;
    }

    public double getMean() {
        return sumOfAllTemps / totalNumberOfTemps;
    }

    public int getMode() {
        return mode;
    }

    public static void main(String[] args) {
        TempTracker tempTracker = new TempTracker();

        tempTracker.insert(100);
        tempTracker.insert(50);
        tempTracker.insert(80);
        tempTracker.insert(80);
        tempTracker.insert(100);
        tempTracker.insert(0);
        tempTracker.insert(110);

        System.out.println("getMax: " + tempTracker.getMax());
        System.out.println("getMin: " + tempTracker.getMin());
        System.out.println("getMean: " + tempTracker.getMean());
        System.out.println("getMode: " + tempTracker.getMode());
    }
}
