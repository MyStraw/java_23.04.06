package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26041_비슷한전화번호표시2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] phone = br.readLine().split(" ");
		String B = br.readLine();

		int count = 0;

		for (String num : phone) {		
			if (!num.equals(B) && num.startsWith(B)) {
				count++;
			}
		}

		System.out.println(count);
	}

}
