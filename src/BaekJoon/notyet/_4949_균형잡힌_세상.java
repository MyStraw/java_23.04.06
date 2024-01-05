package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _4949_균형잡힌_세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String moonjang = "";

		while (!moonjang.equals(".")) {
			moonjang = br.readLine();
			Stack<String> big = new Stack<>();
			Stack<String> small = new Stack<>();
			for (char bal : moonjang.toCharArray()) {
				if (bal == '[' || bal == ']' || bal == '(' || bal == ')') {
					if (bal == '[') {
						big.push("[");
					} else if (bal == ']') {
						if (!big.isEmpty()) {
							big.pop();
						} else {
							big.push("]");
							break;
						}

					} else if (bal == '(') {
						small.push("(");

					} else if (bal == ')') {
						if (!small.isEmpty()) {
							small.pop();
						} else {
							small.push(")");
							break;
						}

					} else if (bal == '.') {
						break;
					}
				}
			}
			if (big.isEmpty() && small.isEmpty()) {
				bw.write("yes");
				bw.newLine();
			} else {
				bw.write("no");
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}
