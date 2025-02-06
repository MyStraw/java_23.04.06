package BaekJoon.notyet;

import java.util.Scanner;

public class _11282_한글 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char result = getHangulChar(N);		
		System.out.println(result);

	}

	public static char getHangulChar(int N) {		
		int uniCode = 0xAC00;		
		N -= 1; 
		int choIdx = N / (21 * 28);
		int jungIdx = (N % (21 * 28)) / 28;
		int jongIdx = N % 28;		
		int code = uniCode + (choIdx * 21 * 28) + (jungIdx * 28) + jongIdx;
		return (char) code;
	}

}
