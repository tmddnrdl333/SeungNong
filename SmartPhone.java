package InterfacePolymorphism;

public class SmartPhone extends Phone implements Chargable {

	@Override
	public void charge() {
		System.out.println("sp charging");
	}

}
