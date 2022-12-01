import java.lang.*;
import java.util.*;
import java.io.*;
class BoxPlot
{

   public static double findMedian(int arr[],int start,int end)
   {
        int n=end-start+1;
        if(n%2==0)
        {
            return (arr[start+n/2-1]+arr[start+n/2])/2;
        }
        else
        {
            return arr[start+n/2];
        }

   }
   public static void main(String[] args) throws Exception
   {
    BufferedReader   br = new BufferedReader(new FileReader("boxplot.csv"));

    
    String [] fields = br.readLine().trim().split(","); // Splits at the space
    int i=0;
    int [] arr=new int[fields.length];
    for(String str:fields){
    int x=Integer.parseInt(str); //prints out name
    arr[i++]=x;
    }
    System.out.println("---------The data set input from file-------");
    for(int a:arr)
    {
       System.out.print(a +"  ");
    }
    
       
   System.out.println();
   System.out.println("-------------Five Point Summary(Box Plot)--------");
    Arrays.sort(arr);
    System.out.println("Sorted Data");
    for(int a:arr)
    {
       System.out.print(a+" ");
    }
    System.out.println();
    int n=arr.length;
    double median=findMedian(arr,0,n-1);
    double q1=findMedian(arr,0,n/2-1);
    double q3=0;
    if(n%2==0)
    {
        q3=findMedian(arr,n/2,n-1);
    }
    else
    {
        q3=findMedian(arr,n/2+1,n-1);
    }
    StringBuilder builder = new StringBuilder();
    System.out.println("1.MAX VALUE--------->"+arr[n-1]);
    builder.append("Max"+","+arr[n-1]);
    builder.append("\n");
    System.out.println("2.MIN VALUE--------->"+arr[0]);
    builder.append("Min"+","+arr[0]);
    builder.append("\n");
    System.out.println("3.MEDIAN---------->"+median);
    builder.append("Median"+","+median);
    builder.append("\n");
    System.out.println("4.QUARTILE 1--------->"+q1);
    builder.append("Q1"+","+q1);
    builder.append("\n");
    System.out.println("5.QUARTILE 3--------->"+q3);
    builder.append("Q3"+","+q3);
    builder.append("\n");
    double x=q3-q1;
    System.out.println("6.IQR--------->"+x);
    builder.append("IQR"+","+x);
    builder.append("\n");
    double a=q1-1.5*(q3-q1);
    System.out.println("7.Lower Bound----->"+a);
    builder.append("Lower Bound"+","+a);
    builder.append("\n");
    double b=q3+1.5*(q3-q1);
    System.out.println("8. UpperBound---->"+b);
    builder.append("Upper Bound"+","+b);
    builder.append("\n");

   BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
   writer.write(builder.toString());//save the string representation of the board
   writer.close();

   }
}