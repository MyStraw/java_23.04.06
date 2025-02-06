package BaekJoon.notyet;

import java.util.Scanner;

public class _6887_Squares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tiles = sc.nextInt();
		int sideLength = (int) Math.sqrt(tiles);

		System.out.println("The largest square has side length " + sideLength+".");
	}

}
