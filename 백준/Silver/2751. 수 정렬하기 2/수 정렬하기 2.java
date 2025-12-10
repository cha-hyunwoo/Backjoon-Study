import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력 모아주기
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		// ArrayList사용
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		// Collections.sort사용
		Collections.sort(list);

		for (int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
}