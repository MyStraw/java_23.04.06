package BaekJoon.notyet;

import java.util.Scanner;

public class _15051_Máquina_de_café {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A1 = sc.nextInt(); 
		int A2 = sc.nextInt(); 
		int A3 = sc.nextInt(); 

		
		int f1 = (A2 * 2) + (A3 * 4);

		
		int f2 = (A1 * 2) + (A3 * 2);

	
		int f3 = (A1 * 4) + (A2 * 2);

		
		int min = Math.min(f1, Math.min(f2, f3));

		System.out.println(min); 

	
	}

}
