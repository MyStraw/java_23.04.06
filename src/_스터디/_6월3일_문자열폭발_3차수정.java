package _스터디;

import java.util.Scanner;

public class _6월3일_문자열폭발_3차수정 { //잉... 하다보니까 스택 어디갔냐

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String moonjang = sc.next();
		String bomb = sc.next();
		String split[];
		

		while (moonjang.contains(bomb)) {
			split = moonjang.split(bomb);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < split.length; i++) {
				sb.append(split[i]);
			}
			moonjang = sb.toString();
		}

		if(moonjang.length() == 0) {
			System.out.println("FRULA");
		}else
			System.out.println(moonjang);
		sc.close();
	}
}
