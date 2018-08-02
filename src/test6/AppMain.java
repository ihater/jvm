package test6;
/**
 *  https://www.cnblogs.com/heyanan/p/6125030.html 
 *  
 *  执行流程：
 *  	启动程序，发出指令就是：“java AppMain”
 *  类加载过程：
 *  	系统收到了我们发出的指令，启动了一个Java虚拟机进程，这个进程首先从classpath中找到AppMain.class文件，
 *  	读取这个文件中的二进制数据，然后把Appmain类的   类信息   存放到   运行时数据区   的   方法区中。
 *  	这一过程称为AppMain类的加载过程
 *  
 *  接着，Java虚拟机定位到方法区中AppMain类的Main()方法的字节码，开始执行它的指令。
 *  	这个main()方法的第一条语句就是：让java虚拟机创建一个Sample实例，并且呢，使引用变量test1引用这个实例
		Sample test1=new Sample("测试1");
 *		
 *	我们来跟踪一下Java虚拟机，看看它究竟是怎么来执行创建一个Sample实例这个任务的：
 *
 *
 *	加载类信息：
 *		JVM 得知要创建一个Sample实例 ，就先去方法区去找Sample类，但是，现在方法区还没有Sample
 *		于是，JVM就从classpath 加载 Sample类，并把 Sample类的类信息放到方法区里。
 *
 *	堆分配内存：
 *		有了类信息，JVM要做的，就是先在堆区域中为一个新的Sample实例分配内存。
 *		这个Sample实例，持有指向方法区Sample类信息的引用。（类型信息在方法区中的内存地址）
 *		
 *	何为栈帧：
 *		 在JAVA虚拟机进程中，每个线程都会拥有一个方法调用栈，用来跟踪线程运行中一系列的方法调用过程，
 *		栈中的每一个元素就被称为栈帧，每当线程调用一个方 法的时候就会向方法栈压入一个新帧。
 *		这里的帧用来存储方法的参数、局部变量和运算过程中的临时数据
 *	
 *	定义变量并指向堆的 实例：	
 *		位 于“=”前的test1是一个在main()方法中定义的变量，可见，它是一个局部变量，因此，
 *		它被会添加到了     执行main()方法的主线程的  JAVA方法调用栈(就是虚拟机栈？)   中。
 *		而“=”将把这个test1变量指向堆区中的Sample实例，也就是说，它持有指向Sample实例的引用。		
 *
 *	栈中由test1持有的引用找堆中的Sample实例：
 *	再根据Sample 实例持有的引用，找到方法区中的Sample的printName()方法的字节码：
 *		在堆区里继续创建另一个Sample实例，然后依次执行它们的printName()方法。
 *		当JAVA虚拟机 执行test1.printName()方法时，
 *		JAVA虚拟机根据局部变量test1持有的引用，定位到堆区中的Sample实例，再根据Sample 实例持有的引用，
 *		定位到方法区中Sample类的类型信息，从而获得printName()方法的字节码，接着执行printName()方法包含的指 令
 */
public class AppMain {

	// 运行时, jvm 把appmain的信息都放入方法区  ,   类的版本、字段、方法、接口

	public static void main(String[] args) { // main 方法本身放入方法区。

		Sample test1 = new Sample(" 测试1 "); // test1是引用，所以放到栈区里，
											// Sample是自定义对象应该放到堆里面

		Sample test2 = new Sample(" 测试2 ");

		test1.printName();

		test2.printName();

	}
}
