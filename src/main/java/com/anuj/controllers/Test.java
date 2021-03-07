package com.anuj.controllers;


//interface A{
//	//int m(int i);
//	default int m(int i){
//		System.out.println("A::"+i);
//		return 1;
//	}
//}
//
//interface B{
//	//int m(int i);
//	default int m(int i){
//		System.out.println("B::"+i);
//		return 1;
//	}
//
//}
//public class Test implements A,B{
//
//	public static void main(String[] args) {
//		new Test().m(22);
//	}
//
//}

//////////////////////////////////////////////////////////////////////
//public class Test extends Throwable{
//
//	public static void main(String[] args) {
//		new Test().m(22);
//	}
//	
//	public int m(int i) {
//		
//		return 1;
//	}
//
//	public int mm(int i) {
//		
//		return 1;
//	}
//}


//////////////////////////////////////////////////////////////////////

// abstract class X {
//
//    void t1()
//    {
//        System.out.println("super");
//
//    }
//
//}
//  class concret extends X{
//
//    void t1()
//    {
//    	 //super.t1();
//        System.out.println("child");
//
//    }
//    void t2()
//    {
//        System.out.println("child2");
//
//    }
//
//}
//
//public class Test {
//    public static void main(String[] args) {
//        X t=new concret();
//        t.t1();
//    }
//
//}

//////////////////////////////////////////////////////////////////////

//A simple Java program to demonstrate multiple inheritance through default methods. 

//interface PI1 
//{ 
//	// default method 
//	default void show() 
//	{ 
//		System.out.println("Default PI1"); 
//	} 
//} 
//
//interface PI2 
//{ 
//	// Default method 
//	default void show() 
//	{ 
//		System.out.println("Default PI2"); 
//	} 
//} 
//
////Implementation class code 
//class Test implements PI1, PI2 
//{ 
//	// Overriding default show method 
//	public void show() 
//	{ 
//		// use super keyword to call the show 
//		// method of PI1 interface 
//		PI1.super.show(); 
//
//		// use super keyword to call the show 
//		// method of PI2 interface 
//		PI2.super.show(); 
//	} 
//
//	public static void main(String args[]) 
//	{ 
//		Test d = new Test(); 
//		d.show(); 
//	} 
//} 
