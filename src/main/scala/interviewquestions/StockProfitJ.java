package interviewquestions;

public class StockProfitJ {
    public static void main(String[] args) {
        int[] prices1 = new int[]{10, 7, 5, 8, 11, 9};
        int[] prices2 = new int[]{10, 11, 12, 13, 14, 15};
        int[] prices3 = new int[]{20, 9, 8, 7, 6, 5};

        StockProfitJ stockProfitJ = new StockProfitJ();

        System.out.println("1 = " + stockProfitJ.maxProfit(prices1));
        System.out.println("2 = " + stockProfitJ.maxProfit(prices2));
        System.out.println("3 = " + stockProfitJ.maxProfit(prices3));
    }

    private int maxProfit(int[] prices) {
        if (prices.length < 2) {
            throw new IllegalArgumentException("must have at least two prices for profit calculation");
        }

        int maxProfit = prices[1] - prices[0];
        int lowestPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            maxProfit = Math.max(maxProfit, price - lowestPrice);
            lowestPrice = Math.min(price, lowestPrice);
        }

        return maxProfit;
    }
}
