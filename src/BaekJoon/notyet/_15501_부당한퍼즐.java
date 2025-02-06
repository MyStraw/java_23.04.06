package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15501_부당한퍼즐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] origin = new int[n];
		int[] change = new int[n];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			change[i] = Integer.parseInt(st.nextToken());
		}
	
		int firstIdx = 0;
		for (int i = 0; i < n; i++) {
			if (change[i] == origin[0]) {
				firstIdx = i;
				break;
			}
		}
	
		boolean isCase1 = true;
		for (int i = 0; i < n; i++) {
			if (origin[i] != change[(firstIdx + i) % n]) {
				isCase1 = false;
				break;
			}
		}
		
		boolean isCase2 = true;
		for (int i = 0; i < n; i++) {
			if (origin[i] != change[(firstIdx - i + n) % n]) {
				isCase2 = false;
				break;
			}
		}

		if (isCase1 || isCase2) {
			System.out.println("good puzzle");
		} else {
			System.out.println("bad puzzle");
		}
	}

}
