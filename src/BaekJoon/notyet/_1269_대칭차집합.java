package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1269_대칭차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numA = Integer.parseInt(st.nextToken());
		int numB = Integer.parseInt(st.nextToken());

		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		int[] arrA = new int[numA];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numA; i++) {
			int a = Integer.parseInt(st.nextToken());
			setA.add(a);
			arrA[i] = a;
		}
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < numB; i++) {
			int b = Integer.parseInt(st.nextToken());
			setB.add(b);
			setA.remove(b);
		}
		for (int i = 0; i < numA; i++) {
			setB.remove(arrA[i]);
		}
		System.out.println(setA.size() + setB.size());
	}
}
