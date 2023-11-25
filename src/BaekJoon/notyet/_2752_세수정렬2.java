package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2752_세수정렬2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));		
		
		String[] input = (bw.readLine().split(" "));
		
		int [] numbers = new int [input.length];
		for (int i = 0; i < input.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(numbers);
		for (int num : numbers) {
            System.out.print(num + " ");
        }
	}
}
