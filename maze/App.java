package com.maze;

public class App {

	public static void main(String[] args) {
		FileRead fr = new FileRead("C:\\workspace\\learning\\ds\\Advance-alg\\src\\com\\maze\\map.txt", 5, 5);
		fr.parse();
		MazeSolver ms = new MazeSolver(fr.getMap(), fr.getStartRow(), fr.getStartCol());
		ms.solve();
	}

}
