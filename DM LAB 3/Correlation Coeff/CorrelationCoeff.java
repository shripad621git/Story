
import java.io.*;
import java.util.*;

class CorrelationCoeff
{
    public static double correlationCoeff(ArrayList<ArrayList<String>>l,int row1,int row2)
    {
        int y1count=0,y2count=0,n1count=0,n2count=0,totYcount=0,totNcount=0;
        
        for(int i=0;i<l.get(row1).size();i++)
        {
     
            if(l.get(row1).get(i).equals("Y"))
                y1count++;
            else 
                n1count++;
        }  
        for(int i=0;i<l.get(row2).size();i++)
        {
     
            if(l.get(row2).get(i).equals("Y"))
                y2count++;
            else 
                n2count++;
        }  
        
        for(int i=0;i<l.get(row1).size();i++)
        {
     
            if(l.get(row1).get(i).equals("Y")&&l.get(row2).get(i).equals("Y"))
               totYcount++;
            else 
               totNcount++;
        } 
        double ans=(1.0*totYcount/(y1count*y2count));
        ans=Math.round(ans*100.0)/100.0;
        return ans;
    }
        
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/ShripaD/OneDrive/Desktop/corr.csv"));
        String []str=br.readLine().trim().split(",");
        int n=str.length;
        ArrayList<String>location=new ArrayList<>();
        ArrayList<ArrayList<String>> l=new ArrayList<>();
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
            ArrayList<String> temp=new ArrayList<>();
            
            location.add(s[0]);
            for(int i=1;i<n;i++)
            {
                
                temp.add(s[i]);
            }
            l.add(temp);
        }
        System.out.println(l);
        double ans=correlationCoeff(l,1,2);
        System.out.println("Correlation Coeff is"+ans);
        
    }
}