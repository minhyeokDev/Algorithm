import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int i, boolean[] visited, int[][] computers){
        visited[i] = true;
        for(int j = 0; j < computers.length ; j++){
            if( (i != j) && visited[j] == false && computers[i][j] == 1 ) {
                dfs(j, visited, computers);
            }
        }
        
    }
}