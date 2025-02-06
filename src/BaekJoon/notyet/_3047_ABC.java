package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3047_ABC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int[] num = new int[3];
		num[0] = Integer.parseInt(str[0]);
		num[1] = Integer.parseInt(str[1]);
		num[2] = Integer.parseInt(str[2]);

		Arrays.sort(num);

		String soon = br.readLine();

		StringBuilder sb = new StringBuilder();
		for (char ch : soon.toCharArray()) {
			if (ch == 'A')
				sb.append(num[0]).append(" ");
			else if (ch == 'B')
				sb.append(num[1]).append(" ");
			else if (ch == 'C')
				sb.append(num[2]).append(" ");
		}

		System.out.println(sb.toString());
	}

}
