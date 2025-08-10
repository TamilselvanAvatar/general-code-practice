package generalAmbiguous;

/**
 * Given an array where each element represents the price of a stock on the {@code i}th day,
 * this method finds the maximum profit that can be made by buying and selling the stock.
 * <p>
 * You can only hold one stock at a time — a stock must be sold before buying again.
 *
 * <p><b>Example:</b></p>
 * <pre>
 * Input:  [100, 180, 260, 310, 40, 535, 695]
 * Output: Maximum Profit = 865
 * Explanation:
 *   Buy on day 0 (price = 100), sell on day 3 (price = 310),
 *   buy on day 4 (price = 40), sell on day 6 (price = 695)
 *   Total profit = (310 - 100) + (695 - 40) = 865
 * </pre>
 *
 * <p>return: The maximum profit that can be achieved.</p>
 */

public class StockProfitCalculation {
    public static void main(String[] args) {
        Integer[] arr = {180, 100, 260, 310, 40, 535, 695};
        stockProfitCalculation(arr);
    }

    private static void stockProfitCalculation(Integer[] arr) {
        int size = arr.length;
        int indexInitialStock = arr[0] > arr[1] ? 1 : 0;
        int initialStock = arr[indexInitialStock];
        int profit = 0;
        for (int i = indexInitialStock + 1; i < size; i++) {
            int currentStock = arr[i];
            if (arr[i] >= initialStock && i != size - 1) {
                continue;
            }
            profit += (i == size - 1 ? arr[i] : arr[i - 1]) - initialStock;
            initialStock = currentStock;
        }
        System.out.println("Profit " + profit);

    }
}
