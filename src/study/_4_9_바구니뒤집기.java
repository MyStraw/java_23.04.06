package study;

import java.util.Scanner;

public class _4_9_바구니뒤집기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int N[] = new int[n];

		for (int i = 0; i < n; i++) {
			N[i] = i + 1;
		}

		int M = sc.nextInt();

		for (int I = 0; I < M; I++) {
			int i = sc.nextInt();
			int j = sc.nextInt();

			int cross[] = new int[j - i + 1];

			for (int K = 0; K <= j - i; K++) {
				cross[j - i - K] = N[i + K - 1];

			}								   // 어제의 풀이과정중 -> cross[]를 바로 N[]에 대입하는 작업을 했으나 실패해서 temp[]를 만들었는데
			for (int K = 0; K <= j - i; K++) { // 위와 똑같은 for문을 하나 더 만들어서 cross[]를 N[]에 대입하는 작업을 따로 빼준다.
				N[K + i - 1] = cross[K];	   // N[K + i - 1] = cross[K]; 이 코드를 위 for문에 붙이면 아직 채워지지 않은 cross의 값은 0인 상태이기 때문에
			}								   // N[]에 계속 0이 들어가게 된다. 어제 계속해서 답에 0이 보였던 이유.	
											   // 이걸로 temp[] 배열 하나를 없애는 코드가 가능.	
		}
		for (int i = 0; i < n; i++) {
			System.out.print(N[i] + " ");
		}

	}

}