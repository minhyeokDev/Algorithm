import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] planets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        planets = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                planets[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int[] planet : planets) {
            compress(planet);
        }

        System.out.println(getCount());

        br.close();


    }

    public static void compress(int[] planet) {
        int[] cloned = planet.clone();
        // 이분 탐색을 위한 중복 제거와 정렬 작업
        int[] arr = Arrays.stream(cloned).sorted().toArray();

        for (int i = 0; i < n; i++) {
            planet[i] = Arrays.binarySearch(arr, planet[i]);
        }
    }

    public static int getCount() {
        int count = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (Arrays.equals(planets[i], planets[j])) {
                    count++;
                }
            }
        }
        return count;

    }
}
