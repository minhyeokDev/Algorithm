import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int sum = 0;
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0 && !s.empty()) {
				sum -= s.pop();
			} else {
				s.push(num);
				sum += num;
			}
		}

		System.out.println(sum);

	}

}
