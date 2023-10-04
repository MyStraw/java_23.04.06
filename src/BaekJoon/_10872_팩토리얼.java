package BaekJoon;

import java.util.Scanner;

public class _10872_팩토리얼 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int combi = 1;
		
		for (int i = 1; i<=N;i++) {
			combi = combi*i;
		}
		System.out.println(combi);		
	}
}
