package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _25192_인사성밝은곰곰이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashSet<String> hash = new HashSet<>();
		int count = 0;
		boolean enter = false;

		for (int i = 0; i < n; i++) {
			String nick = br.readLine();
			if (nick.equals("ENTER")) {
				hash.clear();
				enter = true;
			} else if (true && !hash.contains(nick)) {
				hash.add(nick);
				count++;
			}
		}
		System.out.println(count);
	}
}