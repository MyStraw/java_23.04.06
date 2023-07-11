package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _10250_ACM호텔 {
	public static void main(String[] args) throws IOException {				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(br.readLine());
		String y = "";
		String x = "";
		
		for (int i = 0 ; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int floor = Integer.parseInt(st.nextToken());
			int room = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			y = Integer.toString((customer % floor));
			x = Integer.toString((customer / floor)+1);
			
			
			
			if (y == "0") {
				y = Integer.toString(floor);
				if (x.length() == 2){
					System.out.println(y + x);
				}
				else if (x.length() == 1) {
					System.out.println(y + "0"+ x);
				}
			}
			else
				if (x.length() == 2){
					System.out.println(y + x);
				}
				else if (x.length() == 1) {
					System.out.println(y + "0"+ x);
				}	
			
		}		
	}
}
