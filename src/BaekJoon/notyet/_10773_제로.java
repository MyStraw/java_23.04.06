package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _10773_제로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());

		Stack<Integer> zero = new Stack<>();
		int total = 0;

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				zero.add(num);
				total = total + num;
			} else if (num == 0) {
				total = total - zero.pop();
			}
		}
		bw.write(String.valueOf(total));
		bw.flush();
		bw.close();

	}
}
