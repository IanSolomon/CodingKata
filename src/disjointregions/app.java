package disjointregions;

import java.util.Arrays;

public class app {

	public static void main(String[] args) {
		int[][] one = {{1,0,0,1},
				 	   {1,0,0,1},
				 	   {1,0,0,1},
				 	   {1,1,1,1}};// fails shows 2
		
		int[][] twoPass =  {{1,0,0,1}, 
							{1,0,0,1}, 
							{1,0,0,1}, 
							{1,1,0,0}};
		
		
		int[][] twoFails =  {{1,0,0,1}, 
							{1,0,1,1}, 
							{1,0,0,1}, 
							{1,1,0,0}};
					
		int[][] single = {{1,0,1,0}, 
				          {0,0,0,1},
				          {0,0,0,0},
				          {0,1,0,1}};//works
		
		int[][] map = {{1,1,1,1}, 
					   {1,0,0,1},
					   {1,0,0,1},
					   {1,1,1,1}};//works
		
		int[][] works = {{1,1,1,1},
				         {1,0,1,1},
				         {1,0,0,1},
				         {1,1,1,1}};//works
		
		int[][] fails = {{1,1,0,1},
					     {1,0,1,1},
					     {1,0,0,1},
					     {1,1,1,1}};//fails
		
		System.out.println("Number of regions: "+totalRegiondCount(twoPass));
	}


	static private int totalRegiondCount(int[][] dataSet) {
		int totalIslandsFound = 0;
//		boolean[][] datasetFlags = new boolean[dataSet.length][dataSet.length];	
//		
//		for (boolean[] row: datasetFlags)
//		    Arrays.fill(row, false);
		
		for(int row = 0; row < dataSet.length; row++) {
			for(int col = 0; col < dataSet.length; col++ ) {
				if(dataSet[row][col] == 1) {	
				     if( (row-1 < 0 || dataSet[row-1][col] == 0) && (col-1 < 0 || dataSet[row][col-1] == 0) ){
				    	 //checking around to see if 0 marks end of the region
				    	 totalIslandsFound++;
				     }
				}

													
			}
			
		}

		return totalIslandsFound;
	}
}
