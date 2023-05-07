package Chap3_검색알고리즘;
//1. 난수생성

//2. 정렬

import java.util.Random;
import java.util.Scanner;

public class _01정수배열이진탐색 {

	static void getData(int[] items) {
		// 난수생성하여 배열에 입력
		Random rand = new Random();
		for (int i = 0; i < items.length; i++)
			items[i] = rand.nextInt(100);
	}

	static void showData(int[] items) {
		// 난수생성하여 배열에 입력
		for (int i : items)
			System.out.print("[" + i + "] ");

	}

	static int findMax(int[] items) {
		int mvalue = 0;
		for (int i = 0; i < items.length; i++)
			if (mvalue < items[i])
				mvalue = items[i];
		return mvalue;
	}

	static void sortData(int[] items) {

		for (int i = 0; i < items.length; i++)
			for (int j = 0; j < items.length; j++)
				if (items[i] < items[j])
					swap(items, i, j);
	}

	static void swap(int[] items, int i, int j) { // 정렬 메소드 만들기
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("\n최대값 = " + mvalue);

		sortData(data);
		System.out.println("\n정렬후 결과");
		showData(data);
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("index 찾으려는 key값 입력");
		int key = sc.nextInt();
		int result = binSearch(data, key);

		System.out.println();
		if (result != -1) {
			System.out.println("원하는 값 " + key + "는(은) 인덱스 " + result + "("+ (result +1) +"번째)"+ "에 있습니다.");
		} else {
			System.out.println("원하는 값 " + key + "를(을) 찾지 못했습니다.");
		}

	}

	private static int binSearch(int[] data, int key) {
		int left = 0;
		int right = data.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (data[mid] == key) {
				return mid;
			} else if (data[mid] < key) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

}
