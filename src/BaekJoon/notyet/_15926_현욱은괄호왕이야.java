package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _15926_현욱은괄호왕이야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int maxLen = 0;
		int[] dp = new int[n];
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '(') {
				stk.push(i);
			} else {
				if (!stk.isEmpty()) {
					int openIdx = stk.pop();
					dp[i] = i - openIdx + 1;
					if (openIdx > 0) {
						dp[i] += dp[openIdx - 1];
					}
					maxLen = Math.max(maxLen, dp[i]);
				}
			}
		}

		System.out.println(maxLen);
	}

}
