package BOJ.silver.silver01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_2667_List {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int total = 0;
        List<Integer> aptList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    int idx = 0;
                    int count = 0;
                    List<int[]> list = new ArrayList<>();

                    list.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(idx < list.size()){
                        int[] current = list.get(idx);
                        idx++;
                        count++;

                        int y = current[0];
                        int x = current[1];

                        // 사방 탐색
                        for (int d = 0; d < 4; d++) {
                            int ny = y + dy[d];
                            int nx = x + dx[d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                                    list.add(new int[]{ny, nx});
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                    aptList.add(count);
                    total++;
                }
            }
        }

        int[] answer = new int[aptList.size()];
        for(int i = 0; i < aptList.size(); i++){
            answer[i] = aptList.get(i);
        }
        Arrays.sort(answer);

        System.out.println(total);
        for (int num : answer){
            System.out.println(num);
        }
    }
}
