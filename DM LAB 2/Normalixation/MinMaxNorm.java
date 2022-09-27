import java.lang.*;
import java.util.*;
import java.io.*;
class MinMaxNorm
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
   
    int max2;
    int min2;
    System.out.println("Enter the minimum value");
    min2=sc.nextInt();
   
    System.out.println("Enter the maximum value");
    max2=sc.nextInt();
    double normArray[]=new double[arr.length];
    for( i=0;i<arr.length;i++)
    {
      double ans=((1.0*(arr[i]-min1)/(max1-min1))*(max2-min2))+min2;
      normArray[i]=Math.round(ans*100.0)/100.0;
 
    }
    for( i=0;i<arr.length;i++)
    {
         System.out.println(arr[i]+"---Normalized value-->"+normArray[i]);
    }
    StringBuilder builder = new StringBuilder();
    builder.append("value"+","+"normalized value");
    builder.append("\n");
    for(i = 0; i < normArray.length; i++)//for each row
   {
   
      builder.append(arr[i]+","+normArray[i]);//append to the output string
      builder.append("\n");
   }
   


   BufferedWriter writer = new BufferedWriter(new FileWriter("output1.csv"));
   writer.write(builder.toString());//save the string representation of the board
   writer.close();
  }
}    

 