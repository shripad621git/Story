import java.util.*;

class Distance
{
   public static double getdistance(double[] center,double []p)
   {
       double distance=0.0; 
       double x1=center[0];
       double x2=p[0];
       double y1=center[1];
       double y2=p[1];
       double sqr=((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
       distance=Math.sqrt(sqr);
       return distance;
   }

   public static void main(String[] args)throws Exception
   {
      
       double [][]p={{72,88},{25,65},{40,38},{90,32}};
      
       double [] center=new double [2];
       center[0]=1.0*(p[0][0]+p[1][0]+p[2][0]+p[3][0])/4;
       
       center[1]=1.0*(p[0][1]+p[1][1]+p[2][1]+p[3][1])/4;
      
       System.out.println("Center (X,Y)("+center[0]+","+center[1]+")");
       double [] distance=new double[4];
       for(int i=0;i<p.length;i++)
       {
          distance[i]=getdistance(center,p[i]);
       }
       double [][] ans=new double[4][4];
       System.out.println("*************Distance Matrix**************");
       for(int i=0;i<4;i++)
       {
        for(int j=0;j<4;j++)
        {
            if(i==j)
              ans[i][j]=0;
            if(i<j)
            {
                ans[i][j]=Math.round(getdistance(p[i],p[j])*100.0)/100.0;
            }
        }
       }
       for(int i=0;i<4;i++)
       {
        for(int j=0;j<4;j++)
        {
            System.out.print(ans[i][j]+"    ");
        }
        System.out.println();
       }
       for(int i=0;i<p.length;i++)
       {
          System.out.println("Distance from p"+(i)+"--------->  "+distance[i]);
       }

       double min=distance[0];
       int index=0;
       for(int i=1;i<distance.length;i++)
       {
          if(distance[i]<min)
          {
               min=distance[i];
               index=i; 
          }  
       }
       
       System.out.println("Min Distance  --------->"+min);
       double [] point=p[index];
       System.out.println("Min Point--------> (X,Y)("+point[0]+","+point[1]+")");

       double [] recomputeddist=new double[4];
       for(int i=0;i<4;i++)
       {
         recomputeddist[i]=getdistance(point,p[i]);
       }
       for(int i=0;i<4;i++)
       {
          System.out.println("Distance from p"+(i)+"----------->  "+recomputeddist[i]+" ");
       }

   }
}    