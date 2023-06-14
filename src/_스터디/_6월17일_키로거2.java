package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _6월17일_키로거2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 케이스 개수

//		StringBuilder sb = new StringBuilder();		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();		

		boolean k = true;
		
		// <<BP<A>>Cd-
		Stack<Character> keyloger = new Stack<>();
		Stack<Character> back = new Stack<>();
		List<Character> list = new LinkedList<>();
		
		
		
		
		
		
		for (int i = 0; i < N; i++) {
			String L = br.readLine();
			keyloger.clear();
			back.clear();

			for (char c : L.toCharArray()) {
				keyloger.push(c);

				switch (keyloger.peek()) {
				case '<':
					keyloger.pop();
					back.push(keyloger.pop());					
					break;
				case '>':
					keyloger.pop();
					break;
				case '-':
					keyloger.pop();
					keyloger.pop();
					break;
				}
				if (!keyloger.isEmpty())
					System.out.println(keyloger.peek());
			}
		}
	}

}
