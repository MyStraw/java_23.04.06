package BaekJoon.notyet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _11580_Footprint2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String EWSN = sc.next();

		int x = 0;
		int y = 0;

		Set<String> step = new HashSet<>();
		step.add("0,0");

		for (int i = 0; i < L; i++) {
			switch (EWSN.charAt(i)) {
			case 'E':
				x++;
				break;
			case 'W':
				x--;
				break;
			case 'S':
				y--;
				break;
			case 'N':
				y++;
				break;
			}
			step.add(x + "," + y);
		}
		System.out.println(step.size());

	}

}
