package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4470_줄번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i + ". ");
			sb.append(br.readLine());

			bw.write(String.valueOf(sb));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
