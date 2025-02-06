package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10188_Quadrilateral {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int numData = Integer.parseInt(br.readLine());	
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numData; i++) {			
			String[] dimension = br.readLine().split(" ");
			int length = Integer.parseInt(dimension[0]);
			int width = Integer.parseInt(dimension[1]);
		
			for (int row = 0; row < width; row++) {
				for (int col = 0; col < length; col++) {
					sb.append("X");
				}
				sb.append("\n");
			}
			
			if (i < numData - 1) {
				sb.append("\n");
			}
		}
	
		System.out.print(sb.toString());
	}

}
