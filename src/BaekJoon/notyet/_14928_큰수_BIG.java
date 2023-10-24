package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class _14928_큰수_BIG {
	public static void main(String[] args) throws IOException {	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		BigInteger N = new BigInteger(br.readLine());

		BigInteger birth = BigInteger.valueOf(20000303);

		BigInteger result = N.mod(birth);	

		System.out.println(result);
	}

}
