package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1620_나는야_포켓몬_마스터_이다솜 {//반복문 땜에 시간초과 실패
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer, String> dogam = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String poketmon = br.readLine();
			dogam.put(i, poketmon);
		}

		for (int i = 1; i <= M; i++) {
			String guess = br.readLine();
			try {
				int number = Integer.parseInt(guess);
				String name = dogam.get(number);
				bw.write(String.valueOf(name) + "\n");

			} catch (Exception e) {							
				for (int j = 1; j <= N; j++) {
					if (dogam.get(j).equals(guess)) {
						bw.write(String.valueOf(j) + "\n");
						break;
					}
				}
			}
//			try {
//				int number = Integer.parseInt(guess);
//				String name = dogam.get(number);
//				bw.write(String.valueOf(name) + "\n");
//
//			} catch (Exception e) {
//				for (Map.Entry<Integer, String> entry : dogam.entrySet()) {
//					if (entry.getValue().equals(guess)) {
//						bw.write(String.valueOf(entry.getKey()+"\n"));
//						break;
//					}
//				}
//			}
		}
		bw.flush();
		bw.close();
	}
}
