import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < arr.length;i++) {
            if(i==0) {
                s.push(arr[i]);
            }
            else if(s.peek() != arr[i]) {
                s.push(arr[i]);
            }
        }
        answer = new int[s.size()];
    
        for(int i=s.size()-1; i >= 0;i--){
            answer[i] = s.pop();
        }
        return answer;
    }
}