package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _10989_수정렬하기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String num[] = new String[N];

		for (int i = 0; i < N; i++) {			
			num[i] = br.readLine();
		}

		Arrays.sort(num);

		for (String r : num) {
			bw.write(r +"\n");
		}
		bw.flush();
		bw.close();
	}
}
