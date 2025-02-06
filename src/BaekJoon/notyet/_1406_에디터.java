package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class _1406_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> editor = new LinkedList<>();
	
		String str = br.readLine();
		for (char ch : str.toCharArray()) {
			editor.add(ch);
		}
	
		ListIterator<Character> cursor = editor.listIterator(editor.size());

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			String command = br.readLine();

			char cmd = command.charAt(0);
			switch (cmd) {
			case 'L':
				if (cursor.hasPrevious()) {
					cursor.previous();
				}
				break;
			case 'D':
				if (cursor.hasNext()) {
					cursor.next();
				}
				break;
			case 'B':
				if (cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
				break;
			case 'P':
				char c = command.charAt(2);
				cursor.add(c);
				break;
			}
		}
	
		StringBuilder result = new StringBuilder();
		for (char ch : editor) {
			result.append(ch);
		}
		System.out.println(result.toString());
	}

}
