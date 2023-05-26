package Chap6_정렬알고리즘;

import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

	static void InsertionSort(int[] a, int n) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i]; //두번째부터 하니까 i=1부터 시작.
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1]; count++;
			}
			a[j] = tmp; //이게 swap이다. 

		}
		System.out.println("비교횟수 = "+ count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		System.out.println("단순 삽입 정렬");
		System.out.println("요솟수: ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = random.nextInt(100);
		}

		InsertionSort(x, nx); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
