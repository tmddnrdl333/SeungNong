package live;

class Creature {
	int age;

	Creature() {
		System.out.println("- Creature created.");
	}

	void breathe() {
		System.out.println("- breathing.");
	}
}

class Person extends Creature {
	String name;

	Person() {
		System.out.println("- Person created.");
	}

	void walk() {
		System.out.println("- walking.");
	}

	void eat() {
		System.out.println("- eating.");
	}
}

class Student extends Person {
	int grade;

	Student() {
		System.out.println("- Student created");
	}

	Student(int grade) {
		this.grade = grade;
	}

	void eat() {
		System.out.println("- drinking.");
	}
}

public class ClassTest_Polymorphism {

	public static void main(String[] args) {

		System.out.println("===");
		//
		Person p1 = new Person();
		p1.walk(); // 당연한 객체의 메서드 호출.

		// 다형성에 대한 이해
		Creature c1 = new Student(); // Creature 객체를 생성하는데 자식의 자식 클래스인 Student를 참조.
		c1.breathe(); // 메모리 자체는 단순 Creature가 아닌 Person에 Student까지도 만들어지지만, 접근 가능 범위는 Creature까지만 가능.
		Student s1 = (Student) c1; // 그 객체를 Student로 명시적 캐스팅하면 접근도 가능해짐.
		s1.eat(); // Student가 Person의 것을 오버라이딩한 eat함수가 호출됨.

		Creature c2 = new Creature(); // 그러면 Student 클래스를 참조하지 않은 Creature 객체를 생성하면?
		Student s2 = (Student) c2; // 명시적으로 캐스팅해주면?
//		c4.eat(); // 이건 할 수 없음.

		Person p2 = new Student(); // Person 클래스의 객체를 생성할 때 자식인 Student 클래스를 참조하면 메모리상으로 Student가 생성되나 접근은 할 수 없음.
		p2.eat(); // 하지만 Person인 p3의 eat()함수를 호출하면 메모리상에 있는 오버라이딩된 자식클래스의 eat()가 호출됨.

	}
}
