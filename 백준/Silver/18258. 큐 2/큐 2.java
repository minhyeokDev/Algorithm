import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Queue<Integer> q = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());
		int end = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if (command.equals("push")) {
					q.add(num);
					end = num;
				}
			}
			if (command.equals("pop")) {
				if (!q.isEmpty()) {
					bw.write(q.poll().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}

			} else if (command.equals("size")) {
				bw.write(q.size() + "\n");

			} else if (command.equals("empty")) {
				if (q.isEmpty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}

			} else if (command.equals("front")) {
				if (!q.isEmpty()) {
					bw.write(q.peek().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}
			} else if (command.equals("back")) {
				if (!q.isEmpty()) {
					bw.write(end + "\n");
				} else {
					bw.write("-1" + "\n");
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();

	}

}
