package _스터디;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _6월17일_내일할거야 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
		int n = sc.nextInt();
		List<Integer> list = new LinkedList<>();
		int d = 0;
		int t = 0;
		for (int i = 0; i < n; i++) {
			d = sc.nextInt();
			t = sc.nextInt();
//			d = Integer.parseInt(br.readLine());
//			t = Integer.parseInt(br.readLine());

			for (int j = 0; j < d; j++) {
				list.add(t - j, t - j);
			}
		}
	}

}
