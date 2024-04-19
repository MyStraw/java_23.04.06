package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _1010_다리놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(gob(a,b).toString());
			bw.write("\n");			
		}
		bw.flush();		
		bw.close();
	}

	public static BigInteger gob(int a, int b) {
		
	    BigInteger totala = BigInteger.ONE; //1을 나타냄
        BigInteger totalb = BigInteger.ONE;
        BigInteger totalc;

        for (int i = 0; i < a; i++) {
            totala = totala.multiply(BigInteger.valueOf(b - i));
            totalb = totalb.multiply(BigInteger.valueOf(a - i));
        }
        totalc = totala.divide(totalb);
        return totalc;		

//		long totala = 1;
//		long totalb = 1;
//		long  totalc; //사칙연산 하려면 전부 long 타입 일치 하자
//		for (int i = 0; i < a; i++) {
//			totala = totala * (b - i);
//			totalb = totalb * (a - i);
//		}
//		totalc = totala / totalb;
//		return totalc;
	}

}





