import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,k,result;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1,0,1,0};
	
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t= 1; t <= T; t++) {
			sb.append('#').append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
		
			map = new int[n][n];
			visited = new boolean[n][n];
			result = -1;
			
			int maxHeight = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
					
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(maxHeight != map[i][j]) {
						continue;
					}
					
					visited[i][j] = true;
					dfs(i,j,1,map[i][j],k);
					visited[i][j] = false;
					
				}
				
			}
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);
		br.close();
		
		
	}
	
	public static void dfs(int x, int y, int length, int height, int k) {
		result = Math.max(length, result);
		
		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			
			if(nX <0 || nY <0 || nX >= n || nY >= n || visited[nX][nY]) {
				continue;
			}
			if(k==0) {
				if(map[nX][nY] < height) {
					visited[nX][nY] = true;
					dfs(nX,nY,length + 1, map[nX][nY],k);
					visited[nX][nY] = false;
				}
			} else {
				if(map[nX][nY] < height ) {
					visited[nX][nY] = true;
					dfs(nX,nY,length + 1, map[nX][nY],k);
					visited[nX][nY] = false;
					
				} else if ((map[nX][nY] - k) < height) {
					visited[nX][nY] = true;
					dfs(nX,nY,length + 1, height - 1,0);
					visited[nX][nY] = false;
				}
			}
			
		}
		
		
	}

}
