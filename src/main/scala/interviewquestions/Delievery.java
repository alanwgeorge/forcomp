package interviewquestions;

import java.util.Arrays;
import java.util.Random;

public class Delievery {
    public static void main(String[] args) {
        Random random = new Random();

        int[] deliveryLog = Delievery.generateRandomDeliveryLog(21);

        deliveryLog[Math.abs(random.nextInt(deliveryLog.length))] = 0;
        deliveryLog = Arrays.stream(deliveryLog).filter(value -> value != 0).toArray();

        System.out.println(Arrays.toString(deliveryLog));

        for (int i = 0; i < deliveryLog.length; i++) {
            if (i % 2 == 0 && deliveryLog[i] != deliveryLog[i + 1]) {
                System.out.println(deliveryLog[i]);
                break;
            }
        }
    }

    public static int[] generateRandomDeliveryLog(int numberOfOrders) {
        Random random = new Random();

        int[] orderIds = new int[numberOfOrders];
        int[] deliveryLog = new int[numberOfOrders * 2];
        Arrays.fill(deliveryLog, 0);

        for (int i = 0; i < numberOfOrders; i++) {
            orderIds[i] = Math.abs(random.nextInt());
        }

        for (int i = 0; i < numberOfOrders; i++) {
            int orderLogIdx = Math.abs(random.nextInt(deliveryLog.length));

            while (deliveryLog[orderLogIdx] != 0) {
                orderLogIdx = Math.abs(random.nextInt(deliveryLog.length));
            }

            deliveryLog[orderLogIdx] = orderIds[i]; // take off

            while (deliveryLog[orderLogIdx] != 0) {
                orderLogIdx = Math.abs(random.nextInt(deliveryLog.length));
            }

            deliveryLog[orderLogIdx] = orderIds[i]; // landing
        }

        System.out.println(Arrays.toString(orderIds));
        Arrays.sort(deliveryLog);
        System.out.println(Arrays.toString(deliveryLog));

        return deliveryLog;
    }
}
