package BaekJoon.notyet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class _11580_Footprint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String EWSN = sc.next();

		int x = 0;
		int y = 0;

		Set<XandY> step = new HashSet<>();
		step.add(new XandY(0, 0));

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
			step.add(new XandY(x, y));
		}
		System.out.println(step.size());

	}

	static class XandY {
		int X;
		int Y;

		XandY(int x, int y) {
			this.X = x;
			this.Y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			XandY xandy = (XandY) o;
			return X == xandy.X && Y == xandy.Y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(X, Y);
		}
	}

}
