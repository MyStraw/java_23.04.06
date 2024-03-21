package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2845_파티가끝나고난뒤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int person = Integer.parseInt(st.nextToken());
		int perM = Integer.parseInt(st.nextToken());
		int sum = person * perM;

		st = new StringTokenizer(br.readLine());	

		for (int i = 0; i < 5; i++) {
			int one = Integer.parseInt(st.nextToken());		
			System.out.print(one - sum + " ");
		}
	}
}
