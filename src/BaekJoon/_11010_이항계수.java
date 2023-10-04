package BaekJoon;

import java.util.Scanner;

public class _11010_이항계수 {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int total = 1;
		int na = 1;
		
		for (int i = 1 ; i<=K ; i++) {
			na = na * i;
			total = total * (N-i+1);			
		}
		
		System.out.println(total/na);
	}
}
