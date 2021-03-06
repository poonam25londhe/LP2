import java.io.*;
import java.util.*;
class QueenBack
{
	final int N=4;
	public static void main(String args[])
	{
		QueenBack q=new QueenBack();
		q.solveNQ();
	}
	boolean solveNQ()
	{
		int board[][]={
						{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0},
						{0,0,0,0},
					};
		if(solveUtil(board,0)==false)
		{
			System.out.println("Solution does not exist");
			return false;
		}
		printSolution(board);
		return true;
					
	}
	
	boolean solveUtil(int board[][], int col)
	{
		if(col>=N)
		{
			return true;
		}
		for(int i=0;i<N;i++)
		{
			if(isSafe(board,i,col))
			{
				board[i][col]=1;
				if(solveUtil(board,col+1)==true)
				{
					return true;
				}
				board[i][col]=0;
			}
		}
		return false;
	
	}
	
	boolean isSafe(int board[][],int row,int col)
	{
		int i,j;
		for(i=0;i<col;i++)
		{
			if(board[row][i]==1)
			{
				return false;
			}
		}
		for(i=row,j=col;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]==1)
			{
				return false;
			}
		}
		
		for(i=row,j=col;i<N && j>=0;i++,j--)
		{
			if(board[i][j]==1)
			{
				return false;
			}
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
