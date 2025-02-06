package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15922_아우으우아으이야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] segments = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			segments[i][0] = Integer.parseInt(st.nextToken());
			segments[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(segments, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			} else {
				return Integer.compare(a[0], b[0]);
			}
		});

		long totalLength = 0;
		int currentStart = segments[0][0];
		int currentEnd = segments[0][1];

		for (int i = 1; i < N; i++) {
			if (segments[i][0] <= currentEnd) {
				currentEnd = Math.max(currentEnd, segments[i][1]);
			} else {
				totalLength += currentEnd - currentStart;
				currentStart = segments[i][0];
				currentEnd = segments[i][1];
			}
		}

		totalLength += currentEnd - currentStart;

		bw.write(totalLength + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
