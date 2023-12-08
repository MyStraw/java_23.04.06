package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int tong[] = new int[N];

		int total = 0;

		for (int i = 0; i < N; i++) {
			tong[i] = Integer.parseInt(br.readLine());
			total += tong[i];

		}
		
		//계수정렬을 이용해서 counts[br.readLine()++] 하려고 했는데
		//이건 음수를 표현못하잖아.
	

		int sansul = total / N;
		System.out.printf("%d", sansul);
		System.out.println();
		Arrays.sort(tong);		
		System.out.println(tong[N / 2]);
		System.out.println(tong[N - 1] - tong[0]);

	}
}
