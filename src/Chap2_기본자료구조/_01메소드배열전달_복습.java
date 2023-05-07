package Chap2_기본자료구조;

import java.util.Random;

public class _01메소드배열전달_복습 {
	static void getData(int[] data) {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}

	static void showData(int[] data) {
		System.out.println("난수 생성 :");
		for (int i : data) {
			System.out.print("[" +i + "] ");
		}
	}

	static int findMax(int[] data) {
		int mvalue = 0;
		for (int i = 0; i < data.length; i++) {
			if (mvalue < data[i]) {
				mvalue = data[i];
			}
		}
		return mvalue;
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
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("최대값 : " + mvalue);

		sortData(data);		
		System.out.println("\n정렬후 결과");
		showData(data);

	}
}
