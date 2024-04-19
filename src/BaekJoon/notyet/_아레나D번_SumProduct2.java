package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _아레나D번_SumProduct2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];

		int start = 0, end = 0;
		int total = num[0];
		int gob = num[0];
		int count = 0;

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		while (end < N && start <= end) {
			if (total == gob) {
				count++;
				end++;
				if (end < N) {
					total += num[end];
					gob *= num[end];
				}
			} else if (total > gob) {
				total -= num[start];
				gob /= num[start];
				start++;
			} else {
				end++;
				if (end < N) {
					total += num[end];
					gob *= num[end];
				}
			}
		}
		System.out.println(count + N);	
	}

}
