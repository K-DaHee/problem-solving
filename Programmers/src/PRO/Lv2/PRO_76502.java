package PRO.Lv2;

import java.util.Stack;

public class PRO_76502 {
    public static void main(String[] args) {
        Solution_76502 s = new Solution_76502();
        int answer = s.solution("[](){}");
        System.out.println(answer);
    }
}
class Solution_76502 {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char[] arr = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean isCorrect = true;

            for (char c : arr) {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.add(c);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') {
                            isCorrect = false;
                            break;
                        }
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{') {
                            isCorrect = false;
                            break;
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') {
                            isCorrect = false;
                            break;
                        }
                        break;
                }
                if (!isCorrect) break;
            }

            if (isCorrect && stack.isEmpty()) {
                answer++;
            }

            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
}