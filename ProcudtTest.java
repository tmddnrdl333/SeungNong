package com.ssafy.practice01;

public class ProcudtTest {
	public static void main(String[] args) {
		ProductManager pm1 = ProductManager.getPm();
		ProductManager pm2 = ProductManager.getPm();

		System.out.println(pm1 == pm2);
		System.out.println(pm1);
		System.out.println(pm2);

	}
}
