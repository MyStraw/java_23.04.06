package _코테준비_;

import java.util.LinkedList;
import java.util.Queue;

public class _bfs물_ {
    // 상, 하, 좌, 우 이동을 위한 배열
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 각 칸까지의 거리를 저장할 배열
        int[][] distance = new int[n][m];

        // 큐에 시작 지점 추가
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        // 시작 지점의 거리는 1
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵의 범위를 벗어나지 않고, 벽이 아니며, 아직 방문하지 않은 칸인지 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && distance[nx][ny] == 0) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 목적지까지의 거리 반환, 도달할 수 없으면 -1 반환
        return distance[n-1][m-1] == 0 ? -1 : distance[n-1][m-1];
    }
}
