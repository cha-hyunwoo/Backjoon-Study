import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 다른 줄에서 입력받으려면 다시 써줘야함
		st = new StringTokenizer(br.readLine(), " ");

		int card[] = new int[n];
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int j = 0; j < n; j++) {
			for (int r = j + 1; r < n; r++) {
				for (int z = r + 1; z < n; z++) {
					if (card[j] + card[r] + card[z] > m) {
						continue;
					}
					if (max < card[j] + card[r] + card[z]) {
						max = card[j] + card[r] + card[z];
					}
				}
			}
		}
		System.out.print(max);
	}
}