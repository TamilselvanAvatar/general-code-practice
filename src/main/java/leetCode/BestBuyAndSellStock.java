package leetCode;

/**
 * Description: <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/">Link</a>
 * <p>Best Buy And Sell Stock</p>
 */

public class BestBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 1, 3, 6, 4};
        /*
        int[] arr = {7, 1, 5, 3, 6, 4};
        int[] arr = {7,6,4,3,1};
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4}  ;
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {1, 2};
        int[] arr = {2, 4, 1};
        */
        System.out.println("Max Profit: " + maxProfit(arr));
        System.out.println("Max Profit When Buy And Sell One Time: " + maxProfitWhenBuyAndSellOneTime(arr));
    }

    public static int maxProfit(int[] prices) {
        // Greedy Algorithm
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    public static int maxProfitWhenBuyAndSellOneTime(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int currentPrice : prices) {
            if (minPrice > currentPrice) {
                minPrice = currentPrice;
            } else {
                maxProfit = Math.max(maxProfit, currentPrice - minPrice);
            }
            System.out.println("STEP: currentPrice = " + currentPrice + " minPrice = " + minPrice + " maxPrice = " + maxProfit);
        }
        return maxProfit;
    }

    public static int maxProfitNotBestOne(int[] prices) {
        int profit = 0;
        int increment = 0;
        while (increment < prices.length) {
            int[] buy = findNextMinStock(prices, increment);
            int[] sell = findNextHighStock(prices, buy[0], buy[1] + 1);
            profit += (sell[0] - buy[0]);
            increment += sell[1];
        }
        return profit;
    }

    public static int[] findNextHighStock(int[] prices, int curStock, int startFrom) {
        int index = startFrom;
        int maxStock = curStock;
        for (int i = startFrom; i < prices.length; i++) {
            int stock = prices[i];
            if (stock > maxStock) {
                index = i;
                maxStock = stock;
            } else {
                if (i > index) {
                    break;
                }
            }
        }
        return new int[]{maxStock, index};
    }

    public static int[] findNextMinStock(int[] prices, int startFrom) {
        int index = startFrom;
        int minStock = prices[startFrom];
        boolean isMaxFindInTheMiddle = false;
        for (int i = startFrom; i < prices.length; i++) {
            int stock = prices[i];
            if (stock == 0) {
                continue;
            }
            if (minStock >= stock) {
                if (isMaxFindInTheMiddle) {
                    break;
                }
                index = i;
                minStock = stock;
            } else {
                isMaxFindInTheMiddle = true;
            }
        }
        return new int[]{minStock, index};
    }
}
