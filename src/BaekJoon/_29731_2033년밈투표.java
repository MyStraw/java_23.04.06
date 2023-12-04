package BaekJoon;

import java.util.Scanner;

public class _29731_2033년밈투표 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        boolean changed = false;
        for (int i = 0; i < N; i++) {
            String sentence = sc.nextLine();
            if (!original(sentence)) {
            	changed = true;
                break;
            }
        }

        System.out.println(changed ? "Yes" : "No");
    }

    public static boolean original(String sentence) {
        return sentence.equals("Never gonna give you up")
                || sentence.equals("Never gonna let you down")
                || sentence.equals("Never gonna run around and desert you")
                || sentence.equals("Never gonna make you cry")
                || sentence.equals("Never gonna say goodbye")
                || sentence.equals("Never gonna tell a lie and hurt you")
                || sentence.equals("Never gonna stop");
    }
}
