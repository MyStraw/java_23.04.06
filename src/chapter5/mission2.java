package chapter5;

//윤년 검사
// 2023년 이후 윤년 10개를 찾아서 배열에 저장하고 이를 출력.
// 4로 나누어 떨어지는 해는 윤년, 그밖 평년
// 4로 나누어 떨어져도 100으로 나눠지면 평년
// 4로 나눠지고, 100으로도 나눠지지만 400으로 나눠 떨어지면 또 윤년
public class mission2 {

	public static void main(String[] args) {

		int year = 2023;
		int find = 0;
		int[] arr = new int[40];
		
		while (find < 40) {
			year += 1;
			if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0
					|| year % 4 == 0 && year % 100 != 0 && year % 400 == 0
					|| year % 4 == 0 && year % 100 != 0 && year % 400 != 0) {

				arr[find] = year; // 필요없엉~
				find += 1;
				// System.out.println(year); // arr 안쓰면 이걸로
			}
		}
		for (int k : arr) {
			System.out.println(k);
			System.out.println(k);
		}
	}
}
