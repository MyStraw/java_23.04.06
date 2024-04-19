package _코테준비_;

public class 아_동적계획법_1 {
	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 10; // 예시로 10번째 피보나치 수를 계산
		System.out.println(n + "번째 피보나치 수: " + fib(n));
	}

}

//입력: n = 10
//출력: 10번째 피보나치 수: 55.. 피보나치 수열.
//