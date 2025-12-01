package bronze.q11720;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		String b=sc.next();
		int sum=0;
		// 숫자로 받아서 10으로 나누는 방식 런타임 에러
		for(int i=0;i<a;i++) {
			sum+=b.charAt(i)-'0';
			// charAt으로 문자 하나씩 받아와야함
		}
		System.out.print(sum);
	}

}
