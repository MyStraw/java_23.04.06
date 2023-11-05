package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _24736_FootballScoring {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 2; i++) {

			st = new StringTokenizer(br.readLine());

			int T = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			T = T * 6;
			F = F * 3;
			S = S * 2;
			P = P * 1;
			C = C * 2;
			
			int result = T + F + S + P + C;		

			bw.write(String.valueOf(result) + " ");			
		}
		bw.flush();
		

	}

}
