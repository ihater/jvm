package test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类主要是用来学习JDK自带的性能分析工具
 * 在目录D:\Program Files\Java\jdk1.8.0_171\bin 里 的 JConsole
 */
public class JConsoleTest {

	// 为了让堆中快速填充数据，我们在JConsoleTest对象里
	// 带有一盒128K 的 空数组
	/**
	 * 我们从监控器上可以看到，我们的堆内存不断被占用，使用，直到程序执行完毕
	 * 因为，b1 是作为 JConsole 对象的一个属性，被填充到 List集合里面的，所以GC不会光顾一个类的成员变量
	 * 但是，如果我们将这个数组，定义成一个局部变量，局部变量没有使用，就会被GC回收！！！！
	 */
	public byte[]  b1 = new byte[128*1024];
	
	public JConsoleTest() {
		// b2 作爲局部变量，没有使用，就会被GC 关顾，并回收
		// 这时，堆内存的图像，就会一上，一下，一上，一下
		byte[]  b2 = new byte[128*1024];
	}
	
	public static void main(String[] args) {
		
		try {
			// 我们main开始运行，我们在JConsole才能看到Java进程的连接对象
			// 等 5 秒，让我们有时间 用JConsole连上我们的JAVA进程
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fill(1000);
	}

	private static void fill(int n) {
		// TODO Auto-generated method stub
		List<JConsoleTest> jlist = new ArrayList<>();
		for(int i= 0 ;i<n;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jlist.add(new JConsoleTest());
		}
	}
}


