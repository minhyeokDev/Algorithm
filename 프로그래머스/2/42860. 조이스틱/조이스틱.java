class Solution {
    public int solution(String name) {
        //ABCDEFGHIJKLMNOPQRSTUVWXYZ
        int index = 0; //다음 값들을 확인할 때 사용
        int length = name.length();
        int move = length - 1; //좌우 움직일 수를 체크

        int answer = 0;
        
        for(int i =0 ; i< length;i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            index = i + 1;
            //연속되는 A 개수 확인
            while(index < length && name.charAt(index) == 'A') {
                index++;
            }
            
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        
        
        
        return answer + move;
    }
}