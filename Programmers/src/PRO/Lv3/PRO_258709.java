package PRO.Lv3;

import java.util.*;

public class PRO_258709 {
    public static void main(String[] args) {
        Solution_258709 s = new Solution_258709();
        int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(s.solution(dice)));
        dice = new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
        System.out.println(Arrays.toString(s.solution(dice)));
        dice = new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};
        System.out.println(Arrays.toString(s.solution(dice)));
    }

    static class Solution_258709 {
        public int[] solution(int[][] dice) {
            int n = dice.length;
            int diceSize = n/2;
            int[] answer = new int[diceSize];
            int maxWins = -1;

            Stack<int[]> combo = new Stack<>();
            for (int i = 0; i <= diceSize; i++) {
                combo.add(new int[]{i});
            }

            while (!combo.isEmpty()){
                int[] ADice = combo.pop();
                // A 주사위의 조합이 완성되지 않았다면
                if (ADice.length < diceSize){
                    int last = ADice[ADice.length - 1];
                    for (int next = last + 1; next <= n - (diceSize - ADice.length); next++) {
                        int[] newCombo = Arrays.copyOf(ADice, ADice.length + 1);
                        newCombo[ADice.length] = next;
                        combo.push(newCombo);
                    }
                }
                // A 주사위의 조합이 완성됐다면
                else {
                    // B가 가져갈 주사위 인덱스 결정
                    boolean[] isA = new boolean[n];
                    for (int idx : ADice) isA[idx] = true;
                    int[] BDice = new int[diceSize];
                    int Idx = 0;
                    for (int i = 0; i < n; i++) {
                        if (!isA[i]) BDice[Idx++] = i;
                    }

                    // A가 가져간 주사위를 던져서 나오는 수의 합 구하기
                    List<Integer> aSums = new ArrayList<>();
                    Stack<int[]> sumStack = new Stack<>();  // 굴린 주사위의 개수, 주사위의 합 저장
                    sumStack.push(new int[]{0, 0}); // 처음 시작 개수 : 0개, 합 : 0

                    while (!sumStack.isEmpty()) {
                        int[] state = sumStack.pop();
                        int depth = state[0];   // 현재까지 굴린 주사위의 개수
                        int currentSum = state[1];  // 현재까지의 합

                        if (depth == diceSize) {    // 현재까지 굴린 주사위의 개수가 굴려야 할 수와 같다면
                            aSums.add(currentSum);
                            continue;
                        }
                        for (int i : dice[ADice[depth]]) {  // 아직 굴려야할 주사위가 남아있다면
                            sumStack.push(new int[]{depth + 1, currentSum + i});
                        }
                    }

                    // B가 가져간 주사위를 던져서 나오는 수의 합 구하기
                    // B팀의 모든 점수 합계 구하기
                    List<Integer> bSums = new ArrayList<>();
                    sumStack.push(new int[]{0, 0}); // 스택 재사용

                    while (!sumStack.isEmpty()) {
                        int[] state = sumStack.pop();
                        int depth = state[0];
                        int currentSum = state[1];

                        if (depth == diceSize) {
                            bSums.add(currentSum);
                            continue;
                        }
                        for (int i : dice[BDice[depth]]) {
                            sumStack.push(new int[]{depth + 1, currentSum + i});
                        }
                    }

                    // A가 승리하는 횟수 구하기
                    Collections.sort(bSums);    // B 주사위 합계 조합 정렬
                    int currentWins = 0;
                    for (int aSum : aSums) {    // A 주사위 합계 조합 하나씩 가져와서 B와 비교
                        // 이분탐색 하려고 left, right 지정
                        int left = 0, right = bSums.size();
                        while (left < right) {
                            int mid = (left + right) / 2;
                            if (bSums.get(mid) >= aSum) {
                                right = mid;
                            } else {
                                left = mid + 1;
                            }
                        }
                        currentWins += left;
                    }

                    // A의 최적의 조합 구하기
                    if (currentWins > maxWins) {
                        maxWins = currentWins;
                        for (int i = 0; i < diceSize; i++) {
                            answer[i] = ADice[i] + 1;
                        }
                    }
                }
            }

            Arrays.sort(answer);
            return answer;
        }
    }
}
