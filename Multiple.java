package com.ssafy.hw01;

import java.util.Scanner;

public class Multiple {
	public static void main(String[] args) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("===============\n숫자를 입력하세요 : ");
			int num = sc.nextInt();
			if (num == 0) {
				System.out.println("프로그램을 종료합니다.\n===============");
				break;
			} else if (num < 0 || num > 9) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} else {
				for (int i = 1; i <= 9; i++) {
					System.out.println(num+" * "+i+" = "+num*i);
				}
			}
		}

	}
}
