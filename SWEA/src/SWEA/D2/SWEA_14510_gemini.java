package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14510_gemini {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            // 1. 입력 및 최대 높이 계산
            int N = Integer.parseInt(br.readLine().trim());
            int[] trees = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                if (trees[i] > maxHeight) {
                    maxHeight = trees[i];
                }
            }

            // 2. 필요한 성장 횟수 계산 (+1 성장, +2 성장)
            int onesNeeded = 0;
            int twosNeeded = 0;
            for (int height : trees) {
                int diff = maxHeight - height;
                if (diff > 0) {
                    twosNeeded += diff / 2;
                    onesNeeded += diff % 2;
                }
            }

            // 3. 시뮬레이션을 통해 최소 날짜 계산
            int days = 0;
            
            // 필요한 성장이 하나라도 있으면 루프 시작
            while (onesNeeded > 0 || twosNeeded > 0) {
                days++;
                
                if (days % 2 != 0) { // 홀수 날 (+1 성장 가능)
                    // 우선순위 1: +1 성장이 필요한 경우 처리
                    if (onesNeeded > 0) {
                        onesNeeded--;
                    } 
                    // 우선순위 2: +1 성장은 필요 없지만, +2 성장이 2번 이상 남은 경우
                    // +2 필요 횟수를 +1 필요 횟수로 전환하여 균형을 맞춘다.
                    else if (twosNeeded >= 2) {
                        twosNeeded--;
                        onesNeeded++;
                    }
                    // 만약 +1 필요 횟수=0, +2 필요 횟수=1 이면, 다음 짝수 날을 기다리는 것이 이득이므로 아무것도 하지 않음 (날짜만 증가)
                    
                } else { // 짝수 날 (+2 성장 가능)
                    // +2 성장이 필요한 경우 처리
                    if (twosNeeded > 0) {
                        twosNeeded--;
                    }
                    // +2 성장은 +1 성장에 사용할 수 없으므로, 필요 없으면 아무것도 하지 않음
                }
            }
            
            sb.append("#").append(t).append(" ").append(days).append("\n");
        }
        System.out.print(sb.toString());
    }
}