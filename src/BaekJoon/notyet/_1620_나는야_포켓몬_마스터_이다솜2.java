package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1620_나는야_포켓몬_마스터_이다솜2 { //binarySearch를 썼는데, 그냥 Map을 2개 만들면 된다.

	static class Pokemon {
		private int num;
		private String name;

		public Pokemon(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {
			return num;
		}

		public String getName() {
			return name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Pokemon[] dogam = new Pokemon[N];

		for (int i = 0; i < N; i++) {
			String poketmon = br.readLine();
			dogam[i] = new Pokemon(i + 1, poketmon);

		}
		Comparator<Pokemon> nameCom = new Comparator<>() {
			@Override
			public int compare(Pokemon p1, Pokemon p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};

		Pokemon[] sortCopy = Arrays.copyOf(dogam, dogam.length);
		Arrays.sort(sortCopy, nameCom);

		for (int i = 0; i < M; i++) {
			String guess = br.readLine();
			try {
				int number = Integer.parseInt(guess);
				bw.write(dogam[number - 1].getName() + "\n");

			} catch (Exception e) {
				int index = Arrays.binarySearch(sortCopy, new Pokemon(0, guess), nameCom);
				bw.write(sortCopy[index].getNum() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
