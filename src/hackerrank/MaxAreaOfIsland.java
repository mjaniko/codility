package hackerrank;

public class MaxAreaOfIsland {

    public void solution(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int c = visitCell(grid, visited, i, j);
                    System.out.println("Visited:[" + i + "," + j + "]      Count:" + c);
                    counter = Math.max(c, counter);
                }
            }
        }
        System.out.println("Max Island Size:" + counter);
    }

    public int visitCell(int[][] grid, boolean[][] visited, int i, int j) {
        // protect from out of  bound
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
            return 0;
        }
        // check if visited cell or island is zero
        if (visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return 1 +
                visitCell(grid, visited, i, j - 1) + // go left
                visitCell(grid, visited, i, j + 1) + // go right
                visitCell(grid, visited, i + 1, j) + // go down
                visitCell(grid, visited, i - 1, j); // go top
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maoi = new MaxAreaOfIsland();
        maoi.solution(new int[][]{
                //   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        });
        maoi.solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        });
        maoi.solution(new int[][]{
                {0, 1},
                {1, 1}
        });
    }
}