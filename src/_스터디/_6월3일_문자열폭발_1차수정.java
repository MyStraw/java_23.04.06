package _스터디;

import java.util.Scanner;
import java.util.Stack;

public class _6월3일_문자열폭발_1차수정 {
//	static Stack<StringBuffer> result = new Stack<>();
	static String splitmoonjang;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String moonjang = sc.next();
		String bomb = sc.next();

		int num = bomb.length();
		Bomb(moonjang, bomb, num);
		System.out.println(splitmoonjang);
		sc.close();
	}

	private static void Bomb(String moonjang, String bomb, int num) {
//		String splitmoonjang;
//		String[] hap;
//		String concatmoonjang;
		if (num == 0) {
			return;
		}
		
//		if (moonjang.contains(bomb)) {
//            moonjang = moonjang.replace(bomb, "");
//        }
		
		splitmoonjang = moonjang.replaceAll(bomb, ""); //문제이해 잘못. 붙여도 되네?
//		hap = splitmoonjang.split("\\s+");
		
		if (splitmoonjang == "") {
			System.out.println("FRULA");
			return;
		}
		
//		if (hap.length == 0 || splitmoonjang == "") {
//			result.push(new StringBuffer("FRULA"));
//			return;
//		}
//		concatmoonjang = String.join("", hap);
//		result.push(new StringBuffer(concatmoonjang));
//		Bomb(concatmoonjang, bomb, num - 1);
//		result.push(new StringBuffer(splitmoonjang));
		Bomb(splitmoonjang, bomb, num - 1);
	}
}
