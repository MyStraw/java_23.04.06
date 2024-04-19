package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5073_삼각형과세변 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a + b + c == 0) break;
			
			int triangle[] = { a, b, c };			
			Arrays.sort(triangle);

			if (triangle[0] + triangle[1] <= triangle[2]) {
				bw.write("Invalid");
				bw.newLine();
			}
			else if (triangle[0] == triangle[1] && triangle[0] == triangle[2]) {
				bw.write("Equilateral");
				bw.newLine();
			} else if (triangle[0] == triangle[1] || triangle[0] == triangle[2] || triangle[1] == triangle[2]) {
				bw.write("Isosceles");
				bw.newLine();
			} else if (triangle[0] != triangle[1] || triangle[0] != triangle[2] || triangle[1] != triangle[2]) {
				bw.write("Scalene");
				bw.newLine();
			}			
		}
		bw.flush();
		bw.close();
	}
}

//String input;

//while(!(input = br.readLine()).equals("0 0 0")) 이걸 이용하자.
