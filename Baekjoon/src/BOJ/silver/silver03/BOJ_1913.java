package BOJ.silver.silver03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1913 {
    // 상 우 하 좌
    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        int num = 1;
        int len = 1;
        int dir = 0;

        int startR = n/2;
        int startC = n/2;
        arr[startR][startC] = num++;

        while (num <= n * n) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < len; k++) {
                    if (num > n * n) break;
                    startR += row[dir];
                    startC += col[dir];
                    arr[startR][startC] = num++;

                }
                dir = (dir + 1) % 4;
                if (num > n * n) break;
            }
            len++;
        }

        StringBuilder sb = new StringBuilder();

        int resultX = 0;
        int resultY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == m) {
                    resultX = i + 1;
                    resultY = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(resultX).append(" ").append(resultY);
        System.out.println(sb);
    }

}