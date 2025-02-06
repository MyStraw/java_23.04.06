package BaekJoon.notyet;

import java.util.Scanner;

public class _18408_일본어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
	
		int count1 = 0;
		int count2 = 0;
	
		if (A == 1)
			count1++;
		else
			count2++;

		if (B == 1)
			count1++;
		else
			count2++;

		if (C == 1)
			count1++;
		else
			count2++;
		
		if (count1 > count2) {
			System.out.println(1);
		} else {
			System.out.println(2);
		}
	
	}

}
