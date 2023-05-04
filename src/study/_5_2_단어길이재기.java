package study;

import java.util.Scanner;

public class _5_2_단어길이재기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int n = str.length();
		System.out.println(n);
//
//		char[] a = new char[100];
//		int count = 0;
//
//		for (int i = 0; i < 100; i++) {
//			char s = str.charAt(i);
//			a[i] = s;
//
//			if (a[i] != '0') {
//				count++;
//
//			} 
//
//		}
//		System.out.println(count);

	}
}

//-----------------------------------------내가 한 코드. 에러남.
// length 쓰면 한방에 끝.
// ---------------------------------------- 굳이 for 쓰려면
//import java.util.Scanner;
//
//public class _5_2_단어길이재기 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        sc.close();
//
//        char[] a = str.toCharArray();
//        int count = 0;
//
//        for (char c : a) {
//            if (c != 0) {
//                count++;
//            } else {
//                break;
//            }
//        }
//        System.out.println(count);
//    }
//}
//-------------------------------------------------------
//import java.util.Scanner;
//
//public class _5_2_단어길이재기 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        sc.close();
//
//        char[] a = new char[100];
//        int count = 0;
//
//        for (int i = 0; i < 100; i++) {
//            if (i < str.length()) {
//                a[i] = str.charAt(i);
//                count++;
//            } else {
//                break;
//            }
//        }
//        System.out.println(count);
//    }
//}
