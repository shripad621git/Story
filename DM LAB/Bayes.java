import java.io.*;
import java.util.*;

class GiniIndex
{
   static Map<String,Map<String,Integer>> m=new HashMap<>();
   public static double findAttributeGini(String [][] array,int col_no)
    {
        
        
        int p=array[0].length;
        for(int i=0;i<array.length;i++)
        {
            String key=array[i][col_no];
            if(!m.containsKey(key))
            {
                m.put(key,new HashMap<>());
            }
            Map<String,Integer>temp=m.get(key);
            String key2=array[i][p-1];
            if(!temp.containsKey(key2))
            {
                temp.put(key2,1);
            }
            else
            {
                temp.put(key2,temp.get(key2)+1);
            }
            
        }
       
        
        
           
        return 0.0;
    }
    public static void Bayes(
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/ccf/Desktop/data.csv"));
        String []str=br.readLine().trim().split(",");
        int n=str.length;
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
            for(int i=0;i<n;i++)
            {
                
                temp.add(s[i]);
            }
            l.add(temp);
        }
        

        String[][] array = new String[l.size()][];
        for (int i = 0; i < l.size(); i++) 
        {
              
               ArrayList<String> row = l.get(i);
               array[i] = row.toArray(new String[row.size()]);
        }
        Map<String,Integer>m1=new HashMap<>();
        int p=array[0].length;
        for(int i=0;i<array.length;i++)
        {
            String key=array[i][p-1];
            if(!m1.containsKey(key))
            {
               m1.put(key,1);
            }
            else
            {
               m1.put(key,m1.get(key)+1);
            }
       }
       int tot=0;
       for(Map.Entry<String,Integer>e1:m1.entrySet())
       {
          tot+=e1.getValue();
       }
       
        for(int i=0;i<array[0].length-1;i++)
         {
           double  ans=findAttributeGini(array,i);
          
         } 
         System.out.println(m);
          
       
     } 
}
           

          
