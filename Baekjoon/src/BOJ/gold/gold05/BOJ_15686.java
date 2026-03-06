package BOJ.gold.gold05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();   // 집 좌표
    static List<int[]> chickens = new ArrayList<>(); // 전체 치킨집 좌표
    static int[] selected;    // 선택된 M개 치킨집
    static int minDist = Integer.MAX_VALUE;    // 도시의 치킨 거리 최솟값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());    // 도시 크기
        M = Integer.parseInt(st.nextToken());    // 살아남을 치킨집

        // 도시 정보 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    houses.add(new int[] {i, j});
                }
                if (num == 2) {
                    chickens.add(new int[] {i, j});
                }
            }
        }
        selected = new int[M];
        comb(0, 0);
        System.out.println(minDist);
    }

    static void comb(int cnt, int start) {
        // M개를 다 뽑았을 때
        if (cnt == M) {
            calDist(); // 뽑힌 치킨집들로 거리 계산
            return;
        }

        // 조합 뽑기
        for (int i = start; i < chickens.size(); i++) {
            selected[cnt] = i;      // i번째 치킨집 선택
            comb(cnt + 1, i + 1);
        }
    }

    static void calDist() {
        int total = 0;

        for (int[] house : houses) {
            // 집에서 가장 가까운 치킨집 찾기
            int min = Integer.MAX_VALUE;
            for (int idx : selected) {
                // 치킨집 하나 꺼내기
                int[] chicken = chickens.get(idx);
                // 치킨거리
                int dist = Math.abs(house[0] - chicken[0]) +  Math.abs(house[1] - chicken[1]);
                min = Math.min(min, dist);
            }
            // 각 집의 최소 치킨 거리를 도시 치킨 거리에 더함
            total += min;
        }

        minDist = Math.min(minDist, total);
    }

}