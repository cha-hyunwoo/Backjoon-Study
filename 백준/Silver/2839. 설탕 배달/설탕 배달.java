import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		int count =0;

		while(true) {
			if(n%5==0) {
				System.out.println((n/5)+count);
				break;
			}
			else if(n<0) {
				System.out.println(-1);
				break;
			}
			n-=3; // 3kg씩 덜어내기
			count++; // 봉지 개수 추가
		}
	}
}