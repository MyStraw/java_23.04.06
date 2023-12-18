package BaekJoon.notyet;

public class _부르트포스_ {
	public static int searchString(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();

		for (int i = 0; i <= n - m; i++) {
			int j;

			for (j = 0; j < m; j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}

			if (j == m) {
				return i; // 패턴이 발견된 위치 반환
			}
		}
		return -1; // 패턴이 발견되지 않음
	}

	public static void main(String[] args) {
		String text = "ABC이지스DEF";
		String pattern = "이지스";

		int position = searchString(text, pattern);

		if (position != -1) {
			System.out.println("패턴이 발견된 위치: " + position);
		} else {
			System.out.println("패턴을 찾을 수 없습니다.");
		}
	}

}
