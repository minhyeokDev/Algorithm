import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Pair> a = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());
            a.add(new Pair(i, p));
        }

        Collections.sort(a, (o1, o2) -> {
            if (o1.p == o2.p) {
                return o1.num - o2.num;
            }
            return o1.p - o2.p;
        });

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sum += a.get(j).p;
            }
        }

        System.out.println(sum);

        br.close();

    }

    public static class Pair {

        int num, p;

        public Pair(int num, int p) {
            this.num = num;
            this.p = p;
        }
    }

}
