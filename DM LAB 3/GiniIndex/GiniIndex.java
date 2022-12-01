import java.io.*;
import java.util.*;

class GiniIndex
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/ShRipaD/OneDrive/Desktop/data1.csv"));
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
        Map<String,Integer> m=new HashMap<>();
        int p=array[0].length;
        for(int j=0;j<array.length;j++)
        {
            String key=array[j][p-1];
            if(!m.containsKey(key))
            {
                m.put(key,1);
            }
            else
            {
              m.put(key,m.get(key)+1);
            } 
        }

        //finding the class gini Index
        int tot=0;
        for(Map.Entry<String,Integer> e:m.entrySet())
        {
            tot+=e.getValue();
        }
        ArrayList<Double> l1=new ArrayList<>();
        for(Map.Entry<String,Integer> e:m.entrySet())
        {
            l1.add(1.0*e.getValue()/tot);
        }
        double class_gini=1;
        for(int i=0;i<l1.size();i++)
        {
           class_gini-=l1.get(i)*l1.get(i);
        }
        System.out.println("Class Gini Index is-->"+class_gini);
        //finding the entropy of attr
        StringBuilder builder = new StringBuilder();
        
        builder.append("col_name"+","+"info gain");
        builder.append("\n");
         for(int i=0;i<array[0].length-1;i++)
         {
            double  ans=findAttributeGini(array,i);
           
           System.out.print("Gini Index for"+str[i]+"  is---->");
           builder.append(str[i]+","+ans);
           builder.append("\n");
           System.out.println(ans);
         } 
         BufferedWriter writer = new BufferedWriter(new FileWriter("output15.csv"));
         writer.write(builder.toString());
         
         writer.close();
        

    }
    public static double findAttributeGini(String [][] array,int col_no)
    {
        
        Map<String,Map<String,Integer>> m=new HashMap<>();
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
        //System.out.println(m);
        int i=0,k=0;
        double attr_gini[]=new double[100];
        for(Map.Entry<String,Map<String,Integer>> e1:m.entrySet())
        {
            
            Map<String,Integer> m3=e1.getValue();
            int tot=0;
            for(Map.Entry<String,Integer>e3:m3.entrySet())
            {
                tot+=e3.getValue();
            }
            //System.out.println(e1.getKey()+" "+tot);
            ArrayList<Double>l1=new ArrayList<>();
            for(Map.Entry<String,Integer>e3:m3.entrySet())
            {
                l1.add(1.0*e3.getValue()/tot);
            }
            //System.out.println(l1);
            double ans=1.0;
            for(i=0;i<l1.size();i++)
            {

                ans-=(l1.get(i)*l1.get(i));
            }
            
            
            attr_gini[k++]+=ans*(1.0*tot/array.length);
            
            
       }
       
       double total_attr_gini=0.0;
       for( i=0;i<k;i++)
       {
          total_attr_gini+=attr_gini[i];
       }
        
           
        return total_attr_gini;
    }
}            