package com.techmentro.beans;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements ABC {

	public void a()
	{
		System.out.println("a() of Target is invoked.");
	}
	public String b()
	{
		System.out.println("b() of Target is invoked returning succes...");
		return "success";
	}
	public void c(int x) throws Exception
	{
		System.out.println("c() of Target is invoked.");
		if(x < 0)
			throw(new Exception("input must be > 0"));
		else
			System.out.println("Returning normally.");
	}
}
