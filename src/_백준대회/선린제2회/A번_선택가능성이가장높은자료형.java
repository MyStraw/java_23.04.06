package _백준대회.선린제2회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A번_선택가능성이가장높은자료형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		if (N >= Short.MIN_VALUE && N <= Short.MAX_VALUE) {
			System.out.println("short");
		} else if (N >= Integer.MIN_VALUE && N <= Integer.MAX_VALUE) {
			System.out.println("int");
		} else {
			System.out.println("long long");
		}
	}

}
