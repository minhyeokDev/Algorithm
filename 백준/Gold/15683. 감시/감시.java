import java.io.*;
import java.util.*;

public class Main {

	static class CCTV {

		int x, y, num;

		CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	static int map[][]; //최초에 입력받은 맵
	static int board2[][] = new int[10][10]; // 사각 지대 개수 세기 위한 맵
	static int n;
	static int m;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static List<CCTV> cctvList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int answer = 0;

		cctvList = new ArrayList<>();
		map = new int[n][m];


		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 빈칸과 벽이 아니라면 CCTV이므로 집어넣음
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add(new CCTV(i, j, map[i][j]));
				}
				if (map[i][j] == 0) {
					answer++;
				}
			}
		}
		for (int tmp = 0; tmp < (1 << (2 * cctvList.size())); tmp++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					board2[i][j] = map[i][j];
				}
			}
			int brute = tmp;
			for (int i = 0; i < cctvList.size(); i++) {
				int dir = brute % 4;
				brute /= 4;
				int x = cctvList.get(i).x;
				int y = cctvList.get(i).y;
				if (map[x][y] == 1) {
					upd(x, y, dir);
				} else if (map[x][y] == 2) {
					upd(x, y, dir);
					upd(x, y, dir + 2);
				} else if (map[x][y] == 3) {
					upd(x, y, dir);
					upd(x, y, dir + 1);
				} else if (map[x][y] == 4) {
					upd(x, y, dir);
					upd(x, y, dir + 1);
					upd(x, y, dir + 2);
				} else { // 5일때
					upd(x, y, dir);
					upd(x, y, dir + 1);
					upd(x, y, dir + 2);
					upd(x, y, dir + 3);
				}
			}
			int val = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (board2[i][j] == 0) {
						val += 1;
					}
				}
			}
			answer = Math.min(answer, val);
		}

		System.out.println(answer);

		br.close();

	}

	public static void upd(int x, int y, int dir) {
		dir %= 4;
		while (true) {
			x += dx[dir];
			y += dy[dir];
			if (check(x, y) || board2[x][y] == 6) {
				return; // 범위 벗어나거나 벽 만나면 함수 탈출)
			}
			if (board2[x][y] != 0) {
				continue; //해당 칸이 빈칸이 아닐 경우(CCTV가 잇을경우) 넘어감
			}
			board2[x][y] = 7; //빈칸을 7로 덮음
		}
	}

	public static boolean check(int a, int b) {
		return a < 0 || a >= n || b < 0 || b >= m;
	}

}

