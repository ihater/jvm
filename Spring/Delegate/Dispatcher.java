package Delegate;

/**
 * 项目经理 ：项目经理虽然也执行了架构师IDelegate的任务 
 * 但是，他的工作职责是不一样的，他的任务就是分配任务给执行者A 和 执行者B
 */
public class Dispatcher implements IExector {

	IExector exeutor;

	Dispatcher(IExector exeutor) {
		this.exeutor = exeutor;
	}

	@Override
	public void doing() {
		// TODO Auto-generated method stub
		// 项目经理，是不做事的，执行的方法，就只有回调
		this.exeutor.doing();

	}

}
