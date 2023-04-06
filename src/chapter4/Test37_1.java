package chapter4;

import java.util.Scanner;

// scanner로 입력받기 미션
public class Test37_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("첫번째 점수를 입력하세요.");			
		int[] score = new int[] {				
				sc.nextInt()
				}; // 5번 입력 how?
		
		
		int sum = 0; // 총점
		double avg = 0.0; // 평균
		int max = 0; // 최댓값
		int min = 999; // 최소값

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			if (max < score[i])
				max = score[i];
			if (min > score[i])
				min = score[i];

		}

		avg = sum / score.length;
		System.out.println("총  점 : " + sum);
		System.out.println("평  균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);

	}

}
