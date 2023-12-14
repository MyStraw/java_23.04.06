package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1620_나는야_포켓몬_마스터_이다솜3 { //그냥 map 2개 쓰기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer, String> dogam = new HashMap<>();
		Map<String, Integer> magod = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String poketmon = br.readLine();
			dogam.put(i, poketmon);
			magod.put(poketmon, i);
		}

		for (int i = 1; i <= M; i++) {
			String guess = br.readLine();
			try {
				int number = Integer.parseInt(guess);
				String name = dogam.get(number);
				bw.write(String.valueOf(name) + "\n");

			} catch (Exception e) {
				int numm = magod.get(guess);
				bw.write(String.valueOf(numm) + "\n");			
			}

		}
		bw.flush();
		bw.close();
	}
}
