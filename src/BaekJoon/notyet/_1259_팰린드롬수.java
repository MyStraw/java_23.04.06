package BaekJoon.notyet;

import java.util.Scanner;

public class _1259_팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}
			String A = Integer.toString(N);			
			
			if(A.length()==1) {
				System.out.println("yes");
			}			
			
			else if (A.length() == 2) {
				if (A.charAt(0) == A.charAt(1)) {
					System.out.println("yes");
				}
				else
					System.out.println("no");
			}

			else if (A.length() == 3) {				
				if (A.charAt(0) == A.charAt(2)) {
					System.out.println("yes");
				}
				else
					System.out.println("no");
			}

			else if (A.length() == 4) {
				if (A.charAt(0) == A.charAt(3) && A.charAt(1) == A.charAt(2)) {
					System.out.println("yes");
				}
				else
					System.out.println("no");
			}

			else if (A.length() == 5) {
				if (A.charAt(0) == A.charAt(4) && A.charAt(1) == A.charAt(3)) {
					System.out.println("yes");
				}
				else
					System.out.println("no");
			} else
				System.out.println("no");
		}
	}
}