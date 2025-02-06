package BaekJoon.notyet;

public class _31577_랜섬웨어와비트코인2 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		// 1부터 20까지 숫자를 4개씩 그룹으로 묶음
		String[] list = new String[5];
		for (int i = 0; i < 5; i++) {
			StringBuilder group = new StringBuilder();
			for (int j = 1; j <= 4; j++) {
				group.append(i * 4 + j).append(" ");
			}
			list[i] = group.toString().trim();
		}

		// 첫 번째와 두 번째 그룹을 6번 반복
		for (int i = 0; i < 6; i++) {
			sb.append(list[0]).append(" ").append(list[1]).append("\n");
		}

		// 세 번째와 네 번째 그룹을 3번 반복
		for (int i = 0; i < 3; i++) {
			sb.append(list[2]).append(" ").append(list[3]).append("\n");
		}

		// 세 번째와 다섯 번째 그룹을 3번 반복
		for (int i = 0; i < 3; i++) {
			sb.append(list[2]).append(" ").append(list[4]).append("\n");
		}

		// 네 번째와 다섯 번째 그룹을 3번 반복
		for (int i = 0; i < 3; i++) {
			sb.append(list[3]).append(" ").append(list[4]).append("\n");
		}

		// 결과 출력
		System.out.println(sb.toString());
	}

}
