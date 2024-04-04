import java.io.*;
import java.util.*;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		sb.append((int) Math.pow(2,k) -1).append("\n");
		hanoi(1, 3, k);
		System.out.println(sb);

		br.close();
	}

	public static void hanoi(int a, int b, int n) {

		if (n == 1) { //base conditon
			sb.append(a + " " + b).append("\n");
			return;
		}
		hanoi(a, 6 - a - b, n - 1);
		sb.append(a + " " + b).append("\n");
		hanoi(6 - a - b, b, n - 1);


	}


}
