package BOJ.gold.gold05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14503 {
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌 (시계 방향)
    static int[] dc = {0, 1, 0, -1};
    // 왼쪽 회전: (dir + 3) % 4

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] robot = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int dir = Integer.parseInt(st.nextToken());

        int[][] rooms = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int move = 0;
        while(true) {
            // 현재 위치 청소
            if(rooms[robot[0]][robot[1]] == 0) {
                count++;
                rooms[robot[0]][robot[1]] = 2;
            }

            // 반시계 방향 회전
            dir = (dir + 3) % 4;
            int nr = robot[0] + dr[dir];
            int nc = robot[1] + dc[dir];
            if(nr >= 0 && nc >= 0 && nr < N && nc < M && rooms[nr][nc] == 0) {
                // 청소 안된 칸이 있으면 전진
                robot[0] = nr;
                robot[1] = nc;
                move = 0;
            } else {
                move++;
            }

            if(move == 4) {
                move = 0;
                // 후진
                int backR = robot[0] - dr[dir];
                int backC = robot[1] - dc[dir];

                // 후진하는데 위치가 벽이면 끝
                if(backR >= 0 && backC >= 0 && backR < N && backC < M && rooms[backR][backC] != 1) {
                    robot[0] = backR;
                    robot[1] = backC;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}