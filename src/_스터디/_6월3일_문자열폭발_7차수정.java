package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _6월3일_문자열폭발_7차수정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String moonjang = br.readLine();
		String bomb = br.readLine();
		String splitmoonjang = "";

		Queue<String[]> que = new LinkedList<>();
		String[] st = moonjang.split(bomb);
		que.add(st);
		
		
		System.out.println(splitmoonjang);

	}
}
