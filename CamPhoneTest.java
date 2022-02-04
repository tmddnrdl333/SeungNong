package InterfacePolymorphism;

public class CamPhoneTest {
	public static void main(String[] args) {
		Object[] objs = { new Phone(), new SmartPhone(), new Camera(), new DigitalCamera() };

		for (Object obj : objs) {
			System.out.println(obj);
			if(obj instanceof Chargable) {
				((Chargable) obj).charge();
			}
		}

	}
}
