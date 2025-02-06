package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26163_문제출제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] v = new int[5];
		for (int i = 0; i < 5; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

		int mx = 0;
	
		for (int n = 1; n <= 15; n++) {		
			for (int a = 0; a <= n; a++) {				
				for (int b = 0; a + b <= n; b++) {					
					for (int c = 0; a + b + c <= n; c++) {						
						for (int d = 0; a + b + c + d <= n; d++) {						
							int e = n - (a + b + c + d);
							int t = a * 1 + b * 2 + c * 3 + d * 4 + e * 5;
						
							if ((n <= 3 && t > 10) || t > 15) {
								continue;
							}
						
							int currentProfit = a * v[0] + b * v[1] + c * v[2] + d * v[3] + e * v[4];
							mx = Math.max(mx, currentProfit);
						}
					}
				}
			}
		}

		System.out.println(mx);
	}

}
