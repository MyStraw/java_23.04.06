package _스터디;

import java.util.Scanner;
import java.util.Stack;

public class 스택슈열 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>();		
		int Su[] = new int[N];
		Stack<Integer> result = new Stack<>();		
		int count = 0;

		StringBuffer str = new StringBuffer(N);
		
		for (int i = 0; i < N; i++) {
			int su = sc.nextInt();
			Su[i] = su;			
		}

		for (int i = 0; i < N; i++) {
			for (int j = i; j <= N; j++) {
				if (count > N) {
					System.out.println("NO");
					return;
				}
				if (st.isEmpty() && result.size() == Su.length) {
					break;
				} else if (st.isEmpty() || !st.peek().equals(Su[i])) {
					st.push(j + 1);
					str.append("+\n");
					count++;
				} else {
					result.push(st.pop());
					str.append("-\n");
					j--;
					i++;
				}
			}
		}
		System.out.println(str);
		}

	}

