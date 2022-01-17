package com.ssafy.ws01;

import java.util.Scanner;

public class Season2 {
	public static void main(String[] args) {
		int i = 1;
		while (i < 4) {
			int m;
			Scanner sc = new Scanner(System.in);
			System.out.print("학생" + i + " 월 입력>> ");
			m = sc.nextInt();

			switch (m) {
			case 3:
			case 4:
			case 5:
				System.out.println("봄");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("여름");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("가을");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("겨울");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			i++;
		}
	}
}
