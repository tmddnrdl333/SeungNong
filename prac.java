package jan15th;

import java.util.Scanner;

class Info {
	String name;
	int age;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void printInfo() {
		System.out.println("# " + this.name + "은(는) " + this.age + "세 입니다.");
	}
}

public class prac {

	static Info[] cus = new Info[5];
	static int cusCnt = 0;

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. 추가\n2. 확인");
			System.out.println("# 번호를 입력하시오. (0:종료)");
			int inpNum;
			Scanner sc = new Scanner(System.in);
			inpNum = sc.nextInt();
			if (inpNum == 0) {
				System.out.println("# 프로그램을 종료합니다.");
				break;
			}

			switch (inpNum) {
			case 1:
				cus[cusCnt] = new Info();
				System.out.println("# 이름을 입력하시오.");
				String name;
				Scanner sc1 = new Scanner(System.in);
				name = sc1.next();
				cus[cusCnt].setName(name);
				System.out.println("# 나이를 입력하시오.");
				int age;
				Scanner sc2 = new Scanner(System.in);
				age = sc2.nextInt();
				cus[cusCnt].setAge(age);
				System.out.println("# " + cus[cusCnt].age + "세의 " + cus[cusCnt].name + "을(를) 추가했습니다.\n");
				cusCnt++;
				break;
			case 2:
				for (int i = 0; i < cusCnt; i++) {
					cus[i].printInfo();
				}
				break;
			default:
				System.out.println("# 다시 입력하시오.");
				break;
			}

		}
	}
}
