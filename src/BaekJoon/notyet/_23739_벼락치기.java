package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23739_벼락치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] thunder = new int[N];
	
		int ans = 0;
		int sum = 0;	

		for (int i = 0; i < N; i++) {
			thunder[i] = Integer.parseInt(br.readLine());
			
			if ((thunder[i] + 1) / 2 <= 30 - sum) {
				ans++;
			}
			sum += thunder[i];
			if (sum >= 30) {
				sum = 0;
			}
		}	
		System.out.println(ans);
	}

}
