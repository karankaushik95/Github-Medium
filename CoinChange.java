import java.util.*;

class CoinChange {
    public static int coinChange(int[] coins, int amount) {

        // Converting to a primitive type array because you can't reverse sort a normal
        // int array.
        Integer[] primitiveCoins = Arrays.stream(coins) // IntStream
                .boxed() // Stream<Integer>
                .toArray(Integer[]::new);

        // Arrays.sort(primitiveCoins, Collections.reverseOrder());
        int numberOfCoins = changeCalculator(primitiveCoins, amount, 0);
        // return numberOfCoins;
        if (numberOfCoins == 999) {
            return -1;
        } else {
            return numberOfCoins;
        }
    }

    public static int changeCalculator(Integer[] coins, int amount, int numberOfCoins) {

        if (amount == 0) {
            return numberOfCoins; // Found a solution, go for it
        }

        if (coins.length == 0 && amount > 0) {
            return 999; // Did not find a solution. Sad!
        }
        int left = 999; // Left Subtree
        int right = 999; // Right subtree

        left = changeCalculator(Arrays.copyOfRange(coins, 1, coins.length), amount % coins[0],
                numberOfCoins + amount / coins[0]); // Include this coin

        right = changeCalculator(Arrays.copyOfRange(coins, 1, coins.length), amount, numberOfCoins); // Exclude this
                                                                                                     // coin

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        int amount = 6249;
        int[] coins = { 186, 419, 83, 408 };
        System.out.println(coinChange(coins, amount));
    }

}