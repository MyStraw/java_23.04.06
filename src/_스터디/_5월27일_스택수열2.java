package _스터디;

import java.util.Scanner;
import java.util.Stack;

public class _5월27일_스택수열2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		int Natural[] = new int[N];
		int Su[] = new int[N];
		Stack<Integer> result = new Stack<>();
		Stack<String> plus = new Stack<>();

		for (int i = 0; i < N; i++) {
			int su = sc.nextInt();
			Su[i] = su;
			Natural[i] = i + 1;
		}

		
		try {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N; j++) {
					if (st.isEmpty() && result.capacity() == Su.length) {
						return;
					} else if (st.isEmpty() || st.peek() != Su[i]) {
						st.push(Natural[j]);
						plus.push("+");
					} else {
						result.push(st.pop());
						plus.push("-");
						if (!st.isEmpty()) {
							j--;
							i++;
						} else if (st.isEmpty()) {
							i++;
						}
					}
				}
			}			
			for (int re : result) {
				for(int ss : Su) {
					if(re == ss) {
						break;
					}else {
						System.out.println("NO");
					}
				}
			}System.out.println("yes");

		} catch (Exception e) {
			System.out.println("NO");
		}

	}
}
