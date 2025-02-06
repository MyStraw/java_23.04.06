package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _31009_진주로가자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int jinjuFare = 0;
		List<Integer> fares = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String destination = st.nextToken();
			int fare = Integer.parseInt(st.nextToken());

			if (destination.equals("jinju")) {
				jinjuFare = fare;
			}
			fares.add(fare);
		}

		int count = 0;
		for (int fare : fares) {
			if (fare > jinjuFare) {
				count++;
			}
		}

		System.out.println(jinjuFare);
		System.out.println(count);

		
	}
}
