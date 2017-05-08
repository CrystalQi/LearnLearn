package Facebook;

import java.util.HashSet;
import java.util.Set;

public class NumberOfUniqueIslands {
	public static int numIslands(char[][] grid) {
	    Set<String> set = new HashSet<String>();
	    for(int i = 0; i< grid.length; i++)
	        for(int j = 0; j < grid[0].length; j++){
	            if(grid[i][j] == '1'){
	                dfsFill(grid, i, j, "", set);
	            }
	        }
	    return set.size();
	}
	
	private static boolean dfsFill(char[][] grid,int i, int j, String path, Set<String> set){
	    if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
	        grid[i][j]='0';
	        boolean down = dfsFill(grid, i + 1, j, path + "d", set);
	        boolean up = dfsFill(grid, i - 1, j, path + "u", set);
	        boolean right = dfsFill(grid, i, j + 1, path + "r", set);
	        boolean left = dfsFill(grid, i, j - 1, path + "l", set);
	        if (!down && !up && !right && !left) {
	        	set.add(path);
	        }
	        return true;
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		char[][] grid = new char[][]{
				{'1', '1', '0', '0', '0', '0'}, 
				{'1', '1', '0', '0', '0', '1'}, 
				{'0', '0', '1', '1', '0', '1'}, 
				{'1', '0', '1', '1', '0', '0'},
				{'1', '0', '1', '0', '0', '0'}};
		System.out.println(numIslands(grid));
		
	}
//	110000
//	110001
//	001101
//	101100
//	100000
}
