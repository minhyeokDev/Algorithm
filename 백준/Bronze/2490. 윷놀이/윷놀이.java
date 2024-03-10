import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());

			int a = 0, b = 0, c = 0, d = 0;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			int bae = 0;
			int deung = 0;
			if (a == 0) {
				bae++;
			} else if (a == 1) {
				deung++;
			}
			if (b == 0) {
				bae++;
			} else if (b == 1) {
				deung++;
			}
			if (c == 0) {
				bae++;
			} else if (c == 1) {
				deung++;
			}
			if (d == 0) {
				bae++;
			} else if (d == 1) {
				deung++;
			}

			if (bae == 1 && deung == 3) {
				System.out.println("A");
			} else if (bae == 2 && deung == 2) {
				System.out.println("B");
			} else if (bae == 3 && deung == 1) {
				System.out.println("C");
			} else if (bae == 4) {
				System.out.println("D");
			} else if (deung == 4) {
				System.out.println("E");
			}
		}
	}

}
