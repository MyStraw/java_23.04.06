package BaekJoon.notyet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _31859_SMUPC_NAME {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String S = sc.next();

		Set<Character> smupc = new HashSet<>();// Set 인터페이스를 구현한 HashSet 클래스
		// HashSet<Character> smupc = new HashSet<>(); //이거보다 위가 더 맞는 쓰인새

		StringBuilder sb = new StringBuilder();

		int count = 0;
		for (int i = 0; i < S.length(); i++) {
			if (smupc.contains(S.charAt(i))) {
				count++;
			} else {
				smupc.add(S.charAt(i));
				sb.append(S.charAt(i));
			}
		}
		sb.append(count + 4).insert(0, N+1906).reverse().insert(0, "smupc_");
		System.out.println(sb);
	}
}
