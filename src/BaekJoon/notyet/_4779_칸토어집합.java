package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4779_칸토어집합 { //EOF(end of file) 처리. 입력을 읽고 입력이 null이면 처리 종료.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while ((input = br.readLine()) != null) {
			if(input.isEmpty()) continue; //입력 중간에 빈줄이 있을수도 있으니까.
			int N = Integer.parseInt(input);
			System.out.println(can((int) Math.pow(3, N)));			
		}		
		
	}

	public static String can(int length) {
		if (length == 1) {
			return "-";
		} else {
			int partLen = length / 3;
			String part = can(partLen);
			return part + " ".repeat(partLen) + part;
		}
	}
}