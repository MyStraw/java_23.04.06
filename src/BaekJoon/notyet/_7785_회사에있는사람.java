package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _7785_회사에있는사람 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String inAndOut = st.nextToken();

			if (inAndOut.equals("enter")) {
				set.add(name);
			} else if (inAndOut.equals("leave")) {
				set.remove(name);
			}
		}
		Object[] setset = set.toArray();
		Arrays.sort(setset, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return o2.toString().compareTo(o1.toString());
			}
		});
		for (Object s : setset) {
			System.out.println(s);
		}
	}
}
