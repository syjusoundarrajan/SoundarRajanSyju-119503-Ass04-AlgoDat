import java.util.*;
import static java.lang.Math.min;
import static java.lang.StrictMath.abs;

public class ClosePtsDivAndConqRanInp {
	//My main method that generates random pts and use those points in the below implemented algorithm to find the closest points.
	public static void main(String[] args) {    
    	Random RanGen;
    	//Asking user that how many no of points he/she wants to be generated
        Scanner scan = new Scanner(System.in);  
        System.out.println("Give the no of pts that you wish to be generated randomly to be given to our Divide And Conquer Algorithm");
        //Represents the inputed value
        int N = scan.nextInt();   
        //Creates plane of N number
         plane = new Point[N];           
         A = new Point[N];
         RanGen = new Random();  
        for (int i = 0; i < N; i++) { 
            float x = RanGen.nextInt(N<<6);
            float y = RanGen.nextInt(N<<6);
            plane[i] = new Point(x,y); 
            }
        //Sorting of my created points in my plane based on x axis
        Arrays.sort(plane); 
        for (int i = 1; i < N; ++i)  
            if (plane[i-1].x >= plane[i].x) plane[i].x = plane[i-1].x + 1;    
        System.out.println(N + " points are randomly created.");   
        //Calling and asking my algorithm here for the closest point
        float min = DivideAndConquer(0, N-1);
        System.out.println("The two closest points in our plane containing the randomly generated points are "+plane[N-1]+" and "+plane[0]);
        System.out.println("The distance of the two closest points by our implemented algorithm is "+min);
        }      
        static void exchange(int i, int j) {
        Point x = plane[i];
        plane[i] = plane[j];
        plane[j] = x;
        }
	
	static Point[] plane,A;
    static class Point implements Comparable<Point> {  
        float x, y;    // Constructor  
        Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
        public  int compareTo(Point r) {
            //Comparing my points that may be equal or less than or greater than zero
        	if (this.x == r.x) {
                    if (this.y == r.y) {
                        return 0;}
                    else {
                        return (this.y > r.y)? 1 : -1; }
                }
            else {
                    return (this.x > r.x)? 1 : -1;}
        }

        public String toString() {
            return " ("+Float.toString(this.x)+","+Float.toString(this.y)+")";
        }
        public float distance(Point r) {
        	float distxaxis = (this.x - r.x);
        	float distyaxis = (this.y - r.y);
            return (float) Math.sqrt(distxaxis*distxaxis + distyaxis*distyaxis);
        }
    }
             
    
        //Starting of the implementation of my Algorithm
    //The first part is a normal algorithm that finds closest points upto may be 4 points
        public static float DivideAndConquer(int top, int bottom) {      	
        	float mmid,mstart,mlen;
        if (top == bottom+1) { 
                if (plane[bottom].y > plane[top].y) exchange(bottom, top);
                return (float) plane[bottom].distance(plane[top]);
        } 
            else if (top == bottom+2) { 
            	//Sorting of my created points in my plane based on y axis
            if (plane[bottom].y > plane[top].y) exchange(bottom, top);
           if (plane[bottom].y > plane[bottom+1].y) exchange(bottom, bottom+1);
            else if (plane[bottom+1].y > plane[top].y) exchange(bottom+1, top);
            //Finding out the distances
            float d1 = (float) plane[bottom].distance(plane[top]);
            float d2 = (float) plane[bottom].distance(plane[bottom+1]);
            float d3 = (float) plane[bottom+1].distance(plane[top]);
            return ((d1 < d2)? ((d1 < d3)? d1 : d3) : (d2 < d3)? d2 : d3);  // return min(d1, d2, d3)
        }
        //The Actual Divide and Conquer algorithm starts here as this is capable of working even number of points is more than 4 or even more
            else {  
                int mid = (top + bottom)/2;
                float low = (float) DivideAndConquer(bottom,mid),up = (float) DivideAndConquer(mid+1,top); 
                mmid = min(low, up);
                int L = 0;
                double x0 = plane[mid].x;
                int N=0;
                for(int i = 1; i < N; i++){
                    if(abs(plane[i].x-x0) <= mmid){
                        L++;
                        A[L] = plane[i];
                    }
                }
                mstart = 2 * mmid;
                for (int i = 1; i < L-1; i++){
                    for(int j = i + 1; j < min(i+7,L);j++){
                        float distance0 = (float) abs(A[i].distance(A[j]));
                        if(distance0 < mstart){
                        	mstart = distance0;
                        }
                    }
                }
                mlen = min(mstart, mmid);
            }
            return mlen;
        }
}