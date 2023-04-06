package chapter5;

public class mission_1 { // 클래스

	public void matrix() { // 메소드 선언

		int[][] x = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] y = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				int sum = 0;
				for (int j = 0; j < 4; j++) {

					sum = sum + x[i][j] * y[j][k];
				}
				System.out.print(sum + "\t"); // result = sum[i][k]
			}

			System.out.println();
		}

	}

	public static void main(String[] args) {

		mission_1 m = new mission_1(); // 자기자신 클래스를 만듦.
		m.matrix(); // m에 매트릭스를 호출.

	}

}
