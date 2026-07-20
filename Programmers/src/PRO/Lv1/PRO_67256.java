package PRO.Lv1;
import java.util.HashMap;
import java.util.Map;

public class PRO_67256 {
  public static void main(String[] args) {
      Solution_67256 s = new Solution_67256();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_67256 {
    int[] curR;
    int[] curL;
    Map<Integer, int[]> map = new HashMap<>();

    public String solution(int[] numbers, String hand) {
        int key = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(key, new int[]{i, j});
                key++;
            }
        }
        map.put(0, new int[]{3, 1});

        StringBuilder sb = new StringBuilder();
        curR = new int[]{3, 2};
        curL = new int[]{3, 0};

        for (int num : numbers){
            int[] target = map.get(num);
            switch (num){
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    curL = target;
                    break;
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    curR = target;
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                    String result = select(target, hand);
                    sb.append(result);
                    break;
            }
        }

        String answer = sb.toString();
        return answer;
    }

    public String select(int[] target, String hand){
        int disR = Math.abs(target[0] - curR[0]) + Math.abs(target[1] - curR[1]);
        int disL = Math.abs(target[0] - curL[0]) + Math.abs(target[1] - curL[1]);

        if (disR > disL){
            curL = target;
            return "L";
        } else if (disR < disL) {
            curR = target;
            return "R";
        }

        if (hand.equals("right")){
            curR = target;
            return "R";
        } else {
            curL = target;
            return "L";
        }
    }
}