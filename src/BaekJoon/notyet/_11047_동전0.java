package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047_동전0 { //그리디 알고리즘
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] won = new int[N];

		for (int i = 0; i < N; i++) {
			won[i] = Integer.parseInt(br.readLine());
		}
		int count = coin(won, N, K);
		System.out.println(count);
	}

	private static int coin(int[] won, int N, int K) {		
		int count = 0;
		  for (int i = N - 1; i >= 0; i--) {
		        if (K >= won[i]) {
		            count += K / won[i]; // 해당 동전으로 만들 수 있는 최대 금액을 계산
		            K %= won[i]; // 남은 금액
		        }
		    }		
		  
		return count;
	}

	

}
