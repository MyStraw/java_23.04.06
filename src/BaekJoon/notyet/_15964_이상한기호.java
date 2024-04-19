package BaekJoon.notyet;

import java.util.Scanner;

public class _15964_이상한기호 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		long total = (A+B)*(A-B);
		
		System.out.println(total);
	}

}
