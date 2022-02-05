package FreePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoopExceptionTest {
	public static void main(String[] args) {
		/**
		 * 예외처리에 대해... catch에서 break를 통해 반복문 속 다음 try를 시행하지 않게 할 수도 있을까 궁금해서 해봤다.
		 */
		List<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		do {
			list.add(sc.nextInt());
		} while (list.get(list.size() - 1) != 0);
		sc.close();

		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(list.get(i) + "을 넣었다.");
			} catch (Exception e) {
				System.out.println("예외가 발생했다.");
				break;
			}
			System.out.println("다음 반복을 시행한다.");
		}

		System.out.println(list);
	}
}
