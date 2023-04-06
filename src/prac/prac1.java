package prac;

public class prac1 {

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		int[][] b = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 4; k++) {
				int sum = 0;
				for (int j = 0; j < 3; j++) {
					sum = sum + a[i][k] * b[k][j];
				}
				System.out.print(sum + "\t");

			}
			System.out.println();

		}

	}

}
