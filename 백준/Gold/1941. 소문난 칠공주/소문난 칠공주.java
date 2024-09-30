import java.io.*;
import java.util.*;

public class Main {

    static char[][] board = new char[5][5];
    static boolean[] visited = new boolean[7];
    static int[] selected = new int[7];
    static int answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        search(0, 0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }


    // 백트래킹으로 소문난 칠공주 조합 구하는 함수
    public static void search(int start, int depth, int yCount) {
        if (yCount >= 4) {
            return;
        }

        // 조합이 완성되었을 때
        if (depth == 7) {
            visited = new boolean[7];
            // bfs를 통해 연결되어있는지 확인
            bfs();
            return;
        }

        //조합에 다음 여학생 탐색
        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            if (board[i / 5][i % 5] == 'Y') {
                search(i + 1, depth + 1, yCount + 1);
            } else {
                search(i + 1, depth + 1, yCount);
            }

        }

    }

    //BFS을 통해서 조합 내 여학생들이 연결되어 있는지 확인하는 함수
    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(selected[0] / 5, selected[0] % 5));
        visited[0] = true;
        int connected = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nX = p.x + dx[dir];
                int nY = p.y + dy[dir];
                int next = nX * 5 + nY; // 0 ~ 24의 다음 INDEX
                if (nX < 0 || nY < 0 || nX >= 5 || nY >= 5) {
                    continue;
                }

                //내가 뽑은 7개의 index가, 서로 연결되어있는지를 검사해주는 로직.
                //selected[0]과 selected[6], 이런식으로 떨어진 숫자끼리 선택되어 연결되어 있더라도 아래의 for문을 통해 다 만날 수 있다.
                //행렬에 범위 내이며, 방문하지 않았으며, 조합 내 포함되어 있으면
                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && selected[j] == next) {
                        q.add(new Pair(nX, nY));
                        visited[j] = true;
                        connected++;
                    }
                }
            }
        }
        if (connected == 7) {
            answer++;
        }

    }

    public static class Pair {

        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

