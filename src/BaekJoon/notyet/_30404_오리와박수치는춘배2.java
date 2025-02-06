package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30404_오리와박수치는춘배2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int X[] = new int[N];
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		int count = N;

		
		int lastClap = -1;

		for (int i = 0; i < N; i++) {		
			int nowClap = X[i];			
			if (lastClap < nowClap) {				
				lastClap = nowClap + K;
			} else {				
				count--;
			}
		}
		System.out.println(count);

	}

}
