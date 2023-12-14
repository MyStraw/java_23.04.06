package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class _11723_집합2 { //비트마스킹 문제다. 비트마스킹으로 다시 풀어볼것
	static Map<Integer, Boolean> S = new HashMap<>();

	public static void add(int x) {
		S.remove(x);
		S.put(x, true);
	}

	public static void remove(int x) {
		S.remove(x);
		S.put(x, false);
	}

	public static int check(int x) {
		if (S.containsKey(x) && S.getOrDefault(x, false)) {
			return 1;
		} else if (S.get(x) == null) {
			return 0;
		}
		return 0;

	}

	public static void toggle(int x) {
		if (S.containsKey(x) && S.get(x).booleanValue() == true) {
			S.remove(x);
			S.put(x, false);
		} else if (!S.containsKey(x)) {
			S.remove(x);
			S.put(x, true);
		}
	}

	public static void all() {
		S.clear();
		for (int i = 1; i <= 20; i++) {
			S.put(i, true);
		}
	}

	public static void empty() {
		S.clear();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String order = br.readLine();
			String[] command = order.split(" ");

			if (order.equals("all")) {
				all();

			} else if (order.equals("empty")) {
				empty();
			} else {
				int x = Integer.parseInt(command[1]);
				if (order.startsWith("add")) {
					add(x);
				} else if (order.startsWith("remove")) {
					remove(x);
				} else if (order.startsWith("check")) {
					bw.write(String.valueOf(check(x)+"\n"));					
				} else if (order.startsWith("toggle")) {
					toggle(x);
				}
			}
		}
		bw.flush();
		bw.close();
	}//시간초과. -> bw로 바꾸니까 통과. 근데 애포에 Map을 쓸필요가 없었다.

}
