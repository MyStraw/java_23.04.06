package BaekJoon.notyet;

import java.util.Arrays;
import java.util.Scanner;

public class _11948_과목선택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int phy = sc.nextInt();
		int che = sc.nextInt();
		int bio = sc.nextInt();
		int earth = sc.nextInt();
		int his = sc.nextInt();
		int geo = sc.nextInt();
	
		int[] score = { phy, che, bio, earth };
		
		Arrays.sort(score);

		int total = score[1] + score[2] + score[3];
	
		int max = Math.max(his, geo);
		
		int totalScore = total + max;
	
		System.out.println(totalScore);
	}

}
