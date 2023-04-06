package chapter4;

import java.util.Iterator;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		arr[0] = 10; // arr 의 0번지에 10 저장
		arr[1] = 20; //
		arr[2] = 30; //
		arr[3] = 40; //
		arr[4] = 50; //

		System.out.println(arr[0]); // arr 0번지 값 출력
		System.out.println(arr[1]); // 1000개면 근데 이거 1000개 적을거야?
		System.out.println(arr[2]); // 반복문 써서 하기. i로 하면 됨
		System.out.println(arr[3]); //
		System.out.println(arr[4]); //

		for (int i = 0; i < 5;i++) {
			System.out.println(arr[i]);

		}
	}
}
