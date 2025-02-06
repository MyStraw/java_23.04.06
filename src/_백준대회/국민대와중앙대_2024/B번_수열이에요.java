package _백준대회.국민대와중앙대_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B번_수열이에요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nlr = br.readLine().split(" ");
		int n = Integer.parseInt(nlr[0]);
		int l = Integer.parseInt(nlr[1]) - 1;
		int r = Integer.parseInt(nlr[2]) - 1;

		String[] aStr = br.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(aStr[i]);
		}

		int[] subarray = Arrays.copyOfRange(a, l, r + 1);
		Arrays.sort(subarray);

		for (int i = 0; i < l; i++) {
			if (a[i] > subarray[0]) {
				System.out.println(0);
				return;
			}
		}

		for (int i = r + 1; i < n; i++) {
			if (subarray[subarray.length - 1] > a[i]) {
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);
	}

}
