package PRO.Lv2;


public class PRO_60057 {
  public static void main(String[] args) {
      Solution_60057 s = new Solution_60057();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_60057 {
    public int solution(String s) {
        int answer = s.length();

        int l = s.length();

        for (int size = 1; size <= l / 2; size++) {   // 자를 개수 선택
            StringBuilder sb = new StringBuilder();

            String pre = s.substring(0, size);

            int count = 1;

            for (int i = size; i < l; i += size) {

                String cur = s.substring(i, Math.min(i + size, l));

                if (pre.equals(cur)) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(pre);
                    } else {
                        sb.append(count);
                        sb.append(pre);
                    }
                    pre = cur;
                    count = 1;
                }
            }

            if (count == 1) sb.append(pre);
            else sb.append(count).append(pre);

            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}