package cracking.strings;

import java.lang.Math;
import java.util.Arrays;
/*
Minesweeper:

implement the minesweeper board generation function with exactly  k random mines

- args should be n,m and k.
- each board cell should contain how many mines around the adjacents cell and -1 if it's a mine
- print the board

example:

n=6 m=5 k=2

generate(6,5,2)
0  0  0  1  1  1
0  1  1  2 -1  1
0  1 -1  2  1  1
0  1  1  1  1  1
0  0  0  0  0  0
*/

class Mine {

    private int MINE_FLAG = -1;
    private int[][] matrix;

    private void generate(int n, int m, int mines) {
        matrix = new int[n][m];
        while (mines > 0) {
            int x = getRnd(0, n - 1);
            int y = getRnd(0, m - 1);

            if (!isMine(x, y)) {
                putMine(x, y);
                mines--;
            }
        }
        printMatrix();
    }

    private boolean isMine(int x, int y) {
        return matrix[x][y] == MINE_FLAG;
    }

    private void putMine(int x, int y) {

        // center of mine
        if (!isMine(x, y) && x >= 0 & x < matrix.length && y >= 0 && y < matrix[0].length) {
            matrix[x][y] = MINE_FLAG;
            System.out.println("MINE:" + x + ":" + y);
        }

        // increment flag top
        if (x - 1 >= 0 && !isMine(x - 1, y)) {
            matrix[x - 1][y]++;
        }

        // increment flag bot
        if (x + 1 < matrix.length && !isMine(x + 1, y)) {
            matrix[x + 1][y]++;
        }

        // put flag leftside top diagonal
        if (x - 1 >= 0 && y - 1 >= 0 && !isMine(x - 1, y - 1)) {
            matrix[x - 1][y - 1]++;
        }

        // put flag leftside
        if (y - 1 >= 0 && !isMine(x, y - 1)) {
            matrix[x][y - 1]++;
        }

        // put flag leftside  bot diagonal
        if (x + 1 < matrix.length && y - 1 >= 0 && !isMine(x + 1, y - 1)) {
            matrix[x + 1][y - 1]++;
        }

        // put flag right side top diagonal
        if (x - 1 >= 0 && y + 1 < matrix[0].length && !isMine(x - 1, y + 1)) {
            matrix[x - 1][y + 1]++;
        }

        // put flag right side
        if (y + 1 < matrix.length && !isMine(x, y + 1)) {
            matrix[x][y + 1]++;
        }

        // put flag right side bot diagonal
        if (x + 1 < matrix.length && y + 1 < matrix[0].length && !isMine(x + 1, y + 1)) {
            matrix[x + 1][y + 1]++;
        }

    }

    private int getRnd(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Mine mc = new Mine();
        mc.generate(6, 5, 4);
    }
}
