package PRO.Lv1;

import java.util.Arrays;

public class PRO_42889 {
    public static void main(String[] args) {
        Solution_42889 s = new Solution_42889();

        int[] answer = s.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println(Arrays.toString(answer));

        answer = s.solution(4, new int[]{4, 4, 4, 4, 4});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution_42889 {
    public int[] solution(int N, int[] stages) {
        // 스테이지 별 실패율을 담는 배열
        // 스테이지가 1부터 시작이라 크기를 N+1로 생성
        double[] failRates = new double[N + 1];
        // 총 인원 수
        int total = stages.length;

        // 각 스테이지 별 실패율 계산
        for (int i = 1; i < failRates.length; i++) {
            int count = 0;
            for (int j : stages) {
                if (j == i) count++;
            }
            if(count == 0) failRates[i] = 0;
            else failRates[i] = (double) count / total;
            total -= count;
        }

        // 계산된 실패율의 내림차순으로 스테이지(인덱스) 저장
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            double maxRate = -1;
            int maxIdx = 0;

            for (int j = 1; j < failRates.length; j++) {
                if(failRates[j] > maxRate){
                    maxRate = failRates[j];
                    maxIdx = j;
                }
            }

            answer[i] = maxIdx;
            failRates[maxIdx] = -1;
        }
        return answer;
    }
}