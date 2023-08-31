package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _아레나B번_FizzBuzz {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S1 = br.readLine();
		String S2 = br.readLine();
		String S3 = br.readLine();
		
		String [] Fizz = new String[99999999];
		
		for (int i = 1 ; i<=99999999 ; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				Fizz[i-1] = "FizzBuzz";						
			}
			if (i % 3 == 0 && i % 5 != 0) {				
				Fizz[i-1] = "Fizz";	
			}

			if (i % 3 != 0 && i % 5 == 0) {				
				Fizz[i-1] = "Buzz";	
			}

			if (i % 3 != 0 && i % 5 != 0) {				
				Fizz[i-1] = Integer.toString(i);	
			}			
		}
		
		for(int i = 0; i<99999996; i++) {
			if(Fizz[i].equals(S1) && Fizz[i+1].equals(S2) && Fizz[i+2].equals(S3)) {
				bw.write(Fizz[i+3]);
				break;
			}		
		}	
		br.close();
		bw.flush();
		bw.close();
	
	}
}
