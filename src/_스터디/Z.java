package _스터디;

import java.util.Scanner;

public class Z {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();				
		
		int z = 1<<N; //2의 3승 = Math.pow(2, 3); 이건 더블
		int Z[][] = new int[z][z];
		
		for(int i = 0 ; i<z*z;i++) {
			(0,0), (0,1)
			(1,0), (1,1)
		}
		
	}

}
