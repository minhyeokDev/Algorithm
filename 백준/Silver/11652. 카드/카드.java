import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] arsgs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		HashMap<Long, Integer> cards = new HashMap<>();
		int max =0;
		long x = 0;
		for (int i = 0; i < n; i++) {
			long card = Long.parseLong(br.readLine());
			cards.put(card, cards.getOrDefault(card, 0) + 1);

			if (cards.get(card) > max) {
				max = cards.get(card);
				x = card;
			} else if (cards.get(card) == max) {
				x = Math.min(x, card);
			}

		}

		System.out.println(x);

		br.close();
	}

}
