package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int A[] = new int[N];
		ArrayList<Integer> ar = new ArrayList<>();
		
		int total = 0;
		boolean find = false;
		int min = 300000;
		int gap = 0;

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}		
		

		for (int i = 0; i < N - 2; i++) {
			if (find)
				break;
			for (int j = i + 1; j < N - 1; j++) {
				if (find)
					break;
				for (int k = j + 1; k < N; k++) {
					total = A[i] + A[j] + A[k];
					ar.add(total);
					if (total == M) {
						find = true;
						break;
					}					
				}
			}
		}		
		for (int i = 0 ; i < ar.size(); i++) {
			if (ar.get(i) == M) {
				System.out.println(total);
			}
			ar.sort(null);
			if (min > ar.get(i));
			
		}
	}
}
