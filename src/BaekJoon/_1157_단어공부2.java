package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _1157_단어공부2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<String> charList = new ArrayList<>();
		ArrayList<Integer> num = new ArrayList<>();
		String word = br.readLine();
		for (int i = 0; i < word.length(); i++) {
			String tmp = word.substring(i, i + 1).toUpperCase(); 
		
			if (charList.contains(tmp)) {
				num.set(charList.indexOf(tmp), num.get(charList.indexOf(tmp)) + 1);
			} else {
				charList.add(tmp);
				num.add(1);
			}
		}

		boolean overlap = false;
		int maxValue = Integer.MIN_VALUE;
		int idx = -1;
		for (int i = 0; i < charList.size(); i++) {
			if (num.get(i) > maxValue) {
				maxValue = num.get(i);
				idx = i;
			}
		}
		for (int i = idx + 1; i < num.size(); i++) {
			if (num.get(idx).equals(num.get(i))) {
				overlap = true;
				break;
			}
		}
		if (overlap) {
			bw.write("?");
		} else {
			bw.write(charList.get(idx).toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
