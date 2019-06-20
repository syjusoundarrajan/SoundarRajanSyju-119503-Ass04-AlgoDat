import java.util.Random;

public class QuickSort {
	// this function takes an array and two index values. It swaps the values at those indexes
	private void swap (int[] targetArray ,int index1 , int index2) {
		int temp = targetArray[index1];
		targetArray[index1] = targetArray[index2];
		targetArray[index2] = temp;
	}
	
	// returns a random number between low and high
	private  int  getRandomPivotIndex (int low ,int high) {
		Random rand = new Random();
		return rand.nextInt((high -low)+1)+low;
	}
	
	// Swaps all the necessary values and returns the connecting point of the two newly
	// created sub-arrays
	private int swapAndDivide(int[] input, int low, int high) {
		int randomPivot = getRandomPivotIndex(low, high);
		swap(input, low, randomPivot);
		int border = low + 1;
		for (int i = border ; i <= high ; i++) {
			if (input[i] < input[low]) {
				swap (input, i, border++);  
			}
		}
		swap(input, low, border-1);
		return border-1;
	}
	
	// Main algorithm process here. Recursive function.
	private void process(int[] input, int low, int high ) {
		if (low < high +1) {
			int divisionPoint = swapAndDivide (input, low ,high);
			process(input, low, divisionPoint-1);
			process(input, divisionPoint+1, high);
		}
	}
	
	// Takes an int array as input, applies quicksort algorithm and returns it
	public int[] quickSort(int[] input) {
		process (input , 0 ,input.length-1);
		return input;
	}
	
	// Prints any int array given as a parameter with a title first
	static void PrintArray(int[] toBePrinted, String title) {
		System.out.println(title);
		for(int i = 0 ; i < toBePrinted.length; i++) {
			System.out.print(toBePrinted[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QuickSort sorter = new QuickSort();
		
		int[] input = { 19,20,12,31,45,52,27,92,89,72,64,57,95,18,30,69};
		PrintArray(input, "Input list :");
		
		int[] output = sorter.quickSort (input);
		PrintArray(output, "Output list after quicksort:");
	}

}
