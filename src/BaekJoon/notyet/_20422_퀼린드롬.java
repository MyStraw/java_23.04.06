package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _20422_퀼린드롬 {
	public static void main(String[] args) throws IOException {
		// BufferedReader를 사용하여 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String original = br.readLine();

		// 대칭 문자 맵핑
		Map<Character, Character> mirrorMap = new HashMap<>();
		mirrorMap.put('A', 'A');
		mirrorMap.put('H', 'H');
		mirrorMap.put('I', 'I');
		mirrorMap.put('M', 'M');
		mirrorMap.put('O', 'O');
		mirrorMap.put('T', 'T');
		mirrorMap.put('U', 'U');
		mirrorMap.put('V', 'V');
		mirrorMap.put('W', 'W');
		mirrorMap.put('X', 'X');
		mirrorMap.put('Y', 'Y');
		mirrorMap.put('0', '0');
		mirrorMap.put('1', '1');
		mirrorMap.put('8', '8');
		mirrorMap.put('b', 'd');
		mirrorMap.put('d', 'b');
		mirrorMap.put('p', 'q');
		mirrorMap.put('q', 'p');
		mirrorMap.put('v', 'v');
		mirrorMap.put('w', 'w');
		mirrorMap.put('m', 'm');
		mirrorMap.put('o', 'o');
		mirrorMap.put('n', 'n');
		mirrorMap.put('2', 'S');
		mirrorMap.put('S', '2');
		mirrorMap.put('E', '3');
		mirrorMap.put('3', 'E');
		mirrorMap.put('r', '7');
		mirrorMap.put('7', 'r');
		mirrorMap.put('5', 'Z');
		mirrorMap.put('Z', '5');

		int left = 0;
		int right = original.length() - 1;
		char[] result = new char[original.length()];

		boolean possible = true;
		while (left <= right) {
			char leftChar = Character.toUpperCase(original.charAt(left));
			char rightChar = Character.toUpperCase(original.charAt(right));

			if (mirrorMap.containsKey(leftChar) && mirrorMap.get(leftChar) == rightChar) {
				result[left] = Character.isLowerCase(original.charAt(left)) ? Character.toLowerCase(leftChar)
						: leftChar;
				result[right] = Character.isLowerCase(original.charAt(right)) ? Character.toLowerCase(rightChar)
						: rightChar;
			} else if (mirrorMap.containsKey(rightChar) && mirrorMap.get(rightChar) == leftChar) {
				result[left] = Character.isLowerCase(original.charAt(right)) ? Character.toLowerCase(rightChar)
						: rightChar;
				result[right] = Character.isLowerCase(original.charAt(left)) ? Character.toLowerCase(leftChar)
						: leftChar;
			} else {
				possible = false;
				break;
			}
			left++;
			right--;
		}

		if (possible) {
			System.out.println(new String(result));
		} else {
			System.out.println("-1");
		}
	}

}
