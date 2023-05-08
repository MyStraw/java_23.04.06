package Chap3_검색알고리즘연습;

import java.util.Scanner;

class PhyscData implements Comparable<PhyscData> { // 다른 클래스.
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) { // 생성자 형성. 아래서 인스턴스(인수있는) 생성했으니까.
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData data) {
		if (this.name.compareTo(data.name) > 0) { // 스트링을 인트비교로.
			return 1;
		}
		if (this.name.compareTo(data.name) < 0) {
			return -1;
		}
		if (this.height > data.height) {
			return 1;
		}
		if (this.height < data.height) {
			return -1;
		}
		return 0;

	}

	@Override
	public String toString() {
		return "[이름=" + name + ", 키=" + height + ", 시력=" + vision + "]";
	}

}

//------------------------------------------------------------------------------------------

public class _03객체배열이진탐색 {

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2), new PhyscData("최길동", 169, 0.5), new PhyscData("이길동", 201, 2.0) };

		System.out.println("*****데이터 원본*****");
		showData(data);
		System.out.println();
		sortData(data);
		System.out.println("*****정렬후*****");
		showData(data);
		System.out.println();
		System.out.println("index 찾으려는 이름 입력");
		
	
		Scanner sc = new Scanner(System.in);
		String key = sc.next();
		int result = binSearch(data, key);

		System.out.println();
		if (result != -1) {
			System.out.println("원하는 값 " + key + "는(은) 인덱스 " + result + "(" + (result + 1) + "번째)" + "에 있습니다.");
		} else {
			System.out.println("원하는 값 " + key + "를(을) 찾지 못했습니다.");
		}

	}

	static void showData(PhyscData[] items) {
		// 난수생성하여 배열에 입력
		for (PhyscData p : items)
			System.out.println(p);

	}

	static void sortData(PhyscData[] items) {
		for (int i = 0; i < items.length - 1; i++)
			for (int j = i + 1; j < items.length; j++)
				if (items[i].compareTo(items[j]) > 0)
					swap(items, i, j);
	}

	static void swap(PhyscData[] items, int i, int j) {
		PhyscData temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	private static int binSearch(PhyscData[] items, String key) {
		int left = 0;
		int right = items.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (items[mid].name.compareTo(key) == 0) {
				return mid;
			} else if (items[mid].name.compareTo(key) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

}
