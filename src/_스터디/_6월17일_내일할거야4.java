package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _6월17일_내일할거야4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] N = new int[n][2];

		int last = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken()); //띄움표시를 기준으로.
			int t = Integer.parseInt(st.nextToken());
			N[i][0] = d;
			N[i][1] = t;
		}
		Arrays.sort(N, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		for (int i = n - 1; i >= 0; i--) { //if는 쓸때 조심해서 쓰자.
			if (last <= N[i][1] && i != n - 1) {
				last = last - N[i][0];
			} else
				last = N[i][1] - N[i][0] + 1;
		}
		System.out.println(last - 1);
	}
}
