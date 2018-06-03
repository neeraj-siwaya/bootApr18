package com.techmentro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.techmentro.beans.ABC;

@SpringBootApplication
public class Application {

	public static void main(String arr[])
	{
		ApplicationContext context=SpringApplication.run(Application.class, arr);
		
		ABC target=(ABC)context.getBean("target");
		System.out.println("Invoking a() of target...");
		target.a();
		System.out.println("Invoking b() of target...");
		String str=target.b();
		System.out.println(str+" is returned by b() in main().");
		try
		{
			System.out.println("Invoking c() of target...");
			target.c(-5);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
