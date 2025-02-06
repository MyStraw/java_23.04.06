package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26041_비슷한전화번호표시 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String phone[] = br.readLine().split(" ");

		String B = br.readLine();

		int count = 0;

		for (int i = 0; i < phone.length; i++) {
			boolean jub = false;
			if (phone[i].contains(B)) {
				if (phone[i].length() > B.length()) {
					for (int j = 0; j < B.length(); j++) {
						if (B.charAt(j) == phone[i].charAt(j)) {
							jub = true;
						} else {
							jub = false;
							break;
						}
					}
					if (jub) {
						count++;
					}
				}
			}
		}
		System.out.println(count);

	}

}
