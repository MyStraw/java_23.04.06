package BaekJoon.notyet;

import java.util.Scanner;

public class _1662_압축 { //모든 과정을 다 나타내면서 하는거라 메모리 초과남.

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		sb = sb.append(S);
		alZip();

		int jari = sb.length();
		System.out.println(jari);
	}

	private static void alZip() {		
		int end;
		boolean find = true;
		while (find) {
			find = false;
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == ')') {
					end = i;
					i = findNum(end) - 1;
					find = true;
					break;
				}
			}

		}

	}

	public static int findNum(int end) {
		int start = 0;
		int repeatCount = 0;// 몇번 반복하는지 괄호앞 숫자 찾기
		for (int i = end - 1; i >= 0; i--) {
			if (sb.charAt(i) == '(') {
				start = i; // 시작하는 괄호 찾기
				repeatCount = sb.charAt(i - 1) - '0';
				break;
			}
		}
		StringBuilder gwal = new StringBuilder(); // 괄호안 숫자 조합

		if (repeatCount == 0) {
			gwal.delete(0, gwal.length() + 1);
		} else {
			for (int i = 0; i < repeatCount; i++) {
				gwal.append(sb.substring(start + 1, end));
			}
		}

		sb.delete(start - 1, end + 1);
		sb.insert(start - 1, gwal);
		end = start;
		return end;
	}
}
