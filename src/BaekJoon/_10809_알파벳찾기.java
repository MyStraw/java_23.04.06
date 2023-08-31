package BaekJoon;

import java.util.Scanner;

public class _10809_알파벳찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		char p[] = str.toCharArray();
		
		int a[] = new int[26];
		
		for (int i = 0 ; i<26; i++) {
			a[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {
			if (p[i] == 'a' && a[0] == -1) a[0] = i; 
			if (p[i] == 'b' && a[1] == -1) a[1] = i;
			if (p[i] == 'c' && a[2] == -1) a[2] = i; 
			if (p[i] == 'd' && a[3] == -1) a[3] = i;
			if (p[i] == 'e' && a[4] == -1) a[4] = i; 
			if (p[i] == 'f' && a[5] == -1) a[5] = i;
			if (p[i] == 'g' && a[6] == -1) a[6] = i; 
			if (p[i] == 'h' && a[7] == -1) a[7] = i;
			if (p[i] == 'i' && a[8] == -1) a[8] = i; 
			if (p[i] == 'j' && a[9] == -1) a[9] = i;
			if (p[i] == 'k' && a[10] == -1) a[10] = i; 
			if (p[i] == 'l' && a[11] == -1) a[11] = i;
			if (p[i] == 'm' && a[12] == -1) a[12] = i; 
			if (p[i] == 'n' && a[13] == -1) a[13] = i;
			if (p[i] == 'o' && a[14] == -1) a[14] = i; 
			if (p[i] == 'p' && a[15] == -1) a[15] = i;
			if (p[i] == 'q' && a[16] == -1) a[16] = i; 
			if (p[i] == 'r' && a[17] == -1) a[17] = i;
			if (p[i] == 's' && a[18] == -1) a[18] = i; 
			if (p[i] == 't' && a[19] == -1) a[19] = i;
			if (p[i] == 'u' && a[20] == -1) a[20] = i; 
			if (p[i] == 'v' && a[21] == -1) a[21] = i;
			if (p[i] == 'w' && a[22] == -1) a[22] = i; 
			if (p[i] == 'x' && a[23] == -1) a[23] = i;
			if (p[i] == 'y' && a[24] == -1) a[24] = i; 
			if (p[i] == 'z' && a[25] == -1) a[25] = i;
		}
		
		for (int b : a) {
			System.out.print(b + " ");
		}
	}
}
