package Factory.abstractFactory;

public class AbstractFactoryTest {

	public static void main(String[] args) {


		DefaultFactory factory = new DefaultFactory();//  默认生产奥迪
		
		System.out.println(factory.getCar());
		
	}
}
