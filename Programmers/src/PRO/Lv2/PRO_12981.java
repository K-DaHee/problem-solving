package PRO.Lv2;


public class PRO_12981 {
  public static void main(String[] args) {
      Solution_12981 s = new Solution_12981();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    

class Solution_12981 {
    public int[] solution(int n, String[] words) {
        int num = 0;
        int a = 0;
        int b = 0;

        for(int i = 1; i < words.length; i++){
            String[] word = words[i].split("");
            String[] comWord = words[i-1].split("");
            
            if(word.length < 2 || word.length > 50){
                num = i;
                break;
            }
            
            if(!comWord[comWord.length - 1].equals(word[0])){
                num = i;
                break;
            } else {
                for(int j = i-1; j >= 0; j--){
                    if(words[i].equals(words[j])){
                        num = i;
                        a = num % n + 1;
                        b = num / n + 1;
                        return new int[]{a, b};
                    }
                }
            }
        }
        
        if(num != 0){
            a = num % n + 1;
            b = num / n + 1;
        }
        
        int[] answer = {a, b};
        return answer;
    }
}