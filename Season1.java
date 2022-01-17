package com.ssafy.ws01;

import java.util.Scanner;

public class Season1 {
	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {

			int m;
			Scanner sc = new Scanner(System.in);

			System.out.print("학생" + i + " 월 입력 >> ");
			m = sc.nextInt();

			if (m < 1 || m > 12) {
				System.out.println("잘못된 입력입니다.");
				i--;
				continue;
			} else if (m == 12 || m <= 2) {
				System.out.println("겨울");
			} else if (m <= 5) {
				System.out.println("봄");
			} else if (m <= 8) {
				System.out.println("여름");
			} else {
				System.out.println("가을");
			}
		}
	}
}
