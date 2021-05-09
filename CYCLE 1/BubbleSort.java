//CYCLE 1 PRM 1


import java.io.*;
public class BubbleSort
{
 public static void main(String args[])throws IOException
 {
   int a[]=new int[20];
   int i,j,n,t;
   InputStreamReader read=new InputStreamReader(System.in);
   BufferedReader in=new BufferedReader(read);
   System.out.println("Enter the size of the array");
   n=Integer.parseInt(in.readLine());
   System.out.println("Enter the elements of the array");
   for(i=0;i<n;i++)
   {
   a[i]=Integer.parseInt(in.readLine());
   }
   for(i=0;i<n-1;i++)
   {
    for(j=0;j<(n-i-1);j++)
    {
     if(a[j]>a[j+1])
     {
      t=a[j];
      a[j]=a[j+1];
      a[j+1]=t;
     }
    }
   }
   System.out.println("The Array After Sorting:");
   for(i=0;i<n;i++)
   {
   System.out.println(a[i]);
   }
  }
 }
