package _코테준비_구현연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현1연습 {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[st.countTokens()];
		int N = st.countTokens();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());		
		}

		System.out.println(sumOfEvens(arr));

	}

	private static int sumOfEvens(int[] arr) {
		int sum = 0;
		for (int number : arr) {
			if (number % 2 == 0) {
				sum += number;
			}
		}
		return sum;
	}

}
