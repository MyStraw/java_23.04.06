package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _5월13일스터디_탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] <= arr[j]) {
					arr[i] = j + 1;
					break;
				} else {
					arr[i] = 0;
				}
			}
		}
		arr[0] = 0;

		for (int top : arr) {
			bw.write(top + " ");
		}
		br.close();
		bw.flush();
		bw.close();	
	}
}

//9

//10 6 7 4 5 2 3 1 9
