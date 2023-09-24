package BaekJoon;

import java.util.Scanner;

public class _5522_카드게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		
		for (int i = 0 ; i < 5 ; i++) {
			int A = sc.nextInt();
			total+=A;
		}
		
		System.out.println(total);
	}

}
