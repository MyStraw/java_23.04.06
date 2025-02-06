package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31498_장난을잘치는토카양 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long C = Long.parseLong(st.nextToken());
		long D = Long.parseLong(st.nextToken());

		long K = Long.parseLong(br.readLine());

		long end = (long) Math.ceil((double) (A + C) / D);
		long left = 1;
		long right = end;
		long catchTime = end;
		long arriveTime = end + 1;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (B - K * (mid - 1) <= 0) {
				right = mid - 1;
				continue;
			}

			long toka = A - (mid * (2 * B - K * (mid - 1)) / 2);
			long doldol = A + C - mid * D;

			if (toka <= 0) {
				arriveTime = Math.min(arriveTime, mid);
				right = mid - 1;
			} else {
				if (toka >= doldol) {
					catchTime = Math.min(catchTime, mid);
				}
				left = mid + 1;
			}
		}

		if (arriveTime < catchTime) {
			System.out.println(arriveTime);
		} else {
			System.out.println(-1);
		}
	}

}
