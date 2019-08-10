package myPackage;

public class Sudoku {
	private int[][][] demo = new int[10][10][10];
	boolean outCome = true;
	public Sudoku(int[][][] formIn){
		new Copy1To2(formIn, demo);
		
	}
	
	public Sudoku(){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				demo[i][j][0]=0;
				for(int k=1;k<10;k++){
					demo[i][j][k]=1;
				}
			}
		}
	}
	
	
	public boolean check(){
		clean();

		checkA();

		checkB();

		return outCome;
	}
	
	public int[][][] getShuDu(){
		return demo;
	}
	
	
	private void checkA() {
		// TODO 若空格处不可能是任何数，判定题目出错
		for(int i=1;i<10;i++){
	        for(int j=1;j<10;j++){
	            if(demo[i][j][0]==0){
	                int temp=0;//累加计数器
	                for(int k=1;k<10;k++){
	                    if(demo[i][j][k]!=0)temp++;
	                }
	                if(temp==0)outCome=false;
	            }
	        }
	    }
	}
	private void checkB() {
		//N不在这一行/列/块 且本行/列/块其他处不可能有N，判定题目出错
	    //扩充了else语句，判定某行/列/块数字n重复出现
		for(int n=1;n<10;n++){
	        for(int i=1;i<10;i++){
	            if(nIsInThisLine(n,i)==false){
	                int temp=0;
	                for(int j=1;j<10;j++){
	                    if(demo[i][j][n]!=0)temp++;
	                }

	                if(temp==0)outCome=false;

	            }

	            else{
	            	int temp=0;
	                for(int j=1;j<10;j++){
	                    if(demo[i][j][0]==n)temp++;
	                }

	                if(temp>1)outCome=false;

	            }
	            
	            
	        }

	        for(int j=1;j<10;j++){
	            if(nIsInThisColumn(n,j)==false){
	                int temp=0;
	                for(int i=1;i<10;i++){
	                    if(demo[i][j][n]!=0)temp++;
	                }
	                if(temp==0)outCome=false;
	            }
	            else{
	            	int temp=0;
	                for(int i=1;i<10;i++){
	                    if(demo[i][j][0]==n)temp++;
	                }
	                if(temp>1)outCome=false;
	            }
	        }

	        for(int N=0;N<3;N++){
	            for(int M=0;M<3;M++){
	                if(nIsInThisCube(n,N,M)==false){
	                    int temp=0;
	                    for(int i=1;i<4;i++){
	                        for(int j=1;j<4;j++){
	                            if(demo[N*3+i][M*3+j][n]!=0)temp++;
	                        }
	                    }
	                    if(temp==0)outCome=false;
	                }
	                else{
	                	int temp=0;
	                    for(int i=1;i<4;i++){
	                        for(int j=1;j<4;j++){
	                            if(demo[N*3+i][M*3+j][0]==n)temp++;
	                        }
	                    }
	                    if(temp>10)outCome=false;
	                }
	            }
	        }
	    }
	}

	public void printInfo(){
		System.out.println("┌───────┬───────┬───────┐");
		for(int i=1;i<10;i++){
			System.out.print("│ ");
			for(int j=1;j<10;j++){
				System.out.print(demo[i][j][0]+" ");;
				if(j==3|j==6)System.out.print("│ ");
			}
			System.out.print("│");
			System.out.print("\n");
			if(i==3|i==6)System.out.println("├───────┼───────┼───────┤");
		}
		System.out.println("└───────┴───────┴───────┘");
	}
	
	public int countBlank(){
		int blank = 0;
	    for(int i=1;i<10;i++){
	        for(int j=1;j<10;j++){
	            if(demo[i][j][0]==0)blank++;
	        }
	    }
	    return blank;
	}
	
	public int countNote(){
		int note = 0;
	    for(int i=1;i<10;i++){
	        for(int j=1;j<10;j++){
	            for(int k=1;k<10;k++)
	        	if(demo[i][j][k]==1)note++;
	        }
	    }
	    return note;
	}

	public boolean nIsInThisLine(int n,int line){
	    int j=0;
	    for(j=1;j<10;j++){
	        if(demo[line][j][0]==n)return true;
	    }
	    return false;
	}
	
	public boolean nIsInThisColumn(int n,int column){
	    int i=0;
	    for(i=1;i<10;i++){
	        if(demo[i][column][0]==n)return true;
	    }
	    return false;
	}
	
	public boolean nIsInThisCube(int n,int N,int M){
	    int i=0,j=0;
	    for(i=1;i<4;i++){
	        for(j=1;j<4;j++){
	            if(demo[N*3+i][M*3+j][0]==n)return true;
	        }
	    }
	    return false;
	}
	
	//下边这个方法比较特殊，因为有时候用来清理外部数独。
	public void excludePointNote(int line,int column,int[][][] formIn){//对于某个点进行计算排除所在行列块其他位置出现该数字的可能性
		if(formIn[line][column][0]!=0){
			int number = formIn[line][column][0];
			for(int k=1;k<10;k++){
		        formIn[line][column][k]=0;
		    }
		    for(int i=1;i<10;i++){
		        formIn[line][i][number]=0;
		        formIn[i][column][number]=0;
		    }
	
		    int N=(line-1)/3;int M=(column-1)/3;
		    for(int i=1;i<4;i++){
		        for(int j=1;j<4;j++){
		            formIn[N*3+i][M*3+j][number]=0;
		        }
		    }
		}
	    
	}
	
	public void clean(){
		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){
				if(demo[i][j][0]!=0){
					excludePointNote(i,j,demo);
				}
			}
		}
	}
	
	public int[][][] StrToForm(String StrIn){
int test[][][] = new int[10][10][10];
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				test[i][j][0]=0;
				for(int k=1;k<10;k++){
					test[i][j][k]=1;
				}
			}
		}
		
		
		int num=0;
		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){
				char temp = StrIn.charAt(num);
				test[i][j][0]=temp-48;
				num++;
			}
		}
		return test;
	}
	
	public boolean checkStr(String StrIn){
		if(StrIn.length()!=81)return false;
		
		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){
				if(StrToForm(StrIn)[i][j][0]<0|StrToForm(StrIn)[i][j][0]>9)return false;
			}
		}
		return true;
	}
	
}
