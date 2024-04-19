package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10610_30 { //숫자를 String으로 입력을 받고, 각 자리수를 각각 int 배열에 넣을때, 아스키코드값 '0'만큼 빼면 char에 해당하는 그 숫자가 나옴
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();

		Integer[] num = new Integer[N.length()];

		for (int i = 0; i < N.length(); i++) {
			num[i] = N.charAt(i) - '0';
		}

		int sum = 0;
		boolean zero = false;

		for (int i = 0; i < N.length(); i++) {
			sum += num[i];
			if (num[i] == 0) {
				zero = true;
			}
		}
		if (sum % 3 == 0 && zero) {
			Arrays.sort(num, (a, b) -> b - a);
			for (int a : num) {
				System.out.print(a);
			}
		}
		else {
			System.out.println(-1);
		}
	}
}
