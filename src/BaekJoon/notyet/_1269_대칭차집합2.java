package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1269_대칭차집합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numA = Integer.parseInt(st.nextToken());
		int numB = Integer.parseInt(st.nextToken());

		Set<Integer> setA = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numA; i++) {
			int a = Integer.parseInt(st.nextToken());
			setA.add(a);
		}
		st = new StringTokenizer(br.readLine());

		int count = 0;
		for (int i = 0; i < numB; i++) {
			int b = Integer.parseInt(st.nextToken());
			if (setA.contains(b)) {
				count++;
			}
		}
		System.out.println(numA + numB - 2 * count);
	}
}
