package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14893_homwrk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder result = new StringBuilder();

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			for (int n = 0; n < N; n++) {
				String[] inputs = br.readLine().split(" ");
				int A = Integer.parseInt(inputs[0]);
				int B = Integer.parseInt(inputs[1]);

				int sum = A + B;
				int product = A * B;

				result.append(sum).append(" ").append(product).append("\n");
			}
		}

		System.out.print(result);
	}

}
