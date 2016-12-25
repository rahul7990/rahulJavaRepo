package com.basic;


class Demo{
	
	static{
		System.out.println("-----Static from Demo:-------");
	}
	Demo(){
		System.out.println("--------From Demo:----------");
	}
	
	Demo(int i){
		System.out.println("--------From Demo Paramatrized------");
	}
	
	{
		System.out.println("IIB From Demo:");
	}
}
public class InitBlockDemo2 extends Demo {

	static{
		System.out.println("-----Static from InitBlockDemo2:-------");
	}
	{
		System.out.println("-----IIB from InitBlockDemo2:-------");
	}
	
	InitBlockDemo2(){
		System.out.println("-----Default Construtor from InitBlockDemo2:-------");
	}
	InitBlockDemo2(int i){
	System.out.println("-----Paramatrized constructor from InitBlockDemo2:-------");
	}
	
	public static void main(String[] args) {
		new InitBlockDemo2();
		System.out.println("---------oooooooooo-----------ooooooooooo----------");
		new InitBlockDemo2(1);
		
	}
}
