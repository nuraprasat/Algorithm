package com.maze;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {
	int[][] mazeMap;
	private int startRowIndex;
	private int startColIndex;
	private int rowSize;
	private int colSize;
	private String file;
	
	public FileRead(String file, int rowSize, int colSize) {
		this.file = file;
		this.mazeMap = new int[rowSize][colSize];
		this.rowSize = rowSize;
		this.colSize = colSize;
	}
	
	public void parse() {
		
		try(Scanner sc = new Scanner(new File(file))) {
			for(int i=0;i<rowSize;i++) {
				for(int j=0;j<colSize;j++) {
					mazeMap[i][j] = sc.nextInt();
					if(mazeMap[i][j] == 2) {
						this.startRowIndex = i;
						this.startColIndex = j;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[][] getMap() {
		return this.mazeMap;
	}
	
	public int getStartRow() {
		return this.startRowIndex;
	}
	
	public int getStartCol() {
		return this.startColIndex;
	}
}
