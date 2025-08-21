package PRO.Lv1;

import java.util.*;

public class PRO_49994 {
    public static void main(String[] args) {
        Solution_49994 s = new Solution_49994();

        int answer = s.solution("ULURRDLLU");
        System.out.println(answer);

        answer = s.solution("LULLLLLLU");
        System.out.println(answer);
    }
}

class Solution_49994 {
    public int solution(String dirs) {
        // 방향 문자열로 저장
        char[] arr = dirs.toCharArray();

        int x = 0;
        int y = 0;
        
        // 방문한 경로 저장하기 위한 Set
        Set<String> visited = new HashSet<>();

        for(char c : arr) {
            // 좌표 이동 전 이전 좌표 저장
            int prevX = x;
            int prevY = y;
            
            // 문자에 따라 좌표 이동
            switch (c){
                case 'U':
                    if (y == 5) break;
                    y += 1;
                    break;
                case 'D':
                    if (y == -5) break;
                    y -= 1;
                    break;
                case 'L':
                    if (x == -5) break;
                    x -= 1;
                    break;
                case 'R':
                    if (x == 5) break;
                    x += 1;
                    break;
            }
            // 좌표 변동 없으면 continue
            if (prevX == x && prevY == y) {
                continue;
            }
            
            // 새로 밟는 길을 구하기 위해 양방향으로 좌표 경로 저장
            // 이전 위치에서 현재위치
            visited.add(prevX + "," + prevY + "," + x + "," + y);
            // 현재 위치에서 이전 위치
            visited.add(x + "," + y + "," + prevX + "," + prevY);
        }
        
        // 양방향으로 경로를 저장했기 때문에 2로 나눠서 결과값 반환
        int answer = visited.size() / 2;
        return answer;
    }
}