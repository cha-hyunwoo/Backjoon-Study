import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 인원 다 넣어놓을 배열 선언
		int kn[][] = new int[15][15];

		// 0층 초기화
		for (int i = 1; i < 15; i++) {
			kn[0][i] = i;
		}
		// 내 왼쪽 집+ 내 아랫 집=내 집
		// 자바에선 int형 배열에 기본적으로 0이 들어가있어서 1호 계산 가능
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				kn[i][j] = kn[i][j - 1] + kn[i - 1][j];
			}
		}

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			sb.append(kn[k][n]).append('\n');
		}
		System.out.print(sb);

	}
}