package test;

import org.frame.simplify.beans.factory.annotation.ComponentScan;
import org.frame.simplify.beans.factory.util.SingletonBeanFactory;
import org.frame.simplify.core.run.JavaApplication;
import test.demo.controller.TestController;

/**
 * 
 * @ClassName:  RunApplication   
 * @Description:TODO(主程序入口)   
 * @author: willdas 
 * @date:   2018年10月26日 下午7:35:08   
 *
 */
//添加扫描包路径
@ComponentScan(basePackages = "test.demo")
public class RunApplication extends JavaApplication {

	public static void main(String[] args) {
		//必须加上这句
		JavaApplication.run(RunApplication.class);
		//测试
		test();
	}
	
	private static void test() {
		TestController instance = (TestController) SingletonBeanFactory.getInstance(TestController.class);
		instance.run();
		instance.staties();
	}
}
