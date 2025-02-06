package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23976_문자열나누기 {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String S = br.readLine();

		long[][][] dp = new long[N + 1][K + 1][2];

		dp[0][0][0] = 1;

		for (int i = 1; i <= N; i++) {
			char c = S.charAt(i - 1);
			for (int j = 1; j <= Math.min(i, K); j++) {
				if (c != '0') {
					dp[i][j][0] = (dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j][0]) % MOD;
				} else {
					dp[i][j][0] = dp[i - 1][j][0];
					dp[i][j][1] = (dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) % MOD;
				}
			}
		}

		System.out.println((dp[N][K][0] + dp[N][K][1]) % MOD);
	}

}
//
//3차원 DP 배열 사용: dp[i][j][k]를 사용하여 i길이의 문자열을 j개의 부분 문자열로 나누고, 마지막 부분 문자열이 0인지(k=1) 아닌지(k=0)를 구분합니다.
//0과 0이 아닌 경우 구분: 현재 문자가 0인지 아닌지에 따라 다른 로직을 적용합니다.
//Leading zero 처리: 마지막 부분 문자열이 0인 경우를 별도로 관리하여 leading zero 문제를 해결합니다.
//MOD 연산 주의: 중간 계산 과정에서도 MOD 연산을 적용하여 오버플로우를 방지합니다.
//초기화: dp[0][0][0] = 1로 초기화하여 빈 문자열에 대한 경우를 고려합니다.
//최종 결과: dp[N][K][0]과 dp[N][K][1]의 합을 MOD로 나눈 나머지를 출력합니다.
//
//이전 코드의 주요 문제점은 다음과 같았습니다:
//
//Leading zero를 제대로 처리하지 못했습니다.
//0과 0이 아닌 경우를 구분하지 않았습니다.
//DP 배열의 차원이 부족하여 모든 경우를 고려하지 못했습니다.
