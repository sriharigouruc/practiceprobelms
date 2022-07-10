package com.sample.project;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			methodA();
		}
		catch(CustomException ce)
		{
			System.out.println("ce");
			ce.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("e");
			e.printStackTrace();
		}
		
	}

	public  static void methodA() throws Exception
	{
		throw new CustomException();
		
	}
}


class CustomException extends Exception
{
	CustomException()
	{
		super();
	}
}