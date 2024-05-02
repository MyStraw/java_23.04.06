package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13909_창문닫기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int openWindowCount = (int) Math.sqrt(N); // N 이하의 완전 제곱수의 개수를 구함
		//주어진 숫자의 제곱근을 구함. square root을 계산한다. 루트N을 계산하는것.
		System.out.println(openWindowCount); // 열린 창문의 개수를 출력
	}

}
