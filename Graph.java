import java.io.*;
import java.util.*;

class ImplementGraph
{
	int search[];
	LinkedList<Integer> adj[];
	ImplementGraph(int v1)
	{
		adj=new LinkedList[v1];
		for(int j=0;j<v1;j++)
		{
			adj[j]=new LinkedList<Integer>();
		}
	}
	
	public void insertEdge(int source,int destination)
	{
		adj[source].add(destination);
		adj[destination].add(source);
	}	
	public void BFS(int sr1)
	{
		System.out.println("BFS");
		boolean result=false;
		System.out.println("Which vertex u want to search");
		Scanner sc=new Scanner(System.in);
		int ele=sc.nextInt();
		boolean visited[]=new boolean[adj.length];
		int parent[]=new int[adj.length];
		
		Queue<Integer> q=new LinkedList<>();
		q.add(sr1);
		parent[sr1]=-1;
		 visited[sr1]=true;
		while(!q.isEmpty())
		{
			int p=q.poll();
			if(p==ele)
			{
				result=true;
			}
			System.out.print(p+" ");
			for(int k:adj[p])
			{
				if(visited[k]!=true)
				{
					visited[k]=true;
					q.add(k);
					parent[k]=p;
				}
			}	
		}
		if(result ==true)
		{
			System.out.println("Found");
		}
		else
		{
			System.out.println(" Not Found");
		}
		System.out.println("");
	}
	
	
	public void DFS(int sr1)
	{
		System.out.println("DFS");
		boolean visited[]=new boolean[adj.length];
		int parent[]=new int[adj.length];
		Stack<Integer> s=new Stack<>();
		s.add(sr1);
		parent[sr1]=-1;
		 visited[sr1]=true;
		while(!s.isEmpty())
		{
			int p=s.pop();
			System.out.print(p+" ");
			for(int k:adj[p])
			{
				if(visited[k]!=true)
				{
					visited[k]=true;
					s.add(k);
					parent[k]=p;
				}
			}	
		}
		System.out.println("");
		
	}
	// Recursion
	
	public void rDFS(int RSR)
	{
		System.out.println("Recursion");
		boolean vis[]=new boolean[adj.length];
		dfshelp(RSR,vis);
	}
	public void dfshelp(int start, boolean[] visited)
	{
		visited[start]=true;
		System.out.print(start+" ");
		for(int m:adj[start])
		{
			if(visited[m]==false)
			{
				dfshelp(m,visited);
			}
		}
	}
		
}


class Graph
{
	public static void main(String args[])
	{
		Graph g=new Graph();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of vertices and edges");
		int v=sc.nextInt();
		int e=sc.nextInt();
		ImplementGraph ig=new ImplementGraph(v);
		System.out.println("Enter edges");
		for(int i=0;i<e;i++)
		{
			int s=sc.nextInt();
			int d=sc.nextInt();
			ig.insertEdge(s,d);
		}
		System.out.println("Enter source for BFS DFS");
		int sr=sc.nextInt();
		ig.BFS(sr);
		ig.DFS(sr);
		ig.rDFS(sr);
		
		
	}
}
		
