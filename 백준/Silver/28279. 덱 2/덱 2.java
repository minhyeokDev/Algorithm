import java.io.*;
import java.util.*;

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
				if (command.equals("2")) {
					deque.addLast(num);
				} else if (command.equals("1")) {
					deque.addFirst(num);
				}
			}
			if (command.equals("3")) {
				if (!deque.isEmpty()) {
					bw.write(deque.pollFirst().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}

			} else if (command.equals("4")) {
				if (!deque.isEmpty()) {
					bw.write(deque.pollLast().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}

			} else if (command.equals("5")) {
				bw.write(deque.size() + "\n");
			} else if (command.equals("6")) {
				if (deque.isEmpty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}
			} else if (command.equals("7")) {
				if (!deque.isEmpty()) {
					bw.write(deque.peekFirst().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}
			} else if (command.equals("8")) {
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
