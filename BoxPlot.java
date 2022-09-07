import java.lang.*;
import java.util.*;
import java.io.*;
class BoxPlot
{
   public static void main(String[] args) throws Exception
   {
    BufferedReader   in = new BufferedReader(new FileReader("C://Users/it/Desktop/boxplot.txt"));

    String inputLine = in.readLine();
    String [] fields = inputLine.split(" "); // Splits at the space
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
    System.out.println("1.MAX VALUE--------->"+arr[n-1]);
    System.out.println("2.MIN VALUE--------->"+arr[0]);
    System.out.println("3.MEDIAN---------->"+arr[(n+1)/2-1]);
    System.out.println("4.QUARTILE 1--------->"+arr[(n+1)/4-1]);
    System.out.println("5.QUARTILE 3--------->"+arr[3*(n+1)/4-1]);
   
   
   

   }
}
