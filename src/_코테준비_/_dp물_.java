package _코테준비_;

public class _dp물_ {
    public int solution(int m, int n, int[][] puddles) {
        // 격자의 크기가 m x n인 2차원 배열을 생성합니다.
        int[][] dp = new int[n+1][m+1];

        // 물에 잠긴 지역을 표시합니다. puddles의 좌표계는 1부터 시작하므로, 1을 빼줍니다.
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1; // 물웅덩이는 -1로 표시
        }
        // 집의 위치는 항상 건조한 곳이므로 시작점을 1로 설정합니다.
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 물웅덩이이거나 시작점인 경우 건너뜁니다.
                if (dp[i][j] == -1 || (i == 1 && j == 1)) continue;

                // 왼쪽에서 오는 경우와 위쪽에서 오는 경우의 합을 구합니다.
                // 물웅덩이인 경우는 경로에서 제외합니다.
                dp[i][j] = ((i > 1 && dp[i-1][j] != -1 ? dp[i-1][j] : 0)
                        + (j > 1 && dp[i][j-1] != -1 ? dp[i][j-1] : 0)) % 1_000_000_007;
            }
        }
        // 학교까지의 경로의 수를 반환합니다.
        return dp[n][m];
    }
    ///-----------------
    public String solutions (String my_string, String overwrite_string, int s) {
        // my_string을 문자 배열로 변환합니다.
        char[] charArray = my_string.toCharArray();

        // overwrite_string의 각 문자를 my_string의 인덱스 s부터 시작하여 대체합니다.
        for (int i = 0; i < overwrite_string.length(); i++) {
            charArray[s + i] = overwrite_string.charAt(i);
        }

        // 수정된 문자 배열을 기반으로 새로운 문자열을 생성하여 반환합니다.
        return new String(charArray);
    }
}

