package InterfacePolymorphism;

public class DigitalCamera extends Camera implements Chargable {

	@Override
	public void charge() {
		System.out.println("dc charging");
	}

}
