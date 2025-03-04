package _백준대회.제2회_유틸컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _B_곱셈을누가이렇게해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();

			String gophagi = String.valueOf(Long.parseLong(A) * Long.parseLong(B));

			StringBuilder abnormalGop = new StringBuilder();
			int lenA = A.length(), lenB = B.length();
			int maxLen = Math.max(lenA, lenB);

			for (int i = 0; i < maxLen; i++) {
				int digitA = (i < lenA) ? (A.charAt(lenA - 1 - i) - '0') : 1;
				int digitB = (i < lenB) ? (B.charAt(lenB - 1 - i) - '0') : 1;
				abnormalGop.insert(0, digitA * digitB);
			}

			sb.append(abnormalGop.toString().equals(gophagi) ? "1\n" : "0\n");
		}

		System.out.print(sb);
	}

}
