package BaekJoon.notyet;

import java.util.Scanner;

public class _1662_압축2 { //내가 하던거. StringBuilder로는 안된다. GG

	static StringBuilder sb = new StringBuilder();
	static int hap = 0;
	static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		sb = sb.append(S);
		alZip();

		System.out.println(hap);
	}

	private static void alZip() {
		int end;
		boolean find = true;
		while (find) {
			find = false;
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == ')') {
					end = i;
					i = findNum(end);
					find = true;
					break;
				}
			}
		}
	}

	public static int findNum(int end) {
		int start = 0;
		int repeatCount = 0;// 몇번 반복하는지 괄호앞 숫자 찾기
		int repeatIndex = 0;
		int start_num = 0;
		for (int i = end - 1; i >= 0; i--) {
			if (sb.charAt(i) == '(') {
				start = i; // 시작하는 괄호 찾기
				repeatIndex = i - 1;				
				repeatCount = sb.charAt(repeatIndex) - '0';
				if (i - 2 >= 0) {
					for (int j = i - 2; j >= 2; j--) {
						if (!Character.isDigit(sb.charAt(j))) {
							start_num = j + 1;							
							break;
						}
					}
				}
				break;
			}
		}
		if (count == 0) {
			hap += (sb.substring(start + 1, end).length() * repeatCount) + (repeatIndex - start_num);
			count++;
		} else {
			hap = (hap * repeatCount) + (repeatIndex - start_num);
		}
	
		sb.delete(start_num, end+1);
		System.out.println(sb);
		end = start_num;
		return end;
	}
}
