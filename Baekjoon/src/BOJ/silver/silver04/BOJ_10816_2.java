package BOJ.silver.silver04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816_2 {
    // 숫자의 범위가 -10,000,000 ~ 10,000,000인 경우
    private static final int OFFSET = 10000000;
    private static final int MAX_SIZE = 20000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 등장 횟수를 저장할 배열 생성
        int[] countArray = new int[MAX_SIZE];

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 음수 입력을 고려하여 OFFSET을 더한 인덱스에 저장
            countArray[num + OFFSET]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 찾고자 하는 숫자가 배열 범위 내에 있는지 확인 후 출력
            int index = num + OFFSET;
            if (index >= 0 && index < MAX_SIZE) {
                sb.append(countArray[index]).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}