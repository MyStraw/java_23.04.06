package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5358_Football_Team3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			line = line.replace('i', 'x'); // 임시 문자 'x'로 'i' 대체
			line = line.replace('I', 'X'); // 대문자도 처리
			line = line.replace('e', 'i'); // 'e'를 'i'로
			line = line.replace('E', 'I'); // 대문자도 처리
			line = line.replace('x', 'e'); // 임시 문자 'x'를 'e'로
			line = line.replace('X', 'E'); // 대문자도 처리

			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}
}