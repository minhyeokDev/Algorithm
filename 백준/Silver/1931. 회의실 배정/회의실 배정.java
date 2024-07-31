import java.io.*;
import java.util.*;

public class Main {

    static int n;

    static List<Pair> s = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            s.add(new Pair(start, end));
        }

        Collections.sort(s, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.end == o2.end) {
                    return Integer.compare(o1.start, o2.start);
                }
                return Integer.compare(o1.end, o2.end);
            }
        });

        int t = 0;
        for (int i = 0; i < n; i++) {
            if (t > s.get(i).start) {
                continue;
            }
            answer++;
            t = s.get(i).end;
        }

        System.out.println(answer);

        br.close();

    }

    public static class Pair {

        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

}
