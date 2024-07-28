import java.io.*;
import java.util.*;

public class Main {

	static int[] d = new int[10005];
	static int mod = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		d[1] = 1;
		d[2] = 2;
		for(int i = 3; i <= n; i++)
			d[i] = (d[i-1]+d[i-2])%mod;
		System.out.println(d[n]);

	}


}
