package BOJ.silver.silver01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 회전 초밥 접시 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int kind = 0;
        
        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) kind++;
            count[arr[i]]++;
        }

        // 처음 배열에 쿠폰 초밥이 없으면 최대 +1
        int max = kind;
        if (count[c] == 0) max++;

        // 슬라이딩 윈도우
        for (int i = 1; i < n; i++) {
            // 앞 접시 제거
            int remove = arr[i - 1];
            count[remove]--;
            if (count[remove] == 0) kind--;

            // 뒤 접시 추가
            int add = arr[(i + k - 1) % n];
            if (count[add] == 0) kind++;
            count[add]++;

            int current = kind;
            if (count[c] == 0) current++;

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
