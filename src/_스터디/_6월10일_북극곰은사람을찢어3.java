package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6월10일_북극곰은사람을찢어3 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		String bear = br.readLine();
		String bearcopy = bear;
		int count = 1;
		int gae = 0;
		int gae2 = 0;
		bear = bear.replace("()", "O");
		bear = bear.replace(")(", "X");
		bear = bear.replace("O", "");
		bear = bear.replace("X", "");
		bearcopy = bearcopy.replace(")(", "X");
		bearcopy = bearcopy.replace("()", "O");
		bearcopy = bearcopy.replace("X", "");
		bearcopy = bearcopy.replace("O", "");
		String baby = bear;
		boolean pandan = bear.length() >= bearcopy.length();
		while (true) {
			if (bear == "" || bearcopy == "")
				break;
			if (pandan) {
				gae = baby.length();
				baby = baby.replace("()", "O");
				baby = baby.replace(")(", "X");
				baby = baby.replace("O", "");
				baby = baby.replace("X", "");				
				count++;
				if (gae == baby.length() || baby == "") {
					break;
				}
				
			} else {
				gae2 = baby.length();
				baby = baby.replace(")(", "X");
				baby = baby.replace("()", "O");
				baby = baby.replace("X", "");
				baby = baby.replace("O", "");				
				count++;
				if (gae2 == baby.length() || baby == "") {
					break;
				}				
			}
		}

		if (baby == "") {
			System.out.println(count);

		} else
			System.out.println("-1");
	}
}
