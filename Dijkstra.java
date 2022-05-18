import java.util.*;
public class Dijkstra
{
	public static void main(String args[])
	{
		Dijkstra d=new Dijkstra();
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		int adjMatrix[][]=new int[v][v];
		for(int i=0;i<e;i++)
		{
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int wt=sc.nextInt();
			adjMatrix[v1][v2]=wt;
			adjMatrix[v2][v1]=wt;
		}
		d.dijkstra(adjMatrix);
	}
	
	public void dijkstra(int[][] adjMatrix)
	{
		int v=adjMatrix.length;
		boolean visited[]=new boolean[v];
		int distance[]=new int[v];
		distance[0]=0;
		for(int i=1;i<v;i++)
		{
			distance[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<v-1;i++)
		{
			int minVertex=findMinVertex(distance,visited);
			visited[minVertex]=true;
			for(int j=0;j<v;j++)
			{
				if(adjMatrix[minVertex][j]!=0 && !visited[j] && distance[minVertex]!=Integer.MAX_VALUE)
				{
					int newDist=distance[minVertex]+adjMatrix[minVertex][j];
					if(newDist<distance[j])
					{
						distance[j]=newDist;
					}
				}				
		  }	
	  }
	  
	  //Print 
	  for(int i=0;i<v;i++)
	  {
		  System.out.println(i+" "+distance[i]);
		}
	}
	public int findMinVertex(int[] distance,boolean[] visited)
	{
		int minVertex=-1;
		for(int i=0;i<distance.length;i++)
		{
			if(!visited[i] && (minVertex==-1 || distance[i]<distance[minVertex]))
			{
				minVertex=i;
			}
		}
		return minVertex;
			
	}
		
			
			
}
