package myPackage;


public class Solver {
	int[][][] form = new int[10][10][10];
	public Solver(int[][][] formIn){
		new Copy1To2(formIn, form);
		System.out.println("原题目：（剩余"+new Sudoku(form).countBlank()+"个空格）");
		new Sudoku(form).printInfo();
		
		
		//先对原题目进行一次排除
		Sudoku mySD = new Sudoku(form);
		if(mySD.check()==true){
			new Copy1To2(mySD.getShuDu(),form);
			//System.out.println("题目未查出错误");
		
			// /****求解器工作区
			long time = System.currentTimeMillis();
			for(int i=0;i<99;i++){
				//执行求解器1
				Algorithm_1 myAl_1 = new Algorithm_1(form);
				Sudoku myAl_1SD = new Sudoku(myAl_1.getForm());
				if(myAl_1SD.check()==true){
					new Copy1To2(myAl_1SD.getShuDu(), form);
					//System.out.println("求解器1正常");
				}
				else{
					System.out.println("求解器1异常报错，似乎题目无解");
					System.exit(0);
				}
				//执行求解器2
				Algorithm_2 myAl_2 = new Algorithm_2(form);
				Sudoku myAl_2SD = new Sudoku(myAl_2.getForm());
				if(myAl_2SD.check()==true){
					new Copy1To2(myAl_2SD.getShuDu(), form);
					//System.out.println("求解器2正常");
				}
				else{
					System.out.println("求解器2异常报错，似乎题目无解");
					System.exit(0);
				}
				new Copy1To2(new Algorithm_2(form).getForm(), form) ;
			
				if(new Sudoku(form).countBlank()==0){
					//System.out.println("共执行"+ (i+1) +"个循环");
					break;
				}
			}
			// ****/求解器工作区
		
			System.out.println("\n[数独求解器]的运算结果：剩余"+new Sudoku(form).countBlank()+"个空格");
			new Sudoku(form).printInfo();
			time = System.currentTimeMillis()-time;
			System.out.println("用时"+time+"毫秒");
		}
		else{
			System.out.println("题目有明显的错误，请检查");
		}
		
	}

}
