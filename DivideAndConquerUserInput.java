import java.util.Scanner;
import java.lang.Math;

public class DivideAndConquerUserInput
{
    public static void main(String[] args)
    {
        
        System.out.println("Give the number of points wanted for finding the points with shortest distance");
        Scanner scan = new Scanner(System.in);
        int TotalPoints = scan.nextInt();

        float [][] twodpoint = new float[TotalPoints][2];
        
//        String closestPoint1="";
//        String closestPoint2="";
        float SmallDist;
        //enter x,y coords into the ix2 table points[][]
        String AnswerPt1="",AnswerPt2="";
        for (int start=1; start<TotalPoints; start++)
        {
                System.out.print("x"+start+" ");
                twodpoint[start][0] = scan.nextInt();
                System.out.print("y"+start+" ");
                twodpoint[start][1] = scan.nextInt();
        }

        //get the distance between the point in the ith row and the (m+1)th row
        //and check if it's shorter than the distance between 0th and 1st
        SmallDist=0; 
        for (int start=0; start<TotalPoints; start++)
        {
            //use m=i rather than 0 to avoid duplicate computations
        	float dist;
            for (int cen=start; cen<TotalPoints-1;cen++)
            {
                float distxaxis = twodpoint[start][0] - twodpoint[cen+1][0];
                float distyaxis = twodpoint[start][1] - twodpoint[cen+1][1];
                dist = (float) Math.sqrt(distxaxis*distxaxis + distyaxis*distyaxis);

                //set shortestDistance and closestPoints to the first iteration
//                float shortestDistance=0;  
//                float distance=0;
               
                if (cen == 0 && start == 0)
                {
                	SmallDist = dist;
                    AnswerPt1 = "(" + twodpoint[0][0] + "," + twodpoint[0][1] + ")";
                    AnswerPt2 = "(" + twodpoint[1][0] + "," + twodpoint[1][1] + ")";
                }
                //then check if any further iterations have shorter distances
                
                if(dist < SmallDist)
                {
                	SmallDist = dist;
                    AnswerPt1 = "(" + twodpoint[start][0] + "," + twodpoint[start][1] + ")";
                    AnswerPt2 = "(" + twodpoint[cen+1][0] + "," + twodpoint[cen+1][1] + ")";
                }
            }
        }
        System.out.println("The 2 closest points in my given number of points including the origin which is taken our initial point always are"+AnswerPt1+"and"+AnswerPt2);
        System.out.println("And the distance between them is " + SmallDist);
        
    }   
}
