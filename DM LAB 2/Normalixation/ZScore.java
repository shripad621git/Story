import java.lang.*;
import java.util.*;
import java.io.*;
class ZScore
{
   public static void main(String[] args) throws Exception
   {
    BufferedReader   in = new BufferedReader(new FileReader("norm.csv"));
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
       zscore[i]=Math.round(((arr[i]-mean)/sd)*100.0)/100.0;
    }
    System.out.println("Data item ------------->zscore");
    for( i=0;i<n;i++)
    {
        System.out.println(arr[i]+" ------------->"+zscore[i]);
    }
    StringBuilder builder = new StringBuilder();
    builder.append("value"+","+"zscore");
    builder.append("\n");
    for(i = 0; i < zscore.length; i++)//for each row
   {
   
      builder.append(arr[i]+","+zscore[i]);//append to the output string
      builder.append("\n");
   }
   


   BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
   writer.write(builder.toString());//save the string representation of the board
   writer.close();
   }
}    