package _코테준비_;

import java.util.Scanner;

public class 구현_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(sumOfEvens(arr));
		scanner.close();
	}

	public static int sumOfEvens(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			if (num % 2 == 0) {
				sum += num;
			}
		}
		return sum;
	}

}

/*
 * 2. 짝수의 합 계산 문제 (하) 
 * 문제 설명: 주어진 정수 배열에서 모든 짝수의 합을 계산하세요. 
 * 입력 형식: 첫 번째 줄에 배열의 크기 N이 주어지고, 두 번째 줄부터 N개의 정수가 주어집니다. 
 * 출력 형식: 배열에서 모든 짝수의 합을 출력하세요.
 */


//입
//5
//12345

//출
//6