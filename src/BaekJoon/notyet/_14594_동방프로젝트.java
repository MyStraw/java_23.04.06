package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14594_동방프로젝트 {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(br.readLine());
	        int m = Integer.parseInt(br.readLine());

	        boolean[] wall = new boolean[n - 1];
	        for (int i = 0; i < n - 1; i++) {
	            wall[i] = true;
	        }

	        for (int i = 0; i < m; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

	            for (int j = x - 1; j < y - 1; j++) {
	                wall[j] = false;
	            }
	        }

	        int count = 0;
	        for (boolean w : wall) {
	            if (w) count++;
	        }

	        System.out.println(count + 1);
	    }

}
