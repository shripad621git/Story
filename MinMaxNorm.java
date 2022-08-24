import java.lang.*;
import java.util.*;
import java.io.*;
class MinMaxNorm
{
   public static void main(String[] args) throws Exception
   {
    BufferedReader   in = new BufferedReader(new FileReader("C://Users/it/Desktop/data.txt"));

    String inputLine = in.readLine();
    String [] fields = inputLine.split(" "); // Splits at the space
    int i=0;
    int [] arr=new int[fields.length];
    for(String str:fields){
    int x=Integer.parseInt(str); //prints out name
    arr[i++]=x;
    }
    for(int a:arr)
    {
       System.out.println(a);
    }
    int max1=Integer.MIN_VALUE;
    int min1=Integer.MAX_VALUE;
    for( i=0;i<arr.length;i++)
    {
       if(arr[i]>max1)
          max1=arr[i];
    }
    System.out.println(max1);
    for( i=0;i<arr.length;i++)
    {
       if(arr[i]<min1)
         min1=arr[i];
    }
    System.out.println(min1);
    int max2=1;
    int min2=0;
    double normArray[]=new double[arr.length];
    for( i=0;i<arr.length;i++)
    {
      normArray[i]=(double)((double)(arr[i]-min1)/(double)(max1-min1));

    }
    for( i=0;i<arr.length;i++)
    {
         System.out.println(arr[i]+"---Normalized value-->"+normArray[i]);
    }
  }
}    