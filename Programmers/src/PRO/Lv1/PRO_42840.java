package PRO.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRO_42840 {
    public static void main(String[] args) {
        Solution_42840 s = new Solution_42840();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(s.solution(new int[]{1, 3, 2, 4, 2})));
    }
}

class Solution_42840 {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5}; // 수포자 1의 찍기 패턴
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};    // 수포자 2의 찍기 패턴
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};  // 수포자 3의 찍기 패턴

        int[] score = new int[4];   // 각 수포자가 맞춘 갯수 담을 배열

        // 답변과 수포자의 패턴이 일치하는지 확인하고, 일치하면 답을 맞춘 갯수 증가
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) score[1]++;
            if (answers[i] == p2[i % p2.length]) score[2]++;
            if (answers[i] == p3[i % p3.length]) score[3]++;
        }

        // 가장 많이 맞춘 개수 확인
        int max = Math.max(score[1], Math.max(score[2], score[3]));

        // 높은 점수를 받은 사람이 여럿일 수 있어서 List로 선언
        List<Integer> winners = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (score[i] == max) winners.add(i);
        }

        // 승리자 리스트 배열로 바꿔서 반환
        int[] win = new int[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            win[i] = winners.get(i);
        }
        return win;
    }
}