package PRO.Lv1;


public class PRO_86491 {
  public static void main(String[] args) {
      Solution_86491 s = new Solution_86491();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_86491 {
    public int solution(int[][] sizes) {
        for (int[] arr : sizes) {
            int a = arr[0];
            int b = arr[1];
            if (b > a) {
                int temp = a;
                a = b;
                b = temp;
            }
            arr[0] = a;
            arr[1] = b;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            max1 = Math.max(max1, sizes[i][0]);
            max2 = Math.max(max2, sizes[i][1]);
        }

        int answer = max1 * max2;
        return answer;
    }
}