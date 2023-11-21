package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String chess = br.readLine();

		String wb = "wbwbwbwb";

//		List<Character> llist = new ArrayList<>();
//
//		for (char ch : wb.toCharArray()) {
//			llist.add(ch); // 엉덩이에 추가. push는 머리에.
//		}

		

		for (int j = 0; j <= M - 8; j++) {
			int notSame_wb = 0;
			int notSame_bw = 0;
			for (int i = j; i < j + 8; i++) {
				if (wb.charAt(i) != chess.charAt(i)) { //wb.charAt(i)는 8을 넘어가버리니까 이걸 해결.
					notSame_wb++;
					notSame_bw++;
				}
				int result = (notSame_wb > notSame_bw) ? notSame_wb : notSame_bw;

				System.out.println(result);
			}
		}

//		String [][] chess = new String [N][M];
//		Boolean [][] check = new Boolean [8][8];

		for (int i = 0; i < N; i++) {
			String whiteblack = br.readLine();

		}

	}

}
