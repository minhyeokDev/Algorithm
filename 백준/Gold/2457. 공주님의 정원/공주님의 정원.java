import java.io.*;
import java.util.*;

public class Main {

    static List<Flower> flowers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            flowers.add(new Flower(start, end));
        }
//        //시작일 빠른 순으로 정렬, 시작일 같다면 종료일 빠른 순으로 정렬
//        Collections.sort(flowers, (o1, o2) -> {
//            return o1.start - o2.start; // 시작일 빠른
//        });

        int t = 301; // 현재 시간
        int ans = 0; // 선택한 꽃의 개수
        while (t < 1201) {
            int nxt_t = t; // 이번에 추가할 꽃으로 인해 변경된 시간
            for (int i = 0; i < n; i++) {
                if (flowers.get(i).start <= t && flowers.get(i).end > nxt_t) {
                    nxt_t = flowers.get(i).end;
                }
            }
            if (nxt_t == t) { // 시간 t에서 전진 불가능
                System.out.println(0);
                return;
            }
            ans++;
            t = nxt_t;
        }

        System.out.println(ans);
        br.close();
    }

    public static class Flower {

        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
