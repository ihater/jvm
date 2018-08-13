package Factory.abstractFactory;

import Factory.Audi;
import Factory.BWM;
import Factory.Benz;
import Factory.Car;

/**
 *	抽象工厂：结合了简单工厂 和方法工厂的优点
 */
public abstract class AbstractFactory {

		protected abstract Car getCar();
		
		//抽象工厂，可以在这里写方法，直接创建对应的工厂
		public Car getCat(String name){
			
			if("BWM".equalsIgnoreCase(name)){
				return new BWMFactory().getCar();
			}else if("Benz".equalsIgnoreCase(name)){
				return new BenzFactory().getCar();
			}else if("Audi".equalsIgnoreCase(name)){
				return new AudiFactory().getCar();
			}else{
				System.out.println("no this cat");
				return null;
			}
		}
}
