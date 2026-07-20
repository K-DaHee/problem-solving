package PRO.Lv3;
import java.util.*;

public class PRO_42579 {
  public static void main(String[] args) {
      Solution_42579 s = new Solution_42579();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    
class Solution_42579 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreListMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            int playTotal = genreTotal.getOrDefault(genres[i], 0);
            genreTotal.put(genres[i], playTotal + plays[i]);
            genreListMap.putIfAbsent(genres[i], new ArrayList<>());
            genreListMap.get(genres[i]).add(new int[]{i, plays[i]});
        }

        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : genreOrder) {
            List<int[]> songs = genreListMap.get(genre);

            songs.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }


        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}