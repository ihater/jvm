package Factory.abstractFactory;

import Factory.BWM;
import Factory.Car;
import Factory.MethodFactory.MethodFactory;
/**
 *	宝马自己的工厂
 */
public class BWMFactory extends AbstractFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new BWM();
	}

}
