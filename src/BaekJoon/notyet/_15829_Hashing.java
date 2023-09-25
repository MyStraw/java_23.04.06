package BaekJoon.notyet;

import java.util.Scanner;

public class _15829_Hashing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		String alpha = sc.next();			
		int total = 0;		
		for (int i = 0 ; i<L ; i++) {
			total += (Integer.parseInt(Integer.toString(alpha.charAt(i))) - 96) * Math.pow(31, i);
		}
		System.out.println(total);
	}

}
