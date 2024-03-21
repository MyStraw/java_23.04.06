package BaekJoon.notyet;

import java.util.Scanner;

public class _valid_input {
	static class Node {
        String str = ""; // 자바에서는 문자열을 String 객체로 처리
        int[] arr = new int[10];

        public Node() {
            // 자바에서 배열은 생성 시 기본값으로 초기화됩니다. int 배열은 0으로, String은 null로 초기화되므로 별도의 초기화 과정이 필요 없습니다.
        }
    }

    static int wordSum(String str) {
        int sum = 0;
        for (int c = 0; c < str.length() && str.charAt(c) != ' '; c++) {
            sum += str.charAt(c) - 'a' + 1;
        }
        return sum;
    }

    static boolean validateInput1(String str) {
        for (int c = 0; c < str.length(); c++) {
            if (str.charAt(c) < 'A' || str.charAt(c) > 'Z')
                return false;
        }
        return true;
    }

    static boolean validateInput2(String str) {
        final String key = "TSFHHABP", hint = "\\BD_OBNZ";

        int prv = 0;
        for (int i = 0; i < 8; i++) {
            prv = ((prv << 1) ^ str.charAt(i)) & 31;
            if (prv + 'A' != key.charAt(i))
                return false;
        }

        for (int i = 0; i < 8; i++) {
            System.out.print((char)(str.charAt(i) ^ hint.charAt(i) & 31));
        }
        System.out.println();

        return true;
    }

    static boolean validateInput3(int[] arr) {
        final String s1 = "computer preferred bulk tourist biographies";
        final String s2 = "worldwide resistance implemented magical viruses";
        final String s3 = "theorem";

        if (arr[0] != sentenceSum(s1))
            return false;
        if (arr[1] != sentenceSum(s2))
            return false;
        if (arr[2] != sentenceSum(s3))
            return false;

        return true;
    }

    static int sentenceSum(String str) {
        int sum = 0, wordSum = 0;
        for (String word : str.split(" ")) {
            wordSum = wordSum(word);
            sum *= 100;
            sum += wordSum % 100;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node data = new Node();

        data.str = scanner.next();

        // 자바에서는 배열을 사용자 입력으로 직접 받는 것이 일반적이지 않으므로, 예제 입력을 위한 별도의 메커니즘이 필요할 수 있습니다.

        if (!validateInput1(data.str)) {
            System.out.println("NO (1)");
            return;
        }
        if (!validateInput2(data.str)) {
            System.out.println("NO (2)");
            return;
        }
        // validateInput3의 arr는 사용자 입력을 받거나 테스트 케이스에 따라 초기화 필요
        // 예: data.arr = new int[]{1195462209, 1313164613, 84};
        if (!validateInput3(data.arr)) {
            System.out.println("NO (3)");
            return;
        }

        System.out.println("YES");
    }

}
