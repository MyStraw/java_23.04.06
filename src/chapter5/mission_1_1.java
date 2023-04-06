package chapter5;

public class mission_1_1 { // 클래스

	public void matrix() { // 메소드 선언
		
		System.out.println("대한민국");

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

		mission_1_1 m = new mission_1_1(); // 자기자신 클래스를 만듦. m은 인스턴스다.
		m.matrix(); // m에 매트릭스를 호출. 매트릭스로 갔다가 돌아오는거. 위에꺼 실행하고 돌아온다.
		//대한민국 찍고 행렬 찍고 돌아온다.	
		
		//그냥 메인에 넣고 통째로 실행시키면 되지 왜? 공부할때만 이렇게 쓰고
		//실질적으론 이렇게 객체를 이용해서 한다.

	}

}
