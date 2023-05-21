package _스터디;

import java.util.Scanner;

public class 별찍기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] top = new char[N][N];

		extracted(top, false, N); //별 찍을거, 별 안찍을 공백, 따로따로 분리 = 불리언

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(top[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	private static void extracted(char[][] top, boolean gong, int N, int 행, int 열) {
		if (not gong, N단위 블록?, 1칸마다) {
			top[i][j] = '*';
			return;
		}

		if (gong) {
			for (int i = 행; i < 행+N/3; i++) { 블록에 해당하는 범위 지정
				for (int j = 열; j < 열+N/3; j++) {
					top[i][j] = ' ';
				}
			}
			return;
		}

		블록단위를 어떻게 해주냐?  블록= N/3 =3
		int count = 0; //5칸을 이동할때마다 gong이 true = 공백찍기
					   //그외 칸들은 *찍기.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count++;
				if (count == 5) {
					extracted(top, true, N/3);
				} else {
					extracted(top, false, N/3);
				}
			}
		}
	}

	

}