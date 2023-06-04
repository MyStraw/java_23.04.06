package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _6월3일_문자열폭발_2차수정2 {

	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer(); // 콘솔 찍는용도가 다가 아니었던 거시어따
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Scanner sc = new Scanner(System.in);
		Queue<String> que = new LinkedList<>();
		String moonjang = br.readLine();
		String bomb = br.readLine();
		sb.append(moonjang.replaceAll(bomb, ""));
		while (true) {
			que.add(sb.toString());
			sb.delete(0, sb.length());
			if (que.peek().contains(bomb)) {
				sb.append(que.poll().replaceAll(bomb, ""));
			} else {
				break;
			}
		}
		if (!que.isEmpty())
			if (que.peek().isBlank()) {
				System.out.println("FRULA");
			} else
				System.out.println(que.peek());
	}
}
