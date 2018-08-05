package test14;
/**
 *	-verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC  -Xmn10M 		-XX:SurvivorRatio=8
 *	-XX：PretenureSizeThreshold=6M 指定大对象的大小
 *	指定虚拟机 垃圾收集器 参数用  SerialGC 				指定新生代内存的大小	Eden区域内存为8 
 *	
 *	安装Java环境的时候，怎么确定本地是服务器环境还是个人PC环境？？
 *	通过检测本地内存，大于 2 G ，是多核CPU，就认定为 是服务器
 *	但是现在大多数都是2G+多核标配，所以，安装的JAVA环境基本都是服务器的垃圾回收器
 *	比如 使用 HotSport的JVM
 *
 *	为什么大对象，要直接存到 老年代中：
 *		因为大内存对像，一般的都是大的 字符串，可能经常用到
 *		如果把大内存对象，直接存储到 Eden 区域中，我们在执行 垃圾回收的时候
 *		会用到复制算法，就是要不断的把这些大内存区块复制移动，这样字的效率是很低的
 */
public class Main {

	// 可以看到Eden内存使用率变高了
	public static void main(String[] args) {
		byte []b1 = new byte[4*1024*1024];
		
		//如果 这么写的话，大对象直接分配到老年代了
//		大内存的分配：-XX：PretenureSizeThreshold=6M
		//没有默认值，根据本地内存大小计算，能定为大小的对象的大小
		byte []b2 = new byte[40*1024*1024];
		
		// 运行配置		 -Xmn10M 		-XX:SurvivorRatio=8
		// 指定			新生代内存			指定Eden区域内存
		/**
		 * 	|-------------------|-------------------|
		 * 	|					|			 	    |				
		 * 	|					|		1M		    | 	
		 *  |					|	Survivor		|
		 *  |		8M			|-------------------|				    
		 *  |		Eden		|				    |
		 *  |					|		1M		    |
		 *  |					|	Survivor	    |
		 *  |-------------------|-------------------|
		 */
		byte []b11 = new byte[1*1024*1024];
		byte []b12 = new byte[2*1024*1024];
		byte []b13 = new byte[3*1024*1024];	// 用了 6 M，都存在Eden
		
		byte []b14 = new byte[4*1024*1024];	// 还需要用
//		我们把 Eden区域内存为8  ，如果我们前面用了 6 ，再需要用到 4 的对象
//		就会触发一次GC操作，把 前三个对象，共6M的往，Survivor上去放，但是，Survivor只有1M
		
//		所以，我们只能向其他内存借，这就是内存担保
		
		
		
		
	}
}
