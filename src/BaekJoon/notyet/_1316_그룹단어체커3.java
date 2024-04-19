package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class _1316_그룹단어체커3 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			Set<Character> cc = new HashSet<>();
			String group = br.readLine();
			for (int j = 0; j < group.length() - 1; j++) {
				cc.add(group.charAt(j));
				if (group.charAt(j + 1) != group.charAt(j) && !cc.contains(group.charAt(j + 1))) {
					cc.add(group.charAt(j + 1));
				} else if (group.charAt(j + 1) != group.charAt(j) && cc.contains(group.charAt(j + 1))) {
					count++;
					break;
				}
			}
		}
		bw.write(String.valueOf(N - count));
		bw.flush();
		bw.close();
	}
}