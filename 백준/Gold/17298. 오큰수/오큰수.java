import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] seq = new int[n];
		for (int i = 0 ; i < n ; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {

			while(!stack.empty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}

			stack.push(i);
		}
		while (!stack.empty()) {
			seq[stack.pop()] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(seq[i]).append(' ');
		}
		System.out.println(sb);
		br.close();

	}
}
