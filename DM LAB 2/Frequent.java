import java.io.*;
import java.util.*;

class Frequent
{
    static void combinationUtil(String arr[], String data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }
 
        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/Shripad/OneDrive/Desktop/transactions.csv"));
        
       
        ArrayList<ArrayList<String>> l=new ArrayList<>();
         while(true)
        {
            
            try{
                String [] s=br.readLine().trim().split(",");  
                ArrayList<String> temp=new ArrayList<>();
            
                for(int i=0;i<s.length;i++)
                {
                temp.add(s[i]);
                }
                 l.add(temp);
            }
            catch(NullPointerException e)
            {
                break;
            }
           
           
        }
        HashMap<String,Integer>m=new HashMap<>();
        for(int i=0;i<l.size();i++)
        {
            for(int j=0;j<l.get(i).size();j++)
            {
                String key=l.get(i).get(j);
                if(!m.containsKey(key))
                {
                    m.put(key,1);
                }
                else
                {
                    m.put(key,m.get(key)+1);
                }
            }
        }
        String[] arr=new String[m.size()];
        String[] data=new String[2];
        int p=0;
        for(Map.Entry<String,Integer> e:m.entrySet())
        {
            arr[p++]=e.getKey();
            System.out.println(e.getKey()+" "+e.getValue());
        }
        combinationUtil(arr,  data, 0,
                                 p-1, 0, 2 );
        
        
  
    }
}       