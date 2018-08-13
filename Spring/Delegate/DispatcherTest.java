package Delegate;

/**
 *	委派，就是通过一个类，来调用执行另一个类
 *	在调用另一个类的时候，可以执行自己的东西（所以容器跟代理混淆）
 *	
 *	通过 Dispatcher 来执行 Exector的doing方法。就好像，Dispatcher 让 Exector 干活
 */
public class DispatcherTest {

	public static void main(String[] args) {
		
		Dispatcher dispatcher = new  Dispatcher(new ExectorA() );
		
		// 这里 看上去，就好像我们项目经理在干活
		// 但是，实际上，干活的事我们的普通员工。因为执行了回调。
		//  这就是典型的，干活是  执行者A，B ，但是功劳是 项目经理  dispatcher
		// 因为，就调用者来看，就认为是项目经理在干活。
		dispatcher.doing();
	}
}
