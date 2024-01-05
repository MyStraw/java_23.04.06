package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _4949_균형잡힌_세상2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String moonjang;

		while (true) {
			moonjang = br.readLine();
			if (moonjang.equals(".")) {
				break;
			}

			Stack<Character> stack = new Stack<>();
			boolean isBalanced = true;

			for (char bal : moonjang.toCharArray()) {
				if (bal == '[' || bal == '(') {
					stack.push(bal);
				} else if (bal == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						isBalanced = false;
						break;
					}
				} else if (bal == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						isBalanced = false;
						break;
					}
				}
			}

			if (isBalanced && stack.isEmpty()) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
	}
}