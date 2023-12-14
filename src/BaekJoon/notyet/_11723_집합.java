package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class _11723_집합 {
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
		}
		else if (S.get(x) == null) {
			return 0;
		}
		return 0;

	}

	public static void toggle(int x) {
		if (S.containsKey(x)&&S.get(x).booleanValue() == true) {
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
			if (!order.equals("all") || !order.equals("empty")) {
				String[] command = order.split(" ");
				int x = Integer.parseInt(command[1]);
				if (order.startsWith("add")) {
					add(x);
				} else if (order.startsWith("remove")) {
					remove(x);
				} else if (order.startsWith("check")) {
					System.out.println(check(x));					
				} else if (order.startsWith("toggle")) {
					toggle(x);
				}
			} else if (order.equals("all")) {
				all();

			} else if (order.equals("empty")) {
				empty();
			}
		}
	}//all 에서 에러가 난다. 2에서 이거 순서만 좀 바꿈.

}
