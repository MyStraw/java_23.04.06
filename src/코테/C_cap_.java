package 코테;

import java.util.Arrays;

public class C_cap_ {
	 public static void main(String[] args) {
	        int cap = 100;
	        int k = 70;
	        int[] scores = {95, 90, 80, 80, 80, 70, 70, 30, 10};	        
	        int m = 4;
	        
//	        int cap = 100;
//	        int k = 82;
//	        int[] scores = {100, 97, 97, 92, 87, 77, 77, 72, 72};
//	        int m = 4;
//	        
//	        
//	        int cap = 2000;
//	        int k = 1998;
//	        int[] scores = {2000, 2000, 2000, 2000, 1999};
//	        int m = 5;
	        
	        System.out.println(findMinimumAdjustments(scores, k, m, cap));
	    }

	    private static int findMinimumAdjustments(int[] scores, int k, int m, int cap) {
	        int adjustments = -1; // 조정이 필요한 최소한의 사람 수 초기화
	        
	        // 나를 포함한 전체 참가자 수
	        int totalParticipants = scores.length + 1;
	        
	        // 모든 가능한 조정 방법을 시도 (브루트포스)
	        for (int i = 0; i < scores.length; i++) {
	            for (int j = i + 1; j < scores.length; j++) {
	                // i와 j 사이에 점수를 조정합니다.
	                int[] adjustedScores = Arrays.copyOf(scores, scores.length);
	                // 모든 가능한 점수 조정을 시도
	                for (int adjust = -cap; adjust <= cap; adjust++) {
	                    adjustedScores[i] += adjust;
	                    adjustedScores[j] -= adjust;
	                    
	                    if (isValidScore(adjustedScores[i], cap) && isValidScore(adjustedScores[j], cap)) {
	                        // 조정 후의 등수를 계산
	                        int rank = calculateRank(adjustedScores, k, cap);
	                        if (rank <= m && totalParticipants <= m + 1) {
	                            // 조정이 성공한 경우
	                            if (adjustments == -1 || adjustments > 2) {
	                                adjustments = 2; // 최소한의 조정된 사람 수 갱신
	                            }
	                        }
	                    }
	                    // 점수 조정을 원상 복구
	                    adjustedScores[i] -= adjust;
	                    adjustedScores[j] += adjust;
	                }
	            }
	        }
	        
	        return adjustments;
	    }

	    private static boolean isValidScore(int score, int cap) {
	        return score >= 0 && score <= cap;
	    }

	    private static int calculateRank(int[] scores, int k, int cap) {
	        Arrays.sort(scores);
	        int rank = 1;
	        for (int i = scores.length - 1; i >= 0; i--) {
	            if (scores[i] > k) {
	                rank++;
	            } else {
	                break;
	            }
	        }
	        return rank;
	    }
}

/*
 * 프로그램 경진대회에 n+1명이 참가. 예선에서 0점이상 cap점 이하를 받은 사람만 해당하고, 점수 높은순으로 등수를 매겨서
 * m등이상(1등~m등)이 본선진출을 해.
 * 
 * 난 k점을 받아서 진출에 실패를 했는데,특별한 초틍력을 갖고있어.
 * 
 * 나 이외의 2명의 참가자를 정해 그 둘의 점수옮기기를 무한으로 할수있어. 예를들어 참가자 a와 b를 정해서 a에게서 -1점을 해서 b에게
 * +1점을 할수가 있어.
 * 
 * 난 모든 참가자의 예선점수를 알고있어. 난 현재는 진출을 못했지만, 초능력을 써서 본선에 진출할거야. 대신 점수가 바뀌는 사람은 최소한으로
 * 만들고싶어.
 * 
 * 문제의 입력값으로는 |cap | k | 나를 제외한 참가자 점수 내림차순 int [] score | m| 이렇게 주어질거야
 * 
 * 출력값으로 최소한의 사람수를 출력하면 돼
 * 
 * 입력값 하나를 예로 줄게 cap = 100 k = 70 score = {95, 90, 80, 80, 80, 70, 70, 30, 10}
 * m=4
 * 
 * 문제를 하나하나 잘 읽고 자바 코드로 풀어줄래?
 * 
 * (단, 동점자는 같은 등수이고, 등수란 : 자신보다 점수 높은 사람의수 + 1 이다) (또한, 참가자의 점수를 아무리 바꾸어도 내가
 * 진출할수 없다면 -1을 출력한다)
 
 위의 코드로 3개의 예제를 실험해보니 전부 -1이 나왔어. 틀렸단 얘기야.

너가 문제를 제대로 이해하고 있는지 확인해볼게.
--------------------------------------------------
1. 전체 참가자수는 scores.length + 1(나) 
2. 모든 점수들은 항상 0이상 cap 이하를 유지
3. 점수 높은사람부터 1등부터 매겨서 1등~m등까지만 본선진출
4. "나" 는 k 점수를 받았고, 이 점수는 m등 안에 들수없는 점수이다. 왜냐면 "나"는 다른 참가자들의 점수와 등수를 알고있다.
5. scores표의 점수들 중에 1~m등까지 "나"가 들어가야 한다
6. 그러기 위해 점수 조작을 쓰는데, 임의의 2명을 선택하여 둘의 점수를 1점씩 옮길수 있다.
(a의 점수 -1을 해서 b의 점수를 +1 올리는 식)
7. 이 과정은 무한반복 가능하다. 1점씩 10번하면 a는 -10점, b는 +10점이 되는 식.
8. a와 b 뿐만아니라 또 다른 참가자를 6의 방식으로 선택해서 "나"가 m등안에 들수있게 점수 조정을 할수있다.

9. 이렇게 점수조작에 참여된 사람들이 최소한이 되도록 하여 "나"가 1~m등 안에 들어야 한다.
10. 내가 안에 들어가는 대신 누군가는 원래 본선진출이 가능했지만, 더이상 불가능 해지겠지?
11. 혹은 m등안의 동점자수가 많아도 상관없겠지?

12. 이렇게 "나"가 본선진출을 할수있게 조작을 해보다가, 어떠한 방법으로도 불가능 하다면 "-1"을 리턴.
----------------------------------

예제 3개를 보여줄게
int cap = 100;
	        int k = 70;
	        int[] scores = {95, 90, 80, 80, 80, 70, 70, 30, 10};	        
	        int m = 4;
	        답 = 3
	        
	        int cap = 100;
	        int k = 82;
	        int[] scores = {100, 97, 97, 92, 87, 77, 77, 72, 72};
	        int m = 4;
	        답 = 4
	        
	        int cap = 2000;
	        int k = 1998;
	        int[] scores = {2000, 2000, 2000, 2000, 1999};
	        int m = 5;
			답 = -1

각각 답이 3,4,-1 이야
이제 문제에 대한 정보와 정리는 충분히 한것같아
이 채팅을 계속 기억하고 있어! 이 정보를 바탕으로
다시한번 너의 생각과 의견을 존중해줄게. 너의 방식으로 다시한번 코드로 풀어볼래?
 
 
 
 */