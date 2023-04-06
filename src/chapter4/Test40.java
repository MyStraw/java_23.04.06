package chapter4;

public class Test40 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4, 5 },
						{ 6, 7, 8, 9, 10 },
						{ 11, 12, 13, 14, 15 },
						{ 16, 17, 18, 19, 20 },
						{ 21, 22, 23, 24, 25 } };

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				sum += arr[i][j];
				System.out.print(arr[i][j] + "\t"); // \t 탭이랑 같은효과. 이게 괄호 안에 있어야 j도 루프를 받는다. 
				//이거 한줄 아래. } 이거 벗어나서 쓰면 j 벗어나
			}
			System.out.println(); //ln이니까 한칸 아래로.
		}
		System.out.println("합계 : " + sum);

	}

}
