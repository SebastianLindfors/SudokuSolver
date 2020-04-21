package se.seblin.solos.SudokuSolver.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

  @Test
  void testToString() {
    Sudoku testSudoku = new Sudoku();
    char testCharacter = '1';
    for (int i = 0; i < testSudoku.getSize(); i++) {
      for (int j = 0; j < testSudoku.getSize(); j++) {
        testSudoku.updatePosition(i,j, testCharacter);
        if (testCharacter == '9') {
          testCharacter = '1';
        }
        else {
          testCharacter++;
        }
      }
    }
    System.out.println(testSudoku.toString());

  }
}