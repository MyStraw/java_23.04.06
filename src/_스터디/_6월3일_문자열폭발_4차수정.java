package _스터디;

import java.util.Scanner;
import java.util.Stack;

public class _6월3일_문자열폭발_4차수정 { //잉... 하다보니까 스택 어디갔냐

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String moonjang = sc.next();
		String bomb = sc.next();	
		Stack<StringBuffer> result = new Stack<>();
		
		while(moonjang.contains(bomb)) {
		result.push(new StringBuffer(moonjang.replaceAll(bomb, "")));
		moonjang = result.pop().toString().replace(bomb, "");
		}		
		
		if(moonjang.length() == 0) {
			System.out.println("FRULA");
		}else
			System.out.println(moonjang);
		sc.close();
	}
}
