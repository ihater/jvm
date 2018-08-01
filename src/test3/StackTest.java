package test3;
/**
 *  模拟栈内存溢出
 */
public class StackTest {

	private void tes(){
		System.out.println("方法执行了···········");
		tes();// 执行没有收敛的 递归  调用
	}
	public static void main(String[] args) {
		new StackTest().tes();
	}
}
