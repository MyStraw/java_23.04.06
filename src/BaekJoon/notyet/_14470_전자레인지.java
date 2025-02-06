package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14470_전자레인지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		int time = 0;

		if (A < 0) {
			time += -A * C;
			time += D;
			time += B * E;
		} else if (A == 0) {
			time += D;
			time += B * E;
		} else {
			time += (B - A) * E;
		}

		System.out.println(time);
	}

}
