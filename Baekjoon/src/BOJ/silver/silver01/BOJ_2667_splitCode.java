package BOJ.silver.silver01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BOJ_2667_splitCode {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int total = 0;
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        readMap();  // map 정보 입력 받는 메서드 호출

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = loop(i, j);
                    answer.add(count);
                    total++;
                }
            }
        }
        int[] results = new int[answer.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = answer.get(i);
        }
        Arrays.sort(results);

        System.out.println(total);
        for (int num : results) {
            System.out.println(num);
        }
    }

    static void readMap() throws Exception {    // map 정보를 입력받는 메서드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // map의 크기 N
        N = Integer.parseInt(br.readLine());
        // 입력 받은 N만큼 map 배열 선언
        map = new int[N][N];
        // 이미 방문 했던 위치는 넘어가기 위해 저장할 배열 선언
        visited = new boolean[N][N];

        // BufferedReader 사용해서 이차원 배열 값 입력 받기
        for (int i = 0; i < N; i++){
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }
    }

    static int loop(int i, int j){
        Stack<int[]> stack = new Stack<>();
        // 현재 위치를 stack에 담음
        stack.push(new int[]{i, j});
        // 현재 위치를 방문했다고 표시
        visited[i][j] = true;

        int count = 0;
        // 위에서 현재 위치 정보를 스택에 담았기 때문에 while 조건 만족
        while (!stack.isEmpty()) {
            // 현재 위치 정보를 stack에서 꺼내서 저장
            int[] current = stack.pop();
            // 가로 X, 세로 Y로 생각해서, 위치의 0번째 인덱스를 Y, 1번째 인덱스를 X라고 저장
            int y = current[0];
            int x = current[1];

            // 현재 위치로 부터 사방으로 탐색
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

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
        return count;
    }
}
