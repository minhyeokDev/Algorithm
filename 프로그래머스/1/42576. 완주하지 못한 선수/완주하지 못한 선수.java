import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length ; i++) {
            if (map.containsKey(participant[i])) {
                // 값 증가
                map.replace(participant[i], map.get(participant[i]) + 1);
            } else {
                map.put(participant[i], 1);  // 처음 넣을 때 count는 1로 설정
            }
        }
        for(int i = 0 ; i < completion.length ; i++) {
            if(map.containsKey(completion[i])) {
                //만약 이름이 같다면, count - 1
                map.replace(completion[i], map.get(completion[i]) -1 );
            }
        }
        String answer ="";
        for(String key : map.keySet()) {
            if(map.get(key) >= 1) {
                answer = key;
            } 
        }
        return answer;
        

    }
}