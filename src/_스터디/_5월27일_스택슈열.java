package _스터디;

import java.util.Scanner;
import java.util.Stack;

public class _5월27일_스택슈열 {
	static StringBuffer str = new StringBuffer();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>();		
		int Su[] = new int[N];
		Stack<Integer> result = new Stack<>();		
		int count = 0;

		
		
		for (int i = 0; i < N; i++) {
			int su = sc.nextInt();
			Su[i] = su;			
		} // 여기까진 N은 개수, Su는 입력받은 수열들 넣어주고
		 // 스택 st에 

		for (int i = 0; i < N; i++) {
			for (int j = i; j <= N; j++) {
				if (count > N) { //push의 수는 N과 같아야 한다. 그 이상은 No.
					System.out.println("NO");
					return;
				}
				if (st.isEmpty() && result.size() == Su.length) {
					break;//맨마지막 숫자. st가 비는건 제일처음 혹은 다 끝난후. 마지막에 확인.
				} else if (st.isEmpty() || !st.peek().equals(Su[i])) {
					st.push(j + 1);//push 조건. 첫시행 & Su[]와 st의 peek값이 같지 않으면 push. 
					str.append("+\n");
					count++;
				} else { //pop의 조건. st.peek().equals(Su[i]) 같을때.
					result.push(st.pop());
					str.append("-\n");
					j--;
					i++; //result에 집어넣어야 Su[]가 다음칸으로 이동.
				}
			}
		}
		System.out.println(str);
		}

	}

