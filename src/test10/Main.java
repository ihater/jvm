package test10;


/**
 *	通过打印GC的日志信息，查看垃圾回收信息：
 *	-verbose:gc -XX:+PrintGCDetails		打印GC回收的详细信息，不配run configured 打印不出信息的
 *	
 *	关于引用计数法回收策略：
	 *	但是实际上并不会这么做，因为，就算栈没有到对象的引用，堆里的实例之间也会相互引用
	 *	这样，本来外部没有引用的对象，应该被垃圾回收，却因为内部相关联
	 *	使得引用计数器就不为 0 ，而不会被清除
 */
/**
 *	怎么实现，栈不引用，而堆之间相互引用呢（33/08:11） 
 */
public class Main {

	private Object instance;
	
	public Main(){
		// 为了更好观察内存使用情况，我们在构造方法，开辟一个2m 的空白 空间
		byte [] m =  new byte[2*1024*1024];
	}

	public static void main(String[] args) {
		
		Main m1 = new Main();	// 栈 m1 指向 堆 Main m1实例
		Main m2 = new Main();	//	栈 m2 指向 堆 Main m2实例 
		
		//  m1 和 m2	之间的循环引用
		// 就是 m1 内存 和 m2  内存互指
		m1.instance = m2;
		m2.instance = m1;
		
		// 断开 m1 m2 栈变量 跟 堆 实例之间的引用
		m1 = null;
		m2 = null;
		
		// 手动调用垃圾 回收机制
		System.gc();
	}
}
