package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6월10일_북극곰은사람을찢어2 {
	public static class Pair {
        private final int count;
        private final String bear;

        public Pair(int count, String bear) {
            this.count = count;
            this.bear = bear;
        }

        public int getCount() {
            return count;
        }

        public String getBear() {
            return bear;
        }
    }

	public static Pair tear(String bear, String first, String second, String third, String forth, String fifth) {
		int count = 0;
		int gae = 0;
		while (bear !="") {
			gae = bear.length();
			bear = bear.replace(first, second);
			bear= bear.replace(third, forth);
			bear = bear.replace(second, fifth);
			bear = bear.replace(forth, fifth);
			count++;
			if (gae == bear.length()) {
				break;
			}
		}
		return new Pair(count, bear);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		String bear = br.readLine();
		String bearCopy = bear;
		String gual = "()";
		String O = "O";
		String ex = ")(";
		String X = "X";
		String bin = "";

		Pair count1 = tear(bear, gual, O, ex, X, bin);
		Pair count2 = tear(bearCopy, ex, X, gual, O, bin );

		if (count1.getBear() == "" || count2.getBear() == "") {
			if (count1.getCount() > count2.getCount()) {
				System.out.println(count2.getCount());
			} else {
				System.out.println(count1.getCount());
			}
		} else {
			System.out.println("-1");
		}
	}
}
