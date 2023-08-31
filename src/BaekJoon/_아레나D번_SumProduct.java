package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _아레나D번_SumProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];

		int total = 0;
		int gob = 1;
		int count = 0;

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0+i; j <N; j++) {
				if (i != j) {
					total += num[j];
					gob *= num[j];						
				}
				if (total == gob) {
					count ++;
				}
			}
		}
		bw.write(count + N);
		bw.flush();
		bw.close();
	}

}
