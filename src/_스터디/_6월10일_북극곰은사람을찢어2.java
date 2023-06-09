package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6월10일_북극곰은사람을찢어2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		String bear = br.readLine();

		int count = 0;
		int gae = 0;

		while (bear != "") {
			gae = bear.length();
			bear = bear.replace("()", "O");
			bear = bear.replace(")(", "X");
			bear = bear.replace("O", "");
			bear = bear.replace("X", "");
			count++;
			if (gae == bear.length()) {
				break;
			}
		}

		if (gae == bear.length()) {
			System.out.println("-1");
		}

		if (bear == "") {
			System.out.println(count);

		}
	}

}
