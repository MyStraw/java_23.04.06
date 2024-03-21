package BaekJoon.notyet;

public class DFDF {
	 public static void main(String[] args) {
		 int count = 0; // 처리된 문자열 수를 저장하는 변수
	        int total = 26 * 26 * 26 * 26 * 26 * 26 * 26 * 26; // 가능한 문자열 조합의 총 개수

	        // 가능한 모든 8글자의 대문자 알파벳 조합을 생성하여 검사
	        for (char a = 'A'; a <= 'Z'; ++a) {
	            for (char b = 'A'; b <= 'Z'; ++b) {
	                for (char c = 'A'; c <= 'Z'; ++c) {
	                    for (char d = 'A'; d <= 'Z'; ++d) {
	                        for (char e = 'A'; e <= 'Z'; ++e) {
	                            for (char f = 'A'; f <= 'Z'; ++f) {
	                                for (char g = 'A'; g <= 'Z'; ++g) {
	                                    for (char h = 'A'; h <= 'Z'; ++h) {
	                                        String str = "" + a + b + c + d + e + f + g + h;
	                                        if (validateInput2(str)) {
	                                            System.out.println("Found valid string: " + str);
	                                            return; // 조건을 만족하는 첫 번째 문자열을 찾으면 종료
	                                        }
	                                        count++;
	                                        // 진행상황 출력
	                                        double progress = (double) count / total * 100;
	                                        System.out.printf("Progress: %.2f%%\n", progress);
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        System.out.println("No valid string found."); // 조건을 만족하는 문자열이 없을 경우
	    }

	    static boolean validateInput2(String  str) {
	    	// 주어진 문자열에 대한 검증 로직
	        final String key = "TSFHHABP";
	        final String hint = "\\BD_OBNZ";

	        int prv = 0;
	        for (int i = 0; i < 8; i++) {
	            prv = ((prv << 1) ^ str.charAt(i)) & 31;
	            if ((char) (prv + 'A') != key.charAt(i))
	                return false;
	        }

	        for (int i = 0; i < 8; i++) {
	            System.out.print((char) (str.charAt(i) ^ hint.charAt(i) & 31));
	        }
	        System.out.println();

	        return true;
	    }

}
