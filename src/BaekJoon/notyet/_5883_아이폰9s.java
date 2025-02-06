package BaekJoon.notyet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5883_아이폰9s {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] br = new int[n];
		int maxLen = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			br[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			List<Integer> p = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (br[i] != br[j]) {
					p.add(br[j]);
				}
			}

			for (int x = 0; x < p.size(); x++) {
				int len = 1;
				for (int y = x + 1; y < p.size(); y++) {
					if (!p.get(x).equals(p.get(y))) {
						break;
					}
					len++;
				}
				maxLen = Math.max(maxLen, len);
			}
		}

		System.out.println(maxLen);
	}

}
