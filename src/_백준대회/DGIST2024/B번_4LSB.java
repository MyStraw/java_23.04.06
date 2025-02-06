package _백준대회.DGIST2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B번_4LSB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] numbers = new int[3];
		for (int i = 0; i < 3; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
	
		StringBuilder binaryString = new StringBuilder();
		for (int number : numbers) {
			String lsb4 = String.format("%4s", Integer.toBinaryString(number & 0b1111)).replace(' ', '0');
			binaryString.append(lsb4);
		}
	
		int password = Integer.parseInt(binaryString.toString(), 2);
		
		System.out.printf("%04d\n", password);
	}

}
