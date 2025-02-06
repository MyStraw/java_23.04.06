package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11509_풍선맞추기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ball = new int[N];

		for (int i = 0; i < N; i++) {
			ball[i] = Integer.parseInt(st.nextToken());
		}

		int[] arrow = new int[1_000_001];
		int count = 0;

		for (int b : ball) {
			if (arrow[b] > 0) { //현재 풍선의 위치에 화살 있나?
				arrow[b]--;// 화살 있으면 그 화살 사용(1개 깎음)
			} else {
				count++; // 현재풍선 위치에 화살이 없다? 그럼 화살 1개 추가해서 터뜨려
			}
			arrow[b - 1]++; // 어찌됐거나 if나 else나 화살 사용한건 공통이니 화살의 위치 1계단씩 내림.
		}

//		int acount = 0; 
//		for (int a : arrow) {
//			if (a > 0) {
//				acount += a;
//			}
//		}
		System.out.println(count); //추가한 화살의 수
//		System.out.println(acount); 남아있는 화살의 수 이 둘이 같다.
	}
}
