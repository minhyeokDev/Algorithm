import java.io.*;
import java.util.*;

class Solution {
    static boolean[][][] visited; // 행, 열, 방향
    static int R,C;
    static int[] dx = {-1,0,1,0}; // 아래쪽 위쪽
    static int[] dy = {0,-1,0,1}; // 오른쪽 왼쪽
    public int[] solution(String[] grid) {
        List<Integer> ans = new ArrayList<>();
        R = grid.length; // 행
        C = grid[0].length(); // 열
        visited = new boolean[R][C][4];
        
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                for(int k = 0 ; k < 4 ; k++) {
                    if(!visited[i][j][k]) {
                        ans.add(cycle(grid,i,j,k));
                    }
                }
            }
        }
        Collections.sort(ans);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
        
    }
    
    public static int cycle(String[] grid, int r, int c, int k) {
        int cnt = 0 ;
        while(true) {
            if(visited[r][c][k]) {
                break;
            }
            cnt ++;
            visited[r][c][k]=true;
            if(grid[r].charAt(c) == 'L') {
                k = (k+3) % 4; // 좌회전
            } else if(grid[r].charAt(c) == 'R') {
                k = (k+1) % 4; // 우회전
            }
            // (현재 좌표 + 이동 방향 값 + 배열 크기) % 배열크기
            r = (r+dx[k] + R) % R; // 빛 다 쏘고 나서 도착한 행
            c = (c+dy[k] + C) % C; // 빛 다 쏘고 나서 도착한 열
            
        }
        return cnt;//만들어진 사이클 리턴
    }
}