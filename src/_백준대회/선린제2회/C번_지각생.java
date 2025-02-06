package _백준대회.선린제2회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C번_지각생 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer> studentTime = new ArrayList<>();
		int teacherTime = -1;

		for (int i = 0; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String time = st.nextToken();
			String role = st.nextToken();

			int min = toMin(time);

			if (role.equals("student")) {
				studentTime.add(min);
			} else {
				teacherTime = min;
			}
		}

		int arrival = toMin(br.readLine());

		int late = 0;
		for (int st : studentTime) {
			if (st >= arrival && st >= teacherTime) {
				late++;
			}
		}

		System.out.println(late);
	}

	private static int toMin(String time) {
		String[] str = time.split(":");
		int h = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		return h * 60 + m;
	}

}
