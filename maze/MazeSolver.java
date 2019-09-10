package com.maze;

import java.util.Map;

public class MazeSolver {
	static int[][] mazeMap;
	int rowStart;
	int colStart;
	static boolean[][] visited;
	public MazeSolver(int[][] mazemap, int rowStart, int colStart) {
		this.mazeMap = mazemap;
		this.rowStart = rowStart;
		this.colStart = colStart;
		this.visited = new boolean[mazemap.length][mazemap.length];
	}
	
	public void solve() {
		try {
			dfs(rowStart, colStart);
			System.out.println(" Not able to find path");
		} catch(RuntimeException r) {
			System.out.println("Found the exit path");
		}
	}
	
	private static void dfs(int row, int col) {
		System.out.println("searching row-"+row+" col"+col);
		
		if(mazeMap[row][col] == 3) {
			throw new RuntimeException();
		}
		
		int maxlength = mazeMap.length-1;
		
		if(visited[row][col]) {
			return;
		} else if(row<0 || row >=maxlength) {
			return;
		} else if(col<0 || col >= maxlength) {
			return;
		} else if(mazeMap[row][col] == 1) {
			return;
		} else {
			visited[row][col] = true;
			
			dfs(row, col+1);
			dfs(row+1, col);
			dfs(row, col-1);
			dfs(row-1, col);
		}
		
	}
	
}
