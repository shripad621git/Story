import java.io.*;
import java.util.*;

class TDWeight
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/Shripad/OneDrive/Desktop/data.csv"));
        String []str=br.readLine().trim().split(",");
        int n=str.length;
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        while(true)
        {
            String [] s=new String[n];
            try{
                s=br.readLine().trim().split(",");
            }
            catch(NullPointerException e)
            {
                break;
            }
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=1;i<n;i++)
            {
                int x=Integer.parseInt(s[i]);
                temp.add(x);
            }
            l.add(temp);
        }

        //converting arraylist to matrix
        Integer[][] array = new Integer[l.size()][];
        for (int i = 0; i < l.size(); i++) 
        {
              
               ArrayList<Integer> row = l.get(i);
               array[i] = row.toArray(new Integer[row.size()]);
        }

        //finding row sum
        int [] rowsum=new int [array.length];
        for(int i=0;i<array.length;i++)
        {
            int sum=0;
            for(int j=0;j<array[0].length;j++)
            {
                sum+=array[i][j];
            }
            rowsum[i]=sum;
        }

        //finding col sum
        int []colsum=new int[array[0].length];
        for(int i=0;i<array[0].length;i++)
        {
            int sum=0;
            for(int j=0;j<array.length;j++)
            {
                sum+=array[j][i];
            }
            colsum[i]=sum;
        }
        
        //tweight and dweight matrices
        
        
        double [][]tweight=new double[array.length][array[0].length];
        double [][]dweight=new double[array.length][array[0].length];


        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                  double a=(1.0*array[i][j]/rowsum[i])*100;
                  tweight[i][j]=Math.round(a*100.0)/100.0;

                  double b=(1.0*array[i][j]/colsum[j])*100;
                  dweight[i][j]=Math.round(b*100.0)/100.0;
            }
        }
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                System.out.print(array[i][j]+" ");
            }
            System.out.print("------>  ");
            for(int j=0;j<array[0].length;j++)
            {
                System.out.print(tweight[i][j]+"   ");
            }
             System.out.print("----->  ");
            for(int j=0;j<array[0].length;j++)
            {
                System.out.print(dweight[i][j]+"   ");
            }
            System.out.println();
        }
    }
}