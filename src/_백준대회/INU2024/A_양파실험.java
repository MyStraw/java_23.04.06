package _백준대회.INU2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_양파실험 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int chingOni = 1;
		int binanOni = 1;

		for (int i = 0; i < N; i++) {
			chingOni += A;
			binanOni += B;

			if (chingOni < binanOni) {
				int temp = chingOni;
				chingOni = binanOni;
				binanOni = temp;
			} else if (chingOni == binanOni) {
				binanOni--;
			}
		}

		System.out.println(chingOni + " " + binanOni);
	}

}
