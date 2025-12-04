package bronze.q2292;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int range = 1;
		int count = 1;
		
		if (n == 1) {
			System.out.print(1);
		} else {// range<n
			while (range < n) {// 출력은 왠만하면 반복문 밖에서
				range = range + 6 * count;
				count++;

			}
			System.out.print(count);
		}
	}
}
