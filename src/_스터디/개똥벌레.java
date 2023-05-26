package _스터디;

import java.util.Scanner;

public class 개똥벌레 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 돌 개수
		int H = sc.nextInt(); // 높이
		int Gae[][] = new int[H][N]; // x,y 좌표로 나타냄
		// int hol[][] = new int[1][N];
		// int jjack[][] = new int[N][1];
		// Queue<Integer> qe = new LinkedList<>(); //큐에다가 돌 순서 넣어놓음.
		int dol[] = new int[N];

		int counts[] = new int[H];

		for (int i = 0; i < N; i++) {
			int stone = sc.nextInt();
			dol[i] = stone;
		}

		// 석순. 홀수. 인덱스 짝수.0,2,4
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < dol[i]; j++)
				if (i % 2 == 0) {
					Gae[H - 1 - j][i] = 1;
				} else if (i % 2 == 1) {
					Gae[j][i] = 1;
				}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(Gae[i][j] + " ");
			}
			System.out.println();
		} // 종유석 모양 만들기.

		System.out.println();
		for (int i = 0; i < H; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (Gae[i][j] == 1) {
					count++;
				}
				counts[i] = count;
			}
			System.out.println(counts[i]);
		}
		System.out.println();

		int min = 500000;
		int countt = 1;
		for (int i = 0; i < H; i++) {
			if (min == counts[i]) {
				countt++;
			}
			if (min > counts[i]) {
				min = counts[i];
			}

		}System.out.println(min +" " + countt);

	//	Arrays.sort(counts);
	//	Arrays.binarySearch(counts, countt);

//		int left = 0;
//		int right = counts.length -1;
//		int mid;
//		int cc = 0;
//		
//		while(left<=right) {
//			mid = (left + right)/2;
//			if(counts[mid] < cc) left = mid+1;
//			else if(counts[mid] > cc) right = mid-1;
//			else return;			
	}
}
