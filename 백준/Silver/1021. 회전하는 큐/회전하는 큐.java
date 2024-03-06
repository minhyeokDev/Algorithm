import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		int count = 0;
		st = new StringTokenizer(br.readLine());
		while (m --> 0) {
			int size = list.size();
			int num = Integer.parseInt(st.nextToken());
			while (list.getFirst() != num) {
				if (list.indexOf(num) <= size / 2) {
					list.addLast(list.pollFirst());
					count++;
				} else {
					list.addFirst(list.pollLast());
					count++;
				}
			}
			list.pollFirst();
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();

	}

}
