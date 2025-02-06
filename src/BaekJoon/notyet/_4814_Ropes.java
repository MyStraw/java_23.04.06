package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4814_Ropes {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			if (str.equals("0")) {
				break;
			}

			StringTokenizer st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());

			int[] pitch = new int[N];
			int rappelLength = 0;
			int maxPitch = 0;

			for (int i = 0; i < N; i++) {
				pitch[i] = Integer.parseInt(st.nextToken());
				rappelLength += pitch[i];
				if (pitch[i] > maxPitch) {
					maxPitch = pitch[i];
				}
			}

			int requiredRopeLength = rappelLength * 2;
			int[] rope = { 50, 60, 70 };
			int[] climberCount = new int[3];

			for (int i = 0; i < rope.length; i++) {
				if (rope[i] < requiredRopeLength || rope[i] < maxPitch) {
					climberCount[i] = 0;
				} else {
					climberCount[i] = (rope[i] / maxPitch) + 1;
				}
			}

			System.out.println(climberCount[0] + " " + climberCount[1] + " " + climberCount[2]);
		}
		
	}

}
