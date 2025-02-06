package BaekJoon.notyet;

import java.util.Scanner;

public class _24365_세개의꽃 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		scanner.close();
		
		int aver = (a + b + c) / 3;
		int res = 0;
		
		res += (c - aver);
		b += (c - aver);
	
		res += (b - aver);
	
		System.out.println(res);
	}

}
