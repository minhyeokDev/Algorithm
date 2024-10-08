import java.io.*;
import java.util.*;

public class Main {

    static int n;

    //0:오른쪽 , 1:위쪽, 2:왼쪽, 3:아래쪽
    //하지만 문제에서 x,y의 좌표가 반대라서 아래 dx,dy도 반대로 넣어줘야 답이나옴.
    static private int[] dx = {1, 0, -1, 0};
    static private int[] dy = {0, -1, 0, 1};
    static boolean[][] map = new boolean[101][101];
    static List<Integer> directions;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            directions = new ArrayList<>();
            addDirections(d, g);
            drawDragons(x, y);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);

        br.close();

    }

    //이전세대*2 = 다음세대 방향 수
    //즉, 3세대는 총 8번의 방향정보가 나옴.
    public static void addDirections(int d, int g) {
        //0세대일때 방향 추가
        directions.add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--) {
                // directions 에 있는 방향들을 마지막부터 뽑으면서 반시계 방향으로 한번 돌린 것을 다시 list 에 추가한다.
                directions.add((directions.get(j) + 1) % 4);

            }
        }
    }

    public static void drawDragons(int x, int y) {
        map[x][y] = true;

        for (int i = 0; i < directions.size(); i++) {
            int d = directions.get(i);

            x += dx[d];
            y += dy[d];
            map[x][y] = true;
        }

    }

}
