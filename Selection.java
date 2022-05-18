import java.io.*;
import java.util.*;
class Selection
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		System.out.println("Enter elements of array");
		int arr[]=new int[n];
		for(int p=0;p<n;p++)
		{
			arr[p]=sc.nextInt();
		}
		System.out.println("After sorting");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
		
			
		for(int k=0;k<n;k++)
		{
			System.out.println(arr[k]);
		}
	}
}
