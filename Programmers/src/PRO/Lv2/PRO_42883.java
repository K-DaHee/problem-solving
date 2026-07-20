package PRO.Lv2;
import java.util.Stack;

public class PRO_42883 {
  public static void main(String[] args) {
      Solution_42883 s = new Solution_42883();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42883 {
    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;
            }

            stack.push(current);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder answer = new StringBuilder();

        for (char ch : stack) {
            answer.append(ch);
        }

        return answer.toString();
    }
}