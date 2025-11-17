package PRO.Lv0;


public class PRO_120910 {
  public static void main(String[] args) {
      Solution_120910 s = new Solution_120910();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_120910 {
    public int solution(int n, int t) {
        int answer = n;
        for (int i = 1; i < t + 1; i++) {
            answer *= 2;
        }
        return answer;
    }
}