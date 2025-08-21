package PRO.Lv1;

import java.util.Arrays;

public class PRO_12949 {
    public static void main(String[] args) {
        Solution_12949 s = new Solution_12949();
        int[][] answer = s.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        System.out.println(Arrays.deepToString(answer));
        answer = s.solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
        System.out.println(Arrays.deepToString(answer));
    }
}

class Solution_12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col1 = arr1[0].length;
        int col2 = arr2[0].length;
        int[][] answer = new int[row][col2];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
