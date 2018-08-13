package Factory.abstractFactory;

import Factory.Audi;
import Factory.Car;

/**
 *	奥迪自己的工厂
 */
public class AudiFactory extends AbstractFactory{

	public Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
