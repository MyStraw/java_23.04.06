package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2869_달팽이는올라가고싶다4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

	
		
		
		if((V-A)%(A-B)!=0) {
			bw.write(Integer.toString((V-A)/(A-B)+2));
			}
		else   {
			bw.write(Integer.toString((V-A)/(A-B)+1));
		}

		
		bw.flush();
		bw.close();
	}
}