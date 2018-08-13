package Factory.abstractFactory;

import Factory.Benz;
import Factory.Car;
import Factory.MethodFactory.MethodFactory;
/**
 *	奔驰自己的工厂
 */
public class BenzFactory extends AbstractFactory{

	public Car getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
