package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _17363_우유가넘어지면 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char milk[][] = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			milk[i] = line.toCharArray();
		}

		char rotation[][] = new char[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotation[M - j - 1][i] = rotator(milk[i][j]);
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(rotation[i][j]);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static char rotator(char c) {
		switch (c) {
		case '.':
			return '.';
		case 'O':
			return 'O';
		case '-':
			return '|';
		case '|':
			return '-';
		case '/':
			return '\\';
		case '\\':
			return '/';
		case '^':
			return '<';
		case '<':
			return 'v';
		case 'v':
			return '>';
		case '>':
			return '^';
		default:
			return ' ';
		}

	}
}
