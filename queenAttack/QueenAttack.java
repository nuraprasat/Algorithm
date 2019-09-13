package com.queenAttack;

public class QueenAttack {
	private static int totalSize;
	private static int[][] map;
	private static boolean[][] visited;
	private static int count = 0;
	
	public QueenAttack (int totalSize, int[][] map) {
		this.map = map;
		this.totalSize = totalSize;
		this.visited = new boolean[totalSize][totalSize];
	}
	
	public static void findNo(int rowStart, int colStart) {
		dfs(rowStart, colStart + 1, 0, 1);
		dfs(rowStart + 1, colStart, 1, 0);
		dfs(rowStart - 1, colStart, -1, 0);
		dfs(rowStart, colStart - 1, 0, -1);
		dfs(rowStart - 1, colStart - 1, -1, -1);
		dfs(rowStart + 1, colStart + 1, 1, 1);
		dfs(rowStart + 1, colStart - 1, 1, -1);
		dfs(rowStart - 1, colStart + 1, -1, 1);
	}
		
	public static void dfs(int rowStart, int colStart, int i, int j) {
		while (true) {
			if (rowStart < 0 || rowStart >= totalSize || colStart < 0 || colStart >= totalSize ||  map[rowStart][colStart] == 1) {
				break;
			} else if (visited[rowStart][colStart]) {
				rowStart = rowStart + i;
				colStart = colStart + j;
				continue;
			} else {
				count++;
				visited[rowStart][colStart] = true;
			}
			rowStart = rowStart + i;
			colStart = colStart + j;
		}
	}
	
	public int getCount() {
		return this.count;
	}

}
