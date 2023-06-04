package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6월10일_북극곰은사람을찢어 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String N = br.readLine();
		String bear = br.readLine();
		String bearcopy = bear;
		int count = 0;
		int count2 = 0;
		int gae = 0;
		int gae2 = 0;
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
		while (bearcopy != "") {
			gae2 = bearcopy.length();
			bearcopy = bearcopy.replace(")(", "X");
			bearcopy = bearcopy.replace("()", "O");
			bearcopy = bearcopy.replace("X", "");
			bearcopy = bearcopy.replace("O", "");
			count2++;
			if (gae2 == bearcopy.length()) {
				break;
			}
		}

		if (gae == bear.length() && gae2 == bearcopy.length()) {
			System.out.println("-1");
		}

		if (bear == "" || bearcopy == "") {
			if (count > count2) {
				System.out.println(count2);
			} else if (count < count2) {
				System.out.println(count);
			} else if (count == count2) {
				System.out.println(count);
			}
		}

	}
}
