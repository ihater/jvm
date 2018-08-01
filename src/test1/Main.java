package test1;

import java.util.ArrayList;
import java.util.List;
/**
 *  我们要研究JVM内存溢出问题 ，首先得借助内存分析工具
 *  我们通过设置 run as 将产生JVM报错的堆信息，变成快照，存储起来
 *  再借助分析工具
 *  
 *  配置我们的JVM运行参数：
 *  -XX:+HeapDumpOnOutOfMemoryError -Xms20m -Xmx20m
 *  将堆的OutOfMemoryError报错，生成快照，配置运行最大内存20m
 */

public class Main {

	public static void main(String[] args) {
		
		List<Demo> demoList =  new ArrayList<Demo>();
		
		// 运行没有收敛的循环，就可能产生内存泄漏
		while(true){
			demoList.add(new Demo());// 不断往堆内存开辟空间创建新的对象
		}
	}
}
/**
堆内存报错信息：
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid20000.hprof ...
Heap dump file created [27941915 bytes in 0.238 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Unknown Source)
	at java.util.Arrays.copyOf(Unknown Source)
	at java.util.ArrayList.grow(Unknown Source)
	at java.util.ArrayList.ensureExplicitCapacity(Unknown Source)
	at java.util.ArrayList.ensureCapacityInternal(Unknown Source)
	at java.util.ArrayList.add(Unknown Source)
	at test1.Main.main(Main.java:18)
 */