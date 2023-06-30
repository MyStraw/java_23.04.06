package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _7월1일_야구게임4 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		List<Integer> aa = new ArrayList<>();
		List<Integer> bb = new ArrayList<>();

		for (int i = 100; i <= 999; i++) {
			if (Integer.toString(i).charAt(0) != Integer.toString(i).charAt(1)
					&& Integer.toString(i).charAt(1) != Integer.toString(i).charAt(2)
					&& Integer.toString(i).charAt(0) != Integer.toString(i).charAt(2)
					&& Integer.toString(i).charAt(1) != '0' && Integer.toString(i).charAt(2) != '0') {
				aa.add(i);
			}
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String num = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			for (int c : aa) {
				int strikecount = 0;
				int ballcount = 0;

				strikecount = extracted(c, 0, num, 0, strikecount);
				strikecount = extracted(c, 1, num, 1, strikecount);
				strikecount = extracted(c, 2, num, 2, strikecount);

				ballcount = extracted(c, 0, num, 1, ballcount);
				ballcount = extracted(c, 0, num, 2, ballcount);
				ballcount = extracted(c, 1, num, 0, ballcount);
				ballcount = extracted(c, 1, num, 2, ballcount);
				ballcount = extracted(c, 2, num, 0, ballcount);
				ballcount = extracted(c, 2, num, 1, ballcount);

				if (strike == strikecount && ball == ballcount) {
					bb.add(c);
				}
			}
			aa= new ArrayList<>(bb);
			bb.clear();
		}
		bw.write(String.valueOf(aa.size()));
		bw.flush();
		bw.close();
	}

	private static int extracted(int c, int charAt1, String num, int charAt2, int count) {
		if (Integer.toString(c).charAt(charAt1) == num.charAt(charAt2)) {
			count++;
		}
		return count;
	}
}

/**
 * 4 123 1 1 356 1 0 327 2 0 489 0 1
 **/
