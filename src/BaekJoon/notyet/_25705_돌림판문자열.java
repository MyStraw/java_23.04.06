package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25705_돌림판문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] wheel = br.readLine().split("");
		int m = Integer.parseInt(br.readLine());
		String[] aim = br.readLine().split("");
		int count = -1;
		int index = 0;
		while (count++ <= 10000 && index < aim.length) {
			if (aim[index].equals(wheel[count % wheel.length])) {
				index++;
			}
		}
		System.out.println(count <= 10000 ? count : -1);
	}
}
