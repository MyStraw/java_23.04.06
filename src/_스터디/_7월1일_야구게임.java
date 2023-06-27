package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7월1일_야구게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		int s = 123;
		String f = "123";
		System.out.println(f.charAt(0));
		System.out.println(f.contains("1"));
		String q = Integer.toString(s);
		System.out.println(q.charAt(0));
		System.out.println(q.contains("1"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()); // 띄움표시를 기준으로.
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			String nums = Integer.toString(num);

			boolean sttrue = false;
			boolean bltrue = false;
			int strikecount = 0;
			int ballcount = 0;

			for (int k = 0; k < 3; k++) {

				for (int j = 1; j <= 9; j++) { // 이럼 안되네, 1~9 까지 3가지니까
					if (nums.charAt(0) == Integer.toString(j).charAt(0)) {
						strikecount++;
					}
					if (nums.charAt(1) == Integer.toString(j).charAt(1)) {
						strikecount++;
					}
					if (nums.charAt(2) == Integer.toString(j).charAt(2)) {
						strikecount++;
					}

					if (nums.contains(Integer.toString(j)) && ff == true) {
						ballcount++;
						ff = true;
						bltrue = true;
					}
				}
				//달팽이 8퀸처럼?

			}

		}

	}
}
