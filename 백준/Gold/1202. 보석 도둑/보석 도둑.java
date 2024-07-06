import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Gem {

    int m;
    int v;

    Gem(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Gem> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Gem(m, v));
        }
        Collections.sort(list,((o1, o2) -> o1.m - o2.m));
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Gem> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        long total=0;
        int listIdx = 0;
        for(int i = 0; i < K; i++) {
            while(listIdx < N && list.get(listIdx).m <= bags[i]) {
                Gem current = list.get(listIdx++);
                pq.add(new Gem(current.m, current.v));
            }
            if(!pq.isEmpty()) total += pq.poll().v;
        }
        System.out.println(total);
    }

}
