package _스터디;

import java.util.Scanner;
import java.util.Stack;

public class _6월3일_문자열폭발 {
	static Stack<StringBuffer> result = new Stack<>();

	public static void main(String[] args) {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// int N = Integer.parseInt(br.readLine());

		Scanner sc = new Scanner(System.in);

//		 String moonjang = br.readLine();
//		 String bomb = br.readLine(); //C4

		String moonjang = sc.next();
		String bomb = sc.next();

//		String moonjang = "mirkovC4nizCC44";
//		String bomb = "C4";
		// System.out.println(bomb.length());

		int num = bomb.length();
		Bomb(moonjang, bomb, num);
		System.out.println(result.peek());
	}

	private static void Bomb(String moonjang, String bomb, int num) { // 폭발문자열 자릿수 구하는 재귀
		String splitmoonjang;
		String[] hap;
		String concatmoonjang = "";
		if (num == 0) {
			return;
		}
//		System.out.println(num);
//		System.out.println(bomb.charAt(num - 1));
//		System.out.println(moonjang.replace(bomb.charAt(num - 1), ' '));
		splitmoonjang = moonjang.replace(bomb.charAt(num - 1), ' ');// 붙이니까 안되네? 
		hap = splitmoonjang.split("\\s+");
		if (hap.length == 0) {
			result.push(new StringBuffer("FRULA"));
			return;
		}
		concatmoonjang = String.join("", hap);

//		for(int i = 0; i<hap.length; i++) {
//			concatmoonjang = concatmoonjang.concat(hap[i]);
//		}
		// System.out.println(concatmoonjang);
		result.push(new StringBuffer(concatmoonjang));
		Bomb(concatmoonjang, bomb, num - 1);
	}
}
