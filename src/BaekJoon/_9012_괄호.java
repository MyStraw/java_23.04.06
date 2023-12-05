package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9012_괄호 { // 제출해
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String vps = br.readLine();
			int count = 0;
			for (char gwal : vps.toCharArray()) {
				if (gwal == '(') {
					count++;
				} else if (gwal == ')') {
					count--;
				}
				if (count < 0) {
					bw.write("NO\n");
					break;
				}
			}
			if (count == 0) {
				bw.write("YES\n");
			} else if (count > 0) {
				bw.write("NO\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
