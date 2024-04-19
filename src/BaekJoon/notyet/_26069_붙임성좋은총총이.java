package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _26069_붙임성좋은총총이 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Name[] chong = new Name[n];
		HashSet<String> hash = new HashSet<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			chong[i] = new Name(A, B);
		}

		for (int i = 0; i < n; i++) {
			if (chong[i].getA().equals("ChongChong") || chong[i].getB().equals("ChongChong")) {
				hash.add(chong[i].getA());
				hash.add(chong[i].getB());
			}
			else if (hash.contains(chong[i].getA()) || hash.contains(chong[i].getB())) {
				hash.add(chong[i].getA());
				hash.add(chong[i].getB());			
			}			
		}
		System.out.println(hash.size());

	}

	static class Name {
		private String A;
		private String B;

		private Name(String A, String B) {
			this.A = A;
			this.B = B;
		}

		public String getA() {
			return A;
		}

		public String getB() {
			return B;
		}

	}

}
