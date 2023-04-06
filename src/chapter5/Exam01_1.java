package chapter5;

//import java.util.Scanner;

public class Exam01_1 {

	private static int methodSum(int i, int j) {
		int sum = i + j;
		return sum;
		// or return i+j; 윗 두줄을 이거 한줄로 줄일수 있겠지
	}

	public static void main(String[] args) {

		int sum = methodSum(10, 20);
		System.out.println("sum: " + sum);
	}

}
