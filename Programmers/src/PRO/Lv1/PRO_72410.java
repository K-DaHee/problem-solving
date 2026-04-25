package PRO.Lv1;


public class PRO_72410 {
  public static void main(String[] args) {
      Solution_72410 s = new Solution_72410();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_72410 {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        char[] arr = new_id.toCharArray();
        new_id = "";
        for (char c : arr) {
            if ((c >= 'a' && c <= 'z') || c == '-' || c == '_' || c == '.' || (c >= '0' && c <= '9')){
                new_id += c;
            }
        }

        arr = new_id.toCharArray();
        new_id = "";
        int count = 0;
        for (char c : arr) {
            if(c == '.') {
                count++;
            } else {
                count = 0;
            }
            if(count >= 2) {
                continue;
            }
            new_id += c;
        }

        if (!new_id.isEmpty() && new_id.charAt(0) == '.')
            new_id = new_id.substring(1);

        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.substring(0, new_id.length() - 1);

        if (new_id.isEmpty()) new_id = "a";

        if (new_id.length() > 15) new_id = new_id.substring(0, 15);
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.substring(0, new_id.length() - 1);

        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        String answer = new_id;
        return answer;
    }
}