import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (st.hasMoreElements()) {
				int num = Integer.parseInt(st.nextToken());
				if (command.equals("push_back")) {
					deque.addLast(num);
				} else if (command.equals("push_front")) {
					deque.addFirst(num);
				}
			}
			if (command.equals("pop_front")) {
				if (!deque.isEmpty()) {
					bw.write(deque.pollFirst().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}

			} else if (command.equals("pop_back")) {
				if (!deque.isEmpty()) {
					bw.write(deque.pollLast().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}

			} else if (command.equals("size")) {
				bw.write(deque.size() + "\n");
			} else if (command.equals("empty")) {
				if (deque.isEmpty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}
			} else if (command.equals("front")) {
				if (!deque.isEmpty()) {
					bw.write(deque.peekFirst().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}
			} else if (command.equals("back")) {
				if (!deque.isEmpty()) {
					bw.write(deque.peekLast().toString() + "\n");
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
