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
		
		int result=factorial(n)/(factorial(m)*factorial(n-m));
		
		System.out.print(result);
		
	}
	// 팩토리얼 함수 만들기
	public static int factorial(int num) {
		int sum=1;
		for(int i=1;i<=num;i++) {
			sum*=i;
		}
		return sum;
	}
}