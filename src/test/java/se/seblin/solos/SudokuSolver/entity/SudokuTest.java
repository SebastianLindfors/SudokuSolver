package se.seblin.solos.SudokuSolver.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

  @Test
  void testToString() {
    Sudoku testSudoku = new Sudoku();
    System.out.println(testSudoku.toString());

  }
}