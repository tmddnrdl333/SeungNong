package com.ssafy.hw02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {

		// 1. 선언과 동시 초기화 > 출력
		System.out.println("1. arr[] = ");
		int[] arr = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		for (int e : arr) {
			System.out.printf("%d ", e);
		}
		System.out.println("\n");

		// 2. 짝수만 출력
		System.out.println("2. Even Only: ");
		for (int e : arr) {
			if (e % 2 == 0)
				System.out.printf("%d ", e);
		}
		System.out.println("\n");

		// 3. 두 수 입력받고 첫 숫자 위치 원소를 두번째 숫자로 변경하고 배열 다시 출력
		System.out.print("3. num1 번째 인덱스를 num2로 변경합니다.\n# 두 수를 차례로 입력하세요: ");
		
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		if (num1 < 0 || num1 > 9) {
			System.out.println("# 오류, 종료.");
			return;
		}
		
		System.out.printf("# %d번 인덱스를 %d로 변경합니다.\n",num1,num2);
		
		arr[num1] = num2; // num1번째가 아닌 num1번 인덱스를 변경함.

		System.out.println(Arrays.toString(arr)+"\n# 종료.");

	}
}
