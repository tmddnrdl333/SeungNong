package jan15th;

import java.util.Scanner;

public class prac3 {
	public static void main(String[] args) {

		int[] unit = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("액수를 입력하세요 >> ");
			int money = sc.nextInt();
			if (money <= 0) {
				System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
				break;
			}
			System.out.print(money + "원은, ");
			if (money / unit[0] != 0) {
				System.out.print("5만원권 " + money / unit[0] + "장, ");
				money = money - money / unit[0] * unit[0];
			}
			if (money / unit[1] != 0) {
				System.out.print("1만원권 " + money / unit[1] + "장, ");
				money = money - money / unit[1] * unit[1];
			}
			if (money / unit[2] != 0) {
				System.out.print("5천원권 " + money / unit[2] + "장, ");
				money = money - money / unit[2] * unit[2];

			}
			if (money / unit[3] != 0) {
				System.out.print("1천원권 " + money / unit[3] + "장, ");
				money = money - money / unit[3] * unit[3];
			}
			if (money / unit[4] != 0) {
				System.out.print("500원 " + money / unit[4] + "개, ");
				money = money - money / unit[4] * unit[4];
			}
			if (money / unit[5] != 0) {
				System.out.print("100원 " + money / unit[5] + "개, ");
				money = money - money / unit[5] * unit[5];
			}
			if (money / unit[6] != 0) {
				System.out.print("50원 " + money / unit[6] + "개, ");
				money = money - money / unit[6] * unit[6];
			}
			if (money / unit[7] != 0) {
				System.out.print("10원 " + money / unit[7] + "개, ");
				money = money - money / unit[7] * unit[7];
			}
			System.out.println("남은 돈은 "+money+"원 입니다.");

		}

	}
}
