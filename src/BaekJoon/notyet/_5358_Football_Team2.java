package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5358_Football_Team2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;
		while ((line = br.readLine()) != null) {

			char[] charr = line.toCharArray();

			for (int i = 0; i < charr.length; i++) {
				if (charr[i] == 'i') {
					charr[i] = 'e';
				} else if (charr[i] == 'e') {
					charr[i] = 'i';
				} else if (charr[i] == 'I') {
					charr[i] = 'E';
				} else if (charr[i] == 'E') {
					charr[i] = 'I';
				}
			}
			bw.write(new String(charr));
			bw.newLine();
					
		}
		bw.flush();	
		
	}
}