//MethodInjectionTest .java
package com.nt.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class MethodInjectionTest {

	public static void main(String[] args) {
	    //create IOC container
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//get  Target class obj ref
		BankService  service=ctx.getBean("bankService",BankService.class);
		System.out.println(service.getClass()+"   "+service.getClass().getSuperclass()+" "+Arrays.toString(service.getClass().getDeclaredMethods()));
		 
		//invoke the  b.method
		 double IntrAmt=service.calculateIntrestAmount(100000,12 , 2);
		 System.out.println("Intrest Amount  is ::"+IntrAmt);
		 
		 //close container
		ctx.close();

	}

}
