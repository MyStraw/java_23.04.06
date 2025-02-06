package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31826_주식시장 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		BitCoin jusik[] = new BitCoin[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); //가격
			int x = Integer.parseInt(st.nextToken()); //구매 혹은 판매 물량. s는 총 물량
			int f = Integer.parseInt(st.nextToken()); // -1 판매, 1 구매

			jusik[i] = new BitCoin(p, x, f);
		}
		
		
		
		
	}

	static class BitCoin {
		private int p;
		private int x;
		private int f;

		public BitCoin(int p, int x, int f) {
			this.p = p;
			this.x = x;
			this.f = f;
		}

		public int getP() {
			return p;
		}

		public void setP(int p) {
			this.p = p;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getF() {
			return f;
		}

		public void setF(int f) {
			this.f = f;
		}

	}

}
