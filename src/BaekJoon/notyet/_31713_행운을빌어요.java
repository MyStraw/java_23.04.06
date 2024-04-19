package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _31713_행운을빌어요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A * 3 <= B && A * 4 >= B || (A == 0 && B == 0)) {
				bw.write("0\n");
			} else if (A * 3 > B) {
				bw.write(String.valueOf(A * 3 - B) + "\n");
			} else if (A * 4 < B) {
				bw.write(String.valueOf(recur(A, B, count)) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	public static int recur(int A, int B, int count) {
		int needJul = 0;
		if (B % 4 != 0) {
			needJul = B / 4 + 1;
			count = count + (needJul - A);
			A = needJul;

		} else {
			needJul = B / 4;
			count = count + needJul - A;
			A = needJul;
		}

		if (A * 3 <= B && A * 4 >= B) {
			return count;
		}

		else {
			int needIp = Math.min(Math.abs(B - A * 3), A * 4 - B);
			count = count + needIp;
			B = B + needIp;
		}

		if (A * 3 <= B && A * 4 >= B) {
			return count;
		}

		return -1;
	}
}
