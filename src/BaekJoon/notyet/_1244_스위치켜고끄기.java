package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244_스위치켜고끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] onOff = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			onOff[i] = Integer.parseInt(st.nextToken());
		}

		int student = Integer.parseInt(br.readLine());

		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (sex == 1) {
				for (int j = num - 1; j < N; j += num) {
					onOff[j] = 1 - onOff[j];
				}
			} else {
				int left = num - 1;
				int right = num - 1;
				onOff[num - 1] = 1 - onOff[num - 1];

				while (left > 0 && right < N - 1 && onOff[left - 1] == onOff[right + 1]) {
					left--;
					right++;
					onOff[left] = 1 - onOff[left];
					onOff[right] = 1 - onOff[right];

				}
			}

		}
		for (int i = 0; i < N; i++) {
			System.out.print(onOff[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}

}
