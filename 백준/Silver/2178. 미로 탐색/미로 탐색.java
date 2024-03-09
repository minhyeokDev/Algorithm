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

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}

		int count = 1;
		int min = 0;

		count = bfs(q, count);

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();


	}

	public static class Pair {

		int x, y;
		int count;

		public Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

	}

	public static int bfs(Queue<Pair> q, int count) {
		q = new LinkedList<>();

		q.offer(new Pair(0, 0, count));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			if (p.x == n - 1 && p.y == m - 1) {
				return p.count;
			}

			int nowCount = p.count;

			for (int k = 0; k < 4; k++) {
				//아래 오른쪽 위 왼쪽
				int nX = p.x + dx[k];
				int nY = p.y + dy[k];

				if (nX < 0 || nX >= n || nY < 0 || nY >= m) {
					continue;
				}

				if (map[nX][nY] == 1 && !visited[nX][nY]) {
					q.offer(new Pair(nX, nY, nowCount + 1));
					visited[nX][nY] = true;
				}
			}
		}
		return 0;

	}

}
