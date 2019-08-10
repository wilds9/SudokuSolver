package myPackage;

public class Algorithm_1 {
	private int[][][] demo = new int[10][10][10];
	
	public Algorithm_1(int[][][] formIn){
		new Copy1To2(formIn, demo);
		ConfirmNewOne();
	}
	
	//扫描表格和笔记看是否能写入新的数字点
	private void ConfirmNewOne(){
	    //下面这个for循环是检查某个方块的笔记只剩n这一条记录。
		for(int i=1;i<10;i++){
	        for(int j=1;j<10;j++){
	            if(demo[i][j][0]==0){
	                int temp=0;//累加计数器
	                for(int k=1;k<10;k++){
	                    if(demo[i][j][k]!=0)temp++;
	                }
	                if(temp==1){
	                    for(int k=1;k<10;k++){
	                        if(demo[i][j][k]!=0){
	                            //if(nIsInThisLine(k,i))return "NoSolution";
	                            //if(nIsInThisColumn(k,j))return "NoSolution";
	                            //if(nIsInThisCube(k,(i-1)/3,(j-1)/3))return "NoSolution";
	                            demo[i][j][0]=k;
	                            new Sudoku().excludePointNote(i,j, demo);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    //下面是检查该方块所在 行 列 块 的其余的八个地方都不可能写入n。
	    
	    for(int n=1;n<10;n++){
	        for(int i=1;i<10;i++){
	            if(new Sudoku(demo).nIsInThisLine(n,i)==false){
	                int temp=0;
	                for(int j=1;j<10;j++){
	                    if(demo[i][j][n]!=0)temp++;
	                }
	                if(temp==1){
	                    for(int j=1;j<10;j++){
	                        if(demo[i][j][n]!=0){
	                            //if(nIsInThisLine(n,i))return "NoSolution";
	                            //if(nIsInThisColumn(n,j))return "NoSolution";
	                            //if(nIsInThisCube(n,(i-1)/3,(j-1)/3))return "NoSolution";
	                           demo[i][j][0]=n;
	                           new Sudoku().excludePointNote(i,j, demo);
	                        }
	                    }
	                }
	            }
	        }

	        for(int j=1;j<10;j++){
	            if(new Sudoku(demo).nIsInThisColumn(n,j)==false){
	                int temp=0;
	                for(int i=1;i<10;i++){
	                    if(demo[i][j][n]!=0)temp++;
	                }
	                if(temp==1){
	                    for(int i=1;i<10;i++){
	                        if(demo[i][j][n]!=0){
	                            //if(nIsInThisLine(n,i))return "NoSolution";
	                            //if(nIsInThisColumn(n,j))return "NoSolution";
	                            //if(nIsInThisCube(n,(i-1)/3,(j-1)/3))return "NoSolution";
	                            demo[i][j][0]=n;
		                        new Sudoku().excludePointNote(i,j, demo);
	                        }
	                    }
	                }
	            }
	        }

	        int N=0,M=0;
	        for(N=0;N<3;N++){
	            for(M=0;M<3;M++){
	                if(new Sudoku(demo).nIsInThisCube(n,N,M)==false){
	                    int temp=0;
	                    for(int i=1;i<4;i++){
	                        for(int j=1;j<4;j++){
	                            if(demo[N*3+i][M*3+j][n]!=0)temp++;
	                        }
	                    }
	                    if(temp==1){
	                        for(int i=1;i<4;i++){
	                        for(int j=1;j<4;j++){
	                            if(demo[N*3+i][M*3+j][n]!=0){
	                                //if(nIsInThisLine(n,N*3+i))return "NoSolution";
	                                //if(nIsInThisColumn(n,M*3+j))return "NoSolution";
	                                //if(nIsInThisCube(n,N,M))return "NoSolution";
	                                demo[N*3+i][M*3+j][0]=n;
			                        new Sudoku().excludePointNote(N*3+i,M*3+j, demo);
	                            	}
	                        	}
	                        }
	                    }
	                }
	            }
	        }
	    }
	}

	public int[][][] getForm(){
		return demo;	
	}
}
