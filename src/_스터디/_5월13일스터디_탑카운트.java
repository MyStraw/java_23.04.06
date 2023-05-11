package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _5월13일스터디_탑카운트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		int[] copy = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = arr.length - 1; i > 0; i--) {
			int count = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] <= arr[j]) {
					count += 1;
					copy[i] = i - count + 1;
					break;
				} else {
					count += 1;
				}
				if (count == arr.length) {
					copy[i] = 0;
				}
			}
		}
		copy[0] = 0;

		for (int top : copy) {
			bw.write(top + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
