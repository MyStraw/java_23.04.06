package BaekJoon.notyet;

import java.util.Scanner;

public class _27294_몇개고 {
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        int T = sc.nextInt(); 
	        int S = sc.nextInt();
	        
	        int count = riceCount(T,S);
	        
	        System.out.println(count);
		
	}
	
	private static int riceCount(int time, int sool) {
		if (time>=12 && time <=16 && sool == 0) {
			return 320;
		}
		else {
			return 280;
		}
	}

}
