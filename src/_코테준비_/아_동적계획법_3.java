package _코테준비_;

import java.util.Arrays;

public class 아_동적계획법_3 {
	public static int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		System.out.println("최소 동전 개수: " + coinChange(coins, amount));
	}

}

//입력: coins = [1, 2, 5], amount = 11
//출력: 최소 동전 개수: 3