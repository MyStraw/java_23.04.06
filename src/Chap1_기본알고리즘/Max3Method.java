package Chap1_기본알고리즘;

public class Max3Method {

	public Max3Method(int i, int j, int k) {

		int max = i;

		if (j > max) {
			max = j;
		}
		if (k > max) {
			max = k;
		}

	}

	static int max3(int a, int b, int c) {

		int max = a;

		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}

	public static void main(String[] args) {

		Max3Method max = new Max3Method(1, 2, 3);

		System.out.println("max3(3,2,1) = " + max3(3, 2, 1));
	}

}
