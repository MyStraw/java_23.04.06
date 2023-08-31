package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _아레나B번_FizzBuzz3 {

	public static String FizzBuzz(int n) {
		if (n % 3 == 0 && n % 5 == 0)
			return "FizzBuzz";
		if (n % 3 == 0)
			return "Fizz";
		if (n % 5 == 0)
			return "Buzz";
		return Integer.toString(n);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S1 = br.readLine();
		String S2 = br.readLine();
		String S3 = br.readLine();

		int start = 1;

		try {
			start = Integer.parseInt(S3); // S3가 숫자인 경우 시작점으로 잡습니다.
			start++;
		} catch (NumberFormatException e) {
			// S3가 숫자가 아닌 경우 (즉, Fizz, Buzz, FizzBuzz 중 하나인 경우)
			while (true) {
				if (FizzBuzz(start).equals(S1) && FizzBuzz(start + 1).equals(S2) && FizzBuzz(start + 2).equals(S3)) {
					start += 3;
					break;
				}
				start++;
			}
		}

		bw.write(FizzBuzz(start));		

		br.close();
		bw.flush();
		bw.close();
	}
}