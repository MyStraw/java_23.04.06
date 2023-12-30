package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class _27434_팩토리얼3 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int  N = Integer.parseInt(br.readLine());

		BigInteger combi = BigInteger.ONE;


		for (int i = 1; i <= N; i++) {
			combi = combi.multiply(BigInteger.valueOf(i));
		}
		
		bw.write(String.valueOf(combi));
		bw.flush();
		bw.close();		
	}

}
