package PRO.Lv2;


public class PRO_43165 {
  public static void main(String[] args) {
      Solution_43165 s = new Solution_43165();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_43165 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}