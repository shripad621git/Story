import java.lang.*;
import java.util.*;
import java.io.*;
class MinMaxNorm
{
   public static void main(String[] args) throws Exception
   {
    BufferedReader   in = new BufferedReader(new FileReader("C://Users/Shripad/OneDrive/Desktop/norm.csv"));
    Scanner sc=new Scanner(System.in);
    String inputLine = in.readLine();
    String [] fields = inputLine.split(","); // Splits at the space
    int i=0;
    int [] arr=new int[fields.length];
    for(String str:fields){
    int x=Integer.parseInt(str); //prints out name
    arr[i++]=x;
    }
    for(int a:arr)
    {
       System.out.print(a+" ");
    }
    System.out.println();
    int max1=Integer.MIN_VALUE;
    int min1=Integer.MAX_VALUE;
    for( i=0;i<arr.length;i++)
    {
       if(arr[i]>max1)
          max1=arr[i];
    }
   
    for( i=0;i<arr.length;i++)
    {
       if(arr[i]<min1)
         min1=arr[i];
    }
   
    int max2;
    int min2;
    System.out.println("Enter the minimum value");
    min2=sc.nextInt();
    
    System.out.println("Enter the maximum value");
    max2=sc.nextInt();
    double normArray[]=new double[arr.length];
    for( i=0;i<arr.length;i++)
    {
      normArray[i]=(double)((double)(arr[i]-min1)/(double)(max1-min1))*(max2-min2);
 
    }
    for( i=0;i<arr.length;i++)
    {
         System.out.println(arr[i]+"---Normalized value-->"+normArray[i]);
    }
     double mean=0.0;
    double sum=0.0;
    for(i=0;i<arr.length;i++)
    {
         sum+=arr[i];
    }
    mean=sum/arr.length;
    int n=arr.length;
    double sd=0.0;
    double sqrsum=0.0;
    for( i=0;i<n;i++)
    {
       sqrsum=sqrsum+(arr[i]-mean)*(arr[i]-mean);
    }
    sqrsum=sqrsum/n;
    sd=Math.sqrt(sqrsum);
    double zscore[]=new double[n];
    for( i=0;i<n;i++)
    {
       zscore[i]=(arr[i]-mean)/sd;
    }
    System.out.println("Data item ------------->zscore");
    for( i=0;i<n;i++)
    {
        System.out.println(arr[i]+" ------------->"+zscore[i]);
    }
  }
}    
