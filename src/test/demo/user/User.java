package test.demo.user;

import org.frame.simplify.beans.factory.annotation.BeanObj;


//注入成Bean对象
@BeanObj
public class User {
	
	public void kk(int n,int m){
		int result = n + m;
		System.out.println("计算结果：" + result);
	}
	
}
