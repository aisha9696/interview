package kz.algorithm.data_structure.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача о вставки N королев в N×N шахматную доску
 * 1) Choice: N все возможные перестановки
 * 2) Constraints королевы не должны находиться в одном: - column
 * - row
 * - diagonals
 * 3) Goal: если они соответсвуют constraints то записывать result в массив
 * The N Queen is the problem of placing N chess queens on an
 * N×N chessboard so that no two queens attack each other.
 * For example, following is a solution for 4 Queen problem.
 */
public class N_Queen {
    static int N;

    static boolean isSafe(int x, int y, int array[][]) {
        /**
         * проверка по столбикам
         * */
        for (int i = 0; i < y; i++) {
            if (array[x][i] == 1) return false;
        }
        /**
         * проверка по диаганали
         * */
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 1) return false;
        }
        for (int i = x, j = y; j >= 0 && i < N; i++, j--) {
            if (array[i][j] == 1) return false;
        }

        return true;

    }

    private static void solve() {
        int[][] array = new int[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                array[x][y] = 0;

        if (solvRec(0, array)) {
            printSolution(array);
        } else {
            System.err.println("Impossible to place in under attack");
        }

    }

    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    private static boolean solvRec(int x, int[][] array) {
        if (x >= N) return true; /** end of recursion*/
        /**
         * Choice
         * */
        for (int i = 0; i < N; i++) {
            if (isSafe(i, x, array)) { /** Checking constraints */
                array[i][x] = 1;
                if (solvRec(x + 1, array)) { /** movements */
                    return true;
                }
                array[i][x] = 0;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        N = 4;
        solve();
    }


}
