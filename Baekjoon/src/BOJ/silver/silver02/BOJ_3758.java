package BOJ.silver.silver02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3758 {

    static class Team {
        int id;
        int submit;
        int last;
        int[] score;

        Team(int id, int k) {
            this.id = id;
            this.score = new int[k + 1];
        }

        int getScore() {
            int sum = 0;
            for (int s : score) sum += s;
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 데이터

        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 팀 개수
            int k = Integer.parseInt(st.nextToken());   // 문제 개수
            int t = Integer.parseInt(st.nextToken());   // 팀 ID
            int m = Integer.parseInt(st.nextToken());   // 로그 엔트리 개수

            Map<Integer, Team> map = new HashMap<>();
            for (int time = 1; time <= m; time++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                if (!map.containsKey(i)) {
                    map.put(i, new Team(i, k));
                }

                Team team = map.get(i);
                team.submit++;
                team.last = time;
                team.score[j] = Math.max(team.score[j], s);

            }

            // 맵에 담은 팀 정보 리스트로 저장
            List<Team> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!map.containsKey(i)) {
                    map.put(i, new Team(i, k));
                }
                list.add(map.get(i));
            }

            // 리스트 정렬
            list.sort((a, b) -> {

                int scoreA = a.getScore();
                int scoreB = b.getScore();

                // 점수 같은지 확인
                if (scoreA != scoreB)
                    return scoreB - scoreA;

                // 풀이 제출 횟수 확인
                if (a.submit != b.submit)
                    return a.submit - b.submit;

                // 마지막 제출 시간 확인
                return a.last - b.last;
            });

            // 내 팀의 순위 확인
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).id == t) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}