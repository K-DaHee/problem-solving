package PRO.Lv0;


public class PRO_120849 {
  public static void main(String[] args) {
      Solution_120849 s = new Solution_120849();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_120849 {
    public String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }
}