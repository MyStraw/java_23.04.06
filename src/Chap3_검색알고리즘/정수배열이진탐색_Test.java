package Chap3_검색알고리즘;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 정수배열이진탐색_Test {

	static void inputData(int[] data) {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}

	static void showData(int[] data) {
		for (int i : data) {
			System.out.print("[" + i + "] ");
		}
	}

	static void sortData(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i] < data[j]) {
					swap(data, i, j);
				}
			}
		}
	}

	static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;

	}

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();

		for (int num : data) {
			System.out.print(num + " ");
		}
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);

	}

	private static int linearSearch(int[] data, int key) {
		for (int i = 0; i < data.length; i++) {

			if (data[i] == key) {
				return i;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] data, int key) {
		int pl = 0;
		int pr = data.length - 1;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;

			if (data[pc] == key) {
				return pc;

			} else if (data[pc] < key) {
				pl = pc + 1;
			} else
				pr = pc - 1;
		}
		return -1;

	}

}