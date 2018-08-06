package test20;

public class Child extends Info{

	static{
		//一个类的初始化会调用它的静态代码块
		System.err.println("Child init......");
	}
	
	public static void main(String[] args) {
		//类初始化
		// 结果是：
		/**
		 * parent  init ....
		 * Child  init 
		 */
	}
}
