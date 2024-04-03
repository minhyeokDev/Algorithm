import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());

		long answer = recur(a,b,c);
		System.out.println(answer);
		br.close();

	}

	public static long recur(long a, long b,long c) {

		long val = 1;
		if(b ==1) return a % c;
		val = recur(a, b / 2, c);
		val = val * val % c;
		if (b % 2 == 0) {
			return val;
		}
		return val * a % c;

	}


}
