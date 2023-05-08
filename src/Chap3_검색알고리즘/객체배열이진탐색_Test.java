package Chap3_검색알고리즘;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData data) {
		// return this.name.compareTo(data.name);
		// int result = this.name.compareTo(data.name);
		// if(result == 0){
//		int hresult = this.height - data.height;
//		if (hresult == 0) {
//			return (int)(this.height - data.height;)
		// }
//		else return hresult;
		// if (this.height == data.height){
		// return (int)(this.vision - data.height
		// }
		// else if(this.height < data.height){
//	}else return result;		
		// }
//---------------------------------------------------------------		
		int result = this.name.compareTo(data.name);
		if (result == 0) {
			int hresult = this.height - data.height;
			if (hresult == 0) {
				return (int) (this.height - data.height);
			} else
				return hresult;
		} else
			return result;
	}
// -----------------------------------------------------------------
////		
//		if (this.name.compareTo(data.name) > 0) { // 스트링을 인트비교로.
//			return 1;
//		}
//		if (this.name.compareTo(data.name) < 0) {
//			return -1;
//		}
//		if (this.height > data.height) {
//			return 1;
//		}
//		if (this.height < data.height) {
//			return -1;
//		}
//		if (this.vision > data.vision) {
//			return 1;
//		}
//		if (this.vision < data.vision) {
//			return -1;
//		}
//		return 0;
//	}

	@Override
	public String toString() {
		return "[name=" + name + "\t height=" + height + "\t vision=" + vision + "]";
	}

}

public class 객체배열이진탐색_Test {
	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), new PhyscData("길동", 167, 0.5), };
		System.out.println("정렬전");
		showData(data);
		sortData(data);
		System.out.println("정렬후");
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		
		
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}

	static void showData(PhyscData[] data) {
		System.out.println();
		for (PhyscData p : data) {
			System.out.print(p + " ");
			System.out.println();
		}
		System.out.println();
	}

	static void sortData(PhyscData[] data) {

		for (int i = 0; i < data.length - 1; i++)
			for (int j = i + 1; j < data.length; j++)
				if (data[i].compareTo(data[j]) > 0)
					swap(data, i, j);
	}

	static void swap(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i]; // 객체 배열. int, String 선언하듯이 객체 선언
		data[i] = data[j];
		data[j] = temp;

	}

	private static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}

	private static int binarySearch(PhyscData[] data, PhyscData key) {
		int pl = 0;
		int pr = data.length - 1;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;

			if (data[pc].compareTo(key) == 0) {
				return pc;

			} else if (data[pc].compareTo(key) < 0) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		}
		return -1;
	}
}