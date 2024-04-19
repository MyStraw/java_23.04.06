package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10798_세로읽기 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		char[][] young = new char[5][15];

		for (int i = 0; i < young.length; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				young[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < young[0].length; i++) {
			for (int j = 0; j < young.length; j++) {
				if (young[j][i] != '\u0000') //char은 기본타입이고 참조타입처럼 null을 쓰지 못한다. 대신 \u0000 이 null의 유니코드.
				sb.append(young[j][i]);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
