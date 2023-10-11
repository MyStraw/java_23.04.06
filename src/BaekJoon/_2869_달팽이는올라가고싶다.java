package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int total = 0;
		int noon = 0;	

		while (total < V) {
			noon++;
			total = total + A;
			if(total >=V) {
				break;
			}			
			total = total - B;					
			if(total >=V) {
				break;
			}						
		}
		
		while(A-B>V) {
			total = A-B;
		}
		
		bw.write(Integer.toString(noon));
		bw.flush();
		bw.close();

	}

}
