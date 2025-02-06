package _백준대회.DGUPC_제2회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _A_BB84 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
	
		String jh = br.readLine();
		String jhKey = br.readLine();
		String ian = br.readLine();
		String ianCheck = br.readLine();

		StringBuilder sb = new StringBuilder();
		boolean dochung = false;

		for (int i = 0; i < N; i++) {			
			if (jh.charAt(i) == ian.charAt(i)) {				
				if (jhKey.charAt(i) != ianCheck.charAt(i)) {
					dochung = true;
					break;
				} else {				
					sb.append(jhKey.charAt(i));
				}
			}
		}
	
		if (dochung) {
			System.out.println("htg!");
		} else {
			System.out.println(sb.toString());
		}
	}
}
