package BaekJoon.notyet;

import java.util.Scanner;

//백트래킹 문제. dfs를 써야한다.
//dfs나 bfs는 일단 배열 두개 만들어놓고 보자.

//일단 수열이니까. 처음 선택한 수를 포함하고, 그 수를 제외한 다음 숫자 선택
//또 선택한건 제외하고 다음 다른숫자를 택해야 하는데... 갯수가 정해져 있으면
//그냥 for문으로 하면 되지만, 이건 N과 M으로 매번 다르니까.
//가지치기가 된다. 불필요한 경우를 빠르게 제거. 이미 사용한 숫자는 사용 안하는 등.

//각 숫자를 노드로 보고, 그 다음 올 숫자를 간선으로 본다.

//상태 공간 트리라고 부른다.
//첫 번째 단계(루트 레벨)에서 가능한 노드는 1, 2, 3, 4입니다.
//두 번째 단계에서 각 노드(예: 1)에서 이어지는 다음 노드는 1을 제외한 2, 3, 4가 될 수 있습니다.
public class _15649_N과M1 {

	static int N, M;
	static int[] dfs; // 현재 만들어진 수열을 저장.
	static boolean[] used; //노드, 숫자의 사용여부 판별. 중복선택 방지.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		dfs = new int[M];
		used = new boolean[N + 1]; //항상 인덱스랑 번호 구분하기 쉽게. +1 하는걸로.

		backtrack(0);

	}

	static void backtrack(int count) {
		if (count == M) { //현재 포함된 원소의 수가 M개와 같으면 스탑
			for (int num : dfs) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) { //1부터 N까지 돌면서 사용 되었는지 판단.
			if (!used[i]) {//사용되지 않았다면
				used[i] = true;//여기서 i번째 고르면서 사용했다고 표시
				dfs[count] = i;//
				backtrack(count + 1);
				used[i] = false;
			}
		}
	}
}
