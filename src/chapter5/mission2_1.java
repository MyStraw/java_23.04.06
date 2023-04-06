package chapter5;

//윤년 검사
// 2023년 이후 윤년 10개를 찾아서 배열에 저장하고 이를 출력.
// 4로 나누어 떨어지는 해는 윤년, 그밖 평년
// 4로 나누어 떨어져도 100으로 나눠지면 평년
// 4로 나눠지고, 100으로도 나눠지지만 400으로 나눠 떨어지면 또 윤년
public class mission2_1 {

	public static void main(String[] args) {

		int year = 2024;
		int find = 0;
		int[] arr = new int[40]; // 40개 방석만 깔아주고 사람 아직 안앉음!

		while (find < 40) {
//			if (year % 4 == 0) { // 4씩 늘어나니까 어차피 4로 나눠지잖앙~
			if (year % 100 != 0) {
				arr[find] = year;
				find += 1;
			} else if (year % 100 == 0 && year % 400 == 0) {
				arr[find] = year;
				find += 1; // 위랑 아래 순서 바뀌면 2028부터 시작함.
			}
//			}

			// System.out.println(year);
			year += 4;

		}
		for (int k : arr) {
			System.out.println(k);
		}
	}
}