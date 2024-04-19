package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _11478_서로다른부분문자열의개수2 {
	public static void main(String[] args) throws IOException { //set안에 들어있는지 판단하는걸 없애고. add가 성공하면 true가 된다. if는. 그걸로, 변수지정 없이 바로.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		Set<String> set = new HashSet<>();
		int count = 0;
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j < S.length() - i + 1; j++) {
				if (set.add(S.substring(j, j + i))) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}