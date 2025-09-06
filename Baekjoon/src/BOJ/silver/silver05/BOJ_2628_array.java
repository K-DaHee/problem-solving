package BOJ.silver.silver05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2628_array {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt(); // 가로
        int h = sc.nextInt(); // 세로
        int n = sc.nextInt(); // 자르는 횟수

        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();

        horizontal.add(0); // 가로 시작점
        horizontal.add(h); // 가로 끝점
        vertical.add(0); // 세로 시작점
        vertical.add(w); //세로 끝점

        for (int i = 0; i < n; i++) {
            int dir = sc.nextInt(); // 방향 0 or 1
            int pos = sc.nextInt(); // 자르는 위치

            if (dir == 0) horizontal.add(pos);
            else vertical.add(pos);
        }

        Collections.sort(horizontal);
        Collections.sort(vertical);

        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 1; i < vertical.size(); i++) {
            maxWidth = Math.max(maxWidth, vertical.get(i) - vertical.get(i - 1));
        }

        for (int i = 1; i < horizontal.size(); i++) {
            maxHeight = Math.max(maxHeight, horizontal.get(i) - horizontal.get(i - 1));
        }

        System.out.println(maxWidth * maxHeight);
    }
}
