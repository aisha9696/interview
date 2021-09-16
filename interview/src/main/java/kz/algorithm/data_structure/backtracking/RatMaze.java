package kz.algorithm.data_structure.backtracking;


/**
 * Задача мыши в лабиринте
 * Дан двумерный массив которое отображает лабиринт
 * где [0,0] это начало а конец [N-1,N-1]
 * где 1 это путь которому пожно ходить а 0 это дорога куда нельзя наступать
 * задача состоит в том чтобы вывести путь мыша от начало до конца
 * */
public class RatMaze {
    static int N ;
    public static void main(String[] args) {
        RatMaze rm = new RatMaze();
        int maze[][]={  {1,0,0,1},
                        {1,1,0,1},
                        {0,1,0,0},
                        {1,1,1,1}};
        N = maze.length;
        rm.solve(maze);

        /**
         *  1 0 0 0
         *  1 1 0 0
         *  0 1 0 0
         *  0 1 1 1
         * */
    }

    static boolean isSafe(int x, int y, int maze[][])
    {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }
    static void printSolution(int sol[][])
    {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    private void solve(int[][] maze) {
        int sol[][] = new int[8][8];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = 0;

        if(solveBck(0,0,maze, sol)){
            printSolution(sol);

        }else{
            System.out.println("Impossible to get destination!");
            return;
        }
    }
    /**
     * Рекурсия основа для решения Backtracking задач
     *
     * */
    private boolean solveBck(int x, int y, int[][] maze, int[][] sol) {

        /**
         * GOAL
         * */
        if(x==maze.length -1 && y ==maze.length-1 && maze[x][y]==1){
            sol[x][y] =1;
            return true;
        } /// место где выходим из рекурсии

        if(isSafe(x,y,maze)){ /** CONSTRAINTS  */

            if(sol[x][y] ==1) return false;
            sol[x][y] =1;
            /**
             * всевможные варианты CHOICE
             * */
            if(solveBck(x+1, y, maze, sol)) return true;
            if(solveBck(x,y+1, maze,sol)) return true;
            if(solveBck(x-1, y, maze, sol)) return true;
            if(solveBck(x,y-1, maze,sol)) return true;

            sol[x][y] =0;
            return false;
        }

        return false;
    }


}
