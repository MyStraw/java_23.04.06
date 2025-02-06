package BaekJoon.notyet;

import java.util.Arrays;
import java.util.Scanner;

public class _8723_Patyki {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int[] side = { a, b, c };
		Arrays.sort(side);
		
		int x = side[0];
		int y = side[1];
		int z = side[2];

		
		int result = 0;

		
		if (x + y > z) {
			
			if (x * x + y * y == z * z) {
				result = 1;
			}
			
			if (x == y && y == z) {
				result = 2;
			}
		}
		
		System.out.println(result);

	}

}
