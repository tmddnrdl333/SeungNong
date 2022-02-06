package recursive_function;

import java.util.Scanner;

public class FactorialTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		fact1(n);
		System.out.println("factorial 1 : " + res);
		System.out.println("factorial 2 : " + fact2(n));
	}

	// 리턴 값 활용하지 않는 재귀함수
	static int res = 1;

	public static void fact1(int n) {
		// 기본파트
		if (n <= 0)
			return;
		// 유도파트
		res *= n;
		fact1(n - 1);
	}

	// 리턴 값을 활용하는 재귀함수
	public static int fact2(int n) {
		// 기본파트
		if (n <= 1)
			return 1;
		// 유도파트
		return n * fact2(n - 1);
	}
}
