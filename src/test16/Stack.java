package test16;

/**
 *	只要没有发生逃逸的，就是这个变量的作用域只有在方法体内
 *	我们就把这类变量的，存储在栈帧中，变量的生命周期，随栈一起消失
 *	这类变量，就不用浪费GC
 */
public class Stack {

	public Stack obj;
	
	/**
	 * 	方法返回Stack对象，发生了逃逸
	 */
	public Stack getInstance(){
		// 我们要看的就是，方法体内的 new 出来的对象，有没有到方法体外
		return obj == null ? new Stack():obj;
	}
	
	/**
	 * 为成员属性赋值，发生逃逸
	 */
	public void setObj(){
		
		this.obj = new  Stack();
	}
	
	/**
	 * 没有发生逃逸，这个s对象，只能在方法体内使用
	 */
	public void useStack(){
		
		Stack s = new Stack();
	}
	
	/**
	 * 发生逃逸，引用成员变量的值
	 */
	public void useStack2(){
		
		Stack s = getInstance();				
				
	}
}
