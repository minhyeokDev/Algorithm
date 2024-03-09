import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static Queue<Pair> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				// 맵 초기 입력
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0; //그림의 수
		int area = 0;
		int max = 0; //그림의 최댓값

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 0이거나(색칠X) 방문한 적이 있으면 생략
				if (map[i][j] == 0 || visited[i][j]) {
					continue;
				}

				count++; //1이고, 방문을 하지 않았으므로 시작점이 되니까 +1
				visited[i][j] = true; //방문 처리
				q.offer(new Pair(i, j)); //큐에 좌표를 넣어준다.
				area = 0; //0이면 그림이 끊겼으므로 area = 0;

				while (!q.isEmpty()) {
					Pair p = q.poll();
					area++; //넓이 +1

					//네 방향 탐색
					for (int k = 0; k < 4; k++) {
						int n_X = p.x + dx[k];
						int n_Y = p.y + dy[k];

						if (n_X < 0 || n_X >= n || n_Y < 0 || n_Y >= m) {
							continue;
						}
						if (map[n_X][n_Y] == 1 && !visited[n_X][n_Y]) {
							q.offer(new Pair(n_X, n_Y));
							visited[n_X][n_Y] = true;
						}
					}
				}
				if (area > max) {
					max = area;
				}
			}
		}

		bw.write(String.valueOf(count) + "\n" + String.valueOf(max));

		bw.flush();
		bw.close();
		br.close();
	}

	public static class Pair {

		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}


}
