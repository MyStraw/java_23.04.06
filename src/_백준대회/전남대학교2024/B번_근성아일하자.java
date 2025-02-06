package _백준대회.전남대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class B번_근성아일하자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		TreeSet<Integer> tree = new TreeSet<>();
		long total = 0;
		int current = 0;

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if (str[0].equals("1")) {
				int x = Integer.parseInt(str[1]);
				tree.add(x);
			} else {
				while (!tree.isEmpty()) {
					Integer left = tree.floor(current);
					Integer right = tree.ceiling(current);

					int nextPosition;
					if (left == null) {
						nextPosition = right;
					} else if (right == null) {
						nextPosition = left;
					} else {
						int leftDistance = current - left;
						int rightDistance = right - current;
						if (leftDistance <= rightDistance) {
							nextPosition = left;
						} else {
							nextPosition = right;
						}
					}

					total += Math.abs(nextPosition - current);
					current = nextPosition;
					tree.remove(nextPosition);
				}
			}
		}

		System.out.println(total);
	}

}
