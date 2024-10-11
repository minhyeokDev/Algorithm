import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int k = 0 ; k < answer.length; k++) {
            // j - i의 크기만큼 임시 배열 생성
            int[] temp = new int[commands[k][1] - commands[k][0] + 1];
            // 임시 배열 크기에 i ~ j 할당
            int j = commands[k][0];
            for(int i = 0; i < temp.length ; i++) {
                if(j == commands[k][1]) {
                    temp[i] = array[j -1];
                    break;
                }
                temp[i] = array[j -1];
                j++;
            }
            Arrays.sort(temp);
            // k번째 수 배열에 추가
            answer[k] = temp[commands[k][2] - 1];
            
        }
        
        return answer;
    }
}