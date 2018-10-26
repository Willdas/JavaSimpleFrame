package test.demo.controller;

import org.frame.simplify.beans.factory.annotation.Autoload;
import org.frame.simplify.beans.factory.annotation.BeanObj;
import test.demo.service.TestDemo;
import test.demo.user.User;

//注入成Bean对象
@BeanObj
public class TestController {
	
	//自动注入
	@Autoload
	private TestDemo testDemo;
	
	//自动注入
	@Autoload
	private User user;
	
	public void run() {
		testDemo.test();
	}
	
	public void staties(){
		user.kk(3, 5);
	}
}
