package com.queenAttack;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] map;
		String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);
		
		String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }
        map = new int[n][n];
        r_q = r_q - 1;
        c_q = c_q - 1;
        genMap(k,r_q, c_q, obstacles, map);

       QueenAttack q = new QueenAttack(n, map);
       q.findNo(r_q, c_q);
       System.out.println(q.getCount());
	}

	private static void genMap(int k, int r_q, int c_q, int[][] obstacles, int[][] map) {
		for(int i=0; i<k;i++) {
			int a = obstacles[i][0] - 1;
			int b = obstacles[i][1] - 1;
			map[a][b] = 1;
		}
		
		map[r_q][c_q] = 2;
	}
}
