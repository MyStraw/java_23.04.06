package _코테준비_;

import java.util.Scanner;

public class 문자열_2 {
	public static boolean isPalindrome(String s) {
		String filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		int left = 0, right = filtered.length() - 1;
		while (left < right) {
			if (filtered.charAt(left) != filtered.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요: ");
		String input = scanner.nextLine();
		System.out.println("팰린드롬 여부: " + isPalindrome(input));
	}

}

//중: 팰린드롬 여부 검사
//
//문제: 주어진 문자열이 팰린드롬인지 여부를 확인하라. 대소문자를 구분하지 않으며, 영문자와 숫자만을 대상으로 한다.

//입력 예시
//css
//Copy code
//A man, a plan, a canal: Panama
//출력 예시
//arduino
//Copy code
//true