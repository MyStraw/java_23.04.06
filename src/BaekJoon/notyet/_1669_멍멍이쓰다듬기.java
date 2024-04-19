package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1669_멍멍이쓰다듬기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int next1 = 0;
		int next2 = 1;
		int next3 = 2;

		int count = 0;

		int now = a + 1;
		int last = b - 1;

		int plus = 1;

		for (int i = 0; i < b - a; i++) {
			if (now + next1 + plus != last | now + next2 + plus != last | now + next3 + plus != last) {
				for (int j = -1; j <= 1; j++) {
					plus += j;
					if (plus != 0) {						
						count++;
					}
				}
			} else if (now + next1 + plus == last | now + next2 + plus == last | now + next3 + plus == last) {
				break;
			}
		}
		System.out.println(count + 2);
	}

}
