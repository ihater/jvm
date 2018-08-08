package test22;

import java.io.InputStream;

/**
 * 	自定义类加载器：
 * 	
 */
public class MyClassLoader {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		// 不去继承抽象类实现了，直接匿名内部类
		ClassLoader mycl = new ClassLoader() {
			// 重写ClassLoader方法，去加载我们的类  name:类的全限定名
				@Override
				public Class<?> loadClass(String name) throws ClassNotFoundException {
					// TODO Auto-generated method stub
					// test22.MyClassLoader  就是要截取出这个 MyClassLoader，类的名称
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					
					// 读取我们的字节码文件。如果没找到，就交给父类的类加载器去处理
					InputStream ins = getClass().getResourceAsStream(fileName);
					if(ins == null){
						return super.loadClass(name);
					}
					
					// 如果找得到我们的类字节码文件，我们就要实现把字节码文件变成二进制流
					// 存储起来，这是类加载器要做的事情
					try {
						byte [] buff = new byte[ins.available()];
						// read 传入一个数组，InputStream 的read可以把读到的东西存到buff里
						ins.read(buff);
						
						//实例化CLass对象，就是要通过 buff 里的二进制数据，实例化我们的Class
						// 实例化？？肯定不是通过 new 啦，我们要通过 buff 里的二进制数据，实例化我们的类
						
						return defineClass(name, buff, 0,buff.length);// 类的名字，二进制数据，buff里的长度
					
					} catch (Exception e) {
						// TODO: handle exception
						throw new ClassNotFoundException();
					}
					
				}
		};
		
		
		/**
		 * 类加载的测试
		 */
		Object  c = mycl.loadClass("test22.MyClassLoade").newInstance();
		
		// 思考一下，在这类是不是被加载了两次，好像是的。
		// 看下一 C 是不是已经把类加载成功了
		System.out.println(c.getClass());
		
		
		//看一下这个 C 是不是这个类的实例
		System.out.println(c instanceof MyClassLoader);
		/**
		 *  不是！！为什么 ，我们上面做的，是用我们编写的自定义类加载器，去加载我们的自定义加载器类 自己加载自己
		 *  
		 *  MyClassLoader这个类，是被应用程序类加载器加载的
		 *  而我们  C 实例，是被自定义类加载器 加载的！！！
		 *  根据，被不同类加载器加载的类是不相等的。
		 *  
		 *  c  是 由自定义类加载器加载的类
		 *  MyClassLoader  是由 应用程序加载器加载 的类
		 *  所以 c 和 MyClassLoader不是同一个类
		 */
		
	}
}


/**
 *	深入剖析Tomcat的笔记
 *
 * JAVA 的类载入器：
 * 		每次创建JAVA类的实例时，都必须将类载入到内存中，JVM的类加载器来载入相关的类
 * 		一般，JVM类加载器会在JAVA核心类库，环境变量CLASSPATH指的的目录下查找需要的类
 *		如果找不到相关的类，就会爆（ClassNotFoundException） 	
 *		JVM的三种类加载器：启动（引导）类加载器（bootstrap  class loader）
 *					       扩展类加载器（extension class loader）
 *					      系统类加载器 （system class loader）	
 *		三种类加载器是父子关系，其中，引导类加载器是最上层，系统类加载器是最下层
 *		
 *	JVM类加载器的启动过程：
 *		启动（引导）类加载器用于引导启动JVM虚拟机，当调用javax.exe程序的时候，就会启动引导类加载器
 *			引导类家暗自气是使用本地代码来实现的。因为它用来载入运行JVM所需要的类，以及所有的Java核心类
 *			核心类包括，java.lang 或者 java.io 包下的类，启动类加载器会在rt.jar和i18n.jar等jar包搜索需要载入的类
 *			引导类加载器会从哪些库中搜索要载入的类，这依赖于JVM和操作系统的版本
 *		扩展类加载器负责载入标准扩展目录中的类，这有利于程序开发，因为程序员只需要将JAR文件复制到
 *			扩展目录中就可以被类加载器搜索到，扩展库依赖于JDK提供商的具体实现。
 *			例如sum公司的JVM的标准扩展目录是  /jdk/lib/ext
 *		系統类加载器是默认的类加载器，它会搜索在环境变量下CLASSPATH中这么的路径和JVR文件
 *			
 *	当需要载入一个类时：
 *		先调用系统类载入器，但是，系统类载入器会将载入任务交给父类载入器，即扩展类加载器，扩展类加载器
 *		又会将类载入任务交给其父类，即引导类加载器。所以，引导类加载器会首先执行载入某个类
 *		如果引导类加载器找不到类，就让扩展类加载器找，还找不到就交给系统类加载器找，再找不到就报错
 *
 *	Tomcat需要使用自定义类加载器有三个原因：
 *		为了在载入类中指定某些规则
 *		为了缓存已经载入的类
 *		为了实现类的预载入，方便使用
 *
 */
