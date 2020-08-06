package amazon.interview.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/interview/card/amazon/80/dynamic-programming/2998/
 * 
 * @author polymath
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[][] minCoins = new int[coins.length + 1][amount + 1];
		
		for (int j = 0; j < amount + 1; j++) {
			minCoins[0][j] = Integer.MAX_VALUE - 1;
		}
		
		for (int i = 1; i < coins.length + 1; i++) {
			for (int j = 1; j < amount + 1; j++) {
				if (j >= coins[i - 1]) {
					minCoins[i][j] = Math.min(minCoins[i][j - coins[i - 1]] + 1, minCoins[i - 1][j]);
				} else {
					minCoins[i][j] = minCoins[i - 1][j];
				}
			}
		}
		if (minCoins[coins.length][amount] == 2147483646)
			return -1;
		return minCoins[coins.length][amount];
	}

	/**
	 * Using a 1D array 
	 * Run time 17ms
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChangeV2(int[] coins, int amount) {
        int[] counts = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(counts, max);
        counts[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    counts[i] = Math.min(counts[i], counts[i - coin] + 1);
                }
            }
        }
        return counts[amount] == max ? -1 : counts[amount];
    }
	
	public static void main(String[] args) {
		CoinChange ins = new CoinChange();
		int[] coins = { 3}; int amount = 4;
		System.out.println(ins.coinChange(coins, amount));
				
	}
}
