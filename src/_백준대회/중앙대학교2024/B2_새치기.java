package _백준대회.중앙대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_새치기 { // 만족도가 높은 애들 맨 앞으로 계속 세워서 뒤에 모든 애들의 만족도를 빼주는 방식... 근데 이건 안되네.
	// 오히려 맨 뒤에서서 앞에 애들 만족도의 합이 더 높은 경우도 생각해야함.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] student = new int[N];
		for (int i = 0; i < N; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}

		long[] dp = new long[N];
		
		dp[0] = student[0];//첫번째

		for (int i = 1; i < N; i++) {
			//맨 뒤에
			dp[i] = dp[i - 1];

			//새치기
			long manjok = student[i];
			for (int j = 0; j < i; j++) {
				manjok -= student[j];
			}
			dp[i] = Math.max(dp[i], manjok);
		}

		System.out.println(dp[N - 1]);
	}
}
