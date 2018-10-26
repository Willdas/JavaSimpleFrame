package test.demo.service.impl;

import org.frame.simplify.beans.factory.annotation.BeanObj;

import test.demo.service.TestDemo;

//注入成Bean对象
@BeanObj
public class TestDemoImpl implements TestDemo{
	
	@Override
	public void test(){
		System.out.println("接口实现类调用成功");
	}
	
}
