package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26489_GumGumforJayJay {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = "";
		int count = 0;

		while ((line = br.readLine()) != null && !line.isEmpty()) {			
				count++;				
		}
		System.out.println(count);
	}

}
