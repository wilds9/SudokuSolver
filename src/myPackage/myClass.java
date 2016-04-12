package myPackage;

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testStr = "";
		
		System.out.println("========数独========\nhuidexuan@foxmail.com");
		do{
			if(testStr==""){
				System.out.println("请输入题目：");
				System.out.println("例如：008507000000000010002000060005000008600010030000000000130000000000800000000400205");
			}
			else System.out.println("题目输入错误，请重新输入题目：");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			testStr = scan.nextLine();
		}
		while(new Sudoku().checkStr(testStr)==false);
		
		new Solver(new Sudoku().StrToForm(testStr));
	}

}
