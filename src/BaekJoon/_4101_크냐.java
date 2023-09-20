package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _4101_크냐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String han;
		
		while (!(han = br.readLine()).equals("0 0")) { //br.readline은 한번 호출되면 소실된다.
			StringTokenizer st = new StringTokenizer(han);
			int jung1 =  Integer.parseInt(st.nextToken());
			int jung2 =  Integer.parseInt(st.nextToken());						
			
			if (jung1 > jung2) {
				bw.write("Yes\n");				
			}else {
				bw.write("No\n");
			}		
			
		}	
		bw.flush();
		bw.close();
		br.close();
		
	}

}
