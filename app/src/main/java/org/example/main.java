package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class main {

  public static void main(String[] args) {
    cleanMaker();
    // boolean unfinished = true;
    // while (unfinished) {
    // int[][] finalFullSud = sud();
    // int errors = 0;
    // for (int i = 0; i < 9; i++) {
    // for (int j = 0; j < 9; j++) {
    // if (finalFullSud[i][j] == 0) {
    // errors++;
    // }
    // }
    // }
    // if (errors == 0) {
    // unfinished = false;
    // for (int i = 0; i < finalFullSud.length; i++) {
    // System.out.println(Arrays.toString(finalFullSud[i]));
    // }
    // }
    // }
  }

  public static int[][] cleanMaker() {
    boolean unfinished = true;
    int[][] cleanSudoku = new int[9][9];
    while (unfinished) {
      cleanSudoku = sud();
      int errors = 0;
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (cleanSudoku[i][j] == 0) {
            errors++;
          }
        }
      }
      if (errors == 0) {
        unfinished = false;
        for (int i = 0; i < cleanSudoku.length; i++) {
          System.out.println(Arrays.toString(cleanSudoku[i]));
        }
        // return cleanSudoku;
      }
    }
    return cleanSudoku;
  }

  public static int[][] sud() {
    int[][] sud = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int[] insertableArray = shuffleArray(IntStream.iterate(1, k -> k <= 9, k -> k + 1).toArray());
        for (int m = 0; m < 9; m++) {
          if (isValid(sud, i, j, insertableArray[m])) {
            sud[i][j] = insertableArray[m];
          }
        }
      }
    }
    return sud;
  }

  static int[] shuffleArray(int[] ar) {
    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
    return ar;
  }

  static boolean isValid(int[][] arr, int row, int column, int num) {
    for (int i = 0; i < 9; i++) {
      if (arr[row][i] == num) {
        return false;
      }
      if (arr[i][column] == num) {
        return false;
      }
    }
    for (int k = 3 * (row / 3); k < (3 * (row / 3) + 3); k++) {
      for (int j = 3 * (column / 3); j < (3 * (column / 3)) + 3; j++) {
        if (arr[k][j] == num) {
          return false;
        }
      }
    }
    return true;
  }
}
