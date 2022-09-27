import java.io.*;
import java.util.*;

class InfoGain
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/Shripad/OneDrive/Desktop/class.csv"));
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

        //finding the parent entropy
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
        double parent_entropy=0.0;
        for(int i=0;i<l1.size();i++)
        {
           parent_entropy+=-(l1.get(i)*(Math.log(l1.get(i))/Math.log(2)));
        }
        System.out.println("Parent entropy is-->"+parent_entropy);
        //finding the entropy of children
         for(int i=0;i<array[0].length-1;i++)
         {
           double  ans=findChildEntropy(array,i);
           double info_gain=parent_entropy-ans;
           System.out.print("Info Gain for"+str[i]+"is---->");
           System.out.println(info_gain);
         } 
        

    }
    public static double findChildEntropy(String [][] array,int col_no)
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
        
        int i=0,k=0;
        double child_entropy[]=new double[10];
        for(Map.Entry<String,Map<String,Integer>> e1:m.entrySet())
        {
            // System.out.print(e1.getKey()+"  ");
            Map<String,Integer> m3=e1.getValue();
            int tot=0;
            for(Map.Entry<String,Integer>e3:m3.entrySet())
            {
                tot+=e3.getValue();
            }
            ArrayList<Double>l1=new ArrayList<>();
            for(Map.Entry<String,Integer> e3:m3.entrySet())
            {
               l1.add(1.0*e3.getValue()/tot);
            }
            // System.out.println(l1);
            
            
            for( i=0;i<l1.size();i++)
            {
               double ans=-(l1.get(i)*(Math.log(l1.get(i))/Math.log(2)));
               child_entropy[k++]+=(1.0*tot/array.length)*ans;
            }
            
        }
        double total_child_entropy=0.0;
        for(i=0;i<k;i++)
        {
           total_child_entropy+=child_entropy[i];
        }
        // System.out.println(total_child_entropy);
        return total_child_entropy;
    }
}            