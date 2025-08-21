package BOJ.silver.silver01;

import java.util.*;

public class BOJ_13335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 트럭의 수
        int W = sc.nextInt();   // 다리의 길이
        int L = sc.nextInt();   // 최대 무게

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        int time = 0;
        int idx = 0;
        int sum = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < W; i++) {
            q.offer(0); // 일단 다리를 빈 공간(0)으로 채움
        }

        while (idx < N || sum > 0) {
            time++;     // 한번 이동에 1초

            sum -= q.poll();    // 다리 위에 올라가 있는 트럭 앞으로 한칸씩

            if (idx < N) {
                // 여태 더한 트럭 무게 + 새로 들어올 트럭 무게 > 최대 무게 라면
                // 다리에 트럭이 아닌 빈 공간(0) 넣기
                if (sum + list.get(idx) > L) {
                    q.offer(0);
                } else {    // 더한 무게가 최대 무게보다 낮으면
                    q.offer(list.get(idx)); // 다리에 트럭 들어옴
                    sum += list.get(idx);   // 다리에 들어오는 트럭 무게 더하기
                    idx++;  // 트럭 인덱스 하나 뒤로 이동
                }
            }
        }

        System.out.println(time);
    }
}
