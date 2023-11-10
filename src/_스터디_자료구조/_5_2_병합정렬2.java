package _스터디_자료구조;

import java.util.Scanner;

public class _5_2_병합정렬2 {

	static int[] buff;
	static int count;

	static void __mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;

			__mergeSort(a, left, center);
			__mergeSort(a, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[p++] = a[i];			
			}

			while (i <= right && j < p) {
				if (buff[j] <= a[i]) {
					a[k++] = buff[j++]; 							
				}
				else {
					a[k++] = a[i++];
					count++;
				}				
			}

			while (j < p) {
				a[k++] = buff[j++];				
			}
		}
	}

	static void mergeSort(int[] a, int n) {
		buff = new int[n];

		__mergeSort(a, 0, n - 1);

		buff = null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("병합정렬");
		System.out.print("데이터수: ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]: ");
			x[i] = sc.nextInt();
		}

		mergeSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
		
		System.out.println(count);

	}	

}
