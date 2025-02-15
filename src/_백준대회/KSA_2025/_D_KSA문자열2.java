package _백준대회.KSA_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _D_KSA문자열2 {
	static int countK, countS, countA;
	static char[] X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		X = br.readLine().toCharArray();
		for (char x : X) {
			if (x == 'K')
				countK++;
			else if (x == 'S')
				countS++;
			else
				countA++;
		}
		int left = 0;
		int right = X.length;
		int gilE = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (ok(mid)) {
				gilE = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		char T[] = new char[gilE];
		for (int i = 0; i < gilE; i++) {
			int susik = (i + 1) % 3;
			if (susik == 1) {
				T[i] = 'K';
			} else if (susik == 2) {
				T[i] = 'S';
			} else {
				T[i] = 'A';
			}
		}
		int positionX = X.length - 1;
		int positionT = gilE - 1;
		int match = 0;
		while (positionX >= 0 && positionT >= 0) {
			if (X[positionX] == T[positionT]) {
				match++;
				positionT--;
				positionX--;
			} else {
				positionX--;
			}
		}
		System.out.println(X.length - match);

	}

	static boolean ok(int mid) {
		int needK = (mid + 2) / 3;
		int needS = (mid + 1) / 3;
		int needA = mid / 3;
		if (needK > countK) {
			return false;
		}
		if (needS > countS) {
			return false;
		}
		if (needA > countA) {
			return false;
		}
		return true;
	}
}
