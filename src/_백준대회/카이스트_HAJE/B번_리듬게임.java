package _백준대회.카이스트_HAJE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B번_리듬게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		double S0 = Double.parseDouble(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<double[]> byensok = new ArrayList<>();
		byensok.add(new double[] { 1, S0 });
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			double S = Double.parseDouble(st.nextToken());
			byensok.add(new double[] { M, S });
		}
		byensok.add(new double[] { N + 1, 0 });

		double totalTime = 0;
		for (int i = 0; i < byensok.size() - 1; i++) {
			double now = byensok.get(i)[0];
			double next = byensok.get(i + 1)[0];
			double nowBpm = byensok.get(i)[1];
			double playTime = next - now;			
			double min = playTime * (4.0 / nowBpm);
			totalTime += min * 60; 
		}

		System.out.printf("%.12f\n", totalTime);
	}

}
