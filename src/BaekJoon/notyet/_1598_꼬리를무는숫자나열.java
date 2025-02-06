package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1598_꼬리를무는숫자나열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		int ax = (a - 1) / 4;
		int ay = (a - 1) % 4;
		int bx = (b - 1) / 4;
		int by = (b - 1) % 4;

		int distance = Math.abs(ax - bx) + Math.abs(ay - by);
		System.out.println(distance);
	}

}
