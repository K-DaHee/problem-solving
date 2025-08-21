package BOJ.silver.silver01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BOJ_2667 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // map의 크기 N
        int N = Integer.parseInt(br.readLine());
        // 입력 받은 N만큼 map 배열 선언
        int[][] map = new int[N][N];
        // 이미 방문 했던 위치는 넘어가기 위해 저장할 배열 선언
        boolean[][] visited = new boolean[N][N];

        // BufferedReader 사용해서 이차원 배열 값 입력 받기
        for (int i = 0; i < N; i++){
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        // 상하좌우 탐색을 위한 배열
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int total = 0;
        List<Integer> answer = new ArrayList<>();
        // 2차원 배열 순회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                // 현재 위치가 1이고 이전에 방문을 안했으면 실행
                if(map[i][j] == 1 && !visited[i][j]){
                    // 배열에 1이 있는 위치를 저장할 stack 선언
                    Stack<int[]> stack = new Stack<>();
                    // 현재 위치를 stack에 담음
                    stack.push(new int[]{i, j});
                    // 현재 위치를 방문했다고 표시
                    visited[i][j] = true;

                    // 위에서 현재 위치 정보를 스택에 담았기 때문에 while 조건 만족
                    while (!stack.isEmpty()) {
                        // 현재 위치 정보를 stack에서 꺼내서 저장
                        int[] current = stack.pop();
                        // 가로 X, 세로 Y로 생각해서, 위치의 0번째 인덱스를 Y, 1번째 인덱스를 X라고 저장
                        int curY = current[0];
                        int curX = current[1];

                        // 현재 위치로 부터 사방으로 탐색
                        for (int d = 0; d < 4; d++) {
                            int ny = curY + dy[d];
                            int nx = curX + dx[d];

                            // 범위가 넘어가지 않도록 조건
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                // 사방 탐색해서 map이 1이고 이전에 방문을 안했으면 stack에 담음
                                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                                    // 여기서 stack에 담으면 stack은 다시 비어있지 않아서 while 조건 만족 (재귀)
                                    stack.push(new int[]{ny, nx});
                                    // 방문했다고 표시
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                        count++;
                    }
                    answer.add(count);
                    total++;
                }
            }
        }
        Collections.sort(answer);
        System.out.println(total);
        for (int num : answer) {
            System.out.println(num);
        }
    }
}