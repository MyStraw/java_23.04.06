package _백준대회.서울사이버대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C번_회상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		Map<String, Integer> studentCount = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			String[] students = br.readLine().split(" ");

			for (String student : students) {
				studentCount.put(student, studentCount.getOrDefault(student, 0) + 1);
			}
		}

		int result = 0;
		for (int count : studentCount.values()) {
			if (count >= m) {
				result++;
			}
		}

		System.out.println(result);
	}

}
