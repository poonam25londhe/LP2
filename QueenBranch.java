import java.io.*;
import java.util.*;
class QueenBranch
{
	final int N=4;
	public static void main(String args[])
	{
		QueenBranch q=new QueenBranch();
		q.solveNQ();
		
	}
	boolean solveNQ()
	{
		int board[][]=new int[N][N];
		int slashcode[][]=new int[N][N];
		int backslashcode[][]=new int[N][N];
		 boolean[] rowlookup=new boolean[N];
		 boolean slashcodelookup[]=new boolean[2*N-1];
		 boolean backslashcodelookup[]=new boolean[2*N-1];
		 for(int r=0;r<N;r++)
		 {
			 for(int c=0;c<N;c++)
			 {
				  slashcode[r][c] = r + c;
					backslashcode[r][c] = (r-c+3);;
			}
		}
		if(solveUtil(board,0,slashcode,backslashcode,rowlookup,slashcodelookup,backslashcodelookup)==false)
		{
			System.out.println("Solution not exist");
			return false;
		}
		 printSolution(board);
		return true;
	}
	
	boolean solveUtil(int board[][],int col,int slashcode[][],int backslashcode[][],boolean rowlookup[],boolean slashcodelookup[], boolean backslashcodelookup[])
	{
		if(col>=N)
		{
			return true;
		}
		for(int i=0;i<N;i++)
		{
			if(isSafe(i,col,slashcode,backslashcode,rowlookup,slashcodelookup,backslashcodelookup))
			{
				board[i][col]=1;
				rowlookup[i]=true;
				slashcodelookup[slashcode[i][col]]=true;
				backslashcodelookup[backslashcode[i][col]]=true;
				if(solveUtil(board,col+1,slashcode,backslashcode,rowlookup,slashcodelookup,backslashcodelookup))
				{
					return true;
				}
				board[i][col]=0;
				rowlookup[i]=false;
				slashcodelookup[slashcode[i][col]]=false;
				backslashcodelookup[backslashcode[i][col]]=false;
					
			}		
	   }  
	   return false;
	}
	boolean isSafe(int row,int col,int slashcode[][],int backslashcode[][],boolean rowlookup[],boolean slashcodelookup[], boolean backslashcodelookup[])
	{
		if(slashcodelookup[slashcode[row][col]] || rowlookup[row] || backslashcodelookup[backslashcode[row][col]])
		{
			return false;
		}
		return true;
	}
	
	public void printSolution(int board[][])
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(" "+board[i][j]+"");
				 
			}
			 System.out.println();
		}
	}
}

