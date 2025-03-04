package _백준대회.제2회_유틸컵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _C_TextureWrapping {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int U = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		char[][] texture = new char[U][V];
		for (int i = 0; i < U; i++) {
			texture[i] = br.readLine().toCharArray();
		}
		String mode = br.readLine();
		char[][] result = new char[N][M];
		if (mode.equals("clamp-to-edge")) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int r = i < U ? i : U - 1;
					int c = j < V ? j : V - 1;
					result[i][j] = texture[r][c];
				}
			}
		} else if (mode.equals("repeat")) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int r = i % U;
					int c = j % V;
					result[i][j] = texture[r][c];
				}
			}
		} else if (mode.equals("mirrored-repeat")) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int blockR = i / U;
					int blockC = j / V;
					int localR = i % U;
					int localC = j % V;
					int r = (blockR % 2 == 1) ? U - 1 - localR : localR;
					int c = (blockC % 2 == 1) ? V - 1 - localC : localC;
					result[i][j] = texture[r][c];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(new String(result[i])).append("\n");
		}
		System.out.print(sb);
	}

}
