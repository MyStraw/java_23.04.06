package _스터디;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _6월10일_앵무새 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		List<Queue<String>> listOfque = new ArrayList<>();
		Queue<String> result = new LinkedList<>();
		int count = 0;
		int count2 = 0;

		for (int i = 0; i < N; i++) {
			String S = sc.nextLine();
			Queue<String> que = new LinkedList<>();
			for (String s : S.split(" ")) {
				que.add(s);
			}
			listOfque.add(que);
		}

		String sum = sc.nextLine();
		for (String s : sum.split(" ")) {
			result.add(s);
		}

		while (!result.isEmpty()) {
			if (count2 > count) {
				break;
			}
			for (int i = 0; i < N; i++) {
				if (listOfque.get(i).isEmpty()) {
					continue;
				}
				if (listOfque.get(i).peek().equals(result.peek())) {
					listOfque.get(i).poll();
					result.poll();
					count++;
					if (listOfque.get(i).isEmpty()) { //반례. 2 a b a impossible
						listOfque.remove(i);
						N = N - 1;
					}
				}
			}
			count2++;
		}

		if (result.isEmpty() && listOfque.isEmpty()) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
	}
}
