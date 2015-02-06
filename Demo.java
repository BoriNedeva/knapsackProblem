package knapsackProblem;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
//		int[] weights = {3,2,1};
//		int[] values = {5,3,4};
//		
//		int[] weights1 = {5,7,3,6};
//		int[] values1 = {8,11,14,9};
//		
//		long before = System.currentTimeMillis();
//		DynamicProgrammingSolution.solve(5, 3, weights, values);
//		System.out.println("Time: " + (System.currentTimeMillis() - before));
//		
//		long before1 = System.currentTimeMillis();
//		DynamicProgrammingSolution.solve(18, 4, weights1, values1);
//		System.out.println("Time: " + (System.currentTimeMillis() - before1));
		
		Scanner sc = new Scanner(System.in);
			
		while(true){
			System.out.println("Enter number of items:");
			int numberOfItems = sc.nextInt();
			int[] weights = new int[numberOfItems];
			int[] values = new int[numberOfItems];
			
			for (int i = 0; i < numberOfItems; i++) {
				System.out.println("Enter weight:");
				weights[i] = sc.nextInt();
				System.out.println("Enter value:");
				values[i] = sc.nextInt();
			}
			
			System.out.println("Enter capacity of the knapsack");
			int capacity = sc.nextInt();
			
			long before = System.currentTimeMillis();
			DynamicProgrammingSolution.solve(capacity, numberOfItems, weights, values);
			System.out.println("Time: " + (System.currentTimeMillis() - before));
			
			System.out.println("Enter 1 for new input or 0 to exit:");
			int decision = sc.nextInt();
			if(decision == 0){
				break;
			}
		}
		sc.close();
	}
	
}
