package part1.week4.project.better; /******************************************************************************
 *  Compilation:  javac-algs4 PuzzleChecker.java
 *  Execution:    java-algs4 PuzzleChecker filename1.txt filename2.txt ...
 *  Dependencies: Board.java Solver.java
 *
 *  This program creates an initial board from each filename specified
 *  on the command line and finds the minimum number of moves to
 *  reach the goal state.
 *
 *  % java-algs4 PuzzleChecker puzzle*.txt
 *  puzzle00.txt: 0
 *  puzzle01.txt: 1
 *  puzzle02.txt: 2
 *  puzzle03.txt: 3
 *  puzzle04.txt: 4
 *  puzzle05.txt: 5
 *  puzzle06.txt: 6
 *  ...
 *  puzzle3x3-impossible: -1
 *  ...
 *  puzzle42.txt: 42
 *  puzzle43.txt: 43
 *  puzzle44.txt: 44
 *  puzzle45.txt: 45
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;

public class PuzzleChecker {

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        boolean needSolution = false;
        // for each command-line argument
        File resources = new File("princetonSolution\\src\\part1\\week4\\project\\hardtestfiles");
        for (File filename : resources.listFiles()) {

            // read in the board specified in the filename
            In in = new In(filename);
            int n = in.readInt();
            int[][] tiles = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tiles[i][j] = in.readInt();
                }
            }

            // solve the slider puzzle
            Board initial = new Board(tiles);
            IDAStarSolver solver = new IDAStarSolver(initial);
            StdOut.println(filename + ": " + solver.moves());
            System.out.println(stopwatch.elapsedTime());
            if (needSolution) {
                int idx = 0;
                for (Board b : solver.solution()) {
                    System.out.println(idx++);
                    System.out.println(b);
                }
            }
        }
        System.out.println(stopwatch.elapsedTime());
    }
}
