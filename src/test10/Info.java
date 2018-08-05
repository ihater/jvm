package test10;
/**
 *  如何判定对象为垃圾
 *  	引用计数法（参考Main测试方法）
 *  		在对象中天年假一个引用计数器，当有地方引用这个对象的时候，引用计数器的值就 +1
 *  		当有一个引用失效的时候，计数器的值就 -1 
	 *			但是实际上并不会这么做，因为，就算栈没有到对象的引用，堆里的实例之间也会相互引用
	 *			这样，本来外部没有引用的对象，应该被垃圾回收，却因为内部相关联
	 *			使得引用计数器就不为 0 ，而不会被清除
 *  	可达性分析法
 *  
 *  如何回收
 *  	回收的策略	
 *  		标记清除
 *  		复制算法
 *  		标记-整理算法
 *  		分代收集算法
 *  
 *  	常见的垃圾收集器
 *  		Serial	
 *  		Parnew
 *  		Cms
 *  		G1
 *  
 *  何时回收
 *  	
 *  
 */
public class Info {

}