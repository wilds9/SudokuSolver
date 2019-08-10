package myPackage;

import java.util.Scanner;

public class myClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testStr = "";
		
		System.out.println("========数独========");
		System.out.println("Author's Email: wildsandalwood9@gmail.com");
		do{
			if(testStr==""){
			    System.out.println("题目输入示例：008507000000000010002000060005000008600010030000000000130000000000800000000400205");
			    System.out.print("请输入题目：");

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
