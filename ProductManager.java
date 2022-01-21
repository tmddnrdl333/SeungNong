package com.ssafy.practice01;

public class ProductManager {
	Product[] products = new Product[100];
	// 매니저가 관리하고 있는 제품 수
	static int size;
	
	// 멤버변수도 외부에서 접근하지 못하게 막기
	private static ProductManager pm = new ProductManager();
	
	// 기본생성자를 외부에서 접근하지 못하게 막기
	private ProductManager() {
	}
	
	// 외부에서 pm을 부를 수 있도록 getter 설정
	// 메모리에 미리 올려야겠다.
	public static ProductManager getPm() {
		return pm;
	}
}
