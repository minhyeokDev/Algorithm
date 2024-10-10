class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int row = 0;
        int col = 0;
        for(int i = 0 ; i < sizes.length; i++) {
            int r = Math.max(sizes[i][1],sizes[i][0]); // 가장 큰 변을 가로
            int c = Math.min(sizes[i][0],sizes[i][1]); // 가장 작은 변을 세로
            row = Math.max(row,r); // 가로중 가장 큰 것
            col = Math.max(col,c); // 세로중 가장 큰 것
        }
        answer = row * col;
        
        return answer;
    }
}