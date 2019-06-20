import java.util.Scanner;
import java.lang.Math;

public class DivideAndConquerUserInput
{
    public static void main(String[] args)
    {
        //Input taking and defining variables required
        System.out.println("Give the number of points wanted for finding the points with shortest distance");
        Scanner scan = new Scanner(System.in);
        int TotalPoints = scan.nextInt();

        float [][] twodpoint = new float[TotalPoints][2];

        float SmallDist;
       
        String AnswerPt1="",AnswerPt2="";
        for (int start=1; start<TotalPoints; start++)
        {
                System.out.print("x"+start+" ");
                twodpoint[start][0] = scan.nextInt();
                System.out.print("y"+start+" ");
                twodpoint[start][1] = scan.nextInt();
        }

        SmallDist=0; 
        for (int start=0; start<TotalPoints; start++)
        {
            
        	float dist;
            //Some parts of the understanding and implementation hava been taken from the research paper https://www.cs.cmu.edu
            for (int cen=start; cen<TotalPoints-1;cen++) //Loop that ables to take my points
            {
                float distxaxis = twodpoint[start][0] - twodpoint[cen+1][0];
                float distyaxis = twodpoint[start][1] - twodpoint[cen+1][1];
                dist = (float) Math.sqrt(distxaxis*distxaxis + distyaxis*distyaxis);
          
                if (cen == 0 && start == 0)
                {
                	SmallDist = dist;
                    AnswerPt1 = "(" + twodpoint[0][0] + "," + twodpoint[0][1] + ")";
                    AnswerPt2 = "(" + twodpoint[1][0] + "," + twodpoint[1][1] + ")";
                }
                               
                if(dist < SmallDist)
                {
                	SmallDist = dist;
                    AnswerPt1 = "(" + twodpoint[start][0] + "," + twodpoint[start][1] + ")";
                    AnswerPt2 = "(" + twodpoint[cen+1][0] + "," + twodpoint[cen+1][1] + ")";
                }
            }
        }
        //Result display
        System.out.println("The 2 closest points in my given number of points including the origin which is taken our initial point always are"+AnswerPt1+"and"+AnswerPt2);
        System.out.println("And the distance between them is " + SmallDist);
        
    }   
}
