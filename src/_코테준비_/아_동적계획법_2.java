package _코테준비_;

public class 아_동적계획법_2 {
	public static int maxScore(int[][] scores) {
		int m = scores.length, n = scores[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = scores[0][0];
		for (int i = 1; i < m; i++)
			dp[i][0] = dp[i - 1][0] + scores[i][0];
		for (int j = 1; j < n; j++)
			dp[0][j] = dp[0][j - 1] + scores[0][j];
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + scores[i][j];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] scores = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println("최대 점수: " + maxScore(scores));
	}

}

//입력: scores = [[1,3,1],[1,5,1],[4,2,1]]
//출력: 최대 점수: 8