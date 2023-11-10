package _스터디_자료구조;

import java.util.Scanner;

public class _5_1_퀵정렬 { //피벗을 기준으로 좌우 나누기만
	static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;

	}

	static void partition(int[] a, int n) { //어디서 많이 봤네? 투 포인터.
		int pleft = 0;
		int pright = n - 1;
		int pivot = a[n / 2];

		do {
			while (a[pleft] < pivot)
				pleft++;
			while (a[pright] > pivot)
				pright--;
			if (pleft <= pright)
				swap(a, pleft++, pright--); //왼쪽이랑 오른쪽 값을 바꾼뒤에 left는 한칸 오른쪽, right는 한칸 왼쪽
		} while (pleft <= pright);

		System.out.println("피벗값은 " + pivot + "입니다");

		System.out.println("피벗 이하의 그룹");
		for (int i = 0; i <= pleft - 1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		if (pleft > pright + 1) {
			System.out.println("피벗과 같은 그룹");
			for (int i = pright + 1; i <= pleft - 1; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}

		System.out.println("피벗 이상의 그룹");
		for (int i = pright + 1; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("배열을 나눕니다.");
		System.out.println("데이터수: ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]: ");
			x[i] = sc.nextInt();

		}
		partition(x, nx);

	}

}


