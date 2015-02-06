package knapsackProblem;

public class DynamicProgrammingSolution {

	public static void solve(int knapsackCapacity, int numberOfItems,
			int[] weights, int[] values) {

		if(validateInput(knapsackCapacity, numberOfItems, weights, values)){
			
			int[][] vTable = new int[numberOfItems + 1][knapsackCapacity + 1];
			int[][] keepTable = new int[numberOfItems + 1][knapsackCapacity + 1];
	
			// bottom-up computation 
			//O(numberOfItems*knapsackCapacity) time complexity
			//O(numberOfItems*knapsackCapacity + numberOfItems) space complexity
			for (int i = 0; i <= numberOfItems; i++) {
				for (int w = 0; w <= knapsackCapacity; w++) {
	
					if (i == 0 || w == 0) {
						vTable[i][w] = 0;
						keepTable[i][w] = 0;
					}
					else if(weights[i-1] <= w){
						vTable[i][w] = Math.max(vTable[i-1][w], values[i-1] + vTable[i-1][w-weights[i-1]]);
				
						keepTable[i][w] = values[i-1] + vTable[i-1][w-weights[i-1]] > vTable[i-1][w] ? 1 : 0;
					}
					else{
						// weights[i-1] > w (item doesn't fit)
						vTable[i][w] = vTable[i-1][w];
						keepTable[i][w] = 0;
					}
					//System.out.print(keepTable[i][w] + " ");
				}
				//System.out.println();
			}
			
			int weight = knapsackCapacity;
			int[] selected = new int[numberOfItems];
			
			for(int item = numberOfItems; item >= 1; item--){
				if(keepTable[item][weight] == 1)
				{
					selected[item - 1] = 1;
					weight -= weights[item - 1];
				}
			}
			
			int maxValue = vTable[numberOfItems][knapsackCapacity];
			System.out.println("Maximum value of items to put in the knapsack is " + maxValue);
			System.out.println("The selected items are:");
			for (int i = 0; i < selected.length; i++) {
				if(selected[i] == 1){
					System.out.println("Weight: " + weights[i] + " with value: " + values[i]);
					}
				}
		}
		else{
			System.out.println("Wrong input data!");
		}
	}
	
	private static boolean validateInput(int knapsackCapacity, int numberOfItems,
			int[] weights, int[] values){
		return weights != null && values != null &&
				knapsackCapacity >= 0 && numberOfItems >= 0 && 
				numberOfItems == weights.length && numberOfItems == values.length;
	}
}
