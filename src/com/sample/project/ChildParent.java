/**
 * 
 */
package com.sample.project;

/**
 * @author SGouru
 *
 */
public class ChildParent extends Parent 
{

	public int a = 30;
	public int b = 40;

	public void m1() {
		System.out.println("Child m1 method");
	}

	public static void main(String[] args) {
		Parent c = new ChildParent();
		System.out.println(c.a);
		System.out.println(c.b);
		c.m1();
	}

}

class Parent {
	public int a = 10;
	public int b = 20;

	public void m1() {
		System.out.println("Parent m1 method");
	}
}



