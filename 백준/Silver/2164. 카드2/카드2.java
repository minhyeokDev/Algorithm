import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();

		int result = 0;
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (q.size() > 1) {
			q.poll();
			q.add(q.poll());
		}
		bw.write(q.poll().toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
