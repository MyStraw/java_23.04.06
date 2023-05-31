package _스터디;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//3 - 총 제시할 문제의 케이스개수 

//1 0
//5

//문서 1개, 몇번째로 인쇄되는지 궁금한 문서가 0번째 있다. 당연히 1개밖에 없으니.. 
//중요도 5. 문서 1개니까 당연히 1개 인쇄

//4 2
//1 2 3 4
//문서 4개/ 궁금한 문서가 인덱스 2번째에 있다.
//각 문서의 중요도가 1,2,3,4 다.
// 그럼 출력은 3이니까 2번재로 인쇄 되겠지.

//6 0
//1 1 9 1 1 1
//문서 6개. // 인덱스 0번째 문서는 언제 인쇄? 지금 맨앞 1이네
//9먼저 인쇄되고 그 뒤에꺼 1 3개 인쇄된 후 맨앞 1 인쇄 되겠네. 그럼5

//
//큐 2개, 
//아님 배열하나 해서
//수 입력받자마자 arrays.sort해서
//값 매칭하면서 하면?
//		
//		정렬해서 제일 뒷 배열이 큰수가 되니까
//		뒤에서부터 기준으로 비교를 시행
//		que를 pop해서 배열큰수가 맞으면 카운트1
//		아니면 다시 엉덩이로 push

public class _6월3일_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null; //new StringTokenizer(br.readLine());
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		int N = Integer.parseInt(br.readLine());

		Queue<Integer> testcase = new LinkedList<>();
		Queue<Integer> testcasecopy = new LinkedList<>();

		Scanner sc = new Scanner(System.in);

		int casenum = sc.nextInt();

		for (int i = 0; i < casenum; i++) {
			int max = 0;
			int count = 0;
			int N = sc.nextInt();
			int Nbae[] = new int[N];
			int M = sc.nextInt();
			for (int j = 0; j < N; j++) {
				int importance = sc.nextInt();
				testcase.add(importance);
				Nbae[j] = importance;
				if (max < Nbae[j]) {
					max = Nbae[j];
				}
			}
			while (!testcase.isEmpty()) {				
				if (testcase.peek() == max) {				
					testcase.poll();
					count++;					
				} else if (testcase.peek() < max) {
					testcase.add(testcase.poll());					
				} else if (testcase.isEmpty()) {
					break;
				}if(count-1 == M) {
					System.out.println(count);
					break;
				}

			}

		}

	}
}
