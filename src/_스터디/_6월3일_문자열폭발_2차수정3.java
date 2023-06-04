package _스터디;

import java.util.Scanner;

public class _6월3일_문자열폭발_2차수정3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String moonjang = sc.next();
		String bomb = sc.next();		
		while(moonjang.contains(bomb)) {
			 moonjang = moonjang.replaceAll(bomb, ""); //String은 불변. 새로 갱신할때마다 객체가 새로 만들어진다.
		}
		if(moonjang.length() == 0) {
			System.out.println("FRULA");
		}else
			System.out.println(moonjang);
		sc.close();
	}
}
