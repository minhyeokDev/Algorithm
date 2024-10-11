import java.util.*;

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> q = new LinkedList<>();
    static boolean[][] visited;
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        // 캐릭터 위치 큐에 추가
        q.offer(new Pair(0,0));
        visited = new boolean[n][m];
        
        int temp = bfs(maps, visited, n, m);
        return temp;
    }
    public static int bfs(int[][] maps, boolean[][] visited, int n, int m) {
        visited[0][0] = true;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            for(int dir = 0 ; dir < 4 ; dir ++) {
                int nX = p.x + dx[dir];
                int nY = p.y + dy[dir];
                
                if( nX < 0 || nX >= n || nY <0 || nY >= m) {
                    continue;
                }
                if(!visited[nX][nY] && maps[nX][nY] != 0) {
                    visited[nX][nY] = true;
                    maps[nX][nY] = maps[p.x][p.y] + 1;
                    q.offer(new Pair(nX,nY));
                }
            }
        }
        
        if(visited[n-1][m-1] == false) {
            return -1;
        }
        return maps[n-1][m-1];
        
    }
    
    public static class Pair {
        int x, y;
        
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}